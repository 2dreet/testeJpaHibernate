package br.com.projetoJpa.infra;

import br.com.projetoJpa.modelo.basico.Entidade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

// aqui criamos a classe DAO que ira receber uma classe
// ou model que precisa extender a classe Entidade
// essa classe Entidade é vazia só para controle
// para apenas Models que implementarem essa classe
// podem ser passadas para o DAO
public class DAO<E extends Entidade> {

    // quando criamos um atributo estatico o unico lugar
    // que da para instanciar é na linha ou em um bloco
    // estatico
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private Class<E> classe;

    // aqui criamos um bloco estatico para iniciar o atributo
    // é executado apenas uma vez quando o sitema carrega
    static {
        try {
            // Aqui criamos o entityManagerFactory utiliznado a classe Persistence
            // e obtendo as configurações do arquivo persistence.xml
            // persistence-unit name="projeto-jpa"
            entityManagerFactory = Persistence
                    .createEntityManagerFactory("projeto-jpa");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Construtor padrao sem model
    public DAO () {
        this(null);
    }

    // Criamos um contrutor passando qual model vai gerenciar
    // o DAO
    public DAO(Class<E> classe) {
        this.classe = classe;
        // Aqui criamos o EntityManager com o Factory.
        entityManager = entityManagerFactory.createEntityManager();
    }

    // aqui criamos a funcao de abrir a transacao
    // e retornamos a class para poder
    // encadiar varias chamadas Exp
    // new DAO<Produto>().abrirTransacao().fecharTransacao();
    public DAO<E> abrirTransacao() {
        entityManager.getTransaction().begin();
        return this;
    }

    // aqui criamos a funcao de comitar a transacao
    // e retornamos a class para poder
    // encadiar varias chamadas Exp
    // new DAO<Produto>().abrirTransacao().fecharTransacao();
    public DAO<E> fecharTransacao() {
        entityManager.getTransaction().commit();
        return this;
    }

    public DAO<E> incluir( E entidade) {
        entityManager.persist(entidade);
        return this;
    }

    //Atomico quer dizer que vai fazer tudo de uma vez
    public DAO<E> incluirAtomico( E entidade) {
        // aqui usufruimos do encadiamento dos retorno
        // das funcoes
        return this.abrirTransacao()
                .incluir(entidade)
                .fecharTransacao();
    }

    public DAO<E> alterar( E entidade) {
        entityManager.persist(entidade);
        return this;
    }

    public List<E> obter5() {
        return this.obterTodos(5 , 0);
    }

    public List<E> obter10() {
        return this.obterTodos(10 , 0);
    }

    public List<E> obter20() {
        return this.obterTodos(20 , 0);
    }

    public List<E> obter50() {
        return this.obterTodos(50 , 0);
    }

    public List<E> obter100() {
        return this.obterTodos(100 , 0);
    }

    // criamos a classe de obter todos com paginacao
    public List<E> obterTodos(int quantidade, int pagina) {
        // verifica se a classe foi populada
        if (classe == null) {
            // caso nao for populada estoramos essa exception
            // de OPERACAO NAO SUPORTADA
            throw new UnsupportedOperationException("Classe nula.");
        }

        String jpql = "Select e from " + classe.getName() + " e ";

        // aqui uma maneria de criar a query
        TypedQuery<E> query = entityManager.createQuery(jpql, classe);
        query.setMaxResults(quantidade);
        query.setFirstResult(pagina);

        // aqui fazendo tudo na mesma chamada
        return entityManager.createQuery(jpql, classe)
                .setMaxResults(quantidade)
                .setFirstResult(pagina)
                .getResultList();
    }

    // aqui obtemos por id a classe
    public E obterPorId(Long id) {
        return entityManager.find(classe, id);
    }

    // aqui fechamos o EntityManager
    // não fechamos o factory pois ele é da aplicacao toda
    // e a cada nova instacian é criado a conexao com o entityManager
    public void fechar() {
        entityManager.close();
    }

}
