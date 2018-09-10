package com.cskaoyan.service;

import com.production.dao.AccountDao;

import java.sql.SQLException;

public interface TransferService {
    public boolean transfer(String from, String to, String money) throws SQLException;
    public void setAccountDao(AccountDao accountDao);
}
