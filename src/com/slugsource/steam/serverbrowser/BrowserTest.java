package com.slugsource.steam.serverbrowser;

import com.slugsource.steam.servers.KillingFloorServer;
import com.slugsource.steam.servers.ServerAddress;
import com.slugsource.steam.servers.query.KillingFloorGameQuery;
import com.slugsource.steam.servers.query.KillingFloorPlayerQuery;
import com.slugsource.steam.servers.query.KillingFloorServerQuery;
import com.slugsource.steam.servers.query.MasterServerQuery;
import com.slugsource.steam.servers.query.SourceServerQuery;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Nathan Fearnley
 */
public class BrowserTest
{

    private static SourceServerQuery srcQuery = new SourceServerQuery();
    private static KillingFloorServerQuery kfServerQuery = new KillingFloorServerQuery();
    private static KillingFloorGameQuery kfGameQuery = new KillingFloorGameQuery();
    private static KillingFloorPlayerQuery kfPlayerQuery = new KillingFloorPlayerQuery();
    private static MasterServerQuery mQuery = new MasterServerQuery();

    public static void main(String[] args)
    {
        try
        {
            sendMasterRequest(InetAddress.getByName("208.64.200.52"), 27011);
//            sendRequest(InetAddress.getByName("68.232.176.139"), 28852);
//            sendRequest(InetAddress.getByName("localhost"), 28852);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    private static void sendMasterRequest(InetAddress address, int port) throws IOException
    {
        try
        {
            String header = "Server " + address.getHostAddress() + ":" + port;
            header += '\n' + StringUtils.repeat('=', header.length());
            System.out.println(header);

            List<ServerAddress> serverList = new LinkedList<>();

            mQuery.queryServer(address, port, "", serverList);

            System.out.println(serverList);
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

    private static void sendRequest(InetAddress address, int port) throws IOException
    {
        try
        {
            String header = "Server " + address.getHostAddress() + ":" + port;
            header += '\n' + StringUtils.repeat('=', header.length());
            System.out.println(header);

            KillingFloorServer server = new KillingFloorServer(address, port);

            srcQuery.queryServer(address, port, server);
            kfServerQuery.queryServer(address, server.getGamePort() + 1, server);
            kfGameQuery.queryServer(address, server.getGamePort() + 1, server);
            kfPlayerQuery.queryServer(address, server.getGamePort() + 1, server);

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
