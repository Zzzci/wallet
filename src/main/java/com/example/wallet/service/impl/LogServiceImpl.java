package com.example.wallet.service.impl;

import com.example.wallet.service.LogService;
import com.example.wallet.entity.Log;
import com.example.wallet.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年10月22日 11:07
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public void insertLog(Log log) {
        logMapper.insertLog(log);
    }

    @Override
    public List<Log> selectLog() {
        return logMapper.selectLog();
    }
}
