package com.github.johan.backstrom.data.person.generator;

import com.github.johan.backstrom.common.core.Attribute;
import com.github.johan.backstrom.common.core.model.random.WeightedRandomizedCollection;
import com.github.johan.backstrom.entities.person.Gender;
import com.github.johan.backstrom.entities.util.DataHelper;

public abstract class NameGenerator {
    protected Attribute<Gender> genderAttribute;
    protected WeightedRandomizedCollection<String> weightedNames;

    protected NameGenerator(Attribute<Gender> genderAttribute) {
        this.genderAttribute = genderAttribute;
        initWeightedNames();
    }

    protected NameGenerator(Attribute<Gender> genderAttribute, long seedValue) {
        this(genderAttribute);
        this.setSeed(seedValue);
        initWeightedNames();
    }

    public void setSeed(long seedValue) {
        DataHelper.getRandomness().getRandom().setSeed(seedValue);
    }

    public String generate() {
        return weightedNames.next();
    }

    protected abstract void initWeightedNames();
}
