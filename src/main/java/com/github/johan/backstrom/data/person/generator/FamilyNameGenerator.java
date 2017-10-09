package com.github.johan.backstrom.data.person.generator;

import com.github.johan.backstrom.common.core.Attribute;
import com.github.johan.backstrom.common.core.model.random.RandomNumberGenerator;
import com.github.johan.backstrom.common.core.model.random.RandomPicker;
import com.github.johan.backstrom.common.core.model.random.WeightedRandomizedCollection;
import com.github.johan.backstrom.data.person.Gender;
import com.github.johan.backstrom.data.person.sweden.DataHelper;
import com.github.johan.backstrom.data.person.sweden.dictionary.SwedishNameDictionary;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FamilyNameGenerator extends NameGenerator {
    public FamilyNameGenerator(Attribute<Gender> genderAttribute) {
        super(genderAttribute);
    }

    protected void initWeightedNames() {
        Random random = DataHelper.getRandomness().getRandom();
        int numberOfItems = 10;
        List<String> selectedNames = new RandomPicker<String>().pick(random, Arrays.asList(SwedishNameDictionary.SURNAMES), numberOfItems);
        double[] weights = RandomNumberGenerator.generateWithSpecifiedSum(random, numberOfItems, 100);
        weightedNames = new WeightedRandomizedCollection<>(random);
        for (int i = 0; i < numberOfItems; i++) {
            weightedNames.add(weights[i], selectedNames.get(i));
        }
    }
}
