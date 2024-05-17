package com.wangxt.mybatis.core.demo.dao;

import com.wangxt.mybatis.core.demo.pojo.UserDo;

import java.util.List;

public interface UserDao {

    /**
     * @author wangxt
     * @description 查询所有用户
     * @date 2022/2/8 9:57
     **/
    List<UserDo> queryList();

    /**
     * @author wangxt
     * @description 查询单个用户
     * @date 2022/2/8 9:58
     **/
    UserDo queryUser(UserDo user);
}
