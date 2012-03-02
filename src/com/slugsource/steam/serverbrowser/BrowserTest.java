/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slugsource.steam.serverbrowser;

import java.net.DatagramSocket;

/**
 *
 * @author Nathan Fearnley
 */
public class BrowserTest
{
    public static void main(String[] args)
    {
        DatagramSocket s = new DatagramSocket();
        ServerBrowser.testMethod(null);
    }
}
