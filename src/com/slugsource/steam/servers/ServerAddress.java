package com.slugsource.steam.servers;

import java.net.InetAddress;

/**
 *
 * @author Nathan Fearnley
 */
public class ServerAddress
{

    private volatile InetAddress address;
    private volatile int port;

    public ServerAddress()
    {
    }

    public ServerAddress(InetAddress address, int port)
    {
        this.address = address;
        this.port = port;
    }

    public InetAddress getAddress()
    {
        return address;
    }

    public void setAddress(InetAddress address)
    {
        this.address = address;
    }

    public int getPort()
    {
        return port;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    @Override
    public String toString()
    {
        String output = "";
        output += address.getHostAddress() + ":";
        output += port;
        return output;
    }
}
