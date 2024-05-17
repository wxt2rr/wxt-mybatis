package com.wangxt.mybatis.core.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangxt
 * @description 存放 链接mysql 配置信息
 * @date 2022/2/8 10:11
 **/
@Getter
@Setter
public class Configuration {
    // 数据源对象
    private DataSource dataSource;

    // key: statementId  value:封装好的mappedStatement对象
    Map<String,MappedStatement> mappedStatementMap = new HashMap<>();
}
