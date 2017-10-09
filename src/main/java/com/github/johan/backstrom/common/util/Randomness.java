package com.github.johan.backstrom.common.util;

import java.util.Random;

public interface Randomness {
    public Random getRandom();
    public int getRandomInteger(int lowerBound, int upperBound);
}
