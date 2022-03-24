package br.com.projetoJpa.UmPraMuitos;

import br.com.projetoJpa.infra.DAO;
import br.com.projetoJpa.modelo.basico.Produto;
import br.com.projetoJpa.modelo.umPraMuitos.ItemPedido;
import br.com.projetoJpa.modelo.umPraMuitos.Pedido;

import java.util.Date;

public class InserirPedido {
    public static void main(String[] args) {
        DAO<Produto> produtoDAO = new DAO(Produto.class);
        DAO<Pedido> pedidoDAO = new DAO(Pedido.class);
        DAO<ItemPedido> itemPedidoDAO = new DAO(ItemPedido.class);

        Produto produto1 = new Produto("Carne Porco", 15.36);
        Produto produto2 = new Produto("Pipoca Doce", 5.27);

        produtoDAO.abrirTransacao()
                .incluir(produto1)
                .incluir(produto2)
                .fecharTransacao();

        Pedido pedido1 = new Pedido(new Date());

        pedidoDAO.abrirTransacao()
                .incluir(pedido1)
                .fecharTransacao();

        ItemPedido itemPedido1 = new ItemPedido(pedido1, produto1, 4);
        ItemPedido itemPedido2 = new ItemPedido(pedido1, produto2, 2);

        itemPedidoDAO.abrirTransacao()
                .incluir(itemPedido1)
                .incluir(itemPedido2)
                .fecharTransacao();

        produtoDAO.fechar();
        pedidoDAO.fechar();
        itemPedidoDAO.fechar();
    }
}
