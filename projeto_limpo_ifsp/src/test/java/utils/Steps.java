package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class Steps extends Variables {
    public Steps(WebDriver navegador) {
        super(navegador);
    }

    public Steps assertMSG(String xpath, String mensagem) {
        WebDriverWait esperar = new WebDriverWait(navegador, 10);
        WebElement mensagemSucesso = navegador.findElement(By.xpath(xpath));
        esperar.until(ExpectedConditions.elementToBeClickable(mensagemSucesso));
        JavascriptExecutor js = (JavascriptExecutor) navegador;
        js.executeScript("arguments[0].scrollIntoView();", mensagemSucesso);
        String verificarMensagemSucesso = mensagemSucesso.getText();
        assertEquals(mensagem, verificarMensagemSucesso);
        return this;
    }
    public Steps xpathClick(String xpath) {
        WebDriverWait esperar = new WebDriverWait(navegador, 10);
        WebElement config = navegador.findElement(By.xpath(xpath));
        esperar.until(ExpectedConditions.elementToBeClickable(config));
        JavascriptExecutor js = (JavascriptExecutor) navegador;
        WebElement botaoPagina = navegador.findElement(By.xpath(xpath));
        js.executeScript("arguments[0].scrollIntoView();", botaoPagina);
        config.click();
        return this;
    }

    public Steps xpathSend(String xpath, String text) {
        WebDriverWait esperar = new WebDriverWait(navegador, 10);
        WebElement config = navegador.findElement(By.xpath(xpath));
        esperar.until(ExpectedConditions.elementToBeClickable(config));
        JavascriptExecutor js = (JavascriptExecutor) navegador;
        WebElement botaoPagina = navegador.findElement(By.xpath(xpath));
        js.executeScript("arguments[0].scrollIntoView();", botaoPagina);
        config.sendKeys(text);
        return this;
    }

    public Steps xpathClear(String xpath) {
        WebDriverWait esperar = new WebDriverWait(navegador, 10);
        WebElement config = navegador.findElement(By.xpath(xpath));
        esperar.until(ExpectedConditions.elementToBeClickable(config));
        JavascriptExecutor js = (JavascriptExecutor) navegador;
        WebElement botaoPagina = navegador.findElement(By.xpath(xpath));
        js.executeScript("arguments[0].scrollIntoView();", botaoPagina);
        config.clear();
        return this;
    }

    public Steps esperar(int tempo) throws InterruptedException {
        Thread.sleep(tempo);
        return this;
    }

    public void print(String arquivo, String status, String msg) throws IOException {
        Date date = new Date();
        date.setDate(date.getDate());
        SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss");
        String formattedDate = df.format(date);
        File screenshot = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
        String datesplit[] = formattedDate.split("-");
        String horas[] = datesplit[1].split("_");


        String path = "\\src\\test\\resources\\evidencias\\" + arquivo + "\\" + datesplit[0] + "\\" + status + "\\" + horas[0] + "h" + horas[1] + "m" + horas[2] + "s" + "\\";
        try {
            FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + path + arquivo + ".png"));
        } catch (Exception e) {
            System.out.println("Houveram problemas ao copiar o arquivo para a pasta: *" + e.getMessage());
        }
        if (!status.equals("OK")) {
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(System.getProperty("user.dir") + path + "Error.log"), "utf-8"))) {
                writer.write(msg);
            }
        }
    }
}
