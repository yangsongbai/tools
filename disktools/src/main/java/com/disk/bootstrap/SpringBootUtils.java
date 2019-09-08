package com.disk.bootstrap;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * SpringBootUtils 的主要职责:
 *
 * @ClassName SpringBootUtils
 * @Description: TODO
 * @Author songbai yang
 * @Date 2019/7/23 19:48
 * @Version V1.0
 **/
@Configuration
//@Profile(value = "prod")
@Component("springBootUtils")
public class SpringBootUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    @Override
    public  void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringBootUtils.applicationContext==null)
        SpringBootUtils.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }
    /**
     * 通过class获取Bean.
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 通过name,以及Clazz返回指定的Bean
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }
}
