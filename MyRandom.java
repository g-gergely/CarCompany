package com.codecool;

import java.util.Random;

public class MyRandom {
    private static final Random RANDOM = new Random();

    private MyRandom() {}

    public static int between(int lower, int upper){
        return lower +RANDOM.nextInt(upper-lower);
    }

    public static int nextInt(int max){
        return RANDOM.nextInt(max);
    }
}
