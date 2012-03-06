package com.slugsource.steam.servers.query;

import com.slugsource.steam.serverbrowser.NotAServerException;
import com.slugsource.steam.servers.SourceServer;
import com.slugsource.steam.servers.readers.SourceServerReader;
import com.slugsource.steam.string.StringUtils;
import java.io.IOException;
import java.net.*;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author Nathan Fearnley
 */
public class SourceServerQuery extends ServerQuery<SourceServer>
{

    SourceServerReader reader = new SourceServerReader();

    @Override
    protected DatagramSocket sendQueryRequest(InetAddress address, int port) throws SocketException, IOException
    {
        DatagramSocket socket = new DatagramSocket();

        byte[] header =
        {
            (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0x54
        };

        byte[] query = StringUtils.getNullTerminatedString("Source Engine Query");

        byte[] buffer = ArrayUtils.addAll(header, query);

        DatagramPacket request = new DatagramPacket(
                buffer, buffer.length, address, port);

        socket.send(request);
        return socket;
    }

    @Override
    protected void readQueryResponse(DatagramSocket socket, SourceServer server) throws NotAServerException, SocketTimeoutException, SocketException, IOException
    {
        socket.setSoTimeout(1000);

        byte[] receiveBuffer = new byte[1400];
        DatagramPacket response = new DatagramPacket(receiveBuffer, 1400);

        socket.receive(response);

        reader.readServer(response, server);
    }
}
