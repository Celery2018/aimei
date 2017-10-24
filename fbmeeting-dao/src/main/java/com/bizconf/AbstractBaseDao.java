package com.bizconf;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * User: Byron
 * Date: 2017/2/9
 * Time: 15:13
 */
public class AbstractBaseDao extends SqlMapClientTemplate {

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    @Override
    public int update(String statementName, Object parameterObject) throws DataAccessException {
        Assert.notNull(parameterObject, "updata entity error ,entity can't be null!");
        return super.update(statementName, parameterObject);
    }

    @Override
    public Object insert(String statementName, Object parameterObject) throws DataAccessException {
        Assert.notNull(parameterObject, "insert entity error ,params can't be null!");
        return super.insert(statementName, parameterObject);
    }
}
