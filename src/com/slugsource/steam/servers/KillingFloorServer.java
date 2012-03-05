package com.slugsource.steam.servers;

import com.slugsource.steam.servers.SourceServer;
import java.net.InetAddress;

/**
 *
 * @author Nathan Fearnley
 */
public class KillingFloorServer extends SourceServer
{

    public KillingFloorServer()
    {
    }

    public KillingFloorServer(InetAddress address, int port)
    {
        super(address, port);
    }

    @Override
    public String toString()
    {
        String output = super.toString() + "\n";
        // Append Killing Floor server parameters
        return output;
    }
    
    
    
}
