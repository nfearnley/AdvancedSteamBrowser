/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slugsource.steam.serverbrowser;

/**
 *
 * @author Nathan Fearnley
 */
public class NotAServerException extends Exception
{

    /**
     * Creates a new instance of
     * <code>NotAServerException</code> without detail message.
     */
    public NotAServerException()
    {
    }

    /**
     * Constructs an instance of
     * <code>NotAServerException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public NotAServerException(String msg)
    {
        super(msg);
    }
}
