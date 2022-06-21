package test;

import dao.ClienteDaoMock;
import dao.IClienteDAO;
import domain.Client;
import exceptions.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTest {

    private IClienteDAO clienteDAO;

    private Client cliente;

    public ClienteDAOTest() {
        clienteDAO = new ClienteDaoMock();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Client();
        cliente.setCpf(123456L);
        cliente.setNome("Casa de Tintas");
        cliente.setCidade("Belo Horizonte");
        cliente.setEnd("Rua YYYYY");
        cliente.setEstado("MG");
        cliente.setNumero(15);
        cliente.setTel(3433333434L);
        clienteDAO.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente(){

        Client clienteConsultado = clienteDAO.consultar(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);

    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteDAO.cadastrar(cliente);
        Assert.assertTrue(retorno);

    }

    @Test
    public void excluirCliente () {
        clienteDAO.excluir(cliente.getCpf());

    }
    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Novo Cliente");
        clienteDAO.alterar(cliente);

        Assert.assertEquals("Novo Cliente", cliente.getNome());
    }


}
