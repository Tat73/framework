package course.automation.test;

import course.automation.model.FormForCalculator;
import course.automation.page.Email;
import course.automation.page.FillComputeEngineForm;
import course.automation.service.FormForCalculatorCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FillComputeEngineFormTest extends CommonConditions {
    private Logger log = LogManager.getRootLogger();

    @Test
    public void openNewBrowser() {

        FormForCalculator input = FormForCalculatorCreator.withCredentialsFromProperty();
        FillComputeEngineForm fillComputeEngineForm = new FillComputeEngineForm(driver);
        fillComputeEngineForm.openCalculatorPage()
                .inputSearchText("Google Cloud Platform Pricing Calculator")
                .searchElement()
                .newFrame()
                .clickOnComputeEngine()
                .inputNumberOfInstances(input.getNumberOfInstances())
                .choseSoftware(input.getOperationSystem())
                .choseMachineClass(input.getMachineClass())
                .choseSeriesOfInstanceType(input.getInstanceSeries())
                .choseInstanceType(input.getInstanceType())
                .choseGPUButton()
                .choseGRUsType(input.getGPUType())
                .choseGRUsNumber(input.getNumberOfGPUs())
                .inputLocalSSD(input.getLocalSSD())
                .choseDatacenterLocation(input.getLocation())
                .choseCommitedUsage(input.getCommitedUsage())
                .addToEstimateButton()
                .clickOnEmailButton();

        Assert.assertEquals(fillComputeEngineForm.getEstimatedComponentCostValue(), "Total Estimated Cost: USD 1,084.69 per 1 month");

        String sumFromCalculator = fillComputeEngineForm.getEstimatedComponentCostValue();

        ((JavascriptExecutor) driver).executeScript("window.open()");
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://yopmail.com/");
        fillComputeEngineForm.waitForPageLoad();

        fillComputeEngineForm
                .generateRandomEmail()
                .copyEmail();
        String newEmail = fillComputeEngineForm.getEmailString();

        driver.switchTo().window(tabs.get(0));
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");

        log.info("frame 'myframe' is switched ");
        fillComputeEngineForm
                .inputEmailToCalculator(newEmail);

        Email email = new Email(driver);
        email
                .openEmailPage()
                .openEmailBox(newEmail);

        Assert.assertEquals("Total Estimated Cost: " + email.getTotalCost() + " per 1 month",
                sumFromCalculator);

    }
}
