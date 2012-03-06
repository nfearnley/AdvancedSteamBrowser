/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slugsource.steam.servers;

/**
 *
 * @author Nathan Fearnley
 */
public class Player
{
    private int id;
    private String name;
    private int ping;
    private int score;
    private int statsId;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getPing()
    {
        return ping;
    }

    public void setPing(int ping)
    {
        this.ping = ping;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public int getStatsId()
    {
        return statsId;
    }

    public void setStatsId(int statsId)
    {
        this.statsId = statsId;
    }

    @Override
    public String toString()
    {
        String output = "[";
        output += "Player: " + name + ", ";
        output += "ID: " + id + ", ";
        output += "Ping: " + ping + ", ";
        output += "Score: " + score + ", ";
        output += "Stats ID: " + statsId;
        output += "]";
        return output;
    }
}
