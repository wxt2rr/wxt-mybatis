package com.wangxt.mybatis.core.pojo;

import com.wangxt.mybatis.core.utils.ParameterMapping;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangxt
 * @description 存放解析之后的sql数据
 * @date 2022/2/7 18:13
 **/
@Getter
@Setter
public class BoundSql {

    private String sqlText; //解析过后的sql

    private List<ParameterMapping> parameterMappingList = new ArrayList<>();

    public BoundSql(String sqlText, List<ParameterMapping> parameterMappingList) {
        this.sqlText = sqlText;
        this.parameterMappingList = parameterMappingList;
    }
}
