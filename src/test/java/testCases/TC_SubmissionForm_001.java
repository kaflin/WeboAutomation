package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.DriverPropertyInfo;
import java.util.List;

public class TC_SubmissionForm_001 extends BaseClass {
    @Test(priority = 1)
    public void submissionForm() throws IOException {
        logger.info("URL is opened");
        if (driver.getTitle().equals("Home Page - Dallcon")) {
            captureScreen(driver, "submissionTestPassed");
            Assert.assertTrue(true);
            logger.info("Submission Test passed");
        } else {
            captureScreen(driver, "submissionTestFailed");
            logger.info("Submission Test Failed");
            Assert.fail();

        }
    }

    @Test(priority = 2)
    public void homePage() throws IOException, InterruptedException {
        logger.info("Clicking Logo");
        WebElement element = driver.findElement(By.xpath("//section[@class='site-branding']/div/a/img"));
        action.moveToElement(element).perform();
        element.click();
        if (driver.getTitle().equals("Home Page - Dallcon")) {
            captureScreen(driver, "clickingOnBrandingPassed");
            Assert.assertTrue(true);
            logger.info("Clicking On Branding Passed");
        } else {
            captureScreen(driver, "clickingOnBrandingFailed");
            logger.info("Clicking On Branding Failed");
            Assert.fail();
        }
        clickOnVideo();
        searchingProduct();
        clickOnScrollButton();

    }

    public void clickOnVideo() throws InterruptedException {
        logger.info("Playing Video");
        WebElement element = driver.findElement(By.xpath("//div[@class='video-icon']/a"));
        action.moveToElement(element).perform();
        element.click();
        Thread.sleep(30000);

        logger.info("Clicking On Close Icon");
        WebElement element1 = driver.findElement(By.xpath("//div[@class='fancybox-toolbar']/button[4]"));
        action.moveToElement(element1).perform();
        element1.click();
    }

    public void searchingProduct() {
        logger.info("Searching Product");
        WebElement element = driver.findElement(By.xpath("//div[@class='product-search-form']/form/input[2]"));
        element.click();
        WebElement element1 = driver.findElement(By.xpath("//div[@class='product-search-form layout-two']/form/input[1]"));
        element1.sendKeys("RCP PIPES");
        driver.findElement(By.xpath("//div[@class='product-search-form layout-two']/form/input[2]")).click();
        if (driver.findElement(By.xpath("//div[@class='product product-951 item']/a/h4")).getText().equals("RCP PIPES")) {
            Assert.assertTrue(true);
            logger.info("Searching  of Product Passed");
        } else {
            logger.info("Searching  of Product Failed");
            Assert.fail();
        }
        driver.navigate().back();
        driver.navigate().back();
    }

    public void clickOnScrollButton() throws InterruptedException {
        logger.info("Clicking On Scroll button");
        WebElement element_next = driver.findElement(By.xpath("//div[@class='owl-dots']/button[2]"));
        action.moveToElement(element_next).perform();
        element_next.click();
        Thread.sleep(2000);
        WebElement element_prev = driver.findElement(By.xpath("//div[@class='owl-dots']/button[1]"));
        action.moveToElement(element_prev).perform();
        element_prev.click();
        Thread.sleep(2000);
    }

    public void ourProduct() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//nav[@id='site-navigation']/ul/li/a"));
        action.moveToElement(element).perform();
        Thread.sleep(3000);
    }

    public void ourCompanyHover() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[@id='site-navigation']/ul/li[4]/a"));
        action.moveToElement(element).perform();
        Thread.sleep(3000);

    }

    @Test(priority = 3)
    public void products() throws InterruptedException {
        ourProduct();
        for (int i = 1; i <= 16; i++) {
            List<WebElement> productMain = driver.findElements(By.xpath(("//*[@id='site-navigation']/ul/li[1]/ul/div/div[" + i + "]/div/ul/li/a")));
            Thread.sleep(2000);
            int sizeOfMainProduct = productMain.size();
            if (sizeOfMainProduct == 0) {
                List<WebElement> productMain_item = driver.findElements(By.xpath(("//*[@id=\"site-navigation\"]/ul/li[1]/ul/div/div[" + i + "]/div/h4/a")));
                ourProduct();
                int a = 0;
                while (a == 0) {
                    logger.info("Hovering on Product Main_Menu Item");
                    logger.info("MainMenu Name: " + productMain_item.get(a).getText());
                    productMain_item.get(a).click();
                    ourProduct();
                    driver.navigate().back();
                    a = a + 1;
                }
            } else {
                List<WebElement> product_submenu_item = driver.findElements(By.xpath(("//*[@id='site-navigation']/ul/li[1]/ul/div/div[" + i + "]/div/ul/li/a")));
                ourProduct();
                for (int j = 1; j <= product_submenu_item.size(); j++) {
                    List<WebElement> product_submenu = driver.findElements(By.xpath(("//*[@id='site-navigation']/ul/li[1]/ul/div/div[" + i + "]/div/ul/li[" + j + "]/a")));
                    ourProduct();
                    int a = 0;
                    while (a < product_submenu.size()) {
                        logger.info("Hovering on Product Sub_Menu Item");
                        logger.info("SubMenu Name: " + product_submenu.get(a).getText());
                        product_submenu.get(a).click();
                        ourProduct();
                        driver.navigate().back();
                        a = a + 1;
                    }
                }
            }
        }
    }

    @Test(priority = 4)
    public void customPreCast() throws InterruptedException, IOException {
        driver.findElement(By.xpath("//*[@id='site-navigation']/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id='search_text']")).sendKeys("Boat Ramps");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//*[@id='main-content-area']/div[2]/a/h4"));
        if (element.getText().equals("Boat Ramps")) {
            captureScreen(driver, "customPreCastPassed");
            Assert.assertTrue(true);
            logger.info("Custom Pre Cast Test has been Passed");
        } else {
            captureScreen(driver, "customPreCastFailed");
            logger.info("Custom Pre Cast Test has been failed");
            Assert.fail();
        }
    }

    @Test(priority = 5)
    public void projects() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='site-navigation']/ul/li[3]/a")).click();
        Thread.sleep(3000);
        logger.info("Clicking Mining of Project");
        driver.findElement(By.xpath("//*[@id='ourProjects']/div/div[1]/ul/li[2]/a")).click();
        Thread.sleep(3000);
        logger.info("Clicking Civil of Project");
        driver.findElement(By.xpath("//*[@id='ourProjects']/div/div[1]/ul/li[3]/a")).click();
        Thread.sleep(2000);

    }

    @Test(priority = 6)
    public void ourCompany() throws InterruptedException {
        ourCompanyHover();
        logger.info("Hovering On Our Company");
        for (int i = 1; i <= 4; i++) {
            ourCompanyHover();
            WebElement elements = driver.findElement(By.xpath("//*[@id='site-navigation']/ul/li[4]/ul/li[" + i + "]/a"));
            logger.info("Item name: " + elements.getText());
            elements.click();
            Thread.sleep(5000);
        }
    }


    @Test(priority = 7)
    public void contactUs() throws InterruptedException, IOException {
        logger.info("Clicking and give all detail to Contact us form");
        driver.findElement(By.xpath("//*[@id=\"site-navigation\"]/ul/li[5]/a")).click();
        driver.findElement(By.name("full_name")).sendKeys("Suraj Gupta");
        driver.findElement(By.name("company")).sendKeys("Webo digital");
        driver.findElement(By.name("email")).sendKeys("suraj520876@gmail.com");
        driver.findElement(By.name("phone")).sendKeys("9867488538");
        driver.findElement(By.name("zip")).sendKeys("33000");
        WebElement testDrop = driver.findElement(By.name("how_did_you_hear_about_us_"));
        Select select = new Select(testDrop);
        select.selectByValue("LinkedIn");
        driver.findElement(By.xpath("//textarea[@class='hs-input']")).sendKeys("Webo digital is very supportive");
        driver.findElement(By.xpath("//div/input[@class='hs-button primary large']")).click();
        Thread.sleep(30000);
        WebElement element = driver.findElement(By.xpath("//div[@class=\"contact-form-wrap\"]/div/div/p"));
        if (element.getText().equals("Thanks for submitting your enquiry. We will get back to you shortly!")) {
            captureScreen(driver, "enquiryTestPassed");
            Assert.assertTrue(true);
            logger.info("Enquiry has been submitted");
        } else {
            captureScreen(driver, "enquiryTestFailed");
            logger.info("Enquiry has not been submitted");
            Assert.fail();
        }

    }

    @Test(priority = 8)
    public void careers() throws InterruptedException, IOException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)");
        driver.findElement(By.xpath("//*[@id=\"menu-item-4719\"]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"search_text\"]")).sendKeys("Carpenters");
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"main-content-area\"]/div[2]/h4/a"));
        if (element.getText().equals("Carpenters")) {
            captureScreen(driver, "careersTestPassed");
            Assert.assertTrue(true);
            logger.info("Careers Test has been submitted");
        } else {
            captureScreen(driver, "careersTestFailed");
            logger.info("Careers Test has been failed");
            Assert.fail();
        }
    }

}


