package br.edu.lojamodelo.logica;

import br.edu.lojamodelo.controller.CtrlProduto;
import br.edu.lojamodelo.model.Produto;
import br.edu.lojamodelo.util.UpFiles;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
public class ProdutoLogica implements Logica {

    private static final long serialVersionUID = 1L;

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res)
            throws Exception {
        res.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        
        //Retorno da Pagina
        String pagina = "index.jsp";

        //Ação para cadastro
        //<editor-fold>
        if (req.getParameter("action").equals("cad")) {
            Produto produto = new Produto();
            try {
                UpFiles up = new UpFiles();
                up.setPath("../../web/img/produto/");
                if (up.send(req)) {
                produto.setFoto1(req.getPart("foto1").getSubmittedFileName());
                produto.setFoto2(req.getPart("foto2").getSubmittedFileName());
                produto.setFoto3(req.getPart("foto3").getSubmittedFileName());
                produto.setCategoria(req.getParameter("categoria").trim());
                produto.setDescricao(req.getParameter("descricao").trim());

                if (!req.getParameter("quant").equals("")) {
                    produto.setQuant(Integer.parseInt(req.getParameter("quant")));
                }
                if (!req.getParameter("valor").equals("")) {
                    produto.setValor(Double.parseDouble(req.getParameter("valor")));
                }

                //Trata o valor do botão de rádio
                if (req.getParameter("ativo").equals("1")) {
                    produto.setAtivo(true);
                } else {
                    produto.setAtivo(false);
                }

                produto.isProduto();

                CtrlProduto ctrProduto = new CtrlProduto();
                ctrProduto.salvar(produto);
                req.setAttribute("avisos", "Produto cadastrado com sucesso.");
                produto = null;
                }

            } catch (Exception e) {
                req.setAttribute("erros", e.getMessage().replace(".\n", ".<br>"));
                req.setAttribute("produto", produto);
            }
            pagina = "index.jsp?p=formProduto";
        }//</editor-fold>

        //Ação para listar
        //<editor-fold>
        if (req.getParameter("action").equals("list")) {
            CtrlProduto controller = new CtrlProduto();

            List<Produto> produtos = controller.listProdutos(Integer.parseInt(req.getParameter("status")));
    
            req.setAttribute("listaProdutos", produtos);
            pagina = "indexF.jsp?p=ListaProdutos";                              //  TEM QUE MUDAR O CAMINHO SE FOR USAR
        }//</editor-fold>
        
        /*----------------------------------------------------------------------------------------------------------------------------*/
        
        if (req.getParameter("action").equals("listPesquisa")) {
            try {
                CtrlProduto ctrlProduto = new CtrlProduto();
                List<Produto> produtos = ctrlProduto.pesquisaProdutos(req.getParameter("pesquisa"));
    
            req.setAttribute("listaProdutos", produtos);

            } catch (Exception e) {
                req.setAttribute("erros", e.getMessage().replace(".\n", ".<br>"));
            }
            pagina = "index.jsp?p=produto/zonapesquisa";             //PRECISA CRIAR UMA PAGINA NOVA PARA RETORNAR OS PRODUTOS DA PESQUISA!!                       
        }
        
        /*----------------------------------------------------------------------------------------------------------------------------*/
        

        //Ação para Descrição
        //<editor-fold>
        if (req.getParameter("action").equals("desc")) {
            try {
                CtrlProduto ctrlProduto = new CtrlProduto();
                req.setAttribute("produto", ctrlProduto.buscarID(Long.parseLong(req.getParameter("id"))));

            } catch (Exception e) {
                req.setAttribute("erros", e.getMessage().replace(".\n", ".<br>"));
            }
            pagina = "index.jsp?p=descProduto";
        }//</editor-fold>

        //Ação para Editar
        //<editor-fold>
        if (req.getParameter("action").equals("edit")) {
            Produto produto = new Produto();
            try {
                CtrlProduto ctrProduto = new CtrlProduto();
                produto = ctrProduto.buscarID(Long.parseLong(req.getParameter("id")));
                req.setAttribute("alt", true);
            } catch (Exception e) {
                req.setAttribute("Erros: ", e.getMessage().replace(".\n", ".<br>"));

            }
            req.setAttribute("produto", produto);
            pagina = "indexF.jsp?p=formProduto";                                 //  TEM QUE MUDAR O CAMINHO SE FOR USAR
        }//</editor-fold>

        //Ação para Alterar
        //<editor-fold>
        if (req.getParameter("action").equals("alt")) {
            Produto produto = new Produto();
            try {
                produto.setFoto1(req.getPart("foto1").getSubmittedFileName());
                produto.setFoto2(req.getPart("foto2").getSubmittedFileName());
                produto.setFoto3(req.getPart("foto3").getSubmittedFileName());

                produto.setId(Long.parseLong(req.getParameter("id").trim()));
                produto.setDescricao(req.getParameter("descricao").trim());

                if (!req.getParameter("quant").equals("")) {
                    produto.setQuant(Integer.parseInt(req.getParameter("quant")));
                }
                if (!req.getParameter("valor").equals("")) {
                    produto.setValor(Double.parseDouble(req.getParameter("valor")));
                }

                //Trata o valor do botão de rádio
                if (req.getParameter("ativo").equals("1")) {
                    produto.setAtivo(true);
                } else {
                    produto.setAtivo(false);
                }

                produto.isProduto();
                CtrlProduto ctrlProduto = new CtrlProduto();
                ctrlProduto.alterar(produto);
                req.setAttribute("avisos", "Produto alterado com sucesso.");
                produto = null;

            } catch (Exception e) {
                req.setAttribute("Erros: ", e.getMessage().replace(".\n", ".<br>"));
                req.setAttribute("produto", produto);

            }
            pagina = "indexF.jsp?p=formProduto";
        }//</editor-fold>

        
        //Ação para apagar
        //<editor-fold>
        if (req.getParameter("action").equals("remove")) {
            Produto produto = new Produto();
            try {
                CtrlProduto ctrProduto = new CtrlProduto();
                ctrProduto.remover(Long.parseLong(req.getParameter("id")));
            } catch (Exception e) {
                req.setAttribute("erros", e.getMessage().replace(".\n", ".<br>"));
                req.setAttribute("produto", produto);
            }
            pagina = "index.jsp?p=reportProduto";
        }//</editor-fold>

        
        
         if (req.getParameter("action").equals("status")) {
            CtrlProduto controller = new CtrlProduto();
        try {    
            Produto produto = controller.buscarID(Long.parseLong(req.getParameter("id")));
            if (produto.isAtivo()){
               produto.setAtivo(false); 
            } else {
                produto.setAtivo(true); 
            }
            
            controller.edit(produto);
            
        } catch (Exception ex) {
            Logger.getLogger(ProdutoLogica.class.getName()).log(Level.SEVERE, null, ex);
        }
        pagina = "fc?logica=ProdutoLogica&action=list&status=0";
        }
        
       //Retorna para a pagina
        return pagina;
    }
  
}
