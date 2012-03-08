package com.slugsource.steam.servers.query;

import com.slugsource.steam.serverbrowser.NotAServerException;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;

/**
 *
 * @author Nathan Fearnley
 */
public abstract class ServerQuery implements Runnable
{
    protected InetAddress address;
    protected int port;
    protected DatagramSocket socket;
    
    public ServerQuery(InetAddress address, int port)
    {
        this.address = address;
        this.port = port;
    }

    @Override
    public void run()
    {
        try
        {
            queryServer();
        } catch (Exception ex)
        {
            // Todo: Put something useful here
        }
    }

    public void queryServer() throws NotAServerException, SocketTimeoutException, SocketException, IOException
    {
        try (DatagramSocket socket = new DatagramSocket())
        {
            this.socket = socket;
            sendQueryRequest();
            readQueryResponse();
        }
    }

    protected abstract void sendQueryRequest() throws SocketException, IOException;

    protected abstract void readQueryResponse() throws NotAServerException, SocketTimeoutException, SocketException, IOException;
}
