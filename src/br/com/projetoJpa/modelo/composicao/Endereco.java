package br.com.projetoJpa.modelo.composicao;

import javax.persistence.Embeddable;

// server para dizer que os atributos dessa classe
// vao fazer parte da tabela da model que utilizar
// rezumidamente é compartilhamento de atributos
// e quando trazer do banco os dados vai ser populado
// aqui criamos uma herença de atributos
@Embeddable
public class Endereco {

    private String endereco;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
