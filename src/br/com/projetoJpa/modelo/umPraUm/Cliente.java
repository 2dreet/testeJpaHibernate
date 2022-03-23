package br.com.projetoJpa.modelo.umPraUm;

import br.com.projetoJpa.modelo.basico.Entidade;

import javax.persistence.*;

// Aqui definimos que a classe vai ser uma entidade ou model
@Entity
// aqui configuramos a model para relacionar com o nome da tabela
@Table( name = "clientes")
public class Cliente implements Entidade {

    // Aqui define que o atributo vai ser o ID (PK) da model
    @Id
    // Aqui definimos o auto incremento da id (PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Aqui definimos o relacionamento um para um
    // vai ser criado uma coluna assentoId na tabela clientes
    // o cascade define a operacao que vai ser feita em cascada
    // toda vez que for criar um novo cliente e o assento não tiver
    // sido persistido no banco ele ira fazer de forma automatica
    @OneToOne(cascade = { CascadeType.PERSIST })
    // o Join coloumn serve para configurrar o relacionamento
    // name server para identificar a coluna FK
    // unique serve para identificar que vai ser uma FK unica
    @JoinColumn(name = "assento_id", unique = true)
    private Assento assento;

    public Cliente() {
    }

    public Cliente(String nome) {
        super();
        this.nome = nome;
    }

    public Cliente(String nome, Assento assento) {
        super();
        this.nome = nome;
        this.assento = assento;
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

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }

    @Override
    @Transient
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
