package objects;

public class Wikipedia {
    //TODOS OS XPATHS UTILIZADOS NA AUTOMAÇÃO RELACIONADOS A CLASSE EXECUTORA

    //----------------------dados exemplo
    public static String newUserSuccessMessage = "User created."; //EXEMPLO DE MENSAGEM A SER VALIDADA APOS CADASTRO
    public static String deleteUserSuccessMessage = "Successfully removed user"; //EXEMPLO DE MENSAGEM A SER VALIDADA APOS REMOÇÃO
    public static String genericEmail = "emailteste@teste.com.br"; //EXEMPLO DE EMAIL GENERICO

    //-----------------------dados wikipedia
    public static String dadoEnviado = "Automação de testes";
    public static String mensagemBusca = "Resultados da pesquisa";

    //-----------------------objetos wikipedia
    public static String campoBusca = "//input[contains(@id, \"searchInput\")]";
    public static String botaoBusca = "//i[contains(@class, \"search-icon\")]//ancestor::button[1]";
    public static String campoMensagem = "//h1[contains(text(), \"\")]";


    //EXEMPLO DE XPATH COMPOSTO POR MAIS DE UMA VARIAVEL
    public static String buttonDelete = "//div[contains(text(),\""+genericEmail+"\")]//ancestor::tr[1]//a[text()=\"Delete\"]";


}
