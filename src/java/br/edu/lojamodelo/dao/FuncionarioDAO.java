package br.edu.lojamodelo.dao;

import br.edu.lojamodelo.model.Funcionario;
import java.util.List;
import javax.persistence.EntityNotFoundException;

import javax.persistence.Query;

public class FuncionarioDAO extends Conecta {

    //Salvar funcionario
    public void create(Funcionario funcionario) throws Exception {
        et = em.getTransaction();
        try {
            et.begin();
            em.persist(funcionario);
            et.commit();
        } catch (Exception ex) {
            try {
                et.rollback();
            } catch (Exception re) {
                re.toString();
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //Alterar Funcionario
    public void edit(Funcionario funcionario) throws Exception {
        et = em.getTransaction();
        try {
            et.begin();
            funcionario = em.merge(funcionario);
            et.commit();
        } catch (Exception ex) {
            try {
                et.rollback();
            } catch (Exception re) {

            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = funcionario.getId();
                if (findFuncionario(id) == null) {

                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //Apagar funcionario
    public void destroy(Long id) throws Exception {
        et = em.getTransaction();
        try {
            et.begin();
            Funcionario funcionario = null;
            try {
                funcionario = em.getReference(Funcionario.class, id);
                funcionario.getId();
            } catch (EntityNotFoundException enfe) {

            }
            em.remove(funcionario);
            et.commit();
        } catch (Exception ex) {
            try {
                et.rollback();
            } catch (Exception re) {

            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //Busca cliete pelo id
    public Funcionario findFuncionario(Long id) {
        try {
            return em.find(Funcionario.class, id);
        } finally {
            em.close();
        }
    }

    //Buscar todos por nomes
    public List<Funcionario> findFuncionarios(String dados) {
        try {
            Query query = em.createQuery("select c from Funcionario as c where c.nome like :dados");
            query.setParameter("dados", dados + "%");
            List<Funcionario> funcionarios = query.getResultList();
            return funcionarios;
        } finally {
            em.close();
        }
    }

    //Retorna lista de funcionarios
    public List<Funcionario> listFuncionarios(int opc) {
        try {
            String sql = ("select f from Funcionario as f ");
            boolean status = true;
            switch (opc) {
                case 1:
                    sql += ("where f.status = :dados");
                    break;
                case 2:
                    sql += ("where f.status = :dados");
                    status = false;
                    break;
            }
            Query query = em.createQuery(sql);
            if (opc != 0) {
                query.setParameter("dados", status);
            }

            List<Funcionario> funcionarios = query.getResultList();
            return funcionarios;
        } finally {
            em.close();
        }

    }

    //Busca funcionario pela email e senha
    public Funcionario findFuncionario(String email, String pws) {
        try {
            Query query = em.createQuery(""
                    + "select c from Funcionario as c "
                    + "where c.email = :email and c.pws = :pws");
            query.setParameter("email", email);
            query.setParameter("pws", pws);
            return (Funcionario) query.getSingleResult();
            /* tem algum erro aqui. se ele nao encontrar nenhum resultado ele da erro! >> Grave:   Erros: javax.persistence.NoResultException: getSingleResult() did not retrieve any entities.*/
        } finally {
            em.close();
        }
    }

}
