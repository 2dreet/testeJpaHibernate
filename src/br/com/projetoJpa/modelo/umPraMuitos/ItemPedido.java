package br.com.projetoJpa.modelo.umPraMuitos;

import br.com.projetoJpa.modelo.basico.Entidade;
import br.com.projetoJpa.modelo.basico.Produto;

import javax.persistence.*;

// Aqui definimos que a classe vai ser uma entidade ou model
@Entity
// aqui configuramos a model para relacionar com o nome da tabela
@Table( name = "itens_pedidos")
public class ItemPedido implements Entidade {
    // Aqui define que o atributo vai ser o ID (PK) da model
    @Id
    // Aqui definimos o auto incremento da id (PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // o @ManyToOne é para sinalizar que vai ter varios itemPedido
    // para um pedido
    @ManyToOne
    private Pedido pedido;

    // o @ManyToOne é para sinalizar que vai ter varios itemPedido
    // para um pedido
    @ManyToOne
    private Produto produto;

    // @Column configura a coluna da tabela
    // nullable diz se aceita null ou não
    @Column( nullable = false)
    private int quantidade;

    // @Column configura a coluna da tabela
    // nullable diz se aceita null ou não
    @Column( nullable = false)
    private Double preco;

    public ItemPedido() {
    }

    public ItemPedido(Pedido pedido, Produto produto, int quantidade) {
        super();
        this.setPedido(pedido);
        this.setProduto(produto);
        this.setQuantidade(quantidade);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        if(this.produto != null) {
            this.setPreco(this.produto.getPreco());
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    @Transient
    public String toString() {
        return "ItemPedido{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                '}';
    }
}
