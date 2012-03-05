/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slugsource.steam.serverbrowser;

import java.net.InetAddress;

/**
 *
 * @author Nathan Fearnley
 */
public class ServerAddress
{

    private InetAddress address;
    private int port;

    public ServerAddress()
    {
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
    
    
}
