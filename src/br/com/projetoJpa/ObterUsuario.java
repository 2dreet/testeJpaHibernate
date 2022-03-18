package br.com.projetoJpa;

import br.com.projetoJpa.modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ObterUsuario {
    public static void main(String[] args) {

        // Aqui criamos o entityManagerFactory utiliznado a classe Persistence
        // e obtendo as configurações do arquivo persistence.xml
        // persistence-unit name="projeto-jpa"
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("projeto-jpa");

        // Aqui criamos o EntityManager com o Factory.
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Aqui localizamos pelo id passando qual model vamos utilizar
        Usuario usuario = entityManager.find(Usuario.class, 1L);

        System.out.println(usuario);

        // aqui fechamos a conexao do entityManager
        entityManager.close();
        // aqui fechamos a conexao do entityFactory
        entityManagerFactory.close();
    }
}
