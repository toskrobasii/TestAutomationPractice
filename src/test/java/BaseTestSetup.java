import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Git - system kontroli wersji
// obiektowość Java (teoria): klasa, interfejs, czym sie rozni klasa abstrakcyjna od interfejsu
// lokalizowanie elemntów na stronie: XPath / css / atrybut
public class BaseTestSetup {

    String projectlocation = System.getProperty("user.dir");
    WebDriver driver;

    // hermetyzacja: public/private/protected

    @BeforeEach
    public void setup() {
        System.out.println(projectlocation);
        System.setProperty("webdriver.chrome.driver", projectlocation + "/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
    }


    @AfterEach
    public void teardown() {
        // różnica pomiędzy driver.close(), a driver.quit()
        driver.close();
    }
}
