package br.com.projetoJpa.modelo.composicao;

import br.com.projetoJpa.modelo.basico.Entidade;

import javax.persistence.*;

@Entity
@Table(name = "fornecedores")
public class Fornecedor implements Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // aqui adicionamos a classe Endereco que é um
    // Embeddable e a tabela fornecedores vai passar
    // a ter as colunas da classe endereco
    // aqui é uma herença de atributos
    private Endereco endereco;

    public Fornecedor() {
    }

    public Fornecedor(String nome, Endereco endereco) {
        super();
        this.nome = nome;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
