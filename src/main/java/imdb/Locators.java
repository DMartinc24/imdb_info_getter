
package imdb;

public class Locators {

    String SEARCH_INPUT = "//*[@name='q']";
    String SEARCH_RESULT = ".//a[@class='_3GpC-Bj8birceXgWSkFbpC _3ANMP9u58MZGX_ZS9c20p sc-bxivhb fuSwbl']";
    String SUMMARY_TEXT = "//*[@class='summary_text']";
    String RATING = "//*[@class='ratingValue']";
    String DIRECTOR = "//*[@id=\"title-overview-widget\"]/div[2]/div[1]/div[2]/a";
    String USER_REVIEWS = "//*[contains(text(),'USER REVIEWS')]";
    //should be randomized
    String REVIEW_ITEMS = "//*[@class='text show-more__control clickable']";
    String SHOW_MORE = "//*[@class='show_more quicklink']";
    String MORE_ITEMS = "//*[@class='quicklink']";
    String QUOTES_LIST = "//*[@class='list']";
    //should be randomized
    String QUOTE = "//*[@class='sodatext']";

}
