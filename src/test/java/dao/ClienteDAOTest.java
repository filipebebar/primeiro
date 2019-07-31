package dao;

import br.com.imobisoftware.dao.ClienteDAO;
import br.com.imobisoftware.dao.PessoaDAO;
import br.com.imobisoftware.domain.Cliente;
import br.com.imobisoftware.domain.Pessoa;
import org.junit.Ignore;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
* Project Name: ImobiSoftware
* User: Filipe Barbosa
* Date: 29/07/2019
*/
public class ClienteDAOTest {

    @Test
    public void salvar() throws ParseException {
        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa pessoa = pessoaDAO.buscar(2L);

        Cliente cliente = new Cliente();
        cliente.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2015"));
        cliente.setLiberado(false);
        cliente.setPessoa(pessoa);

        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.salvar(cliente);

        System.out.println("Cliente salvo com sucesso.");
    }
}
