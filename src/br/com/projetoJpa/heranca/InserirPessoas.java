package br.com.projetoJpa.heranca;

import br.com.projetoJpa.infra.DAO;
import br.com.projetoJpa.modelo.basico.Entidade;
import br.com.projetoJpa.modelo.heranca.Pessoa;
import br.com.projetoJpa.modelo.heranca.PessoaFisica;
import br.com.projetoJpa.modelo.heranca.PessoaJuridica;

public class InserirPessoas {
    public static void main(String[] args) {
        DAO<Entidade> dao = new DAO<>();

        Pessoa pessoa = new Pessoa("José");

        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setCpf("09218303110");
        pessoaFisica.setNome("José CPF");

        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setCnpj("021321320001/6941");
        pessoaJuridica.setNome("José CNPJ");

        dao.abrirTransacao()
                .incluir(pessoa)
                .incluir(pessoaFisica)
                .incluir(pessoaJuridica)
                .fecharTransacao()
                .fechar();


    }
}
