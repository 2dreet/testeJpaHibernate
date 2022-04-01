package br.com.projetoJpa.modelo.muitosPraMuitos;

import br.com.projetoJpa.modelo.basico.Entidade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sobrinho implements Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Reponsavel por cria uma relacao de muitos para muitos com outra tabela
    // mappedBy mapea a realacao bi direcional com a model
    @ManyToMany(mappedBy = "sobrinhos")
    private List<Tio> tios = new ArrayList();

    public Sobrinho() {
    }

    public Sobrinho(String nome) {
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

    public List<Tio> getTios() {
        return tios;
    }

    public void setTios(List<Tio> tios) {
        this.tios = tios;
    }
}
