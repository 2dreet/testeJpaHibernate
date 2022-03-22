package br.com.projetoJpa.modelo.basico;

import javax.persistence.*;

// aqui o @Entity diz que a classe é uma model da JPA
@Entity
// @Table configura a model com a tabela
// o name diz para qual tabela está referenciada
// o schema diz qual o banco esta a tabela
@Table( name = "produtos", schema = "projeto-jpa")
public class Produto implements Entidade {

    // @Id diz qual é a columa id da tabela
    @Id
    // @GeneratedValue é o auto incremento e o
    // strategy e o GenerationType.IDENTITY diz que é auto incremento de id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column configura a coluna da tabela
    // name diz qual coluna está referenciada
    // length diz o tamanha maximo do campo
    // nullable diz se aceita null ou não
    @Column( name = "prod_nome", length = 120, nullable = false)
    private String nome;

    // @Column configura a coluna da tabela
    // name diz qual coluna está referenciada
    // nullable diz se aceita null ou não
    // precision diz o tamanho do valor antes da virgula
    // scale diz o tamanho das casas decimais
    @Column( name = "prod_preco", nullable = false, precision = 11, scale = 2)
    private Double preco;

    public Produto() {
    }

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    @Transient
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}
