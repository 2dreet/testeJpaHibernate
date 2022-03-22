package br.com.projetoJpa;

import br.com.projetoJpa.infra.ProdutoDAO;
import br.com.projetoJpa.modelo.basico.Produto;

public class NovoProdutoComDAO {
    public static void main(String[] args) {

        Produto produto = new Produto("Sprite", 10.39);

        ProdutoDAO produtoDao = new ProdutoDAO();
        produtoDao.incluirAtomico(produto)
                .fechar();

        System.out.println(produto);
    }
}
