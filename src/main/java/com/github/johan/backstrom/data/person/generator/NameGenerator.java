package com.github.johan.backstrom.data.person.generator;

import com.github.johan.backstrom.common.core.Attribute;
import com.github.johan.backstrom.common.core.model.random.WeightedRandomizedCollection;
import com.github.johan.backstrom.entities.person.Gender;

public abstract class NameGenerator {
    protected Attribute<Gender> genderAttribute;
    protected WeightedRandomizedCollection<String> weightedNames;

    protected NameGenerator(Attribute<Gender> genderAttribute) {
        this.genderAttribute = genderAttribute;
        initWeightedNames();
    }

    public String generate() {
        return weightedNames.next();
    }

    protected abstract void initWeightedNames();
}
