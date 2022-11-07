import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IrinaDudTest {

    //    TC_1_1  - Тест кейс:
    //    //1. Открыть страницу https://openweathermap.org/
    //    //2. Набрать в строке поиска город Paris
    //    //3. Нажать пункт меню Search
    //    //4. Из выпадающего списка выбрать Paris, FR
    //    //5. Подтвердить, что заголовок изменился на "Paris, FR"


    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {              //что - где - когда
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Casa\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);
        Thread.sleep(5000);


        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder = 'Search city']")
        );
        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//button[@type = 'submit']")
        );
        searchButton.click();
        Thread.sleep(1000);

        WebElement parisFrInDropDownMenu = driver.findElement(
                By.xpath("//ul[@class = 'search-dropdown-menu']/li/span[text()  = 'Paris, FR ']")
        );
        parisFrInDropDownMenu.click();

        WebElement h2CityCountryHeader = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//h2")
        );

        Thread.sleep(2000);

        String actualResult = h2CityCountryHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);

        //Thread.sleep(5000);

        driver.quit();
    }


    /**
     * Test 2
     * System.setProperty("webdriver.chrome.driver", "YouPathToFile/chromedriver");
     * WebDriver driver = new ChromeDriver();
     * <p>
     * String url = "https://openweathermap.org/";
     * <p>
     * TC_11_01
     * 1.  Открыть базовую ссылку
     * 2.  Нажать на пункт меню Guide
     * 3.  Подтвердить, что вы перешли на страницу со ссылкой https://openweathermap.org/guide и что title этой страницы
     * OpenWeatherMap API guide - OpenWeatherMap
     */
    @Test
    public void testOpenWeatherMapInMenuWhenPressButton() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Casa\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String buttonGuideMenu = "Guide";
        String expectedResult1 = "https://openweathermap.org/guide";
        String expectedResult2 = "OpenWeatherMap API guide - OpenWeatherMap";

        driver.get(url);
        Thread.sleep(5000);

        WebElement searchButtonGuide = driver.findElement(
                By.xpath("//a[@href='/guide']")
                );
        searchButtonGuide.click();
        Thread.sleep(500);

        String actualResult1 = driver.getCurrentUrl();
        String actualResult2 = driver.getTitle();

        Assert.assertEquals(actualResult1 ,expectedResult1 );
        Assert.assertEquals(actualResult2 ,expectedResult2);


        driver.quit();
    }

    /** Task 3
     * TC_11_02
     * 1.  Открыть базовую ссылку
     * 2.  Нажать на единицы измерения Imperial: °F, mph
     *
     * 3.  Подтвердить, что температура для города показана в Фарингейтах
     */
    @Test
    public void testUnitsInFeringate_WhenPressingImperial() throws InterruptedException {           //что - где - когда
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Casa\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String menuImperial = "Imperial: °F, mph";
        String expectedResult = "°F";

        driver.get(url);
        Thread.sleep(5000);

        WebElement searchButtonImperialField = driver.findElement(
                By.xpath("//div[@class='switch-container']/div[@class='option']/following-sibling::div")
        );

        searchButtonImperialField.click();
        Thread.sleep(3000);

        WebElement temFerengate = driver.findElement(By.xpath("//div[@class='current-temp']/span"));

        Boolean isTemprInFarIsTrue = temFerengate.getText().contains("°F");
        Assert.assertTrue(isTemprInFarIsTrue);

       // String actualResult
        

        //Assert.assertEquals(actualResult ,expectedResult);


        Thread.sleep(1000);



        driver.quit();


    }

}