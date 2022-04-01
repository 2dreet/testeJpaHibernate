package br.com.projetoJpa.modelo.muitosPraMuitos;

import br.com.projetoJpa.modelo.basico.Entidade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tio implements Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Reponsavel por cria uma relacao de muitos para muitos com outra tabela
    // ira criar uma tabela que liga as 2 models
    @ManyToMany
    private List<Sobrinho> sobrinhos = new ArrayList();

    public Tio() {
    }

    public Tio(String nome) {
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

    public List<Sobrinho> getSobrinhos() {
        return sobrinhos;
    }

    public void setSobrinhos(List<Sobrinho> sobrinhos) {
        this.sobrinhos = sobrinhos;
    }
}
