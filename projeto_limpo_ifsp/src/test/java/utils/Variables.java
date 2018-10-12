package utils;
import org.openqa.selenium.WebDriver;

public class Variables {
    protected WebDriver navegador;
    public Variables(WebDriver navegador){this.navegador = navegador;}

    public static String environmentURL = "https://www.wikipedia.org/";

    public static String emailLogin = "CAMPO USUARIO/EMAIL SE NECESSARIO";
    public static String passwordLogin = "SENHA SE NECESSARIO";

    public static String emailLoginInputPath = "XPATH PARA O CAMPO USUARIO/EMAIL";
    public static String passwordLoginInputPath = "XPATH PARA O CAMPO SENHA";
    public static String buttonLogin = "XPATH PARA O BOTAO ENVIAR/LOGAR/ENTRAR...";
}
