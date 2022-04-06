package br.com.projetoJpa.namedQuery;

import br.com.projetoJpa.infra.DAO;
import br.com.projetoJpa.modelo.namedNativeQuery.NotaFilme;

public class obterMediaFilmes {
    public static void main(String[] args) {
        DAO<NotaFilme> filmeDAO = new DAO(NotaFilme.class);

        System.out.println(filmeDAO.consultarUm("mediaGeral"));
    }
}
