package io.sommers.vehicularengineering.utils;

public class BitUtils {
    public static int getIntFromBooleanArray(boolean[] array)
    {
        int result = 0;
        for (boolean b : array)
        {
            result = (result << 1) | (b ? 1 : 0);
        }
        return result;
    }

    public static boolean[] getBooleanArrayFromInt(int input, int arraySize)
    {
        boolean[] bits = new boolean[arraySize];
        for (int i = arraySize - 1; i >= 0; i--) {
            bits[i] = (input & (1 << i)) != 0;
        }

        return bits;
    }
}
