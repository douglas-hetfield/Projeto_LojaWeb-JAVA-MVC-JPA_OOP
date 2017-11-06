package br.edu.lojamodelo.logica;


import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import br.edu.lojamodelo.util.Crypt;

import br.edu.lojamodelo.controller.CtrlCliente;
import br.edu.lojamodelo.controller.CtrlFuncionario;
import br.edu.lojamodelo.model.Cliente;
import br.edu.lojamodelo.model.Funcionario;
import java.util.Random;
import javafx.scene.control.Alert;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@MultipartConfig
public class ClienteLogica implements Logica {

    private static final long serialVersionUID = 1L;

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res)
            throws Exception {
        res.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        
        String pagina = "index.jsp";
        CtrlCliente ctrlCliente = new CtrlCliente();
        //Ação para login 
        //<editor-fold>
        if (req.getParameter("action").equals("log")) {
            try {
                try {
                
                Cliente cliente = ctrlCliente.verificar(req.getParameter("email"), (Crypt.md5(req.getParameter("pws"))));
                       
                    HttpSession usuario = req.getSession();
                    usuario.setAttribute("cliente", cliente);
                    pagina = "index.jsp";
                    req.setAttribute("avisos", "Logado com Sucesso");
                
                }catch (Exception ex){
                    CtrlFuncionario ctrlFuncionario = new CtrlFuncionario();
                    Funcionario funcionario = ctrlFuncionario.verificar(req.getParameter("email"), (Crypt.md5(req.getParameter("pws"))));
                    
                    HttpSession usuario = req.getSession();
                    usuario.setAttribute("funcionario", funcionario);
                    pagina = "indexF.jsp";
                    req.setAttribute("avisos", "Logado com Sucesso!");
                }
                    
            } catch (Exception ex) {
                req.setAttribute("erros", "Login inválido");
                req.setAttribute("autentic", "invalido");
                pagina = "index.jsp";
                
            } 
        }//</editor-fold>

        //Ação para logoff
        //<editor-fold>
        if (req.getParameter("action").equals("off")) {
            try {
                HttpSession sessao = req.getSession();
                sessao.invalidate();

            } catch (Exception e) {
                req.setAttribute("erros", e.getMessage().replace(".\n", ".<br>"));
            }
        }//</editor-fold>

        //Ação para cadastro
        //<editor-fold>
        if (req.getParameter("action").equals("cad")) {
            Cliente cliente = new Cliente();
            try {
                

                cliente.setStatus(true);
                cliente.setNome(req.getParameter("nome"));
                cliente.setCpf(req.getParameter("cpf"));
                cliente.setEmail(req.getParameter("email"));
                cliente.setPws(Crypt.md5(req.getParameter("pws")));
                cliente.setCep(req.getParameter("cep"));
                cliente.setNumero(req.getParameter("numero"));
                cliente.setComplemento(req.getParameter("complemento"));
                cliente.setLogradouro(req.getParameter("logradouro"));
                cliente.setBairro(req.getParameter("bairro"));
                cliente.setCidade(req.getParameter("cidade"));
                cliente.setUf(req.getParameter("uf"));

                cliente.isPessoa(Crypt.md5(req.getParameter("cpws")));
                
               // CtrlCliente ctrlCliente = new CtrlCliente();
                ctrlCliente.cadastrar(cliente);
                req.setAttribute("avisos", "Cadastrado");
            } catch (Exception ex) {
                req.setAttribute("cliente", cliente);
                req.setAttribute("erros", ex.toString());
                
            }
            
            pagina = "index.jsp?p=formCliente";
        }//</editor-fold>

        //Ação para listar
        //<editor-fold>
        if (req.getParameter("action").equals("list")) {

        }//</editor-fold>

        //Ação para apagar
        //<editor-fold>
        if (req.getParameter("action").equals("remove")) {

        }//</editor-fold>

        //Ação para Editar
        //<editor-fold>
        if (req.getParameter("action").equals("edit")) {

        }//</editor-fold>
        
        if (req.getParameter("action").equals("esqueceuSenha")) {
            try {
                String email = req.getParameter("email");
                Cliente cliente = ctrlCliente.recuperarSenha(email);
                //instância um objeto da classe Random usando o construtor padrão
		Random gerador = new Random();
                int codigo = 0;
               
		//imprime sequência de 10 números inteiros aleatórios
                 for (int i = 0; i < 5; i++) {
                    if (gerador.nextInt() > 0){
                        codigo = gerador.nextInt();
                    }
                }
                 
                // Gera uma nova senha aleatória para o cliente
                String senha = String.valueOf(codigo).replaceAll("-", "0");
                cliente.setPws(Crypt.md5(senha));
                cliente.isPessoa(Crypt.md5(senha));
                ctrlCliente.alterar(cliente);
                
                // Envia a nova senha para o usuário, via-email
                EnviaEmail e = new EnviaEmail();
                e.enviarEmailHtml(email, "Recuperar Senha - Hardware Center", 
                        "<p>Oi, " + cliente.getNome() + "<br>" 
                        + "Sua nova senha de acesso é: " + senha + "<br>" +
                        "<br><i>Loja Hardware Center</i><br><strong>Equipe AndreTech</strong></p>"
                );
                
                req.setAttribute("enviado", "sucesso");
                req.setAttribute("email", email);
                pagina = "index.jsp";
            } catch (Exception ex) {
                req.setAttribute("erros", ex.toString());
            }
           
        }//</editor-fold>

        //Ação para Alterar
        //<editor-fold>
        if (req.getParameter("action").equals("alt")) {
            Cliente cliente = new Cliente();
            
            try{
                cliente.setId(Long.parseLong(req.getParameter("id").trim()));
                
                cliente.setStatus(true);
                cliente.setNome(req.getParameter("nome"));
                cliente.setCpf(req.getParameter("cpf"));
                cliente.setEmail(req.getParameter("email"));
                cliente.setPws(Crypt.md5(req.getParameter("pws")));
                cliente.setCep(req.getParameter("cep"));
                cliente.setNumero(req.getParameter("numero"));
                cliente.setComplemento(req.getParameter("complemento"));
                cliente.setLogradouro(req.getParameter("logradouro"));
                cliente.setBairro(req.getParameter("bairro"));
                cliente.setCidade(req.getParameter("cidade"));
                cliente.setUf(req.getParameter("uf"));

                cliente.isPessoa(Crypt.md5(req.getParameter("cpws")));
                
//                CtrlCliente ctrlCliente = new CtrlCliente();
                ctrlCliente.alterar(cliente);
                req.setAttribute("avisos", "Alterado com Sucesso!");
            } catch (Exception ex) {
                
                req.setAttribute("erros", ex.toString());
            }
            pagina = "index.jsp?p=formCliente";
        }//</editor-fold>

        //Retorna para a pagina
        return pagina;
    }

}
