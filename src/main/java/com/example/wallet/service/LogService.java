package com.example.wallet.service;

import com.example.wallet.entity.Log;

import java.util.List;

public interface LogService{
    void insertLog(Log log);

    List<Log> selectLog();
}
