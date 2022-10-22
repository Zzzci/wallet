package com.example.wallet.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.wallet.entity.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {

    @Insert("insert into log (id,user_id,log,create_time) values (null,#{userId},#{log},#{createTime})")
    void insertLog(Log log);

    @Select("select * from log where user_id = 1 ")
    List<Log> selectLog();
}
