package br.com.projetoJpa.modelo.muitosPraMuitos;

import br.com.projetoJpa.modelo.basico.Entidade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "filmes")
public class Filme implements Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Double nota;

    // Reponsavel por cria uma relacao de muitos para muitos com outra tabela
    @ManyToMany
    // Responsavel por configurar a tabela de ligação entre as models
    // name -> confiura o nome da tabela
    // joinColumns -> confiura a FK apartir da classe mapeada
    // inverseJoinColumns = configura a FK apartir  da classe referenciada
    @JoinTable(
        name = "atores_filme",
        joinColumns = @JoinColumn(name = "filme_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "ator_id", referencedColumnName = "id")
    )
    private List<Ator> atores = new ArrayList();

    public Filme() {
    }

    public Filme(String nome) {
        super();
        this.nome = nome;
    }

    public Filme(String nome, Double nota) {
        super();
        this.nome = nome;
        this.nota = nota;
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

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nota=" + nota +
                '}';
    }
}

