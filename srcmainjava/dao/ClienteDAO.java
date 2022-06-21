package dao;

import dao.generics.GenericDAO;
import domain.Client;

public class ClienteDAO extends GenericDAO<Client> implements IClienteDAO {

    public ClienteDAO() {
        super();
    }

    @Override
    public Class<Client> getTipoClasse() {
        return Client.class;
    }

    @Override
    public void atualiarDados(Client entity, Client entityCadastrado) {

    }

}

