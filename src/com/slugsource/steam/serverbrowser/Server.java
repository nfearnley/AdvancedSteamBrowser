/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slugsource.steam.serverbrowser;

/**
 *
 * @author Nathan Fearnley
 */
public class Server
{
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
    //  - Unrecognized Difficulty
    //  0 Easy
    //  1 Normal
    //  2 Hard
    //  3 Suicidal
    //  4 Hell on Earth
    private String gameTagDataString;
    private char difficulty;
    private long gameId;

    public Server()
    {
        
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
        output += ("Type: " + Integer.toHexString(type));
        output += ("Version: " + version);
        output += ("Server Name: " + serverName);
        output += ("Map: " + map);
        output += ("Game Directory: " + gameDirectory);
        output += ("Game Description: " + gameDescription);
        output += ("App ID: " + appId);
        output += ("Number of Players: " + numberOfPlayers);
        output += ("Maximum Players: " + maximumPlayers);
        output += ("Number of Bots: " + numberOfBots);
        switch (dedicated)
        {
            case 'l':
                output += ("Dedicated: Listen");
                break;
            case 'd':
                output += ("Dedicated: Dedicated");
                break;
            case 'p':
                output += ("Dedicated: SourceTV");
                break;
            default:
                output += ("Dedicated: Unknown");
        }
        switch (operatingSystem)
        {
            case 'l':
                output += ("Operating System: Linux");
                break;
            case 'w':
                output += ("Operating System: Windows");
                break;
            default:
                output += ("Operating System: Unknown");
        }
        output += ((password ? "" : "No ") + "Password");
        output += ((vacSecured ? "" : "Not ") + "VAC Secured");
        output += ("Game Version: " + gameVersion);
        output += ("Has Game Port: " + hasGamePort);
        output += ("Has Steam ID: " + hasSteamId);
        output += ("Has Spectator Server: " + hasSpectatorServer);
        output += ("Has Game Tag Data String: " + hasGameTagDataString);
        output += ("Has Game ID: " + hasGameId);
        if (hasGamePort)
        {
            output += ("Game Port: " + gamePort);
        }

        if (hasSteamId)
        {
            output += ("Steam ID: " + steamId);
        }

        if (hasSpectatorServer)
        {
            output += ("Spectator Server Port: " + spectatorServerPort);
            output += ("Spectator Server Name: " + spectatorServerName);
        }

        // d;#;#
        // d; ?
        // #; ?
        // # Difficulty?
        //  - Unrecognized Difficulty
        //  0 Easy
        //  1 Normal
        //  2 Hard
        //  3 Suicidal
        //  4 Hell on Earth
        if (hasGameTagDataString)
        {
            output += ("Game Tag Data String: " + gameTagDataString);
            
            switch (operatingSystem)
            {
                case '0':
                    output += ("Difficulty: Easy");
                    break;
                case '1':
                    output += ("Difficulty: Normal");
                    break;
                case '2':
                    output += ("Difficulty: Hard");
                    break;
                case '3':
                    output += ("Difficulty: Suicidal");
                    break;
                case '4':
                    output += ("Difficulty: Hell on Earth");
                    break;
                default:
                    output += ("Difficulty: Unknown");
            }
        }

        // TODO: Fix to support unsigned 64 bit numbers
        if (hasGameId)
        {
            output += ("Game ID: " + gameId);

        }

        return output;
    }
}
