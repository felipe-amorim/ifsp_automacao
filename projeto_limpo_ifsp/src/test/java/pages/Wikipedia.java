package pages;

import base.PageLogIn;
import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import support.navigatorGenerate;
import utils.Steps;

import java.io.IOException;
import java.util.Calendar;

public class Wikipedia extends objects.Wikipedia {
    @Rule
    public TestName test = new TestName();
    long t = Calendar.getInstance().getTimeInMillis();
    String status = "";
    String error = "";
    private WebDriver navegador;

    @Before
    public void setUp() {
        navegador = navigatorGenerate.createChromeDriver();
        new PageLogIn(navegador).formLogin();
    }

    @Test
    public void testBusca() {
        try {
            t = Calendar.getInstance().getTimeInMillis();
            new Steps(navegador)
                    .xpathSend(campoBusca, dadoEnviado)
                    .xpathClick(botaoBusca)
                    .assertMSG(campoMensagem, mensagemBusca)
;
            status = "OK";
        } catch (ComparisonFailure ex) {
            status = "NOK";
            error = ex.getMessage();
        } catch (Exception ex) {
            status = "Fail";
            error = ex.getMessage();
        }
    }
    @After
    public void tearDown() throws IOException {
        new Steps(navegador).print(test.getMethodName(), status, error);
        navegador.quit();
    }
}
