package com.bang.test.service1;

import com.bang.test.dao.AccountDao;
import com.bang.test.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class test {

    @Autowired
    private AccountDao accountDao;



    @Transactional
    public void add(){

    }

    @Transactional
    public void sub(){

    }

}
