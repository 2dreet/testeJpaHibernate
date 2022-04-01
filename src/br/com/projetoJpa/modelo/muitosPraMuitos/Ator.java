package br.com.projetoJpa.modelo.muitosPraMuitos;

import br.com.projetoJpa.modelo.basico.Entidade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "atores")
public class Ator implements Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Reponsavel por cria uma relacao de muitos para muitos com outra tabela
    // mappedBy mapea a realacao bi direcional com a model
    @ManyToMany(mappedBy = "atores")
    private List<Filme> filmes = new ArrayList();

    public Ator() {
    }

    public Ator(String nome) {
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

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }
}
