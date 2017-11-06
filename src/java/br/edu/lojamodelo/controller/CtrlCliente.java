
package br.edu.lojamodelo.controller;

import br.edu.lojamodelo.dao.ClienteDAO;
import br.edu.lojamodelo.model.Cliente;

public class CtrlCliente {
    
    public void cadastrar(Cliente cliente) throws Exception{
        ClienteDAO dao = new ClienteDAO();
        dao.create(cliente);
    }
    
    public Cliente verificar(String email, String pws) throws Exception{
        ClienteDAO dao = new ClienteDAO();
        return dao.findCliente(email , pws);
    }
    
    public void alterar(Cliente cliente) throws Exception{
        ClienteDAO dao = new ClienteDAO();
        dao.edit(cliente);
    }
    
    public Cliente verificar(Cliente cliente) throws Exception{
        ClienteDAO dao = new ClienteDAO();
        return dao.findCliente(cliente.getEmail() , cliente.getPws());
    }
    
    public Cliente buscarId(Long id) throws Exception{
        ClienteDAO dao = new ClienteDAO();
        return dao.findCliente(id);
    }
    
    public Cliente recuperarSenha(String email) throws Exception{
        ClienteDAO dao = new ClienteDAO();
        return dao.recuperarSenha(email);
    }
}
