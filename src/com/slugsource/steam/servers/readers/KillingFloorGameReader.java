package com.slugsource.steam.servers.readers;

import com.slugsource.steam.serverbrowser.NotAServerException;
import com.slugsource.steam.servers.KillingFloorServer;

/**
 *
 * @author Nathan Fearnley
 */
public class KillingFloorGameReader extends ServerReader<KillingFloorServer>
{

    public KillingFloorGameReader()
    {
    }

    @Override
    public void readServer(byte[] rawdata, KillingFloorServer server) throws NotAServerException
    {
        // TODO: Change this to read Killing Floor server info
        this.index = 0;
        this.data = rawdata;

        int prefix = readUInt32();
        if (prefix != 0x00000080)
        {
            throw new NotAServerException("Prefix does not match.");
        }

        int id = readUInt8();
        if (id != 0x01)
        {
            throw new NotAServerException("Wrong id.");
        }

        throw new UnsupportedOperationException("Not yet finished.");
    }
}
