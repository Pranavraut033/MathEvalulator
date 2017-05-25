package com.Pranav.Math;



/**
 * Created on 22-04-17 at 14:11
 *
 * @author Pranav
 * @version 1
 */

public class Mathematics {

    public static long fact(int num) {
        return num == 0 ? 1 : num * fact(num - 1);
    }
}
