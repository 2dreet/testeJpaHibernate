package br.com.projetoJpa;

import br.com.projetoJpa.modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ObterUsuarios {
    public static void main(String[] args) {

        // Aqui criamos o entityManagerFactory utiliznado a classe Persistence
        // e obtendo as configurações do arquivo persistence.xml
        // persistence-unit name="projeto-jpa"
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("projeto-jpa");

        // Aqui criamos o EntityManager com o Factory.
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // aqui criamos o JPQL
        String jpql = "select u from Usuario u";

        // Aqui Criamos uma query de Usuario com o JPQL
        TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);

        // aqui determina que vai trazer no maximo 5 resultados
        query.setMaxResults(5);

        // aqui fazemos a consulta e atribuimos a uma lista
        List<Usuario> usuarios = query.getResultList();

        usuarios.stream().forEach(System.out::println);

        // Outra forma é fazer direto
        List<Usuario> usuarios2 = entityManager
                .createQuery("select u from Usuario u", Usuario.class)
                .setMaxResults(3)
                .getResultList();

        System.out.println("\n \n \n \n");

        usuarios2.stream().forEach(System.out::println);

        // aqui fechamos a conexao do entityManager
        entityManager.close();
        // aqui fechamos a conexao do entityFactory
        entityManagerFactory.close();
    }
}
