package br.com.projetoJpa.umPraUmTeste;

import br.com.projetoJpa.infra.DAO;
import br.com.projetoJpa.modelo.umPraUm.Assento;
import br.com.projetoJpa.modelo.umPraUm.Cliente;

public class NovoClienteAssento2 {
    public static void main(String[] args) {
        Assento assento = new Assento("B1");
        Cliente cliente = new Cliente("Joao", assento);

        DAO<Cliente> clienteDao = new DAO(Cliente.class);
        clienteDao.incluirAtomico(cliente);
        clienteDao.fechar();
    }
}
