package br.com.projetoJpa.muitosPraMuitosTeste;

import br.com.projetoJpa.infra.DAO;
import br.com.projetoJpa.modelo.muitosPraMuitos.Ator;
import br.com.projetoJpa.modelo.muitosPraMuitos.Filme;

public class InserirFilmeAtor {

    public static void main(String[] args) {
        Filme filme1 = new Filme("Lord of the rings", 4d);
        Filme filme2 = new Filme("Fast and the furious", 5d);
        Filme filme3 = new Filme("Naruto", 3d);

        Ator ator1 = new Ator("Van Disiel");
        Ator ator2 = new Ator("Paulo escobar");
        Ator ator3 = new Ator("Mateus Lemem");

        filme1.getAtores().add(ator1);
        filme1.getAtores().add(ator2);
        filme1.getAtores().add(ator3);

        filme2.getAtores().add(ator1);
        filme2.getAtores().add(ator2);
        filme2.getAtores().add(ator3);

        filme3.getAtores().add(ator1);
        filme3.getAtores().add(ator2);
        filme3.getAtores().add(ator3);

        new DAO<Ator>()
                .abrirTransacao()
                .incluir(ator1)
                .incluir(ator2)
                .incluir(ator3)
                .fecharTransacao()
                .fechar();

        new DAO<Filme>()
                .abrirTransacao()
                .incluir(filme1)
                .incluir(filme2)
                .incluir(filme3)
                .fecharTransacao()
                .fechar();
    }
}
