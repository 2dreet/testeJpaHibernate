package br.com.projetoJpa;

import br.com.projetoJpa.infra.ProdutoDAO;
import br.com.projetoJpa.modelo.basico.Produto;

import java.util.List;

public class ObterProdutoDAO {
    public static void main(String[] args) {

        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = produtoDAO.obterPorId(1L);
        System.out.println(produto);

        System.out.println("\n\n----------------\n\n");

        List<Produto> produtos = produtoDAO.obter5();
        produtos.stream().forEach(System.out::println);

        produtoDAO.fechar();
    }
}
