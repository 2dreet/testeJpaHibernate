package br.com.projetoJpa.modelo.heranca;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

// define que é uma Entidade
@Entity
// aqui mapeamos o tipo da model com base
// na coluna discriminada na model de Pessoa
// quando tiver o valor J na coluna tipo vai ser
// uma PessoaJuridica
@DiscriminatorValue("J")
public class PessoaJuridica extends Pessoa {

    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
