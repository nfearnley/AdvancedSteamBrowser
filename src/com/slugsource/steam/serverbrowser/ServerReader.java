/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slugsource.steam.serverbrowser;

/**
 *
 * @author Nathan Fearnley
 */
public abstract class ServerReader
{

    protected int index;
    protected byte[] data;

    public ServerReader()
    {
    }

    public Server readServer(byte[] rawdata) throws NotAServerException
    {
        return readServer(rawdata, new Server());
    }

    public abstract Server readServer(byte[] rawdata, Server server) throws NotAServerException;

    protected boolean readBoolean()
    {
        boolean result = data[index] == 0x01;
        index += 1;
        return result;
    }

    protected char readChar()
    {
        char result = (char) data[index];
        index += 1;
        return result;
    }

    protected String readNullTerminatedString()
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

    protected String readLengthPrefixedString()
    {
        int count = readUInt8();
        String result = new String(data, index, count);
        index += count + 1;
        return result;
    }

    protected int readUInt8()
    {
        int result = 0xFF & data[index];
        index += 1;
        return result;
    }

    protected int readUInt16()
    {
        int result = readUInt8()
                | (readUInt8() << 8);
        return result;
    }

    protected int readUInt32()
    {
        int result = readUInt8()
                | (readUInt8() << 8)
                | (readUInt8() << 16)
                | (readUInt8() << 24);
        return result;
    }

    // TODO: Add support for real unsigned 64-bit integers
    protected long readUInt64()
    {
        long result = (long) readUInt8()
                | ((long) readUInt8() << 8)
                | ((long) readUInt8() << 16)
                | ((long) readUInt8() << 24)
                | ((long) readUInt8() << 32)
                | ((long) readUInt8() << 40)
                | ((long) readUInt8() << 48)
                | ((long) readUInt8() << 56);
        return result;
    }
}
