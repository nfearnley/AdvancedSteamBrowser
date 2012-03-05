package com.slugsource.steam.serverbrowser;

import com.slugsource.steam.servers.readers.SourceServerReader;
import com.slugsource.steam.servers.readers.KillingFloorServerReader;
import com.slugsource.steam.servers.KillingFloorServer;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author Nathan Fearnley
 */
public class ServerBrowser
{

    /*
     * public static List<ServerAddress> getServerList() { InetAddress address =
     * InetAddress.getByName("192")
     *
     * DatagramPacket response; try (DatagramSocket datagramSocket = new
     * DatagramSocket()) { datagramSocket.setSoTimeout(1000);
     *
     * byte[] prefix = { (byte) 0x31, (byte) 0xFF };
     *
     * byte[] ip = "0.0.0.0:0".getBytes();
     *
     * byte[] ipSuffix = { 0x00 };
     *
     * byte[] filter = "\\gamedir\\killingfloor".getBytes();
     *
     * byte[] filterSuffix = { 0x00 };
     *
     * byte[] sendBuffer = ArrayUtils.addAll(prefix, ip); sendBuffer =
     * ArrayUtils.addAll(sendBuffer, ipSuffix); sendBuffer =
     * ArrayUtils.addAll(sendBuffer, filter); sendBuffer =
     * ArrayUtils.addAll(sendBuffer, filterSuffix);
     *
     * DatagramPacket request = new DatagramPacket( sendBuffer,
     * sendBuffer.length, address, port);
     *
     * datagramSocket.send(request);
     *
     * byte[] receiveBuffer = new byte[1400]; response = new
     * DatagramPacket(receiveBuffer, 1400);
     *
     * datagramSocket.receive(response); }
     *
     * ServerReader sReader = new ServerReader(); Server myServer =
     * sReader.readServer(response.getData()); myServer.setAddress(address);
     * myServer.setPort(port); return myServer;
     *
     * List<ServerAddress> list = new LinkedList<>();
     *
     * return list;
     *
     *
     * }
     */
    public static KillingFloorServer getServerInfo(InetAddress address, int port) throws SocketTimeoutException, NotAServerException, IOException
    {
        SourceServerReader sReader = new SourceServerReader();
        KillingFloorServerReader kfReader = new KillingFloorServerReader();
        KillingFloorServer myServer = new KillingFloorServer(address, port);
        byte[] data;

        data = querySourceServer(address, port);
        sReader.readServer(data, myServer);

        data = queryKillingFloorServer(address, port);
        kfReader.readServer(data, myServer);



        return myServer;
    }

    private static byte[] querySourceServer(InetAddress address, int port) throws IOException
    {
        DatagramPacket response;
        try (DatagramSocket datagramSocket = new DatagramSocket())
        {
            datagramSocket.setSoTimeout(1000);

            byte[] prefix =
            {
                (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0x54
            };

            byte[] query = "Source Engine Query".getBytes();

            byte[] suffix =
            {
                0x00
            };

            byte[] sendBuffer = ArrayUtils.addAll(prefix, query);
            sendBuffer = ArrayUtils.addAll(sendBuffer, suffix);

            DatagramPacket request = new DatagramPacket(
                    sendBuffer, sendBuffer.length, address, port);

            datagramSocket.send(request);

            byte[] receiveBuffer = new byte[1400];
            response = new DatagramPacket(receiveBuffer, 1400);

            datagramSocket.receive(response);
        }
        return response.getData();
    }

    // TODO: Add support for killing floor server
    private static byte[] queryKillingFloorServer(InetAddress address, int port) throws IOException
    {
        DatagramPacket response;
        try (DatagramSocket datagramSocket = new DatagramSocket())
        {
            datagramSocket.setSoTimeout(1000);

            byte[] prefix =
            {
                (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0x54
            };

            byte[] query = "Source Engine Query".getBytes();

            byte[] suffix =
            {
                0x00
            };

            byte[] sendBuffer = ArrayUtils.addAll(prefix, query);
            sendBuffer = ArrayUtils.addAll(sendBuffer, suffix);

            DatagramPacket request = new DatagramPacket(
                    sendBuffer, sendBuffer.length, address, port);

            datagramSocket.send(request);

            byte[] receiveBuffer = new byte[1400];
            response = new DatagramPacket(receiveBuffer, 1400);

            datagramSocket.receive(response);
        }
        return response.getData();
    }
}
