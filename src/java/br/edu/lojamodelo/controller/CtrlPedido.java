package br.edu.lojamodelo.controller;

import br.edu.lojamodelo.model.Pedido;
import br.edu.lojamodelo.dao.PedidoDAO;
import java.sql.SQLException;
import java.util.List;

public class CtrlPedido {
    
    public void salvar(Pedido pedido) throws SQLException, Exception {
        PedidoDAO pedidoDAO = new PedidoDAO();
        pedidoDAO.create(pedido);
    }

    public List listar(String dados) throws SQLException, Exception {
        PedidoDAO pedidoDAO = new PedidoDAO();
        return pedidoDAO.findPedidos(dados);
    }
    public List listarTodos(String dados) throws SQLException, Exception {
        PedidoDAO pedidoDAO = new PedidoDAO();
        return pedidoDAO.findPedidosALL(dados);
    }

    public Pedido buscarID(long id) throws SQLException, Exception {
        PedidoDAO pedidoDAO = new PedidoDAO();
        return pedidoDAO.findPedido(id);
    }

    public void alterar(Pedido pedido) throws SQLException, Exception {
        PedidoDAO pedidoDAO = new PedidoDAO();
        pedidoDAO.edit(pedido);
    }
    
    public void remover(long parseLong) throws Exception {
        PedidoDAO pedidoDAO = new PedidoDAO();
        pedidoDAO.destroy(parseLong);
    }
    
}
