package com.github.johan.backstrom.common.core.model.random;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomPicker<T> {
    public List<T> pick(Random random, List<T> items, int numberOfPickedItems) {
        return IntStream
                .generate(() -> random.nextInt(items.size()))
                .distinct()
                .limit(numberOfPickedItems)
                .mapToObj(items::get)
                .collect(Collectors.toList());
    }
}
