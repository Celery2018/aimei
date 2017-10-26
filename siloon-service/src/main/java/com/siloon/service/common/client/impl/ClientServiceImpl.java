package com.siloon.service.common.client.impl;

import com.siloon.dao.client.ClientDao;
import com.siloon.domain.entity.Client;
import com.siloon.service.common.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by peter on 25/10/2017.
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    @Override
    public Client queryById(String clientID) {
        return clientDao.queryById(clientID);
    }

    @Override
    public List<Client> queryAll() {
        return clientDao.queryAll();
    }
}
