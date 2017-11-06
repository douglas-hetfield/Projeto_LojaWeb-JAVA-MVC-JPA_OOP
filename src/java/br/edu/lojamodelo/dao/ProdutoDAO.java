package br.edu.lojamodelo.dao;

import br.edu.lojamodelo.model.Produto;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

public class ProdutoDAO extends Conecta {

    //Salvar produto
    public void create(Produto produto) throws Exception {
        et = em.getTransaction();
        try {
            et.begin();
            em.persist(produto);
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

    //Alterar Produto
    public void edit(Produto produto) throws Exception {
        et = em.getTransaction();
        try {
            et.begin();
            produto = em.merge(produto);
            et.commit();
        } catch (Exception ex) {
            try {
                et.rollback();
            } catch (Exception re) {

            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = produto.getId();
                if (findProduto(id) == null) {

                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //Apagar produto
    public void destroy(Long id) throws Exception {
        et = em.getTransaction();
        try {
            et.begin();
            Produto produto = null;
            try {
                produto = em.getReference(Produto.class, id);
                produto.getId();
            } catch (EntityNotFoundException enfe) {

            }
            em.remove(produto);
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
    public Produto findProduto(Long id) {
        try {
            return em.find(Produto.class, id);
        } finally {
            em.close();
        }
    }

    //Buscar todos por nomes
    public List<Produto> findProdutos(String dados) {
        try {
            Query query = em.createQuery("select p from Produto as p where p.categoria = :dados and p.ativo = 1 and p.quant <> 0");
            query.setParameter("dados", dados);
            List<Produto> produtos = query.getResultList();
            return produtos;
        } finally {
            em.close();
        }
    }
    
    public List<Produto> pesquisaProdutos(String dados) {
        try {
            Query query = em.createQuery("select p from Produto as p where p.descricao like :dados and p.ativo = 1 and p.quant <> 0");
            query.setParameter("dados", "%" + dados + "%");
            List<Produto> produtos = query.getResultList();
            return produtos;
        } finally {
            em.close();
        }
    }
    
    public List<Produto> findProdutosALL(String dados) {
        try {
            Query query = em.createQuery("select p from Produto as p where p.descricao like :dados");
            query.setParameter("dados", dados + "%");
            List<Produto> produtos = query.getResultList();
            return produtos;
        } finally {
            em.close();
        }
    }
    
    public List<Produto> findProdutosALL() {
        try {
            Query query = em.createQuery("select p from Produto as p");
           
            List<Produto> produtos = query.getResultList();
            return produtos;
        } finally {
            em.close();
        }
    }

    public List<Produto> listProdutos(int opc) {
        try {
            String sql = ("select p from Produto as p ");
            boolean status = true;
            switch (opc) {
                case 1:
                    sql += ("where p.ativo = :dados");
                    break;
                case 2:
                    sql += ("where p.ativo = :dados");
                    status = false;
                    break;
            }
            Query query = em.createQuery(sql);
            if (opc != 0) {
                query.setParameter("dados", status);
            }

            List<Produto> Produtos = query.getResultList();
            return Produtos;
        } finally {
            em.close();
        }

    }

}
