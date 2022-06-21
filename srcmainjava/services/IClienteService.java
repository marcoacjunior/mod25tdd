package services;

import domain.Client;
import exceptions.TipoChaveNaoEncontradaException;

public interface IClienteService {

    Boolean cadastrar(Client cliente) throws TipoChaveNaoEncontradaException;

    Client consultar (Long cpf);

    void excluir(Long cpf);

    void alterar(Client cliente) throws TipoChaveNaoEncontradaException;

}
