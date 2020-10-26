
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.ElementsCollection.*;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SelenideWait;
import org.junit.Test;
import org.openqa.selenium.By;

public class Main {

    private static String MORE_LOCATOR = "//span[@class='show_more quicklink']";
    private static String ITEMS_COLLECTION = "//div[@class='quicklinkSectionItem']";
    private static String QUOTE_HYPERLINK = "//a[@class='quicklink' and contains(text(),'Quotes')]";
    private static String QUOTE_COUNTER = "//div[@class='ipl-itemcount-header']";
    private static String QUOTE_RESULTS = "//div[@class='sodatext']";
    private static String A_QUOTE = "//div[@id='qt1535701']";

    public static void main(String[] args) {

       open("https://www.imdb.com/");

       $(By.name("q")).setValue("Sex and the city");
       $(By.xpath("/html/body/div[1]/nav/div[2]/div[1]/form/div[2]/div/div/div/ul/li[1]/a/div[1]")).click();
       $x(MORE_LOCATOR).shouldBe(visible).click();
       $$x(ITEMS_COLLECTION).shouldHaveSize(29);
       $x(QUOTE_HYPERLINK).click();
       $x(QUOTE_COUNTER).shouldBe(visible);
       $$x(QUOTE_RESULTS).shouldHave(CollectionCondition.sizeGreaterThan(0));
       String quote = $x(A_QUOTE).shouldBe(visible).getText();

       System.out.println(quote);



    }


}
