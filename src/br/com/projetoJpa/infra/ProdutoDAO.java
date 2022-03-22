package br.com.projetoJpa.infra;

import br.com.projetoJpa.modelo.basico.Produto;

// aqui criamos uma classe de produto Dao
// para nao precisar expecificar a model toda vez
// que for usar a classe DAO
public class ProdutoDAO extends DAO<Produto> {

    public ProdutoDAO() {
        // chama o contrutor passando a model class
        super(Produto.class);
    }
}
