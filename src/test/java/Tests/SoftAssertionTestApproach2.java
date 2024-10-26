package Tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.within;

public class SoftAssertionTestApproach2 {

    @Test
    public void softAssertionTest1() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(3.14).isCloseTo(3, within(0.1));
            softly.assertThat("World").endsWith("l");
            softly.assertThat("OpenAI").contains("AI");
        });
    }

    @Test
    public void softAssertionTest2() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat("Hello").startsWith("H");
            softly.assertThat(10).isGreaterThan(15);
            softly.assertThat(3.14).isCloseTo(3, within(0.1));
        });
    }
}
