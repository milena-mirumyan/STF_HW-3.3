import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchTest extends K5Test {
    private BenefitsPage benefitsPage;

    @BeforeEach
    public void setUp() {
        benefitsPage = new BenefitsPage(driver);
    }

    @Test
    public void testSuccessfulSearch() {
        benefitsPage.navigateToBenefits();
        Assertions.assertTrue(benefitsPage.isAt(), AssertionMessages.benefitsPageNotShown);

        // Perform search
        String keyword = "decimals";
        benefitsPage.getSearchPage().searchFor(keyword);
        Assertions.assertTrue(benefitsPage.getSearchPage().isSearchSuccessful(keyword), AssertionMessages.searchUnSuccessful);

        // Verify intro text in this new page
        String introText = benefitsPage.getIntroPage().getIntroText();
        Assertions.assertTrue(introText.contains("Reading & Math for K-5"), AssertionMessages.introNameInCorrect);

        // Scroll to footer
        benefitsPage.getFooterPage().scrollToFooter();
        Assertions.assertTrue(benefitsPage.getFooterPage().isAtFooter(), AssertionMessages.scrollToFooterDisabled);
    }

    @Test
    public void testEmptySearch() {
        // Perform empty search
        benefitsPage.getSearchPage().searchFor("");
        Assertions.assertTrue(benefitsPage.getSearchPage().isSearchSuccessful(""), AssertionMessages.searchUnSuccessful);

        // Verify intro text
        Assertions.assertTrue(benefitsPage.getIntroPage().getIntroText().contains("Reading & Math for K-5"), AssertionMessages.introNameInCorrect);
    }
}
