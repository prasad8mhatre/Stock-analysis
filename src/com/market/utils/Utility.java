package com.market.utils;

import java.util.Random;

public class Utility {
    public static int getRandomNumber(int low, int high) {
        Random r = new Random();
        return r.nextInt(high - low) + low;
    }


}
