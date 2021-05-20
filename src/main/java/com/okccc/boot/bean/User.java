package com.okccc.boot.bean;

import lombok.*;

/**
 * Author: okccc
 * Date: 2021/5/18 下午3:26
 * Desc:
 */

@Data  // lombok可以简化JavaBean开发,会自动实现属性的get&set方法,可通过Structure查看
@NoArgsConstructor  // 无参构造器
@AllArgsConstructor  // 全参构造器,如果不需要全部参数可以手动指定参数实现
@ToString  // toString方法
@EqualsAndHashCode  // equals和hashCode方法
public class User {
    private String name;
    private Integer age;

    private Pet pet;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
