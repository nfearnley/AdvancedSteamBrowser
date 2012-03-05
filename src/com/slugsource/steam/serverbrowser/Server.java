package com.slugsource.steam.serverbrowser;

import java.net.InetAddress;

/**
 *
 * @author Nathan Fearnley
 */
public class Server
{
    private ServerAddress serverAddress;
    private int type;
    private int version;
    private String serverName;
    private String map;
    private String gameDirectory;
    private String gameDescription;
    private int appId;
    private int numberOfPlayers;
    private int maximumPlayers;
    private int numberOfBots;
    private char dedicated;
    private char operatingSystem;
    private boolean password;
    private boolean vacSecured;
    private String gameVersion;
    private boolean hasGamePort;
    private boolean hasSteamId;
    private boolean hasSpectatorServer;
    private boolean hasGameTagDataString;
    private boolean hasGameId;
    private int gamePort;
    private long steamId;
    private int spectatorServerPort;
    private String spectatorServerName;
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

    public Server()
    {
    }

    public Server(InetAddress address, int port)
    {
        this.serverAddress = new ServerAddress(address, port);
    }
    
    public ServerAddress getServerAddress()
    {
        return serverAddress;
    }

    public void setServerAddress(ServerAddress serverAddress)
    {
        this.serverAddress = serverAddress;
    }

    public int getAppId()
    {
        return appId;
    }

    public void setAppId(int appId)
    {
        this.appId = appId;
    }

    public char getDedicated()
    {
        return dedicated;
    }

    public void setDedicated(char dedicated)
    {
        this.dedicated = dedicated;
    }

    public char getDifficulty()
    {
        return difficulty;
    }

    public void setDifficulty(char difficulty)
    {
        this.difficulty = difficulty;
    }

    public String getGameDescription()
    {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription)
    {
        this.gameDescription = gameDescription;
    }

    public String getGameDirectory()
    {
        return gameDirectory;
    }

    public void setGameDirectory(String gameDirectory)
    {
        this.gameDirectory = gameDirectory;
    }

    public long getGameId()
    {
        return gameId;
    }

    public void setGameId(long gameId)
    {
        this.gameId = gameId;
    }

    public int getGamePort()
    {
        return gamePort;
    }

    public void setGamePort(int gamePort)
    {
        this.gamePort = gamePort;
    }

    public String getGameTagDataString()
    {
        return gameTagDataString;
    }

    public void setGameTagDataString(String gameTagDataString)
    {
        this.gameTagDataString = gameTagDataString;
    }

    public String getGameVersion()
    {
        return gameVersion;
    }

    public void setGameVersion(String gameVersion)
    {
        this.gameVersion = gameVersion;
    }

    public boolean hasGameId()
    {
        return hasGameId;
    }

    public void setHasGameId(boolean hasGameId)
    {
        this.hasGameId = hasGameId;
    }

    public boolean hasGamePort()
    {
        return hasGamePort;
    }

    public void setHasGamePort(boolean hasGamePort)
    {
        this.hasGamePort = hasGamePort;
    }

    public boolean hasGameTagDataString()
    {
        return hasGameTagDataString;
    }

    public void setHasGameTagDataString(boolean hasGameTagDataString)
    {
        this.hasGameTagDataString = hasGameTagDataString;
    }

    public boolean hasSpectatorServer()
    {
        return hasSpectatorServer;
    }

    public void setHasSpectatorServer(boolean hasSpectatorServer)
    {
        this.hasSpectatorServer = hasSpectatorServer;
    }

    public boolean hasSteamId()
    {
        return hasSteamId;
    }

    public void setHasSteamId(boolean hasSteamId)
    {
        this.hasSteamId = hasSteamId;
    }

    public String getMap()
    {
        return map;
    }

    public void setMap(String map)
    {
        this.map = map;
    }

    public int getMaximumPlayers()
    {
        return maximumPlayers;
    }

    public void setMaximumPlayers(int maximumPlayers)
    {
        this.maximumPlayers = maximumPlayers;
    }

    public int getNumberOfBots()
    {
        return numberOfBots;
    }

    public void setNumberOfBots(int numberOfBots)
    {
        this.numberOfBots = numberOfBots;
    }

    public int getNumberOfPlayers()
    {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers)
    {
        this.numberOfPlayers = numberOfPlayers;
    }

    public char getOperatingSystem()
    {
        return operatingSystem;
    }

    public void setOperatingSystem(char operatingSystem)
    {
        this.operatingSystem = operatingSystem;
    }

    public boolean isPassword()
    {
        return password;
    }

    public void setPassword(boolean password)
    {
        this.password = password;
    }

    public String getServerName()
    {
        return serverName;
    }

    public void setServerName(String serverName)
    {
        this.serverName = serverName;
    }

    public String getSpectatorServerName()
    {
        return spectatorServerName;
    }

    public void setSpectatorServerName(String spectatorServerName)
    {
        this.spectatorServerName = spectatorServerName;
    }

    public int getSpectatorServerPort()
    {
        return spectatorServerPort;
    }

    public void setSpectatorServerPort(int spectatorServerPort)
    {
        this.spectatorServerPort = spectatorServerPort;
    }

    public long getSteamId()
    {
        return steamId;
    }

    public void setSteamId(long steamId)
    {
        this.steamId = steamId;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public boolean isVacSecured()
    {
        return vacSecured;
    }

    public void setVacSecured(boolean vacSecured)
    {
        this.vacSecured = vacSecured;
    }

    public int getVersion()
    {
        return version;
    }

    public void setVersion(int version)
    {
        this.version = version;
    }

    @Override
    public String toString()
    {
        String output = "";
        output += ("Type: " + Integer.toHexString(type) + "\n");
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
