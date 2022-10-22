package com.example.wallet.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface UserMapper {

    @Select("select money from user where id=1")
    Double findMoney();

    @Update("update user set money=#{v} where id = 1")
    void updateMoney(Double v);
}
