package test;

import dao.ClienteDaoMock;
import dao.IClienteDAO;
import domain.Client;
import exceptions.TipoChaveNaoEncontradaException;
import services.ClienteService;
import services.IClienteService;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;


public class ClienteTestTest {

    private IClienteService clienteService;

    private Client cliente;

    public ClienteTestTest(){
        IClienteDAO dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
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
        clienteService.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente() {

        Client clienteConsultado = clienteService.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteService.cadastrar(cliente);
        Assert.assertTrue(retorno);

    }

    @Test
    public void excluirCliente () {
        clienteService.excluir(cliente.getCpf());

    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Novo Cliente");
        clienteService.alterar(cliente);

        Assert.assertEquals("Novo Cliente", cliente.getNome());
    }

}

