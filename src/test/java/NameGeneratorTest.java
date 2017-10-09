import com.github.johan.backstrom.common.core.Attribute;
import com.github.johan.backstrom.common.standard.StandardAttribute;
import com.github.johan.backstrom.data.person.generator.FamilyNameGenerator;
import com.github.johan.backstrom.data.person.generator.FirstNameGenerator;
import com.github.johan.backstrom.data.person.generator.NameGenerator;
import com.github.johan.backstrom.entities.person.Gender;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NameGeneratorTest {
    private static final long SEED_VALUE = 999L;
    private static final int NUMBER_OF_NAMES = 5;

    @Test
    public void generateFirstNameTest_withSeed() {
        String[] expectedNames = new String[NUMBER_OF_NAMES];
        Attribute<Gender> gender = new StandardAttribute<>(
                "gender",
                dependencyAttributes -> Gender.Female
        );
        gender.setValue(Gender.Female);

        NameGenerator generator = new FirstNameGenerator(gender, SEED_VALUE);
        for (int i = 0; i < NUMBER_OF_NAMES; i++) {
            expectedNames[i] = generator.generate();
        }
        // re-initialize generator with the same seed value
        generator = new FirstNameGenerator(gender, SEED_VALUE);
        String[] names = new String[expectedNames.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = generator.generate();
            assertEquals(expectedNames[i], names[i]);
        }
    }

    @Test
    public void generateFamilyNameTest_withSeed() {
        String[] expectedNames = new String[NUMBER_OF_NAMES];
        Attribute<Gender> gender = new StandardAttribute<>(
                "gender",
                dependencyAttributes -> Gender.Male
        );
        gender.setValue(Gender.Male);

        NameGenerator generator = new FamilyNameGenerator(gender, SEED_VALUE);
        for (int i = 0; i < NUMBER_OF_NAMES; i++) {
            expectedNames[i] = generator.generate();
        }
        // re-initialize generator with the same seed value
        generator = new FamilyNameGenerator(gender, SEED_VALUE);
        String[] names = new String[expectedNames.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = generator.generate();
            assertEquals(expectedNames[i], names[i]);
        }
    }
}
