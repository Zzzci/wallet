package com.example.wallet.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年10月20日 18:00
 */
@Data
public class Log {
    private String id;

    private String userId;

    private String log;

    private String createTime;

}
