import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.johan.backstrom.common.DocumentBuilder;
import com.github.johan.backstrom.common.core.Attribute;
import com.github.johan.backstrom.common.standard.StandardAttribute;
import com.github.johan.backstrom.data.person.generator.FamilyNameGenerator;
import com.github.johan.backstrom.data.person.generator.FirstNameGenerator;
import com.github.johan.backstrom.data.person.sweden.DataHelper;
import com.github.johan.backstrom.data.person.Gender;
import org.junit.Test;

public class FirstTest {

    Attribute<Gender> gender = new StandardAttribute<>(
            "gender",
            dependencyAttributes -> Gender.Female
    );
    gender.setValue(Gender.Female);

    Attribute<String> lastName = new StandardAttribute<>(
            "lastName",
            dependencyAttributes -> new FamilyNameGenerator(gender).generate()
    );

    Attribute<String> firstName = new StandardAttribute<>(
            "firstName",
            dependencyAttributes -> new FirstNameGenerator(gender).generate()
    );

    Attribute<String> phoneNumber = new StandardAttribute<>(
            "mobilePhone",
            dependencyAttributes -> DataHelper.getRandomMobilePhoneNumber()
    );

    @Test
    public void simpleTest() {

        DocumentBuilder documentBuilder = new DocumentBuilder()
                .addAttribute(gender)
                .addAttribute(firstName)
                .addAttribute(lastName)
                .addAttribute(phoneNumber)
                .addDependency(firstName, gender)
                .buildDataForEmptyAttributes();

        System.out.println(
                documentBuilder.toString()
        );


        try {
            System.out.println(new ObjectMapper().writeValueAsString(documentBuilder.toMap()));
        } catch (Exception e) {

        }
    }
}
