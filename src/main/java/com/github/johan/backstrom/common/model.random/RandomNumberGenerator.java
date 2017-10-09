package com.github.johan.backstrom.common.model;

import java.util.Random;

public class RandomNumberGenerator {
    public static double[] generateWithSpecifiedSum(Random random, int numberOfItems, double sumOfItems) {
        double randomNumbers[] = new double[numberOfItems];
        double total = 0;

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextDouble();
            total += randomNumbers[i];
        }

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = randomNumbers[i] / total * sumOfItems;
        }

        return randomNumbers;
    }
}
