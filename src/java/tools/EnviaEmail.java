/*
 * 
 */
package tools;

import Entidades.Candidato;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
//import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author zorawski
 */
public class EnviaEmail {

    public EnviaEmail(Candidato cand) {
        //Instancia email
        HtmlEmail email = new HtmlEmail();
        //Ativa conexao ssl (tipo de protocolo)
        email.setSSLOnConnect(true);
        //Envia pelo servidor do gmail
        email.setHostName("smtp.gmail.com");
        //Utiliza essa porta do servidor
        email.setSslSmtpPort("465");
        email.setStartTLSRequired(true);
        //Envia utilizando essa conta
        email.setAuthenticator(new DefaultAuthenticator("seu_email@gmail.com", "senha"));
        try {
            //Remetente
            email.setFrom("thaiszorawski@gmail.com");

            //email.setDebug(true);
            //Assunto
            email.setSubject("Testando função");
            //Atribui mensagem
            //email.setMsg( "Este é apenas um teste" );
            //Cria um builder para insercao de strings com html
            StringBuilder builder = new StringBuilder();
            builder.append("<h1>Bom dia!</h1><br/>");
            builder.append("<p>Você acaba de cadastrar o candidato "+cand.getNome()+" ("+cand.getAreaAtuacao()+")!</p>");
            builder.append("<p>Tenha um ótimo dia!</p>");
            builder.append("<br/><p>Referências:</p>");
            builder.append("<a href=\"http://www.botecodigital.info/java/enviando-e-mail-em-java-com-api-commons-email-da-apache/\">Tutorial utilizado</a> <br> ");
            builder.append("<a href=\"http://www.java2s.com/Code/Jar/c/Downloadcommonsemail13jar.htm\">Link para baixar commons-email.jar</a> <br> ");
            builder.append("<a href=\"https://java.net/projects/javamail/pages/Home\">Link para baixar javax.mail.jar</a> <br> ");
            builder.append("<img src=\"https://67.media.tumblr.com/tumblr_loeqhlvdyj1qmd4n9o1_500.gif\">");
            //Converte builder para string e atribui ao email
            email.setHtmlMsg(builder.toString());

//Anexa arquivo
//            EmailAttachment anexo = new EmailAttachment();
//            anexo.setPath("/home/zorawski/Documentos/utfpr/radames/LP3/gerar_pdf/doc1");
//            anexo.setDisposition(EmailAttachment.ATTACHMENT);
//            anexo.setName("Abra.pdf");

//            email.attach(anexo);

//Destinatario
            email.addTo(cand.getEmail());
            email.send();

        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
