/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slugsource.steam.serverbrowser;

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
    public static Server getServerInfo(InetAddress address, int port) throws SocketTimeoutException, NotAServerException, IOException
    {
        DatagramPacket response;
        try
        (DatagramSocket datagramSocket = new DatagramSocket()) {
            datagramSocket.setSoTimeout(1000);

            byte[] prefix =
            {
                (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0x54
            };

            byte suffix = 0x00;

            byte[] sendBuffer = ArrayUtils.addAll(prefix, "Source Engine Query".getBytes());
            sendBuffer = ArrayUtils.addAll(sendBuffer, suffix);

            DatagramPacket request = new DatagramPacket(
                    sendBuffer, sendBuffer.length, address, port);

            datagramSocket.send(request);

            byte[] receiveBuffer = new byte[1400];
            response = new DatagramPacket(receiveBuffer, 1400);

            datagramSocket.receive(response);
        }
        
        ServerReader sReader = new ServerReader();
        Server myServer = sReader.readServer(response.getData());
        return myServer;
    }
}
