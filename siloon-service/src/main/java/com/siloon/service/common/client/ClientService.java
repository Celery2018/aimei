package com.siloon.service.common.client;

import com.siloon.domain.entity.Client;

import java.util.List;

/**
 * Created by peter on 25/10/2017.
 */

public interface ClientService {
    /**
     * 通过ID查询client
     *
     * @param clientID
     * @return
     */
    Client queryById(String clientID);

    /**
     * 查询所有client
     *
     * @return
     */
    List<Client> queryAll();
}
