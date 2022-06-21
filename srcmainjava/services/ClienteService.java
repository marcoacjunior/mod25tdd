package services;

import dao.IClienteDAO;
import domain.Client;
import exceptions.TipoChaveNaoEncontradaException;

public class ClienteService implements IClienteService{

    private IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }


    @Override
    public Boolean cadastrar(Client cliente) throws TipoChaveNaoEncontradaException {
        return clienteDAO.cadastrar(cliente);

    }

    @Override
    public Client consultar(Long cpf) {

        return clienteDAO.consultar(cpf);
    }

    @Override
    public void excluir(Long cpf) {
        clienteDAO.excluir(cpf);
    }

    @Override
    public void alterar(Client cliente) throws TipoChaveNaoEncontradaException {
        clienteDAO.alterar(cliente);
    }
}

