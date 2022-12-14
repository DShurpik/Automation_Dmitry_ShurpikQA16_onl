package pageObjects.moodpanda;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends MoodPandaBasePage {

    private By getStartedBtn = By.partialLinkText("Get started");
    private By title = By.cssSelector("[class^=container] > p[class^='title ']");

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public HomePage open(String url){
        load(url);
        isPageOpened();
        return this;
    }

    public HomePage clickGetStarted(){
        click(getStartedBtn);
        return this;
    }


    @Override
    public void isPageOpened() { // состояния страницы, или для динамического контента
        waitVisibilityOfElement(title);
        verifyElementClickable(getStartedBtn);
    }
}
