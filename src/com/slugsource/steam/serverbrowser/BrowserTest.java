package com.slugsource.steam.serverbrowser;

import com.slugsource.steam.servers.KillingFloorServer;
import com.slugsource.steam.servers.query.SourceServerQuery;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Nathan Fearnley
 */
public class BrowserTest
{

    public static void main(String[] args)
    {
        try
        {
            sendRequest(InetAddress.getByName("216.246.108.212"), 28952);
            sendRequest(InetAddress.getByName("68.232.169.160"), 28852);
            sendRequest(InetAddress.getByName("localhost"), 28852);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private static void sendRequest(InetAddress address, int port) throws IOException
    {
        try
        {
            String header = "Server " + address.getHostAddress() + ":" + port;
            header += '\n' + StringUtils.repeat('-', header.length());
            System.out.println(header);
            KillingFloorServer server = new KillingFloorServer(address, port);
            SourceServerQuery query = new SourceServerQuery();
            query.queryServer(address, port, server);
            System.out.println(server);
        } catch (SocketTimeoutException ex)
        {
            System.out.println("Could not contact server");
        } catch (NotAServerException ex)
        {
            System.out.println("Response was not a server description");
        } finally
        {
            System.out.println();
        }
    }
}
