package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import utils.Variables;

import java.util.concurrent.TimeUnit;

public class navigatorGenerate extends Variables {
    public navigatorGenerate(WebDriver navegador) {
        super(navegador);
    }

    public static WebDriver createChromeDriver () {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        navegador.manage().window().maximize();
        return navegador;
    }

    public static WebDriver createHeadlessChromeDriver () {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=1024,768");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--allow-insecure-localhost");
        chromeOptions.setAcceptInsecureCerts(true);
        WebDriver navegador = new ChromeDriver(chromeOptions);
        navegador.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        return navegador;
    }
}
