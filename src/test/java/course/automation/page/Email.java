package course.automation.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Email extends AbstractPage {
    private static final String MAILPAGE_URL = "https://yopmail.com/";
    WebDriverWait wait = new WebDriverWait(driver, 30);
    private Logger log = LogManager.getRootLogger();

    @FindBy(xpath = "//*[@id='login']")
    private WebElement checkEmail;

    @FindBy(xpath = "//div[contains(text(),'Google Cloud Platform Price Estimate')][1]")
    private WebElement findMail;

    @FindBy(xpath = "//*[@id='mail']//td[2]/h3")
    private WebElement totalCostFromEmail;

    @FindBy(xpath = "//*[@id='ifinbox']")
    private WebElement changeBoxMailFrame;


    public Email(WebDriver driver) {
        super(driver);
    }

    public Email openEmailPage() {
        driver.get(MAILPAGE_URL);
        return this;
    }

    public Email openEmailBox(String email) {
        wait.until(ExpectedConditions.visibilityOf(checkEmail));
        checkEmail.sendKeys(Keys.CLEAR);
        checkEmail.sendKeys(email, Keys.ENTER);

        new WebDriverWait(driver, 50).until(ExpectedConditions
                .frameToBeAvailableAndSwitchToIt(changeBoxMailFrame));

        log.info("frame 'ifinbox' is switched ");

        List<WebElement> allMails = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                (By.xpath("//*[@class='m']"))));

        for (int i = 0; i < allMails.size(); i++) {
            if (allMails.get(i).getText().contains("Google Cloud Sales")) {
                allMails.get(i).click();
            }
            log.info(allMails.get(i).getText());
        }

        driver.switchTo().defaultContent();
        driver.switchTo().frame("ifmail");
        log.info("frame 'ifmail' is switched ");

        return this;
    }

    public String getTotalCost() {
        wait.until(ExpectedConditions.visibilityOf(totalCostFromEmail));

        return totalCostFromEmail.getText();
    }
}
