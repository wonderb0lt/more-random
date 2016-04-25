package com.github.javachat.morerandom;

import java.util.Random;

public class MoreRandomFactory {
    private static int SEED = 4; // Chosen by fair dice roll
    private static Random SEEDED_INSTANCE = new Random(SEED);
    public static int RANDOM_INTS_TO_COLLECT = 15;
    public static int[] EXPECTED_VALUES = SEEDED_INSTANCE.ints(RANDOM_INTS_TO_COLLECT).toArray();

    public static MoreRandom stable() {
        return new MoreRandom(new Random(SEED));
    }
}
