package dao;

import domain.Client;
import exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;

public class ClienteDaoMock implements IClienteDAO{

    @Override
    public Boolean cadastrar(Client entity) {
        return true;
    }

    @Override
    public void excluir(Long valor) {

    }

    @Override
    public void alterar(Client entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public Client consultar(Long valor) {
        Client cliente = new Client();
        cliente.getCpf();
        return cliente;
    }

    @Override
    public Collection<Client> buscarTodos() {
        return null;
    }
}

