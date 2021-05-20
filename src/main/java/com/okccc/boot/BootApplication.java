package com.okccc.boot;

import com.okccc.boot.bean.Pet;
import com.okccc.boot.bean.User;
import com.okccc.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication  // 告诉SpringBoot这是一个SpringBoot应用
public class BootApplication {

    public static void main(String[] args) {
        /*
         * SpringBoot是整合并简化Spring技术栈的一站式框架
         * Create stand-alone Spring applications  // 快速创建独立的Spring应用
         * Embed Tomcat, Jetty or Undertow directly (no need to deploy WAR files)  // 内嵌web服务器
         * Provide opinionated 'starter' dependencies to simplify your build configuration  // starter依赖简化构建配置
         * Automatically configure Spring and 3rd party libraries whenever possible  // 自动配置Spring以及第三方功能
         * Provide production-ready features such as metrics, health checks, and externalized configuration  // 提供生产级别的监控、健康检查及外部化配置
         * Absolutely no code generation and no requirement for XML configuration  // 无需代码生成,无需编写xml配置文件
         *
         * SpringBoot特点
         * 1.依赖管理
         * spring-boot-starter-paren的父项目spring-boot-dependencies声明了所有开发中常用依赖的版本号,也可以自己设置properties覆盖
         * spring-boot-starter-*场景启动器会导入该场景所需要的所有依赖
         * *-spring-boot-starter会导入第三方提供的简化开发的场景启动器
         * spring-boot-starter是所有场景启动器最底层的依赖
         * 2.自动配置
         * spring-boot-dependencies自动配置好Tomcat、SpringMVC全套组件、字符编码等web常用功能
         * 主程序所在包及其所有子包都会被默认扫描进来,可以指定@SpringBootApplication(scanBasePackages="com.okccc")改变包扫描路径
         */

        // 1.返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(BootApplication.class, args);
        // 2.查看容器自带的所有组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        // 3.从容器获取组件
        Pet pet01 = run.getBean("pet", Pet.class);
        Pet pet02 = run.getBean("pet", Pet.class);
        System.out.println(pet01 == pet02);
        // 4.配置类本身也是组件
        MyConfig myConfig = run.getBean(MyConfig.class);
        System.out.println(myConfig);
        User user01 = myConfig.user();
        User user02 = myConfig.user();
        System.out.println(user01 == user02);
        System.out.println(user01.getPet() == pet01);
    }

}
