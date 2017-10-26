package com.bizconf.service.common.client.impl;

import com.bizconf.dao.client.ClientDao;
import com.bizconf.domain.entity.Client;
import com.bizconf.service.common.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
