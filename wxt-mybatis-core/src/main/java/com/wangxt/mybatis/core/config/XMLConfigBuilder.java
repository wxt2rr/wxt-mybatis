package com.wangxt.mybatis.core.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wangxt.mybatis.core.io.Resources;
import com.wangxt.mybatis.core.pojo.Configuration;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.beans.PropertyVetoException;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * @author wangxt
 * @description 解析 Config 配置文件,封装实体对象
 * @date 2022/2/7 18:14
 **/
public class XMLConfigBuilder {

    private static final String ROOT = "src" + File.separator + "main" + File.separator + "resources" + File.separator;

    // 配置文件对象
    private Configuration configuration;

    public XMLConfigBuilder() {
        this.configuration = new Configuration();
    }

    /**
     * @author wangxt
     * @description 该方法就是使用dom4j对配置文件进行解析，封装Configuration
     * @date 2022/2/7 18:15
     **/
    public Configuration parseConfig(InputStream inputStream) throws DocumentException, PropertyVetoException {
        Document document = new SAXReader().read(inputStream);
        //<configuration>
        Element rootElement = document.getRootElement();
        List<Element> list = rootElement.selectNodes("//property");
        Properties properties = new Properties();
        for (Element element : list) {
            String name = element.attributeValue("name");
            String value = element.attributeValue("value");
            properties.setProperty(name, value);
        }

        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(properties.getProperty("driverClass"));
        comboPooledDataSource.setJdbcUrl(properties.getProperty("jdbcUrl"));
        comboPooledDataSource.setUser(properties.getProperty("username"));
        comboPooledDataSource.setPassword(properties.getProperty("password"));

        configuration.setDataSource(comboPooledDataSource);

        //mapper.xml解析: 拿到路径--字节输入流---dom4j进行解析
        List<Element> mapperList = rootElement.selectNodes("//mapper");

        for (Element element : mapperList) {
            // 这里是 包路径
            String mapperPath = element.attributeValue("resource");
            // 获取包下的所有mapper文件
            File file = new File(mapperPath);
            File[] files = file.listFiles();
            for (File f : files) {
                String name = f.getName();
                if (StringUtils.isNotBlank(name) && name.endsWith("Mapper.xml")) {
                    String path = f.getPath();
                    InputStream resourceAsSteam = Resources.getResourceAsSteam(path.replace(ROOT, ""));
                    XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(configuration);
                    xmlMapperBuilder.parse(resourceAsSteam);
                }
            }
        }

        return configuration;
    }


}
