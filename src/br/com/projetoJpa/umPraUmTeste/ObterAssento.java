package br.com.projetoJpa.umPraUmTeste;

import br.com.projetoJpa.infra.DAO;
import br.com.projetoJpa.modelo.umPraUm.Assento;

public class ObterAssento {
    public static void main(String[] args) {
        DAO<Assento> assentoDAO = new DAO(Assento.class);

        Assento assento = assentoDAO.obterPorId(1L);

        System.out.println(assento);
        System.out.println(assento.getCliente());
    }
}
