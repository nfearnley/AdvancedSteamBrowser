package com.slugsource.steam.servers.query;

import com.slugsource.steam.serverbrowser.NotAServerException;
import com.slugsource.steam.servers.KillingFloorServer;
import com.slugsource.steam.servers.readers.KillingFloorServerReader;
import java.io.IOException;
import java.net.*;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author Nathan Fearnley
 */
public class KillingFloorServerQuery extends ServerQuery<KillingFloorServer>
{

    @Override
    protected DatagramSocket sendQueryRequest(InetAddress address, int port) throws SocketException, IOException
    {
        DatagramSocket socket = new DatagramSocket();

        byte[] header =
        {
            (byte) 0x80, (byte) 0x00, (byte) 0x00, (byte) 0x00
        };

        byte query = 0x00;  // Request server information

        byte[] buffer = ArrayUtils.addAll(header, query);

        DatagramPacket request = new DatagramPacket(
                buffer, buffer.length, address, port);

        socket.send(request);
        return socket;
    }

    @Override
    protected void readQueryResponse(DatagramSocket socket, KillingFloorServer server) throws NotAServerException, SocketTimeoutException, SocketException, IOException
    {
        socket.setSoTimeout(1000);

        byte[] receiveBuffer = new byte[1400];
        DatagramPacket response = new DatagramPacket(receiveBuffer, 1400);

        socket.receive(response);

        byte[] data = response.getData();

        KillingFloorServerReader sReader = new KillingFloorServerReader();

        sReader.readServer(data, server);
    }
}
