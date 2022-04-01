package br.com.projetoJpa.muitosPraMuitosTeste;

import br.com.projetoJpa.infra.DAO;
import br.com.projetoJpa.modelo.muitosPraMuitos.Sobrinho;
import br.com.projetoJpa.modelo.muitosPraMuitos.Tio;

public class InserirTioSobrinho {
    public static void main(String[] args) {

        DAO<Tio> tioDAO = new DAO();
        DAO<Sobrinho> sobrinhoDAO = new DAO();

        Tio tio1 = new Tio("Tio Cleber");
        Tio tio2 = new Tio("Tio Daniel");

        Sobrinho sobrinho1 = new Sobrinho("Sobrinho Alex");
        Sobrinho sobrinho2 = new Sobrinho("Sobrinho Mates");

        tio1.getSobrinhos().add(sobrinho1);
        tio1.getSobrinhos().add(sobrinho2);

        tio2.getSobrinhos().add(sobrinho1);
        tio2.getSobrinhos().add(sobrinho2);

        sobrinhoDAO
                .abrirTransacao()
                .incluir(sobrinho1)
                .incluir(sobrinho2)
                .fecharTransacao();

        tioDAO
                .abrirTransacao()
                .incluir(tio1)
                .incluir(tio2)
                .fecharTransacao();

        tioDAO.fechar();
        sobrinhoDAO.fechar();


    }
}
