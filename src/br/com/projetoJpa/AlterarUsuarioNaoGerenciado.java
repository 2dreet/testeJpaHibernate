package br.com.projetoJpa;

import br.com.projetoJpa.modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlterarUsuarioNaoGerenciado {

    public static void main(String[] args) {

        // Aqui criamos o entityManagerFactory utiliznado a classe Persistence
        // e obtendo as configurações do arquivo persistence.xml
        // persistence-unit name="projeto-jpa"
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("projeto-jpa");

        // Aqui criamos o EntityManager com o Factory.
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Usuario usuario = entityManager.find(Usuario.class, 1L);

        usuario.setNome( usuario.getNome() + " Augusto");

        // aqui tiramos o gerenciamento da JPA da model
        entityManager.detach(usuario);

        // aqui abrimos a transacao para manipular o banco
        entityManager.getTransaction().begin();
        // aqui chamamos o metodo de atualizacao da model
        entityManager.merge(usuario);
        // aqui comitamos a transacao no banco
        entityManager.getTransaction().commit();

        // aqui fechamos a conexao do entityManager
        entityManager.close();
        // aqui fechamos a conexao do entityFactory
        entityManagerFactory.close();
    }

}
