/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slugsource.steam.serverbrowser;

import java.io.IOException;
import java.net.*;
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
            sendRequest(InetAddress.getByName("localhost"), 28852);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return;
        }
    }

    private static void sendRequest(InetAddress address, int port) throws SocketException, IOException
    {
        DatagramSocket datagramSocket = new DatagramSocket();
        datagramSocket.setSoTimeout(1000);

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
        try
        {
            System.out.println("\nServer " + address.getHostAddress() + ":" + port);
            datagramSocket.receive(receivePacket);
            ServerReader sReader = new ServerReader();
            Server myServer = sReader.readServer(receivePacket.getData());
            System.out.println(myServer);
            
        } catch (SocketTimeoutException ex)
        {
            System.out.println("Could not contact server");
        }
        catch (NotAServerException ex)
        {
            System.out.println("Response was not a server description");
        }
        finally
        {
            datagramSocket.close();
        }
    }
}
