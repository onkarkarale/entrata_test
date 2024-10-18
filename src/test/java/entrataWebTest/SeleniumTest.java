package entrataWebTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

public class SeleniumTest {

    /*
     Test Description: 1.Validate Entrata website home page is displayed and loaded
                       2. Validate Form elements of "Schedule Your Demo" by navigating to the schedule-demo page.
                       3. Navigate back to Home Page, Validate "Solutions" dynamic drop down & navigate to one of the option.
    */
    WebDriver driver = new ChromeDriver();


    @Test(priority = 1)
    public void navigateToEntrataHomePage() throws InterruptedException {
        // Open Entrata homepage

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

        driver.get("https://www.entrata.com/c");

        checkPageIsReady();
        // Accept the Cookies
        driver.findElement(By.xpath("//a[text()='Accept Cookies']")).click();
        // Close the headline banner = See our newest product and features (learn more)
        driver.findElement(By.xpath("//button[@aria-label='close']")).click();
        String title = driver.getTitle();
        System.out.println("Opened Website is: " + title);

        // Assert Home page title
        Assert.assertEquals(title, "Property Management Software | Entrata");
    }

    @Test(priority = 2)
    public void testScheduleYourDemoPage() throws InterruptedException {

        // Test Scenario: Validate schedule demo form fields

        driver.findElement(By.xpath("//div[normalize-space()='Schedule Your Demo']")).click();
        sleep(1000);
        String title = driver.getTitle();
        System.out.println("Second page is: " + title);

        // Assert page title
        Assert.assertEquals(title, "Entrata | Property Management the Way It Should Be");


        // Test Case 1: Verify First Name text field.
        // Validate Mandatory text field = First Name
        System.out.println("Validating 'First Name' Mandatory text field...");
        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));

        // Check if the First Name text field is mandatory
        String required = firstName.getAttribute("aria-required");
        Assert.assertNotNull(required, "The First Name field is not marked as mandatory.");
        System.out.println("Verified: First Name field is marked as mandatory.");

        // Check if the First Name text field is empty
        String textField = firstName.getAttribute("value");
        Assert.assertTrue(textField.isEmpty(), "The First Name text field is not empty!");
        System.out.println("Verified: First Name text field is empty." + textField);

        //Check if First Name text field is editable.
        firstName.sendKeys("Onkar");
        String getFirstName = firstName.getAttribute("value");
        Assert.assertEquals(getFirstName, "Onkar", "For First Name text field, Entered and Inserted Values are different");
        System.out.println("Verified: First Name text field is editable.");


        // Test Case 2: Verify Last Name text field.
        System.out.println("Validating 'Last Name' Mandatory text field...");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));

        // Check if the Last Name text field is mandatory
        String requiredLastName = lastName.getAttribute("aria-required");
        Assert.assertNotNull(requiredLastName, "The Last Name field is not marked as mandatory.");
        System.out.println("Verified: Last Name field is marked as mandatory.");

        // Check if the Last Name text field is empty
        String lastNameField = lastName.getAttribute("value");
        Assert.assertTrue(lastNameField.isEmpty(), "The Last Name text field is not empty!");
        System.out.println("Verified: Last Name text field is empty." + lastNameField);

        //Check if Last Name text field is editable.
        lastName.sendKeys("Karale");
        String getLastName = lastName.getAttribute("value");
        Assert.assertEquals(getLastName, "Karale", "For Last Name text field, Entered and Inserted Values are different");
        System.out.println("Verified: Last Name text field is editable.");


        // Test Case 3: Verify Email text field.

        System.out.println("Validating 'Email' Mandatory text field...");
        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));

        // Check if the Email text field is mandatory
        String requredEmail = email.getAttribute("aria-required");
        Assert.assertNotNull(requredEmail, "The Email field is not marked as mandatory.");
        System.out.println("Verified: Email field is marked as mandatory.");

        // Check if the Email text field is empty
        String emailField = email.getAttribute("value");
        Assert.assertTrue(emailField.isEmpty(), "The Email text field is not empty!");
        System.out.println("Verified: Email text field is empty." + emailField);

        //Check if Email text field is editable.
        email.sendKeys("karaleonkar19@gmail.com");
        String getEmail = email.getAttribute("value");
        Assert.assertEquals(getEmail, "karaleonkar19@gmail.com", "For Email text field, Entered and Inserted Values are different");
        System.out.println("Verified: Email text field is editable.");

        // Test Case 4: Verify Company Name text field.

        System.out.println("Validating 'Company Name' Mandatory text field...");
        WebElement company = driver.findElement(By.xpath("//input[@id='Company']"));

        // Check if the Company text field is mandatory
        String requredCompany = company.getAttribute("aria-required");
        Assert.assertNotNull(requredCompany, "The Company Name field is not marked as mandatory.");
        System.out.println("Verified: Company Name field is marked as mandatory.");

        // Check if the Company text field is empty
        String companyNameField = company.getAttribute("value");
        Assert.assertTrue(companyNameField.isEmpty(), "The Company Name text field is not empty!");
        System.out.println("Verified: Company Name text field is empty." + companyNameField);

        //Check if Company text field is editable.
        company.sendKeys("Test");
        String getCompany = company.getAttribute("value");
        Assert.assertEquals(getCompany, "Test", "For Company Name text field, Entered and Inserted Values are different");
        System.out.println("Verified: Company Name field is editable.");

        // Test Case 5: Verify Phone Number text field.

        System.out.println("Validating 'Phone Number' Mandatory text field...");
        WebElement phone = driver.findElement(By.xpath("//input[@id='Phone']"));
        phone.sendKeys("123456789");
        String getPhoneNumer = phone.getAttribute("value");
        Assert.assertEquals(getPhoneNumer, "123456789", "For Phone Number text field, Entered and Inserted Values are different");
        System.out.println("Verified: Phone Number field is editable.");

        // Test Case 6: Verify Unit Count Drop down element

        System.out.println("Validating 'Unit Count' Mandatory drop down field...");
        WebElement unitCount = driver.findElement(By.xpath("//select[@id='Unit_Count__c']"));
        // Check if the drop-down is displayed and enabled
        Assert.assertTrue(unitCount.isDisplayed(), "Unit Count drop-down is not displayed.");
        Assert.assertTrue(unitCount.isEnabled(), "Unit Count drop-down is not enabled.");
        System.out.println("Verified: Unit Count drop-down is displayed and enabled.");

        Select select = new Select(unitCount);
        // Get all options from the drop-down
        List<WebElement> options = select.getOptions();
        // Validate the total number of options
        Assert.assertEquals(options.size(), 6, "Incorrect number of options.");

        select.selectByVisibleText("1 - 10");


        // Test Case 7: Verify Job Title text field

        System.out.println("Validating 'Job Title' Mandatory text field...");
        WebElement job = driver.findElement(By.xpath("//input[@id='Title']"));
        job.sendKeys("QA");
        String requredJob = job.getAttribute("aria-required");
        Assert.assertNotNull(requredJob, "The Job Title field is not marked as mandatory.");
        System.out.println("Verified: Job Title.");


        // Test Case 8: Verify "I am" Drop down element

        System.out.println("Validating 'I am' Mandatory drop down field...");
        WebElement am = driver.findElement(By.xpath("//select[@id='demoRequest']"));
        // Check if the drop-down is displayed and enabled
        Assert.assertTrue(am.isDisplayed(), "I am drop-down is not displayed.");
        Assert.assertTrue(am.isEnabled(), "I am drop-down is not enabled.");
        System.out.println("Verified: 'I am' drop-down is displayed and enabled.");
        Select select1 = new Select(am);
        select1.selectByVisibleText("a Resident");


    }

    @Test(priority = 3)
    public void testSolutionsDropDown() throws InterruptedException {
        // Test Scenario : Verify "Solutions" toggle dropdown and navigate to "MultiFamily" page.
        // navigate back to previous home page as current page is "schedule demo"
        driver.navigate().back();
        String title = driver.getTitle();
        // Assert Home page title
        Assert.assertEquals(title, "Property Management Software | Entrata");

        // Mouse hover to Solution dropdown and select option "Multifamily"

        WebElement solution = driver.findElement(By.xpath("//div[@class='dropdown out w-dropdown']"));

        // Pointing to "Solution" dynamic dropdown.
        Actions action = new Actions(driver);
        action.moveToElement(solution).perform();

        // Select option from drop down as a "Mulifamily"
        action.moveToElement(driver.findElement(By.xpath("//a[@class='sub-menu'][normalize-space()='Multifamily']"))).click().perform();

        // Validate page is navigated to Multifamily Property Management web page.
        String title1 = driver.getTitle();
        System.out.println("Currently Opened Webpage: " + title1);

        // Validate open page is Multifamily
        Assert.assertEquals(title1, "Multifamily Property Management Software | Entrata");

        // Scroll down to display Multifamily feature.
        action.sendKeys(org.openqa.selenium.Keys.PAGE_DOWN).perform();

        sleep(2000);

        action.sendKeys(org.openqa.selenium.Keys.PAGE_DOWN).perform();
        action.sendKeys(org.openqa.selenium.Keys.PAGE_DOWN).perform();

        // Waiting the effect of the scroll
        sleep(2000);


    }


    public void checkPageIsReady() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // condition will check ready state of page.
        if (js.executeScript("return document.readyState").toString().equals("complete")) {
            System.out.println("Page Is loaded.");
            return;
        }

        //This loop will rotate for 20 times to check If page Is ready after every 1 second.

        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            //To check page ready state.
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                break;
            }
        }
    }

}
