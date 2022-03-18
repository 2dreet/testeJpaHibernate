package br.com.projetoJpa;

import br.com.projetoJpa.modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

public class InserirUsuario {
    public static void main(String[] args) {
        //aqui obtemos a fabrica de conexao pegando o nome la do persistence.xml
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("projeto-jpa");
        // aqui criamos o entityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<String> nomes = Arrays.asList("Jose", "Mateus", "Joao", "Fernando", "Maria");

        Usuario usuarioMeriva = new Usuario("Meriva", "meriva@meriva.com");

        // aqui iniciamos a transacao
        entityManager.getTransaction().begin();

        nomes.stream().forEach(nome -> {
            entityManager.persist(new Usuario(nome, (nome + "@" + nome + ".com").toLowerCase()));
        });

        entityManager.persist(usuarioMeriva);

        // aqui submetemos a transacao
        entityManager.getTransaction().commit();

        // aqui quando o usuario é submetido o id é preenchido
        System.out.println(usuarioMeriva.getId());

        // aqui fechamos a conexao do entityManager
        entityManager.close();
        // aqui fechamos a conexao do entityFactory
        entityManagerFactory.close();
    }
}
