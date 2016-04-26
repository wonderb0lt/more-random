package com.github.javachat.morerandom;

import java.util.Random;

public class MoreRandomFactory {
    private static int SEED = 4; // Chosen by fair dice roll

    public static MoreRandom stable() {
        return new MoreRandom(new Random(SEED));
    }


}
