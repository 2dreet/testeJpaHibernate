package br.com.projetoJpa.modelo.umPraUm;

import br.com.projetoJpa.modelo.basico.Entidade;

import javax.persistence.*;

// Aqui definimos que a classe vai ser uma entidade ou model
@Entity
// aqui configuramos a model para relacionar com o nome da tabela
@Table( name = "assentos")
public class Assento implements Entidade {

    // Aqui define que o atributo vai ser o ID (PK) da model
    @Id
    // Aqui definimos o auto incremento da id (PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // aqui defimos a relacao bi direcional do assento para o cliente
    // nisso nao vai criar a coluna no banco apenas na memoria ira ser
    // populada, mappedBy diz qual o nome do atributo que esta na classe cliente
    // aque mapea a Model Assento
    @OneToOne(mappedBy = "assento")
    private Cliente cliente;

    public Assento() {
    }

    public Assento(String nome) {
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    @Transient
    public String toString() {
        return "Assento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
