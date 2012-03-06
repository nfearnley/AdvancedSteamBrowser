package com.slugsource.steam.servers.query;

import com.slugsource.steam.serverbrowser.NotAServerException;
import com.slugsource.steam.servers.ServerAddress;
import com.slugsource.steam.servers.readers.MasterServerReader;
import com.slugsource.steam.string.StringUtils;
import java.io.IOException;
import java.net.*;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author Nathan Fearnley
 */
public class MasterServerQuery
{

    MasterServerReader reader = new MasterServerReader();

    public void queryServer(InetAddress address, int port, String filter, List<ServerAddress> serverList)  throws NotAServerException, SocketTimeoutException, SocketException, IOException
    {
        ServerAddress lastAddress;
        try
        {
            lastAddress = new ServerAddress(InetAddress.getByName("0.0.0.0"), 0);
        } catch (UnknownHostException ex)
        {
            return;
        }

        try (DatagramSocket socket = sendQueryRequest(address, port, lastAddress, filter))
        {
            readQueryResponse(socket, serverList);
        }

    }

    private DatagramSocket sendQueryRequest(InetAddress address, int port, ServerAddress lastAddress, String filter) throws SocketException, IOException
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

    private void readQueryResponse(DatagramSocket socket, List<ServerAddress> serverList) throws NotAServerException, SocketTimeoutException, SocketException, IOException
    {
        socket.setSoTimeout(300);

        byte[] receiveBuffer = new byte[1400];
        DatagramPacket response = new DatagramPacket(receiveBuffer, 1400);

        socket.receive(response);

        reader.readServer(response, serverList);
    }
}
