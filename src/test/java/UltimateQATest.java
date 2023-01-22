import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UltimateQATest extends BaseTestSetup {

    // wzorzec projektowy: Page Object Pattern
    @Test
    public void testOne() {
        // sposoby wyszukiwania elementow: id, className, cssSelector, xpath
        WebElement buttonUsingId = driver.findElement(By.id("idExample"));
        Assertions.assertTrue(buttonUsingId.isDisplayed());
        buttonUsingId.click();

        // log.info
        WebElement textButtonSuccess = driver.findElement(By.className("entry-title"));
        Assertions.assertEquals("Button success", textButtonSuccess.getText());
    }

    //input[@id='et_pb_contact_name_0']   1 out of 1
    //input[@class='input et_contact_error']   1 out of 2
    //input[@class='input et_contact_error' and @id='et_pb_contact_name_0']
    //*[@class='et_pb_contact']/form[@class='et_pb_contact_form clearfix']/p/input
    //*[@class='et_pb_contact']/form[@class='et_pb_contact_form clearfix']//input
    //*[@class='et_pb_contact']/form[@class='et_pb_contact_form clearfix']//input[@id='et_pb_contact_name_0']
    //input[@placeholder='Name']
    //*[@placeholder='Name']
    //*[text()="Email Me!"]
    //*[contains(text(), 'Email Me')]
    //*[@id='et_pb_contact_form_0']/div/p
    //*[@id='et_pb_contact_form_0']//p

    //*[] - ogolna postac XPath
    @Test
    public void testTwo() throws InterruptedException {
        WebElement inputName = driver.findElement(By.xpath("//input[@id='et_pb_contact_name_0']"));
        inputName.sendKeys("Tester");

        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='et_pb_contact_email_0']"));
        inputEmail.sendKeys("tester@tester.pl");

        // Java: wyjątki w Javie (Java Exceptions)
        // Java: sposoby oczekiwań w Selenium: Thread.sleep, implicit wait, explicit wait
        Thread.sleep(2000);

        WebElement buttonEmailMe = driver.findElement(By.xpath("//*[text()=\"Email Me!\"]"));
        // .isSelected()
        // Boolean: ! - nie jest prawda
        Assertions.assertTrue(buttonEmailMe.isDisplayed());
        buttonEmailMe.click();

        Thread.sleep(2000);

        WebElement textThanks = driver.findElement(By.xpath("//*[@id='et_pb_contact_form_0']//p"));
        Assertions.assertEquals("Thanks for contacting us", textThanks.getText());
    }
}
