package com.github.johan.backstrom.common.core.model.random;

import java.security.SecureRandom;
import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

public class WeightedRandomizedCollection<E> {
    protected NavigableMap<Double, E> map;
    protected Random random;
    protected double total;

    public WeightedRandomizedCollection() {
        this(new SecureRandom());
    }

    public WeightedRandomizedCollection(Random random) {
        this.map = new TreeMap<>();
        this.random = random;
        this.total = 0;
    }

    public WeightedRandomizedCollection<E> add(double weight, E entry) {
        if (weight <= 0) {
            return this;
        }
        total += weight;
        map.put(total, entry);
        return this;
    }

    public E next() {
        double value = random.nextDouble() * total;
        return map.higherEntry(value).getValue();
    }
}
