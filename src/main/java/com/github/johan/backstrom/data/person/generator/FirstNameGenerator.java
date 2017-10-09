package com.github.johan.backstrom.data.person.generator;

import com.github.johan.backstrom.common.core.Attribute;
import com.github.johan.backstrom.common.core.model.random.RandomNumberGenerator;
import com.github.johan.backstrom.common.core.model.random.RandomPicker;
import com.github.johan.backstrom.common.core.model.random.WeightedRandomizedCollection;
import com.github.johan.backstrom.data.person.sweden.dictionary.SwedishNameDictionary;
import com.github.johan.backstrom.entities.person.Gender;
import com.github.johan.backstrom.entities.util.DataHelper;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FirstNameGenerator extends NameGenerator {
    public FirstNameGenerator(Attribute<Gender> genderAttribute) {
        super(genderAttribute);
    }

    protected void initWeightedNames() {
        Random random = DataHelper.getRandomness().getRandom();
        RandomPicker<String> randomPicker = new RandomPicker<>();
        int numberOfItems = 10;
        String[] names = genderAttribute.getValue().equals(Gender.Male) ?
                SwedishNameDictionary.MALE_FIRST_NAMES :
                SwedishNameDictionary.FEMALE_FIRST_NAMES;
        List<String> selectedNames = randomPicker.pick(random, Arrays.asList(names), numberOfItems);
        double[] weights = RandomNumberGenerator.generateWithSpecifiedSum(random, numberOfItems, 100);
        weightedNames = new WeightedRandomizedCollection<>(random);
        for (int i = 0; i < numberOfItems; i++) {
            weightedNames.add(weights[i], selectedNames.get(i));
        }
    }
}
