package Tests;

import POJOs.Person;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DemoTest {
    @Test
    public void testString() {
        String actual = "Hello, World!";

        assertThat(actual).isEqualTo("Hello, World!")
                .startsWith("Hello")
                .endsWith("World!")
                .contains("Hello")
                .doesNotContain("Universe");

        // Check equality
        Assert.assertEquals(actual, "Hello, World!", "The actual string does not match the expected value.");

        // Check if it starts with a given prefix
        Assert.assertTrue(actual.startsWith("Hello"), "The actual string does not start with 'Hello'.");

        // Check if it ends with a given suffix
        Assert.assertTrue(actual.endsWith("World!"), "The actual string does not end with 'World!'.");

        // Check if it contains a substring
        Assert.assertTrue(actual.contains("Hello"), "The actual string does not contain 'Hello'.");

        // Check if it does not contain a substring
        Assert.assertFalse(actual.contains("Universe"), "The actual string should not contain 'Universe'.");
    }

    @Test
    public void testInt() {
        int actual = 42;

        assertThat(actual).isEqualTo(42)
                .isPositive()
                .isGreaterThan(40)
                .isLessThan(50);
    }

    @Test
    public void testCollection() {
        List<String> actual = Arrays.asList("apple", "banana", "cherry");

        assertThat(actual).isNotEmpty()
                .hasSize(3)
                .contains("banana")
                .doesNotContain("grape")
                .containsExactly("apple", "banana", "cherry")
                .containsExactlyInAnyOrder("cherry", "banana", "apple");
    }

    @Test
    public void testObjects() {
        Person actual = new Person("Ram", 28);

        assertThat(actual)
                .extracting(Person::getName)
                .isEqualTo("Sham");
    }

    @Test
    public void testListObjects() {
        List<Person> actual = List.of(
                new Person("Ram", 28),
                new Person("Sham", 30));

        assertThat(actual)
                .extracting(Person::getName)
                .containsExactlyInAnyOrder("Sham", "Ram", "ABC");
    }

    @Test
    public void testCustomErrorMessages1() {
        String actual = "Hello, World!";

        assertThat(actual)
                .as("Test--Expected 'Hello, Universe!' but was '%s'", actual)
                .isEqualTo("Hello, Universe!");
    }

    @Test
    public void testCustomErrorMessages2() {
        String actual = "Hello, World!";

        assertThat(actual)
                .overridingErrorMessage("Test>> Expected 'Hello, Universe!' but was '%s'", actual)
                .isEqualTo("Hello, Universe!");
    }
}
