package com.slugsource.steam.servers.query;

import com.slugsource.steam.serverbrowser.NotAServerException;
import com.slugsource.steam.servers.KillingFloorServer;
import com.slugsource.steam.string.StringUtils;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author Nathan Fearnley
 */
public class KillingFloorPlayerQuery extends ServerQuery<KillingFloorServer>
{

    @Override
    protected DatagramSocket sendQueryRequest(InetAddress address, int port) throws SocketException, IOException
    {
        DatagramSocket socket = new DatagramSocket();

        byte[] header =
        {
            (byte) 0x80, (byte) 0x00, (byte) 0x00, (byte) 0x00
        };
        
        byte query = 0x02;  // Request player information

        byte[] buffer = ArrayUtils.addAll(header, query);

        DatagramPacket request = new DatagramPacket(
                buffer, buffer.length, address, port);

        socket.send(request);
        return socket;
    }

    @Override
    protected void readQueryResponse(DatagramSocket socket, KillingFloorServer server) throws NotAServerException, SocketException, IOException
    {
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
