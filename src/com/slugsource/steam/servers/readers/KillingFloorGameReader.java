package com.slugsource.steam.servers.readers;

import com.slugsource.steam.serverbrowser.NotAServerException;
import com.slugsource.steam.servers.GameInfo;
import com.slugsource.steam.servers.KillingFloorServer;
import java.net.DatagramPacket;
import java.util.List;

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
    public void readServer(DatagramPacket packet, KillingFloorServer server) throws NotAServerException
    {
        this.index = 0;
        this.data = packet.getData();
        this.length = packet.getLength();

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

        List<GameInfo> gameInfoList = server.getGameInfoList();

        while (index < length)
        {
            GameInfo gameInfo = new GameInfo();
            gameInfo.setName(readLengthPrefixedNullTerminatedString());
            gameInfo.setValue(readLengthPrefixedNullTerminatedString());

            gameInfoList.add(gameInfo);
        }
    }
}
