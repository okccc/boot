package com.okccc.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.okccc.boot.bean.Car;
import com.okccc.boot.bean.Pet;
import com.okccc.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Author: okccc
 * Date: 2021/5/18 下午2:01
 * Desc: 配置类
 */
@Configuration()  // 告诉SpringBoot这是一个配置类,用于替代xml配置文件
@Import({User.class, DBHelper.class})
@EnableConfigurationProperties(Car.class)  // 将组件自动注册到容器中
public class MyConfig {
    /*
     * 1.配置类在方法上使用@Bean注解给容器注册组件,默认是单实例的,配置类本身也是组件
     * 2.proxyBeanMethods是代理bean的方法
     * Full模式(proxyBeanMethods = true) 每个@Bean方法被调用多少次返回的组件都是单实例的,SpringBoot总会检查这个组件是否在容器中有
     * Lite模式(proxyBeanMethods = false)每个@Bean方法被调用多少次返回的组件都是新创建的
     * 配置类的组件相互之间有依赖关系就使用Full模式(默认),没有依赖关系就使用Lite模式可以减少判断加速容器启动
     * 3.@Import({User.class, DBHelper.class})给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名
     * 4.@ImportResource("classpath:beans.xml")导入Spring的配置文件
     */

    @Bean  // 给容器添加组件,方法名就是组件id,返回类型就是组件类型,返回值就是组件在容器中的实例
    public User user() {
        User user = new User("grubby", 19);
        // User组件依赖Pet组件,所以代理bean的方法必须是Full模式
        user.setPet(pet());
        return user;
    }

    @Bean
    public Pet pet() {
        return new Pet("tom", 10.0);
    }
}
