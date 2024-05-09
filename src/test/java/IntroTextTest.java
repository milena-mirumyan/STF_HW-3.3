import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntroTextTest extends K5Test {
    private BenefitsPage benefitsPage;

    @BeforeEach
    public void setUp() {
        benefitsPage = new BenefitsPage(driver);
    }

    @Test
    public void testIntroTextWithAllPOMs() {
        // Interaction with IntroPage through BenefitsPage
        String introText = benefitsPage.getIntroPage().getIntroText();
        boolean isIntroTextCorrect = introText.contains("Reading & Math for K-5");
        Assertions.assertTrue(isIntroTextCorrect, AssertionMessages.introNameInCorrect);

        // Interaction with BenefitsPage
        benefitsPage.clickContactLink();
        // Interaction with FooterPage through BenefitsPage
        benefitsPage.getFooterPage().scrollToFooter();
        // Interaction with SearchPage through BenefitsPage
        benefitsPage.getSearchPage().searchFor("fractions"); // Assuming a method to perform a search for "fractions" in the search page
        Assertions.assertTrue(driver.getPageSource().contains("fractions"), AssertionMessages.searchUnSuccessful);
    }



    @Test
    public void testIntroTextAfterFooterNavigation() {
        // Initially checking the intro text
        String initialIntroText = benefitsPage.getIntroPage().getIntroText();
        Assertions.assertTrue(initialIntroText.contains("Reading & Math for K-5"), AssertionMessages.introNameInCorrect);

        // Navigate to footer page and then return
        benefitsPage.getFooterPage().scrollToFooter();

        // Check the intro text again after returning
        String returnedIntroText = benefitsPage.getIntroPage().getIntroText();
        Assertions.assertTrue(returnedIntroText.contains("Reading & Math for K-5"), AssertionMessages.introNameInCorrect);
    }
}
