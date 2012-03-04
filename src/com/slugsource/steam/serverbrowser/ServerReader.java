/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slugsource.steam.serverbrowser;

/**
 *
 * @author Nathan Fearnley
 */
public class ServerReader
{

    int index;
    byte[] data;

    public ServerReader()
    {
    }

    public Server readServer(byte[] rawdata) throws NotAServerException
    {
        this.index = 0;
        this.data = rawdata;
        Server server = new Server();

        int prefix = readLong();
        if (prefix != 0xFFFFFFFF)
        {
            throw new NotAServerException("Prefix does not match.");
        }

        server.setType(readByte());
        server.setVersion(readByte());
        server.setServerName(readString());
        server.setMap(readString());
        server.setGameDirectory(readString());
        server.setGameDescription(readString());
        server.setAppId(readShort());
        server.setNumberOfPlayers(readByte());
        server.setMaximumPlayers(readByte());
        server.setNumberOfBots(readByte());
        server.setDedicated(readChar());
        server.setOperatingSystem(readChar());
        server.setPassword(readBoolean());
        server.setVacSecured(readBoolean());
        server.setGameVersion(readString());

        int extraDataFlag = readByte();
        server.setHasGamePort((extraDataFlag & 0x80) != 0);
        server.setHasSteamId((extraDataFlag & 0x10) != 0);
        server.setHasSpectatorServer((extraDataFlag & 0x40) != 0);
        server.setHasGameTagDataString((extraDataFlag & 0x20) != 0);
        server.setHasGameId((extraDataFlag & 0x01) != 0);

        if (server.hasGamePort())
        {
            server.setGamePort(readByte());
        }

        if (server.hasSteamId())
        {
            server.setSteamId(readLongLong());
        }

        if (server.hasSpectatorServer())
        {
            server.setSpectatorServerPort(readShort());
            server.setSpectatorServerName(readString());
        }

        if (server.hasGameTagDataString())
        {
            server.setGameTagDataString(readString());
            server.setDifficulty(server.getGameTagDataString().charAt(4));
        }

        if (server.hasGameId())
        {
            server.setGameId(readLongLong());
        }

        return server;
    }

    private boolean readBoolean()
    {
        boolean result = data[index] == 0x01;
        index += 1;
        return result;
    }

    private char readChar()
    {
        char result = (char) data[index];
        index += 1;
        return result;
    }

    private String readString()
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

        String result = new String(data, index, count);
        index += count + 1;
        return result;
    }

    private int readByte()
    {
        int result = 0xFF & data[index];
        index += 1;
        return result;
    }

    private int readShort()
    {
        int result = readByte()
                | (readByte() << 8);
        return result;
    }

    private int readLong()
    {
        int result = readByte()
                | (readByte() << 8)
                | (readByte() << 16)
                | (readByte() << 24);
        return result;
    }

    // Fix support for real unsigned 64-bit integers
    private long readLongLong()
    {
        long result = (long) readByte()
                | ((long) readByte() << 8)
                | ((long) readByte() << 16)
                | ((long) readByte() << 24)
                | ((long) readByte() << 32)
                | ((long) readByte() << 40)
                | ((long) readByte() << 48)
                | ((long) readByte() << 56);
        return result;
    }
}
