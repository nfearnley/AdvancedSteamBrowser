package com.slugsource.steam.servers;

import java.net.InetAddress;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Nathan Fearnley
 */
public class KillingFloorServer extends SourceServer
{

    private int serverId;
    private String serverIp;
    private int gamePort;
    private int statusQueryPort;
    private String serverName;
    private String gameMap;
    private String gameType;
    private int numberOfPlayers;
    private int maximumPlayers;
    private int ping;
    private int serverFlags;
    private String skillLevel;
    private List<GameInfo> gameInfo = new LinkedList<>();
    private List<Player> players = new LinkedList<>();
    
    public KillingFloorServer()
    {
    }

    public KillingFloorServer(InetAddress address, int port)
    {
        super(address, port);
    }

    public int getServerId()
    {
        return serverId;
    }

    public void setServerId(int serverId)
    {
        this.serverId = serverId;
    }

    public String getServerIp()
    {
        return serverIp;
    }

    public void setServerIp(String serverIp)
    {
        this.serverIp = serverIp;
    }

    public int getKFGamePort()
    {
        return gamePort;
    }

    public void setKFGamePort(int gamePort)
    {
        this.gamePort = gamePort;
    }

    public int getStatusQueryPort()
    {
        return statusQueryPort;
    }

    public void setStatusQueryPort(int statusQueryPort)
    {
        this.statusQueryPort = statusQueryPort;
    }

    public String getKFServerName()
    {
        return serverName;
    }

    public void setKFServerName(String serverName)
    {
        this.serverName = serverName;
    }

    public String getGameMap()
    {
        return gameMap;
    }

    public void setGameMap(String gameMap)
    {
        this.gameMap = gameMap;
    }

    public String getGameType()
    {
        return gameType;
    }

    public void setGameType(String gameType)
    {
        this.gameType = gameType;
    }

    public int getKFNumberOfPlayers()
    {
        return numberOfPlayers;
    }

    public void setKFNumberOfPlayers(int numberOfPlayers)
    {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getKFMaximumPlayers()
    {
        return maximumPlayers;
    }

    public void setKFMaximumPlayers(int maximumPlayers)
    {
        this.maximumPlayers = maximumPlayers;
    }

    public int getPing()
    {
        return ping;
    }

    public void setPing(int ping)
    {
        this.ping = ping;
    }

    public int getServerFlags()
    {
        return serverFlags;
    }

    public void setServerFlags(int serverFlags)
    {
        this.serverFlags = serverFlags;
    }

    public String getSkillLevel()
    {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel)
    {
        this.skillLevel = skillLevel;
    }

    public List<GameInfo> getGameInfo()
    {
        return gameInfo;
    }

    public void setGameInfo(List<GameInfo> gameInfo)
    {
        this.gameInfo = gameInfo;
    }

    public List<Player> getPlayers()
    {
        return players;
    }

    public void setPlayers(List<Player> players)
    {
        this.players = players;
    }

    @Override
    public String toString()
    {
        String output = super.toString() + "\n";
        // Append Killing Floor server parameters
        return output;
    }
}