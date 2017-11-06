package br.edu.lojamodelo.logica;

import br.edu.lojamodelo.util.Crypt;
import br.edu.lojamodelo.controller.CtrlFuncionario;
import br.edu.lojamodelo.model.Funcionario;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@MultipartConfig
public class FuncionarioLogica implements Logica {

    private static final long serialVersionUID = 1L;

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res)
            throws Exception {
        res.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        //Retorno da Pagina
        String pagina = "index.jsp";

        //Ação para login 
        //<editor-fold>
        if (req.getParameter("action").equals("log")) {
            try {
                Funcionario Funcionario = new Funcionario();

                CtrlFuncionario ctrlFuncionario = new CtrlFuncionario();
                Funcionario = ctrlFuncionario.verificar(req.getParameter("email"), Crypt.md5(req.getParameter("pws")));
                               
                    HttpSession sessao = req.getSession();
                    sessao.setAttribute("Funcionario", Funcionario);
                    pagina = "index.jsp";
                

            } catch (Exception ex) {
                
                req.setAttribute("erros", "Login inválido");
                pagina = "index.jsp?p=login";
            }
        }//</editor-fold>

        //Ação para logoff
        //<editor-fold>
        if (req.getParameter("action").equals("off")) {

        }//</editor-fold>

        //Ação para cadastro
        //<editor-fold>
        if (req.getParameter("action").equals("cad")) {
            try {
                Funcionario funcionario = new Funcionario();

                funcionario.setStatus(true);
                funcionario.setNome(req.getParameter("nome"));
                funcionario.setCargo(req.getParameter("cargo"));
                
                funcionario.setEmail(req.getParameter("email"));
                funcionario.setPws(Crypt.md5(req.getParameter("pws")));
                
                funcionario.isPessoa(Crypt.md5(req.getParameter("cpws")));

                CtrlFuncionario ctrlFuncionario = new CtrlFuncionario();
                ctrlFuncionario.cadastrar(funcionario);
                req.setAttribute("avisos", "Cadastrado");
            } catch (Exception ex) {
                req.setAttribute("erros",  ex.toString());
            }
            pagina = "indexF.jsp?p=formFuncionario";
        }//</editor-fold>

        //Ação para listar
        //<editor-fold>
        if (req.getParameter("action").equals("list")) {
            CtrlFuncionario controller = new CtrlFuncionario();

            List<Funcionario> funcionarios = controller.listFuncionarios(Integer.parseInt(req.getParameter("status")));
    
            req.setAttribute("listaFuncionarios", funcionarios);
            pagina = "indexF.jsp?p=ListaFuncionarios";
        }//</editor-fold>

        //Ação para apagar
        //<editor-fold>
        if (req.getParameter("action").equals("remove")) {
            

        }//</editor-fold>

        //Ação para Editar
        //<editor-fold>
        if (req.getParameter("action").equals("edit")) {
            /*CtrlFuncionario controller = new CtrlFuncionario();
            Funcionario Funcionario = new Funcionario();
            Funcionario.setStatus(false);
    
            CtrlFuncionario ctrlFuncionario = new CtrlFuncionario();
            ctrlFuncionario.edit(Funcionario);
            
            pagina = "index.jsp?p=ListaFuncionarios"; */
        }//</editor-fold>

        
         if (req.getParameter("action").equals("status")) {
            CtrlFuncionario controller = new CtrlFuncionario();
            
            Funcionario funcionario = controller.findFuncionario(Long.parseLong(req.getParameter("id")));
            if (funcionario.isStatus()){
               funcionario.setStatus(false); 
            } else {
                funcionario.setStatus(true); 
            }
            
            controller.edit(funcionario);
            
            pagina = "fc?logica=FuncionarioLogica&action=list&status=0";
        }
         
        
         
        //Ação para Alterar
        //<editor-fold>
        if (req.getParameter("action").equals("alt")) {
            Funcionario funcionario = new Funcionario();
            
            try{
                funcionario.setId(Long.parseLong(req.getParameter("id").trim()));
                
                funcionario.setStatus(true);
                funcionario.setNome(req.getParameter("nome"));
                funcionario.setCargo(req.getParameter("cargo"));
                funcionario.setEmail(req.getParameter("email"));
                funcionario.setPws(Crypt.md5(req.getParameter("pws")));
                
                funcionario.isPessoa(Crypt.md5(req.getParameter("cpws")));
                
                CtrlFuncionario ctrlFuncionario = new CtrlFuncionario();
                ctrlFuncionario.edit(funcionario);
                req.setAttribute("avisos", "Alterado com Sucesso!");
            } catch (Exception ex) {
                req.setAttribute("erros", ex.toString());
            }
            pagina = "indexF.jsp?p=alterarFuncionario";
        }//</editor-fold>

        //Retorna para a pagina
        return pagina;
    }

}
