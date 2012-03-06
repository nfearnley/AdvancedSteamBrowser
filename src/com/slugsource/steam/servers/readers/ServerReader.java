package com.slugsource.steam.servers.readers;

import com.slugsource.steam.serverbrowser.NotAServerException;
import com.slugsource.steam.servers.SourceServer;
import java.net.DatagramPacket;

/**
 *
 * @author Nathan Fearnley
 */
public abstract class ServerReader<T extends SourceServer>
{

    protected int index;
    protected byte[] data;
    protected int length;

    public ServerReader()
    {
    }

    public abstract void readServer(DatagramPacket packet, T server) throws NotAServerException;

    protected boolean readBoolean()
    {
        if (index >= length)
        {
            throw new IndexOutOfBoundsException("Reached end of packet.");
        }
        boolean result = data[index] == 0x01;
        index += 1;
        return result;
    }

    protected char readChar()
    {
        if (index >= length)
        {
            throw new IndexOutOfBoundsException("Reached end of packet.");
        }
        char result = (char) data[index];
        index += 1;
        return result;
    }

    protected String readNullTerminatedString()
    {
        if (index >= length)
        {
            throw new IndexOutOfBoundsException("Reached end of packet.");
        }
        int count = 0;
        while (data[index + count] != 00)
        {
            count++;
            if (index + count >= length)
            {
                throw new IndexOutOfBoundsException("Reached end of packet.");
            }
        }

        String result = new String(data, index, count);
        index += count + 1;
        return result;
    }

    protected String readLengthPrefixedNullTerminatedString()
    {
        if (index >= length)
        {
            throw new IndexOutOfBoundsException("Reached end of packet.");
        }
        int count = readUInt8();
        if (index + count > length)
        {
            throw new IndexOutOfBoundsException("Reached end of packet.");
        }
        String result = "";
        if (count != 0)
        {
            result = new String(data, index, count - 1);
        }
        index += count;
        return result;
    }

    protected int readUInt8()
    {
        if (index >= length)
        {
            throw new IndexOutOfBoundsException("Reached end of packet.");
        }
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

    // Bug: large unsigned ints become negative signed ints
    // TODO: Add support for real unsigned 32-bit integers
    protected int readUInt32()
    {
        int result = readUInt8()
                | (readUInt8() << 8)
                | (readUInt8() << 16)
                | (readUInt8() << 24);
        return result;
    }

    // Bug: large unsigned ints become negative signed ints
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
