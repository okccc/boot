package com.okccc.boot.bean;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Author: okccc
 * Date: 2021/5/20 上午10:28
 * Desc: 
 */

@Data
@Component
// 会提示Spring Boot Configuration Annotation Processor not configured,在pom添加依赖后Re-run
@ConfigurationProperties(prefix = "person")
public class Person {
    private String userName;
    private Boolean boss;
    private Integer age;
    private Date birth;
    private Pet pet;
    private String[] interests;
    private List<String> animals;
    private Map<String, Object> score;
    private Set<Double> salary;
    private Map<String, List<Pet>> allPets;
}
