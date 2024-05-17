package com.wangxt.mybatis.core.io;

import java.io.InputStream;

public class Resources {

    /**
     * @author wangxt
     * @description 根据配置文件的路径，将配置文件加载成字节输入流，存储在内存中
     * @date 2022/2/7 0007 18:17
     **/
    public static InputStream getResourceAsSteam(String path){
        return Resources.class.getClassLoader().getResourceAsStream(path);
    }
}
