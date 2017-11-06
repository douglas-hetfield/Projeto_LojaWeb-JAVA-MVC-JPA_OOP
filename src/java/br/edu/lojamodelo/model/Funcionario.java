
package br.edu.lojamodelo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.lojamodelo.model.Funcionario[ id=" + id + " ]";
    }
    @Column(nullable = true)
    private boolean status;
    
    private String nome;
    private String email;
    private String pws;
    private String cargo;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPws() {
        return pws;
    }

    public void setPws(String pws) {
        this.pws = pws;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    protected String dados() {
        String erros = "";
        if (nome.equals("")) {
            erros += "Nome em branco.\n";
        }
        if (email.equals("")) {
            erros += "E-mail em branco.\n";
        }
        if (cargo.equals("")) {
            erros += "Cargo em branco.\n";
        }
        return erros;
    }
    
    protected String senha(String confirmaSenha) {
        String erros = "";
        if (pws.equals("")) {
            erros += "Senha em branco.\n";
        } else if (pws.length() < 5) {
            erros += "Senha é muito curta. Minimo de 6(seis) caracteres.\n";
        } else if (!pws.equals(confirmaSenha)) {
            erros += "Senhas diferentes\n";
        }
        return erros;
    }

    public void isPessoa(String confirmaSenha) throws Exception {
        String erros = dados()+senha(confirmaSenha);
        if (!erros.equals("")){
            throw  new Exception(erros);
        }
        
    }
}
