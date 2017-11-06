package br.edu.lojamodelo.controller;

import br.edu.lojamodelo.model.Item;
import br.edu.lojamodelo.dao.ItemDAO;
import java.sql.SQLException;
import java.util.List;

public class CtrlItem {
    
    public void salvar(Item item) throws SQLException, Exception {
        ItemDAO itemDAO = new ItemDAO();
        itemDAO.create(item);
    }

    public List listar(String dados) throws SQLException, Exception {
        ItemDAO itemDAO = new ItemDAO();
        return itemDAO.findItems(dados);
    }
    public List listarTodos(String dados) throws SQLException, Exception {
        ItemDAO itemDAO = new ItemDAO();
        return itemDAO.findItemsALL(dados);
    }

    public Item buscarID(long id) throws SQLException, Exception {
        ItemDAO itemDAO = new ItemDAO();
        return itemDAO.findItem(id);
    }

    public void alterar(Item item) throws SQLException, Exception {
        ItemDAO itemDAO = new ItemDAO();
        itemDAO.edit(item);
    }
    
    public void remover(long parseLong) throws Exception {
        ItemDAO itemDAO = new ItemDAO();
        itemDAO.destroy(parseLong);
    }
    
}
