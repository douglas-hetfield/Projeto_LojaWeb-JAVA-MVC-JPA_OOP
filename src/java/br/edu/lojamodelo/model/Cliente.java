
package br.edu.lojamodelo.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cliente implements Serializable {

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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.lojamodelo.model.Cliente[ id=" + id + " ]";
    }
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataCadastro;
    
    private boolean status;
    
    private String nome;
    private String email;
    private String pws;
    private String cpf;
    private String numero;
    private String complemento;
    
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    protected String dados() {
        String erros = "";
        if (nome.equals("")) {
            erros += "Nome em branco.\n";
        }
        if (email.equals("")) {
            erros += "E-mail em branco.\n";
        }
        if (cpf.equals("")) {
            erros += "CPF em branco.\n";
        }
        if (bairro.equals("")) {
            erros += "Bairro em branco.\n";
        }
        if (cep.equals("")) {
            erros += "CEP em branco.\n";
        }
        if (cidade.equals("")) {
            erros += "Cidade em branco.\n";
        }
        if (complemento.equals("")) {
            erros += "Complemento em branco.\n";
        }
        if (logradouro.equals("")) {
            erros += "Logradouro em branco.\n";
        }
        if (uf.equals("")) {
            erros += "UF em branco.\n";
        }
        if (numero.equals("")) {
            erros += "Numero em branco.\n";
        }
                
        return erros;
    }

    protected String senha(String confirmaSenha) {
        String erros = "";
        if (pws.equals("")) {
            erros += "Senha em branco.\n";
        } else if (pws.length() < 5) {
            erros += "Senha é muito curta. Minimo de 6(seis) caracteres\n";
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
    public void isPessoa()throws Exception {
        String erros = dados();
        if (!erros.equals("")){
            throw  new Exception(erros);
        }
    }
    public void isSenha(String confirmaSenha)throws Exception {
        String erros = senha(confirmaSenha);
        if (!erros.equals("")){
            throw  new Exception(erros);
        } 
    }
   
    
}
