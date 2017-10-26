package com.bizconf.dao.client;

import com.bizconf.domain.entity.Client;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by peter on 25/10/2017.
 */
@Repository
public interface ClientDao {

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

//    /**
//     * 减少馆藏数量
//     *
//     * @param bookId
//     * @return 如果影响行数等于>1，表示更新的记录行数
//     */
//    int reduceNumber(long bookId);
}
