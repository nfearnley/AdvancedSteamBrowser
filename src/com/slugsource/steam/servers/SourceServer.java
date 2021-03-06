package com.slugsource.steam.servers;

import java.net.InetAddress;

/**
 *
 * @author Nathan Fearnley
 */
public class SourceServer extends Server
{

    private volatile ServerAddress serverAddress;
    private volatile int version;
    private volatile String serverName;
    private volatile String map;
    private volatile String gameDirectory;
    private volatile String gameDescription;
    private volatile int appId;
    private volatile int numberOfPlayers;
    private volatile int maximumPlayers;
    private volatile int numberOfBots;
    private volatile char dedicated;
    private volatile char operatingSystem;
    private volatile boolean password;
    private volatile boolean vacSecured;
    private volatile String gameVersion;
    private volatile boolean hasGamePort;
    private volatile boolean hasSteamId;
    private volatile boolean hasSpectatorServer;
    private volatile boolean hasGameTagDataString;
    private volatile boolean hasGameId;
    private volatile int gamePort;
    private volatile long steamId;
    private volatile int spectatorServerPort;
    private volatile String spectatorServerName;
    // d;#;#
    // d; ?
    // #; ?
    // # Difficulty?
    private String gameTagDataString;
    //  - Unrecognized Difficulty
    //  0 Easy
    //  1 Normal
    //  2 Hard
    //  3 Suicidal
    //  4 Hell on Earth
    private char difficulty;
    private long gameId;

    public SourceServer()
    {
    }

    public SourceServer(InetAddress address, int port)
    {
        this.serverAddress = new ServerAddress(address, port);
    }

    public int getAppId()
    {
        return appId;
    }

    public char getDedicated()
    {
        return dedicated;
    }

    public char getDifficulty()
    {
        return difficulty;
    }

    public String getGameDescription()
    {
        return gameDescription;
    }

    public String getGameDirectory()
    {
        return gameDirectory;
    }

    public long getGameId()
    {
        return gameId;
    }

    public int getGamePort()
    {
        return gamePort;
    }

    public String getGameTagDataString()
    {
        return gameTagDataString;
    }

    public String getGameVersion()
    {
        return gameVersion;
    }

    public String getMap()
    {
        return map;
    }

    public int getMaximumPlayers()
    {
        return maximumPlayers;
    }

    public int getNumberOfBots()
    {
        return numberOfBots;
    }

    public int getNumberOfPlayers()
    {
        return numberOfPlayers;
    }

    public char getOperatingSystem()
    {
        return operatingSystem;
    }

    public ServerAddress getServerAddress()
    {
        return serverAddress;
    }

    public String getServerName()
    {
        return serverName;
    }

    public String getSpectatorServerName()
    {
        return spectatorServerName;
    }

    public int getSpectatorServerPort()
    {
        return spectatorServerPort;
    }

    public long getSteamId()
    {
        return steamId;
    }

    public int getVersion()
    {
        return version;
    }

    public boolean hasGameId()
    {
        return hasGameId;
    }

    public boolean hasGamePort()
    {
        return hasGamePort;
    }

    public boolean hasGameTagDataString()
    {
        return hasGameTagDataString;
    }

    public boolean hasSpectatorServer()
    {
        return hasSpectatorServer;
    }

    public boolean hasSteamId()
    {
        return hasSteamId;
    }

    public boolean isPassword()
    {
        return password;
    }

    public boolean isVacSecured()
    {
        return vacSecured;
    }

    public void setAppId(int appId)
    {
        this.appId = appId;
    }

    public void setDedicated(char dedicated)
    {
        this.dedicated = dedicated;
    }

    public void setDifficulty(char difficulty)
    {
        this.difficulty = difficulty;
    }

    public void setGameDescription(String gameDescription)
    {
        this.gameDescription = gameDescription;
    }

    public void setGameDirectory(String gameDirectory)
    {
        this.gameDirectory = gameDirectory;
    }

    public void setGameId(long gameId)
    {
        this.gameId = gameId;
    }

    public void setGamePort(int gamePort)
    {
        this.gamePort = gamePort;
    }

    public void setGameTagDataString(String gameTagDataString)
    {
        this.gameTagDataString = gameTagDataString;
    }

    public void setGameVersion(String gameVersion)
    {
        this.gameVersion = gameVersion;
    }

    public void setHasGameId(boolean hasGameId)
    {
        this.hasGameId = hasGameId;
    }

    public void setHasGamePort(boolean hasGamePort)
    {
        this.hasGamePort = hasGamePort;
    }

    public void setHasGameTagDataString(boolean hasGameTagDataString)
    {
        this.hasGameTagDataString = hasGameTagDataString;
    }

    public void setHasSpectatorServer(boolean hasSpectatorServer)
    {
        this.hasSpectatorServer = hasSpectatorServer;
    }

    public void setHasSteamId(boolean hasSteamId)
    {
        this.hasSteamId = hasSteamId;
    }

    public void setMap(String map)
    {
        this.map = map;
    }

    public void setMaximumPlayers(int maximumPlayers)
    {
        this.maximumPlayers = maximumPlayers;
    }

    public void setNumberOfBots(int numberOfBots)
    {
        this.numberOfBots = numberOfBots;
    }

    public void setNumberOfPlayers(int numberOfPlayers)
    {
        this.numberOfPlayers = numberOfPlayers;
    }

    public void setOperatingSystem(char operatingSystem)
    {
        this.operatingSystem = operatingSystem;
    }

    public void setPassword(boolean password)
    {
        this.password = password;
    }

    public void setServerAddress(ServerAddress serverAddress)
    {
        this.serverAddress = serverAddress;
    }

    public void setServerName(String serverName)
    {
        this.serverName = serverName;
    }

    public void setSpectatorServerName(String spectatorServerName)
    {
        this.spectatorServerName = spectatorServerName;
    }

    public void setSpectatorServerPort(int spectatorServerPort)
    {
        this.spectatorServerPort = spectatorServerPort;
    }

    public void setSteamId(long steamId)
    {
        this.steamId = steamId;
    }

    public void setVacSecured(boolean vacSecured)
    {
        this.vacSecured = vacSecured;
    }

    public void setVersion(int version)
    {
        this.version = version;
    }

    @Override
    public String toString()
    {
        String output = "";
        output += "-------------------------\n";
        output += "Source Server Information\n";
        output += "-------------------------\n";
        output += ("Version: " + version + "\n");
        output += ("Server Name: " + serverName + "\n");
        output += ("Map: " + map + "\n");
        output += ("Game Directory: " + gameDirectory + "\n");
        output += ("Game Description: " + gameDescription + "\n");
        output += ("App ID: " + appId + "\n");
        output += ("Number of Players: " + numberOfPlayers + "\n");
        output += ("Maximum Players: " + maximumPlayers + "\n");
        output += ("Number of Bots: " + numberOfBots + "\n");
        output += "Dedicated: ";
        switch (dedicated)
        {
            case 'l':
                output += ("Listen");
                break;
            case 'd':
                output += ("Dedicated");
                break;
            case 'p':
                output += ("SourceTV");
                break;
            default:
                output += ("Unknown");
        }
        output += "\n";
        output += "Operating System: ";
        switch (operatingSystem)
        {
            case 'l':
                output += ("Linux");
                break;
            case 'w':
                output += ("Windows");
                break;
            default:
                output += ("Unknown");
        }
        output += "\n";
        output += ((password ? "" : "No ") + "Password\n");
        output += ((vacSecured ? "" : "Not ") + "VAC Secured\n");
        output += ("Game Version: " + gameVersion + "\n");
        output += ("Has Game Port: " + hasGamePort + "\n");
        output += ("Has Steam ID: " + hasSteamId + "\n");
        output += ("Has Spectator Server: " + hasSpectatorServer + "\n");
        output += ("Has Game Tag Data String: " + hasGameTagDataString + "\n");
        output += ("Has Game ID: " + hasGameId + "\n");
        if (hasGamePort)
        {
            output += ("Game Port: " + gamePort + "\n");
        }
        if (hasSteamId)
        {
            output += ("Steam ID: " + steamId + "\n");
        }
        if (hasSpectatorServer)
        {
            output += ("Spectator Server Port: " + spectatorServerPort + "\n");
            output += ("Spectator Server Name: " + spectatorServerName + "\n");
        }
        if (hasGameTagDataString)
        {
            output += ("Game Tag Data String: " + gameTagDataString + "\n");
            output += "Difficulty: ";
            switch (difficulty)
            {
                case '0':
                    output += ("Easy");
                    break;
                case '1':
                    output += ("Normal");
                    break;
                case '2':
                    output += ("Hard");
                    break;
                case '3':
                    output += ("Suicidal");
                    break;
                case '4':
                    output += ("Hell on Earth");
                    break;
                default:
                    output += ("Unknown");
            }
            output += "\n";
        }
        if (hasGameId)
        {
            output += ("Game ID: " + gameId);
        }
        return output;
    }
}
