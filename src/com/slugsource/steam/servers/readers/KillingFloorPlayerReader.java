package com.slugsource.steam.servers.readers;

import com.slugsource.steam.serverbrowser.NotAServerException;
import com.slugsource.steam.servers.KillingFloorServer;
import java.net.DatagramPacket;

/**
 *
 * @author Nathan Fearnley
 */
public class KillingFloorPlayerReader extends ServerReader<KillingFloorServer>
{

    public KillingFloorPlayerReader()
    {
    }

    @Override
    public void readServer(DatagramPacket packet, KillingFloorServer server) throws NotAServerException
    {
        // TODO: Change this to read Killing Floor server info
        this.index = 0;
        this.data = packet.getData();
        this.length = packet.getLength();

        int prefix = readUInt32();
        if (prefix != 0x00000080)
        {
            throw new NotAServerException("Prefix does not match.");
        }

        int id = readUInt8();
        if (id != 0x02)
        {
            throw new NotAServerException("Wrong id.");
        }

        throw new UnsupportedOperationException("Not yet finished.");
    }
}
