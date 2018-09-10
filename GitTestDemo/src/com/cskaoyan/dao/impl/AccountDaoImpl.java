package com.cskaoyan.dao.impl;

import com.production.bean.Account;
import com.production.dao.AccountDao;
import com.production.utils.C3P0Utils;
import com.production.utils.TransactionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Override
    public int updateAccount(Account account) throws SQLException {

        QueryRunner queryRunner =new QueryRunner();
        Connection connection = TransactionUtils.getConnection();
        System.out.println("connection = " + connection);
        int update = queryRunner.update(connection,"update account set money=? where id = ?", account.getMoney(),
                account.getId());
        return update;
    }

    @Override
    public Account getAccountInfo(String id) throws SQLException {
        DataSource dataSource = C3P0Utils.getDataSource();
        QueryRunner queryRunner =new QueryRunner(dataSource);

        Account query = queryRunner.query("select * from account where id = ?",new BeanHandler<Account>(Account.class),id);

        return query;
    }
}
