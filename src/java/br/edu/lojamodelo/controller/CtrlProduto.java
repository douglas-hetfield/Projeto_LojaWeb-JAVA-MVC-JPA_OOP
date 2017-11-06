package br.edu.lojamodelo.controller;

import br.edu.lojamodelo.model.Produto;
import br.edu.lojamodelo.dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;

public class CtrlProduto {
    
    public void salvar(Produto produto) throws SQLException, Exception {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.create(produto);
    }
    
    public List pesquisaProdutos(String dados) throws SQLException, Exception {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.pesquisaProdutos(dados);
    }
    
    public List listar(String dados) throws SQLException, Exception {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.findProdutos(dados);
    }
    public List<Produto> listProdutos(int opc) throws Exception{
        ProdutoDAO dao = new ProdutoDAO();
         return dao.listProdutos(opc);
       
    }
    
    public List listarTodos() throws SQLException, Exception {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.findProdutosALL();
    }
    
    public void edit(Produto produto) throws Exception{
        ProdutoDAO dao = new ProdutoDAO();
         dao.edit(produto);
    }
    
    public List listarTodos(String dados) throws SQLException, Exception {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.findProdutosALL(dados);
    }

    public Produto buscarID(long id) throws SQLException, Exception {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.findProduto(id);
    }

    public void alterar(Produto produto) throws SQLException, Exception {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.edit(produto);
    }
    
    public void remover(long parseLong) throws Exception {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.destroy(parseLong);
    }
    
}
