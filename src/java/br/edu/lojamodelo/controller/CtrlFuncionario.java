
package br.edu.lojamodelo.controller;

import br.edu.lojamodelo.dao.FuncionarioDAO;
import br.edu.lojamodelo.model.Funcionario;
import java.util.List;

public class CtrlFuncionario {
    
    public void cadastrar(Funcionario funcionario) throws Exception{
        FuncionarioDAO dao = new FuncionarioDAO();
        dao.create(funcionario);
    }
    
    public Funcionario verificar(String email, String pws) throws Exception{
        FuncionarioDAO dao = new FuncionarioDAO();
        return dao.findFuncionario(email , pws);
    }
    
    public Funcionario findFuncionario(long id) throws Exception{
        FuncionarioDAO dao = new FuncionarioDAO();
       
        return dao.findFuncionario(id);
    }
    
    public List<Funcionario> listFuncionarios(int opc) throws Exception{
        FuncionarioDAO dao = new FuncionarioDAO();
         return dao.listFuncionarios(opc);
       
    }
    
    public void edit(Funcionario funcionario) throws Exception{
        FuncionarioDAO dao = new FuncionarioDAO();
         dao.edit(funcionario);
    }
}
