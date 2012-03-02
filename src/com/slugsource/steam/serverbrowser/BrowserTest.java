/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slugsource.steam.serverbrowser;

import java.io.IOException;
import java.math.BigInteger;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author Nathan Fearnley
 */
public class BrowserTest
{

    public static void main(String[] args)
    {
        try
        {
            sendRequest(InetAddress.getByName("216.246.108.212"), 28952);
            sendRequest(InetAddress.getByName("192.168.0.200"), 28852);
        } catch (Exception ex)
        {
            ex.printStackTrace();
            return;
        }
        System.out.println("Success");
    }

    private static void sendRequest(InetAddress address, int port) throws SocketException, UnknownHostException, IOException
    {
        DatagramSocket datagramSocket = new DatagramSocket();

        byte[] prefix =
        {
            (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0x54
        };

        byte suffix = 0x00;

        byte[] sendBuffer = ArrayUtils.addAll(prefix, "Source Engine Query".getBytes());
        sendBuffer = ArrayUtils.addAll(sendBuffer, suffix);

        DatagramPacket packet = new DatagramPacket(
                sendBuffer, sendBuffer.length, address, port);

        datagramSocket.send(packet);

        byte[] receiveBuffer = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, 1024);
        datagramSocket.receive(receivePacket);
        printPacket(receivePacket);
        datagramSocket.close();
    }

    private static void printPacket(DatagramPacket p)
    {
        int index = 4;
        int count;
        byte[] data = p.getData();

        int type = data[index];
        index += 1;
        System.out.println("Type: " + Integer.toHexString(type));

        int version = data[index];
        index += 1;
        System.out.println("Version: " + version);

        count = readStringCount(index, data);
        String serverName = new String(data, index, count);
        index += count + 1;
        System.out.println("Server Name: " + serverName);

        count = readStringCount(index, data);
        String map = new String(data, index, count);
        index += count + 1;
        System.out.println("Map: " + map);

        count = readStringCount(index, data);
        String gameDirectory = new String(data, index, count);
        index += count + 1;
        System.out.println("Game Directory: " + gameDirectory);

        count = readStringCount(index, data);
        String gameDescription = new String(data, index, count);
        index += count + 1;
        System.out.println("Game Description: " + gameDescription);

        int appId = readShort(index, data);
        index += 2;
        System.out.println("App ID: " + appId);

        int numberOfPlayers = readByte(index, data);
        index += 1;
        System.out.println("Number of Players: " + numberOfPlayers);

        int maximumPlayers = readByte(index, data);
        index += 1;
        System.out.println("Maximum Players: " + maximumPlayers);

        int numberOfBots = readByte(index, data);
        index += 1;
        System.out.println("Number of Bots: " + numberOfBots);

        char dedicated = readChar(index, data);
        index += 1;
        switch (dedicated)
        {
            case 'l':
                System.out.println("Dedicated: Listen");
                break;
            case 'd':
                System.out.println("Dedicated: Dedicated");
                break;
            case 'p':
                System.out.println("Dedicated: SourceTV");
                break;
            default:
                System.out.println("Dedicated: Unknown");
        }

        char operatingSystem = readChar(index, data);
        index += 1;
        switch (operatingSystem)
        {
            case 'l':
                System.out.println("Operating System: Linux");
                break;
            case 'w':
                System.out.println("Operating System: Windows");
                break;
            default:
                System.out.println("Operating System: Unknown");
        }

        boolean password = readBoolean(index, data);
        index += 1;
        System.out.println((password ? "" : "No ") + "Password");

        boolean vacSecured = readBoolean(index, data);
        index += 1;
        System.out.println((vacSecured ? "" : "Not ") + "VAC Secured");

        count = readStringCount(index, data);
        String gameVersion = new String(data, index, count);
        index += count + 1;
        System.out.println("Game Version: " + gameVersion);

        int extraDataFlag = readByte(index, data);
        index += 1;
        System.out.println("Extra Data Flag: " + extraDataFlag);

        boolean hasGamePort = (extraDataFlag & 0x80) != 0;
        System.out.println("Has Game Port: " + hasGamePort);

        boolean hasSteamId = (extraDataFlag & 0x10) != 0;
        System.out.println("Has Steam ID: " + hasSteamId);

        boolean hasSpectatorServer = (extraDataFlag & 0x40) != 0;
        System.out.println("Has Spectator Server: " + hasSpectatorServer);

        boolean hasGameTagDataString = (extraDataFlag & 0x20) != 0;
        System.out.println("Has Game Tag Data String: " + hasGameTagDataString);

        boolean hasGameId = (extraDataFlag & 0x01) != 0;
        System.out.println("Has Game ID: " + hasGameId);

        int gamePort;
        if (hasGamePort)
        {
            gamePort = readByte(index, data);
            index += 1;
            System.out.println("Game Port: " + gamePort);
        }

        // TODO: Fix to support unsigned 64 bit numbers
        long steamId;
        if (hasSteamId)
        {
            steamId = readLongLong(index, data);
            index += 1;
            System.out.println("Steam ID: " + steamId);
        }
        
        int spectatorServerPort;
        String spectatorServerName;
        if (hasSpectatorServer)
        {
            spectatorServerPort = readShort(index, data);
            index += 2;
            count = readStringCount(index, data);
            spectatorServerName = new String(data, index, count);
            index += count + 1;
            System.out.println("Spectator Server Port: " + spectatorServerPort);
            System.out.println("Spectator Server Name: " + spectatorServerName);
        }

        String gameTagDataString;
        if (hasGameTagDataString)
        {
            count = readStringCount(index, data);
            gameTagDataString = new String(data, index, count);
            index += count + 1;
            System.out.println("Game Tag Data String: " + gameTagDataString);
        }

        // TODO: Fix to support unsigned 64 bit numbers
        long gameId;
        if (hasGameId)
        {
            gameId = readLongLong(index, data);
            index += 1;
            System.out.println("Game ID: " + gameId);
            
        }

    }

    private static boolean readBoolean(int index, byte[] data)
    {
        return data[index] == 0x01;
    }

    private static char readChar(int index, byte[] data)
    {
        return (char) data[index];
    }

    private static int readStringCount(int index, byte[] data)
    {
        int count = 0;
        while (data[index + count] != 00)
        {
            count++;
            if (index + count > data.length)
            {
                throw new IndexOutOfBoundsException();
            }
        }
        return count;
    }

    private static int readByte(int index, byte[] data)
    {
        return 0xFF & data[index];
    }

    private static int readShort(int index, byte[] data)
    {
        return readByte(index, data)
                | (readByte(index + 1, data) << 8);
    }

    private static int readLong(int index, byte[] data)
    {
        return readByte(index, data)
                | (readByte(index + 1, data) << 8)
                | (readByte(index + 2, data) << 16)
                | (readByte(index + 3, data) << 24);
    }

    private static long readLongLong(int index, byte[] data)
    {
        return (long) readByte(index, data)
                | ((long) readByte(index + 1, data) << 8)
                | ((long) readByte(index + 2, data) << 16)
                | ((long) readByte(index + 3, data) << 24)
                | ((long) readByte(index + 1, data) << 32)
                | ((long) readByte(index + 2, data) << 40)
                | ((long) readByte(index + 3, data) << 48)
                | ((long) readByte(index + 2, data) << 56);
    }
}
