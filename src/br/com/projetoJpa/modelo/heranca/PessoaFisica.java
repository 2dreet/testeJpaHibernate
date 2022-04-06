package br.com.projetoJpa.modelo.heranca;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

// define que é uma Entidade
@Entity
// aqui mapeamos o tipo da model com base
// na coluna discriminada na model de Pessoa
// quando tiver o valor F na coluna tipo vai ser
// uma PessoaFisica
@DiscriminatorValue("F")
public class PessoaFisica extends Pessoa {

    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
