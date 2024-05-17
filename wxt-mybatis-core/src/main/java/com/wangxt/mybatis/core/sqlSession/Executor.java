package com.wangxt.mybatis.core.sqlSession;

import com.wangxt.mybatis.core.pojo.Configuration;
import com.wangxt.mybatis.core.pojo.MappedStatement;

import java.util.List;

public interface Executor {

    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws Exception;

}
