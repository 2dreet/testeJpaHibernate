package br.com.projetoJpa.UmPraMuitos;

import br.com.projetoJpa.infra.DAO;
import br.com.projetoJpa.modelo.umPraMuitos.Pedido;

public class ObterPedido {

    public static void main(String[] args) {
        DAO<Pedido> pedidoDAO = new DAO(Pedido.class);

        Pedido pedido = pedidoDAO.obterPorId(3L);

        System.out.println(pedido);
        System.out.println("\n");
        pedido.getItemPedidos().stream().forEach(itemPedido -> {
            System.out.println(itemPedido);
            System.out.println(itemPedido.getProduto());
        });
    }
}
