package com.slugsource.steam.servers;

/**
 *
 * @author Nathan Fearnley
 */
public class GameInfo
{

    private volatile String name;
    private volatile String value;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return name + "=" + value;
    }
}
