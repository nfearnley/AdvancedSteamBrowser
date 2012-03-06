package com.slugsource.steam.servers.readers;

import com.slugsource.steam.serverbrowser.NotAServerException;
import com.slugsource.steam.servers.KillingFloorServer;
import java.net.DatagramPacket;

/**
 *
 * @author Nathan Fearnley
 */
public class KillingFloorServerReader extends ServerReader<KillingFloorServer>
{

    public KillingFloorServerReader()
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
        if (id != 0x00)
        {
            throw new NotAServerException("Wrong id.");
        }

        server.setServerId(readUInt32());
        server.setServerIp(readLengthPrefixedNullTerminatedString());
        server.setKFGamePort(readUInt32());
        server.setStatusQueryPort(readUInt32());
        server.setKFServerName(readLengthPrefixedNullTerminatedString());
        server.setGameMap(readLengthPrefixedNullTerminatedString());
        server.setGameType(readLengthPrefixedNullTerminatedString());
        server.setKFNumberOfPlayers(readUInt32());
        server.setKFMaximumPlayers(readUInt32());
        server.setPing(readUInt32());
        server.setServerFlags(readUInt32());
        server.setSkillLevel(readLengthPrefixedNullTerminatedString());
    }
}
