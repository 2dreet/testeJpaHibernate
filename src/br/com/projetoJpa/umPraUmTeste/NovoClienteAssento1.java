package br.com.projetoJpa.umPraUmTeste;

import br.com.projetoJpa.infra.DAO;
import br.com.projetoJpa.modelo.umPraUm.Assento;
import br.com.projetoJpa.modelo.umPraUm.Cliente;

public class NovoClienteAssento1 {
    public static void main(String[] args) {
        Assento assento = new Assento("A1");
        Cliente cliente = new Cliente("José", assento);

        DAO<Assento> assentoDao = new DAO(Assento.class);
        DAO<Cliente> clienteDao = new DAO(Cliente.class);

        assentoDao.incluirAtomico(assento);

        clienteDao.incluirAtomico(cliente);

        assentoDao.fechar();
        clienteDao.fechar();
    }
}
