package br.com.projetoJpa.modelo.heranca;

import br.com.projetoJpa.modelo.basico.Entidade;

import javax.persistence.*;

// aqui define uma entidade
@Entity
// esse atributo define a herenca
// aqui definimos a estrategia para discriminacao das models
// no caso vai ser uma unica tabela com um atributo dizendo que tipo é
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// aqui configuramos qual coluna vai ser responsavel por salvar o valor
// e qual o tamanho e tipo da coluna
@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.STRING)
// aqui mapeamos que quando tiver P na coluna tipo vai ser uma model de pessoa
@DiscriminatorValue("P")
public class Pessoa implements Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(insertable = false, updatable = false)
    private String tipo;

    public Pessoa() {
    }

    public Pessoa(String nome) {
        super();
        this.nome = nome;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
