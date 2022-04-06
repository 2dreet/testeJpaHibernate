package br.com.projetoJpa.namedQuery;

import br.com.projetoJpa.infra.DAO;
import br.com.projetoJpa.modelo.muitosPraMuitos.Filme;

import java.util.List;

public class obterFilmesNamedQuery {
    public static void main(String[] args) {
        DAO<Filme> filmeDAO = new DAO(Filme.class);
        // aqui passamos o nome da query que esta no arquivo consultas.xml
        // o ṕarametro e o valor do parametro logo em seguida
        List<Filme> filmes = filmeDAO.consultar("filmesNotaMaiorQue", "nota", 1.0);

        filmes.stream().forEach(System.out::println);
    }
}
