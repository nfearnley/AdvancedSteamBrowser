package com.slugsource.steam.servers.query;

import com.slugsource.steam.serverbrowser.NotAServerException;
import com.slugsource.steam.servers.KillingFloorServer;
import com.slugsource.steam.servers.readers.KillingFloorServerReader;
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
public class KillingFloorServerQuery extends ServerQuery
{

    private KillingFloorServerReader reader = new KillingFloorServerReader();
    private KillingFloorServer server;
    
    public KillingFloorServerQuery(InetAddress address, int port, KillingFloorServer server)
    {
        super(address, port);
        this.server = server;
    }

    @Override
    protected void sendQueryRequest() throws SocketException, IOException
    {
        byte[] header =
        {
            (byte) 0x80, (byte) 0x00, (byte) 0x00, (byte) 0x00
        };

        byte query = 0x00;  // Request server information

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
