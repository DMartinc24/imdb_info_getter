package imdb;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SelenideWait;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static Locators locators = new Locators();
    private static String summary;
    private static String rating;
    private static String quote;
    private static String director;
    private static String review;
    private static String VALUE;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome friend!");
        System.out.println("Which movie or show do you want to explore? Please enter the name: ");
        System.out.println();
        VALUE = scanner.nextLine();
        open("https://www.imdb.com/");
        $x(locators.SEARCH_INPUT).val(VALUE);
        $x(locators.SEARCH_RESULT).click();
        getSummary();
        getRating();
        System.out.println("First we well give you some summary about it:");
        System.out.println(summary);
        System.out.println("Now lets see the rating! Excited?");
        System.out.println("And the rating is.. tadadaaa : " + rating);
        System.out.println("Now lets have some action!");
        decideAction();
    }

    public static void getSummary() {
        if ($x(locators.SUMMARY_TEXT).exists()) {
            summary = $x(locators.SUMMARY_TEXT).getText();
        } else {
            summary = "Seems the summary is currently not available, sorry!";
        }
    }

    public static void getRating() {
        rating = $x(locators.RATING).shouldBe(visible).getText();
    }

    public static void decideAction() {
        System.out.println("What would you like to know? Want to see some random quote? Type 1");
        System.out.println("Want to know who produced it? Type 2");
        System.out.println("Want to see a random review? Type 3!");
        System.out.println("Want to exit? Type 4!");
        int inp = scanner.nextInt();
        switch (inp) {
            case 1:
                getRandomQuote();
                break;
            case 2:
                getProducer();
                break;
            case 3:
                getReview();
                break;
            case 4:
                exit();
                break;
            default:
                System.out.println("Invalid choice sorry");
                decideAction();
        }
        System.out.println("Do you want to continue? For yes type 1 and for no type 2");
        int inp2 = scanner.nextInt();
        switch (inp2) {
            case 1:
                exit();
                open("http:\\www.imdb.com");
                $x(locators.SEARCH_INPUT).val(VALUE);
                $x(locators.SEARCH_RESULT).click();
                decideAction();
                break;
            case 2:
                exit();
                break;
            default:
                System.out.println("Invalid choice sorry");
                decideAction();
        }
    }


    public static void getRandomQuote() {
        $x(locators.SHOW_MORE).shouldBe(visible).click();
        $$x(locators.MORE_ITEMS).shouldHave(CollectionCondition.sizeGreaterThan(5));
        $$x(locators.MORE_ITEMS).findBy(exactText("Quotes")).click();
        $x(locators.QUOTES_LIST).shouldBe(visible);
        List<String> texts = $$x(locators.QUOTE).texts();
        int max = texts.size();
        int rand = (int) (Math.random() * max);
        quote = texts.get(rand);

        System.out.println("A random quote for you: " + quote);
    }

    public static void getProducer() {
        director = $x(locators.DIRECTOR).shouldBe(visible).getText();
        System.out.println("The producer is " + director);
    }

    public static void getReview() {
        $x(locators.USER_REVIEWS).shouldBe(visible).click();
        $$x(locators.REVIEW_ITEMS).shouldHave(CollectionCondition.sizeGreaterThan(0));
        List<String> reviews = $$x(locators.REVIEW_ITEMS).texts();
        int max = reviews.size();
        int rand = (int) (Math.random() * max);
        review = reviews.get(rand);
        System.out.println("Here is a random review: " + review);
    }


    public static void exit() {
        close();
    }


}

