package br.com.projetoJpa.modelo.basico;

import javax.persistence.*;

// aqui o entity server para identificar que é uma entidade da JPA
@Entity
public class Usuario implements Entidade {

    // aqui refencia qual atributo é o id
    @Id
    // aqui a tag GeneratedValue server para criar auto incremento
    // o valor Identity server para dizer que é uma identidade um ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    public Usuario() {

    }

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    @Transient
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
