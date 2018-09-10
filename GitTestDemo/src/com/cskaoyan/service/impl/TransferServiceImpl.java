package com.cskaoyan.service.impl;

import com.production.bean.Account;
import com.production.dao.AccountDao;
import com.production.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class TransferServiceImpl implements TransferService {
    @Autowired
    AccountDao accountDao;
    @Override
    @Transactional
    public boolean transfer(String from, String to, String money) throws SQLException {
        boolean flag=false;
        Account accountInfo_from = accountDao.getAccountInfo(from);
        Account accountInfo_to = accountDao.getAccountInfo(to);
        float fromMoney = Float.valueOf(accountInfo_from.getMoney()) - Float.valueOf(money);
        float toMoney = Float.valueOf(accountInfo_to.getMoney()) + Float.valueOf(money);
        //开始转账
        System.out.println("开始转账");
        accountDao.updateAccount(new Account(accountInfo_from.getId(),accountInfo_from.getName(),String.valueOf(fromMoney)));
        //int i=1/0;
        accountDao.updateAccount(new Account(accountInfo_to.getId(),accountInfo_to.getName(),String.valueOf(toMoney)));
        System.out.println("转账结束");
        flag=true;
        return flag;
    }

    @Override
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao=accountDao;
    }
}
