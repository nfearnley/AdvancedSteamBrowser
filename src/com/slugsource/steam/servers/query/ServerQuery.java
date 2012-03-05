package com.slugsource.steam.servers.query;

import com.slugsource.steam.serverbrowser.NotAServerException;
import com.slugsource.steam.servers.Server;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;

/**
 *
 * @author Nathan Fearnley
 */
public abstract class ServerQuery<T extends Server>
{

    public void queryServer(InetAddress address, int port, T server) throws NotAServerException, SocketTimeoutException, SocketException, IOException
    {
        try (DatagramSocket socket = sendQueryRequest(address, port))
        {
            readQueryResponse(socket, server);
        }
    }

    protected abstract DatagramSocket sendQueryRequest(InetAddress address, int port) throws SocketException, IOException;

    protected abstract void readQueryResponse(DatagramSocket socket, T server) throws NotAServerException, SocketTimeoutException, SocketException, IOException;
}
