package com.slugsource.steam.servers.readers;

import com.slugsource.steam.serverbrowser.NotAServerException;
import com.slugsource.steam.servers.Player;
import com.slugsource.steam.servers.ServerAddress;
import com.slugsource.steam.servers.SourceServer;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 *
 * @author Nathan Fearnley
 */
public class MasterServerReader extends ServerReader<List<ServerAddress>>
{

    public MasterServerReader()
    {
    }

    @Override
    public void readServer(DatagramPacket packet, List<ServerAddress> serverList) throws NotAServerException
    {
        this.index = 0;
        this.data = packet.getData();
        this.length = packet.getLength();

        int prefix = readLittleEndianUInt32();
        if (prefix != 0xFFFFFFFF)
        {
            throw new NotAServerException("Prefix does not match.");
        }

        int type = readLittleEndianUInt16();
        if (type != 0x0A66)
        {
            throw new NotAServerException("Wrong response type.");
        }
        
        while (index < length)
        {
            ServerAddress address = new ServerAddress();
            
            byte[] rawAddress = new byte[4];
            rawAddress[0] = (byte)readUInt8();
            rawAddress[1] = (byte)readUInt8();
            rawAddress[2] = (byte)readUInt8();
            rawAddress[3] = (byte)readUInt8();
            
            InetAddress ipAddress;
            try
            {
                ipAddress = InetAddress.getByAddress(rawAddress);
            }
            catch (UnknownHostException ex)
            {
                break;
            }
            
            address.setAddress(ipAddress);
            address.setPort(readBigEndianUInt16());

            serverList.add(address);
        }
    }
}
