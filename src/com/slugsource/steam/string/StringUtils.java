package com.slugsource.steam.string;

import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author Nathan Fearnley
 */
public class StringUtils
{

    public static byte[] getNullTerminatedString(String string)
    {
        return ArrayUtils.add(string.getBytes(), (byte) 0x00);
    }

    public static byte[] getLengthPrefixedNullTerminatedString(String string)
    {
        byte[] data = getNullTerminatedString(string);
        byte[] length =
        {
            (byte) data.length
        };
        return ArrayUtils.addAll(length, data);
    }
}
