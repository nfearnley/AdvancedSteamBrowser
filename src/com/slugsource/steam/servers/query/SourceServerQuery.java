package com.slugsource.steam.servers.query;

import com.slugsource.steam.serverbrowser.NotAServerException;
import com.slugsource.steam.servers.SourceServer;
import com.slugsource.steam.servers.readers.SourceServerReader;
import com.slugsource.steam.string.StringUtils;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author Nathan Fearnley
 */
public class SourceServerQuery extends ServerQuery
{

    private SourceServerReader reader = new SourceServerReader();
    private SourceServer server;

    public SourceServerQuery(InetAddress address, int port, SourceServer server)
    {
        super(address, port);
        this.server = server;
    }

    @Override
    protected void sendQueryRequest() throws SocketException, IOException
    {
        byte[] header =
        {
            (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0x54
        };

        byte[] query = StringUtils.getNullTerminatedString("Source Engine Query");

        byte[] buffer = ArrayUtils.addAll(header, query);

        DatagramPacket request = new DatagramPacket(
                buffer, buffer.length, address, port);

        socket.send(request);
    }

    @Override
    protected void readQueryResponse() throws NotAServerException, SocketTimeoutException, SocketException, IOException
    {
        socket.setSoTimeout(300);

        byte[] receiveBuffer = new byte[1400];
        DatagramPacket response = new DatagramPacket(receiveBuffer, 1400);

        socket.receive(response);

        reader.readServer(response, server);
    }
}
