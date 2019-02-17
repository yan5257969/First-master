package com.yanwuyu.service;

import com.yanwuyu.mapper.AccountMapper;
import com.yanwuyu.model.Account;
import com.yanwuyu.model.AccountExample;
import com.yanwuyu.redis.dao.RedisDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitServiceImpl {
        @Autowired
    private AccountMapper adao;

        @Autowired
    private RedisDaoImpl rdao;

    public void init(){
        this.oprtAccount();
    }
    private void oprtAccount(){
        //通过MyBatis取出Account的所有数据
        AccountExample accountExample=new AccountExample();
        accountExample.createCriteria().andUseridIsNotNull();
        List<Account> list=adao.selectByExample(accountExample);
        list.forEach(c->rdao.SetHashTable("account",c.getUserid().toString(),c));
    }
}
