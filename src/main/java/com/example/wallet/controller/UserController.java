package com.example.wallet.controller;

import com.example.wallet.service.LogService;
import com.example.wallet.service.UserService;
import com.example.wallet.util.Result;
import com.example.wallet.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年10月20日 17:55
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LogService logService;


    @PostMapping("/login")
    public void login(){
//        userService.log();
    }

    /**
     * 没有写登录接口,这里默认对“张三”用户进行操作
     */

    /**
     * 查询用户剩余钱包余额
     */
    @GetMapping("/findMoney")
    public Result findMoney(){
        Double money = userService.findMoney();
        return Result.ok(money);
    }



    /**
     * 用户消费100元
     */
    @PostMapping("/consume")
    public Result consume(){
        Double money = userService.findMoney();

        if ((money-100)<0){
            return Result.error("用户余额不足100，请充值");
        }
        Log log = new Log();
        log.setLog("消费100元");
        log.setUserId("1");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        log.setCreateTime(simpleDateFormat.format(new Date()));
        //新增记录
        logService.insertLog(log);
        //更新账户余额
        userService.updateMoney(money-100);
        return Result.ok("消费成功");
    }

    /**
     * 退回20元
     */
    @PostMapping("/refund")
    public Result refund(){
        Double money = userService.findMoney();

        Log log = new Log();
        log.setLog("退款20元");
        log.setUserId("1");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        log.setCreateTime(simpleDateFormat.format(new Date()));
        //新增记录
        logService.insertLog(log);
        //更新账户余额
        userService.updateMoney(money+20);
        return Result.ok("退款成功");
    }

    /**
     * 查询用户钱包金额变动明细
     * @return
     */
    @GetMapping("/selectLog")
    public Result selectLog(){
        List<Log> logList = logService.selectLog();
        System.out.println(logList);
        return Result.ok(logList);
    }
}
