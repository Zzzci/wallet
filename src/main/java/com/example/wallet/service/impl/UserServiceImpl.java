package com.example.wallet.service.impl;

import com.example.wallet.service.UserService;
import com.example.wallet.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年10月20日 18:08
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public Double findMoney() {
        return userMapper.findMoney();
    }

    @Override
    public void updateMoney(double v) {
        userMapper.updateMoney(v);
    }
}
