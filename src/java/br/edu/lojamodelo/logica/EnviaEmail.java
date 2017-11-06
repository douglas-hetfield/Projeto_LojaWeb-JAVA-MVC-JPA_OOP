package br.edu.lojamodelo.logica;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
 
/**
 * Classe Utilitária que contém métodos para envio de Email através de conta do
 * Gmail
 */
public class EnviaEmail {
 
    /**
     * Construtor sem parametros, ao ser chamado já instancia as configuraççoes
     * de email do Gmail na JVM
     *
     */
    public EnviaEmail() {
        //String userNameGmail, String senhaGmail
       // this.username = userNameGmail;
       // this.senha = senhaGmail;
 
        ajustaParametros();
 
    }
 
    /**
     * Variavel local para Sessao
     */
    Session session = null;
 
    String username = "turma2016.5@gmail.com";
    String senha = "informatica2016";
 
    /**
     * Metodo 'main()' para teste e execução
     *
     */
    public static void main(String[] args) {
 
        /**
         * Mensagem de teste para envio de email Html
         */
        String mensagemHtmlTeste = "<html>\n"
                + "<body>\n"
                + "<h1> Mensagem para voc&ecirc;</h1>\n"
                + "<h2> conte&uacute;do da Mensagem:</h2>\n"
                + "<p>Mensagem enviada atrav&eacute;s de Aplica&ccedil;&atilde;o "
                + "que estudei no blog <a href=\"http://www.devfacil.blogspot.com.br\"><b>DevFacil!</b></a></p>\n"
                + "</body>\n"
                + "</html>";
 
        try {
          //  EnviaEmail ee = new EnviaEmail("eu@gmail.com", "123456");
 
            /**
             * Envia mensagem de e-mail com conteúdo html
             */
          //  ee.enviarEmailHtml("eu@gmail.com", "seu@amigo.com", "Estou aprendendo a Enviar Email através do JAVA!", mensagemHtmlTeste);
             
            /**
             * Envia mensagem de e-mail simples, somente com texto
             */
//            ee.enviarEmailHtml("eu@gmail.com", "seu@amigo.com", "Estou aprendendo a Enviar Email através do JAVA!", "Mensagem Somente Texto");
 
        } catch (Exception ex) {
 
            System.out.println(ex.getMessage());
 
        }
 
    }
 
    /**
     * Metodo para envio de mensagem com texto simples
     */
    public void enviarTxt(String destinatario, String assunto, String conteudo) throws Exception {
 
        try {
 
            Message message = new MimeMessage(session);
 
            //Configura o Remetente da mensagem
           // message.setFrom(new InternetAddress(remetente));
            message.setFrom(new InternetAddress(this.username));
 
            //Configura o Destinatário da mensagem
            Address[] toUser = InternetAddress
                    .parse(destinatario);
 
            //Configura o Assunto da mensagem
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(assunto);
 
            //Configura o Conteudo da mensagem
            message.setText(conteudo);
 
            /**
             * Envia a mensagem criada
             */
            Transport.send(message);
 
            System.out.println("Email enviado com Sucesso; ");
 
        } catch (MessagingException e) {
            throw new Exception("Erro ao enviar email! \n" + e.getMessage());
        }
 
    }
 
    /**
     * Metodo para envio de mensagem padrao HTML ja formatado
     */
    public void enviarEmailHtml(String destinatario, String assunto, String conteudoHtml) throws Exception {
        try {
 
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(this.username));
 
            Address[] toUser = InternetAddress
                    .parse(destinatario);
 
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(assunto);
 
            Multipart multipart = new MimeMultipart("related");
            BodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(conteudoHtml, "text/html");
 
            multipart.addBodyPart(htmlPart);
 
            message.setContent(multipart);
 
            /**
             * Método para enviar a mensagem criada
             */
            Transport.send(message);
 
            System.out.println("Email enviado com Sucesso; ");
 
        } catch (MessagingException e) {
            throw new Exception("Erro ao enviar email! \n" + e.getMessage());
        }
 
    }
 
    /**
     * Configura aa propriedades da JVM com parametros do servidor Gmail
     *
     * Modificador de acesso 'private' pois não é necessário que este método
     * seja chamado de outras classes
     */
    private void ajustaParametros() {
 
        Properties props = new Properties();
 
        /**
         * Conexão com servidor Gmail
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
         props.put("mail.smtp.starttls.enable", "true"); 
        /**
         * Associa autenticação a sessao de correio
         */
        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, senha);
                    }
                });
 
    }
 
}