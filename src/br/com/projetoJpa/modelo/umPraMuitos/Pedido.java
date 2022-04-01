package br.com.projetoJpa.modelo.umPraMuitos;

import br.com.projetoJpa.modelo.basico.Entidade;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

// Aqui definimos que a classe vai ser uma entidade ou model
@Entity
// aqui configuramos a model para relacionar com o nome da tabela
@Table( name = "pedidos")
public class Pedido implements Entidade {

    // Aqui define que o atributo vai ser o ID (PK) da model
    @Id
    // Aqui definimos o auto incremento da id (PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column configura a coluna da tabela
    // nullable diz se aceita null ou não
    @Column( nullable = false)
    private Date data;

    // aqui defimos a relacao bi direcional do Pedido para o ItemPedido
    // nisso nao vai criar a coluna no banco apenas na memoria ira ser
    // populada, mappedBy diz qual o nome do atributo que esta na classe ItemPedido
    // aque mapea a Model Pedido
    // o fetch = FetchType.LAZY é marcado para fazer depois quando necessario
    @OneToMany( mappedBy = "pedido", fetch = FetchType.LAZY)
    private List<ItemPedido> itemPedidos;

    public Pedido() {
    }

    public Pedido(Date data) {
        super();
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ItemPedido> getItemPedidos() {
        return itemPedidos;
    }

    public void setItemPedidos(List<ItemPedido> itemPedidos) {
        this.itemPedidos = itemPedidos;
    }

    @Override
    @Transient
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", data=" + data +
                '}';
    }
}
