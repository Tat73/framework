package course.automation.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FillComputeEngineForm extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private WebDriverWait wait = new WebDriverWait(driver, 40);
    private Logger log = LogManager.getRootLogger();

    private static final String LOCATION_XPATH = "//*[@id='select_container_108']//*[@class='md-text ng-binding' and contains(text(),'%s')]";
    private static final String SSD_XPATH = "//div[@id='select_container_413']//div[@class='md-text ng-binding' and contains(text(),'%s')]";
    private static final String COMMITED_USAGE_XPATH = "//*[@id='select_container_115']//div[@class='md-text' and contains(text(),'%s')]";
    private static final String GRU_NUMBER_XPATH = "//*[@id='select_container_453']//div[@class='md-text ng-binding' and contains(text(),'%s')]";
    private static final String GRU_TYPE_XPATH = "//*[@class='md-select-menu-container md-active md-clickable']//div[@class='md-text ng-binding' and contains(text(),'%s')]";
    private static final String INSTANCE_TYPE_XPATH = "//div[@class='md-text ng-binding' and contains(text(),'%s')]";
    private static final String MACHINE_CLASS_XPATH = "//*[@id='select_container_92']//div[@class='md-text' and contains(text(),'%s')]";
    private static final String SOFTWARE_XPATH = "//div[@class='md-text' and contains(text(),'%s')]";

    @FindBy(xpath = "//input[@name='q']")
    private WebElement search;

    @FindBy(xpath = "//a[@class='gs-title']//b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement clickOnFirstResult;

    @FindBy(xpath = "//div[@class='name ng-binding' and text()='Compute Engine']")
    private WebElement clickOnComputeEngine;

    @FindBy(xpath = "//*[@id='input_74']")
    private WebElement inputNumberOfInstances;

    @FindBy(xpath = "//div[@class='md-text']")
    private WebElement clickOnSoftwareOptions;

    @FindBy(xpath = "//*[@class='md-input-has-placeholder flex md-input-has-value']")
    private WebElement clickOnMachineClass;

    @FindBy(xpath = "//*[@id='select_99']")
    private WebElement clickOnSeries;

    @FindBy(xpath = "//*[@id='select_101']")
    private WebElement clickOnMachineType;

    @FindBy(xpath = "//div[@class='md-label' and contains(text(),'Add GPUs.')]")
    private WebElement clickOnGPUs;

    @FindBy(xpath = "//div[@class='md-label' and contains(text(),'Add Sustained Use Discounts.')]")
    private WebElement clickOnSUD;

    @FindBy(xpath = "//*[@aria-label='GPU type']")
    private WebElement clickToChoseGPUsType;

    @FindBy(xpath = "//*[@id='select_value_label_449']")
    private WebElement entryGRUsNumber;

    @FindBy(xpath = "//*[@id='select_value_label_411']")
    private WebElement clickOnLocalSSD;

    @FindBy(xpath = "//*[@id='select_value_label_72']")
    private WebElement clickOnDatacenterLocation;

    @FindBy(xpath = "//*[@id='select_114']")
    private WebElement clickOnCommitedUsage;

    @FindBy(xpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);' and contains(text(),'Add to Estimate')]")
    private WebElement clickOnButton;

    @FindBy(xpath = "//b[@class='ng-binding' and contains(text(),'Total Estimated Cost')]")
    private WebElement totalCostValue;

    /*
    e-mail
     */

    @FindBy(xpath =
            "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple' and contains(text(),'Email Estimate')]")
    private WebElement clickOnEmailButtonOnCalculator;

    @FindBy(xpath = "//*[@class='txtlien']//b[contains(text(),'Random Email Address')]")
    private WebElement randomEmail;

    @FindBy(xpath = "//*[@id='egen']")
    private WebElement email;

    @FindBy(xpath = "//*[@class='notmobile' and contains(text(),'Copy to clipboard')]")
    private WebElement copyNewEmail;

    @FindBy(xpath = "//*[@type='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//*[@class='md-raised md-primary cpc-button md-button md-ink-ripple' and contains(text(),'Send Email')]")
    private WebElement clickToSendInformationOnEmail;

    public FillComputeEngineForm(WebDriver driver) {
        super(driver);
    }

    public FillComputeEngineForm openCalculatorPage() {
        driver.get(HOMEPAGE_URL);
        waitForPageLoad();

        return this;
    }

    public FillComputeEngineForm inputSearchText(String text) {
        wait.until(ExpectedConditions.visibilityOf(search));
        search.sendKeys(text, Keys.ENTER);

        return this;
    }

    public FillComputeEngineForm searchElement() {
        waitForPageLoad();
        wait.until(ExpectedConditions.visibilityOf(clickOnFirstResult));
        clickOnFirstResult.click();

        return this;
    }

    public FillComputeEngineForm newFrame() {
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");

        log.info("frame is switched");

        return this;
    }

    public FillComputeEngineForm clickOnComputeEngine() {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnComputeEngine)).click();

        return this;
    }

    public FillComputeEngineForm inputNumberOfInstances(String number) {
        wait.until(ExpectedConditions.visibilityOf(inputNumberOfInstances)).click();
        inputNumberOfInstances.sendKeys(number);

        return this;
    }

    public FillComputeEngineForm choseSoftware(String software) {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnSoftwareOptions)).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='md-text' and contains(text(), 'Paid: Ubuntu Pro')]"))));
        WebElement choseSoftwareOptions = driver.findElement(By.xpath("//div[@class='md-text' and contains(text(), 'Paid: Ubuntu Pro')]"));
        choseSoftwareOptions.click();

        wait.until(ExpectedConditions.elementToBeClickable(clickOnSoftwareOptions)).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(SOFTWARE_XPATH, software)))));
        WebElement choseSoftwareOptions1 = driver.findElement(By.xpath(String.format(SOFTWARE_XPATH, software)));
        choseSoftwareOptions1.click();

        log.info(choseSoftwareOptions1.getText());

        return this;
    }

    public FillComputeEngineForm choseMachineClass(String machineClass) {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnMachineClass)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(MACHINE_CLASS_XPATH, machineClass)))));
        WebElement choseClass = driver.findElement(By.xpath(String.format(MACHINE_CLASS_XPATH, machineClass)));
        choseClass.click();

        log.info(choseClass.getText());

        return this;
    }

    public FillComputeEngineForm choseSeriesOfInstanceType(String seriesOfInstanceType) {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnSeries)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(INSTANCE_TYPE_XPATH, seriesOfInstanceType)))));
        WebElement choseSet = driver.findElement(By.xpath(String.format(INSTANCE_TYPE_XPATH, seriesOfInstanceType)));

        choseSet.click();

        log.info(choseSet.getText());

        return this;
    }

    public FillComputeEngineForm choseInstanceType(String instanceType) {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnMachineType)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(INSTANCE_TYPE_XPATH, instanceType)))));
        WebElement choseType = driver.findElement(By.xpath(String.format(INSTANCE_TYPE_XPATH, instanceType)));
        choseType.click();

        log.info(choseType.getText());

        return this;
    }

    public FillComputeEngineForm choseGPUButton() {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnSUD)).click();
        wait.until(ExpectedConditions.elementToBeClickable(clickOnGPUs)).click();

        return this;
    }

    public FillComputeEngineForm choseGRUsType(String inputGRUsType) {

        wait.until(ExpectedConditions.elementToBeClickable(clickToChoseGPUsType)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(GRU_TYPE_XPATH, inputGRUsType)))));
        WebElement GPUsType = driver.findElement(
                By.xpath(String.format(GRU_TYPE_XPATH, inputGRUsType)));
        GPUsType.click();

        log.info(GPUsType.getText());

        return this;
    }

    public FillComputeEngineForm choseGRUsNumber(String GPUsNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(entryGRUsNumber)).click();

        wait.ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(GRU_NUMBER_XPATH, GPUsNumber)))));
        WebElement clickOnGRUsNumber = driver.findElement(By.xpath(String.format(GRU_NUMBER_XPATH, GPUsNumber)));
        clickOnGRUsNumber.click();

        log.info(clickOnGRUsNumber.getText());

        return this;
    }


    public FillComputeEngineForm inputLocalSSD(String SSD) {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnLocalSSD)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(SSD_XPATH, SSD)))));
        WebElement inputSSD = driver.findElement(By.xpath(String.format(SSD_XPATH, SSD)));
        inputSSD.click();

        log.info(inputSSD.getText());

        return this;
    }

    public FillComputeEngineForm choseDatacenterLocation(String location) {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnDatacenterLocation)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(LOCATION_XPATH, location)))));
        WebElement choseLocation = driver.findElement(By.xpath(String.format(LOCATION_XPATH, location)));
        choseLocation.click();

        log.info(choseLocation.getText());

        return this;
    }

    public FillComputeEngineForm choseCommitedUsage(String usage) {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnCommitedUsage)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(COMMITED_USAGE_XPATH, usage)))));
        WebElement choseUsage = driver.findElement(By.xpath(String.format(COMMITED_USAGE_XPATH, usage)));
        choseUsage.click();

        log.info(choseUsage.getText());

        return this;
    }

    public FillComputeEngineForm addToEstimateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnButton)).click();

        return new FillComputeEngineForm(driver);
    }

    public FillComputeEngineForm clickOnEmailButton() {
        wait.until(ExpectedConditions.visibilityOf(clickOnEmailButtonOnCalculator));
        clickOnEmailButtonOnCalculator.click();

        return this;
    }

    public FillComputeEngineForm generateRandomEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(randomEmail));
        randomEmail.click();

        return this;
    }

    public String getEmailString() {
        wait.until(ExpectedConditions.visibilityOf(email));

        return email.getText();
    }

    public FillComputeEngineForm copyEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(copyNewEmail)).click();

        return this;
    }

    public FillComputeEngineForm inputEmailToCalculator(String email) {
        new WebDriverWait(driver, 60).pollingEvery(Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(inputEmail));
        inputEmail.sendKeys(email, Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(clickToSendInformationOnEmail)).click();

        return this;
    }

    public String getEstimatedComponentCostValue() {
        wait.until(ExpectedConditions.visibilityOf(totalCostValue));

        return totalCostValue.getText();
    }
}
