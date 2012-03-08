package com.slugsource.steam.servers;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

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
    
    public static ServerAddress getZeroAddress()
    {
        ServerAddress address = null;
        try
        {
            address = new ServerAddress(InetAddress.getByName("0.0.0.0"), 0);
        } catch (UnknownHostException ex)
        {
            // This should never happen.
            assert false;
        }
        return address;
    }

    @Override
    public String toString()
    {
        String output = "";
        output += address.getHostAddress() + ":";
        output += port;
        return output;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final ServerAddress other = (ServerAddress) obj;
        if (!Objects.equals(this.address, other.address))
        {
            return false;
        }
        if (this.port != other.port)
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.address);
        hash = 79 * hash + this.port;
        return hash;
    }
}
