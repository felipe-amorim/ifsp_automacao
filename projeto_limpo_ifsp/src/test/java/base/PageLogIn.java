package base;

import org.openqa.selenium.WebDriver;
import utils.Variables;
import utils.Steps;

import java.util.concurrent.TimeUnit;

public class PageLogIn extends Variables {
    public PageLogIn(WebDriver navegador) {
        super(navegador);
    }

    public Steps formLogin (){

        navegador.get(environmentURL);
        /*  FORMULARIO DE LOGIN, SE NECESSARIO - NÃO UTILIZADO NO EXEMPLO
        *DESCOMENTAR CASO NECESSÁRIO
        new Steps(navegador).xpathSend(passwordLoginInputPath, passwordLogin);
        new Steps(navegador).xpathSend(emailLoginInputPath, emailLogin);
        new Steps(navegador).xpathClick(buttonLogin);
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
        return new Steps(navegador);
    }
}
