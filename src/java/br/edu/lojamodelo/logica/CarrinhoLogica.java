/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.lojamodelo.logica;

import br.edu.lojamodelo.controller.CtrlCliente;
import br.edu.lojamodelo.controller.CtrlItem;
import br.edu.lojamodelo.controller.CtrlPedido;
import br.edu.lojamodelo.controller.CtrlProduto;
import br.edu.lojamodelo.model.Cliente;
import br.edu.lojamodelo.model.Item;
import br.edu.lojamodelo.model.Pedido;
import br.edu.lojamodelo.model.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aluno
 */
@MultipartConfig
public class CarrinhoLogica implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String pagina = "index.jsp";
        
        /* ABERTURA DE SESSÃO DO USUÁRIO */
        HttpSession carrinho = req.getSession(true);
        Pedido pedido = (Pedido) carrinho.getAttribute("pedido");
        
        /* ABERTURA DE SESSÃO DO USUÁRIO */
        //  HttpSession sessao = request.getSession();
        //     sessao.setAttribute("usuario", usuario);
        if (req.getParameter("action").equals("add")) {
            try {
                CtrlProduto ctrlProduto = new CtrlProduto();
                Produto produto = ctrlProduto.buscarID(Long.parseLong(req.getParameter("id")));
                
                Item item = new Item();
                item.setProduto(produto);
                
                if (pedido == null) pedido = new Pedido();
                item.setValor();
                pedido.adiciona(item);
                //item.setPedido(pedido);
                String[] quant= null;
                pedido.setValor(calularValor(pedido, quant));
                
                carrinho.setAttribute("pedido", pedido);
                carrinho.setAttribute("itens", pedido.getItens());
                carrinho.setAttribute("tamanho", pedido.getItens().size());

                pagina = "index.jsp?p=carrinho";
            } catch (Exception ex) {
                req.setAttribute("erros", ex.toString());
            }
        }

        if (req.getParameter("action").equals("remove")) {
            try {
                Long id = Long.parseLong(req.getParameter("id"));
            
                List<Item> lista = new ArrayList<Item>();
                //pedido.getItens().size() != 0
                if (!pedido.getItens().isEmpty()){
                    for (Item item : pedido.getItens() ){
                        // Adiciona itens da lista antiga a minha nova lista, ignorando apenas o único item pelo qual passei o ID no parâmetro .
                        if (item.getProduto().getId() != id){
                            lista.add(item);
                        }
                    }
                }
                
                
                   pedido.setItens(lista);
                

                String[] quant= req.getParameterValues("quant");
                pedido.setValor(calularValor(pedido, quant));

                carrinho.setAttribute("pedido", pedido);
                carrinho.setAttribute("itens", pedido.getItens());
                carrinho.setAttribute("tamanho", pedido.getItens().size()); 
                pagina = "index.jsp?p=carrinho";  
                
                //Seta a lista de itens do pedido, passando a nova lista como parâmetro
                
            } catch (Exception ex) {
                req.setAttribute("erros", ex.toString());
            }
        }
        
        
        if (req.getParameter("action").equals("calcular")) {
              String[] quant= req.getParameterValues("quant");
              
              pedido.setValor(calularValor(pedido, quant));
              
              carrinho.setAttribute("pedido", pedido);
              carrinho.setAttribute("itens", pedido.getItens());
              carrinho.setAttribute("tamanho", pedido.getItens().size()); 
              pagina = "index.jsp?p=carrinho"; 
        }
        
         if (req.getParameter("action").equals("pagamento")) {
             String id = req.getParameter("idUser");
             if (pedido == null){
                    req.setAttribute("alertas","Nenhum produto no carrinho, impossível continuar!");
                    pagina = "index.jsp?p=carrinho"; 
             }
             
             if ((!id.equals("")) || (id == null)){
                 if (pedido == null){
                    req.setAttribute("alertas","Nenhum produto no carrinho, impossível continuar!");
                    pagina = "index.jsp?p=carrinho"; 
                 } else {
                    carrinho.setAttribute("pedido", pedido);
                    carrinho.setAttribute("itens", pedido.getItens());
                    carrinho.setAttribute("tamanho", pedido.getItens().size()); 
                    pagina = "index.jsp?p=pagamento";  
                     }
                 
             } else {
                 
                 req.setAttribute("erros","Por favor, efetue o login para prosseguir");
                 pagina = "index.jsp?p=carrinho";
             }
         }
         
         
         if (req.getParameter("action").equals("finalizar")) {
             String[] quant= req.getParameterValues("quant");
             String[] id = req.getParameterValues("idProduto");
             String idUsuario = req.getParameter("id");
             long idu = Long.parseLong(idUsuario);
             
             String formaPag = req.getParameter("formaPag");
             pedido.setFormaPag(formaPag);
             
             /*BUSCAR CLIENTE */
                CtrlCliente ctrlC = new CtrlCliente();
                Cliente c = ctrlC.buscarId(idu);
                pedido.setCliente(c);
             /* BUSCAR CLIENTE */
             
             CtrlPedido ctrlPedido = new CtrlPedido();
             CtrlProduto ctrlProduto = new CtrlProduto();
             CtrlItem ctrlItem = new CtrlItem();
             int cont = 0;
             for (Item i : pedido.getItens()) {
                    if (i.getProduto().getId() == Long.parseLong(id[cont])){
                        ctrlItem.salvar(i);
                    }
                    cont++; 
             }
             ctrlPedido.salvar(pedido); 
             
             pedido = null;
             Item it = new Item();
             it = null;
             carrinho.setAttribute("pedido", pedido);
             carrinho.setAttribute("itens", it);
             carrinho.setAttribute("tamanho", null); 
             
             req.setAttribute("avisos", "Compra finalizada com sucesso!");
             pagina = "index.jsp?p=carrinho";
         }
         
             return pagina;
        }

    // Calcula o valor
    private double calularValor(Pedido pedido, String[] quant) {
              int cont = 0;
              double total = 0;
              int numeroItens = 0;
              
              for (Item i : pedido.getItens()) {
                    if (quant != null){
                        i.setQuant(Integer.parseInt(quant[cont]));
                    } else {
                        i.setQuant(1);
                    }
                    i.setValor();
                    total += i.getValor();
                    numeroItens += i.getQuant();
                    cont++;
              }
              
              pedido.setNumeroItens(numeroItens);
              return total;     
    }
}
