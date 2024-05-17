package com.wangxt.mybatis.core.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wangxt
 * @description 存放每个mapper中的sql信息
 * @date 2022/2/8 10:11
 **/
@Getter
@Setter
public class MappedStatement {
    //id标识
    private String id;
    //返回值类型
    private String resultType;
    //参数值类型
    private String paramType;
    //sql语句
    private String sql;
}
