package com.okccc.boot.bean;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Author: okccc
 * Date: 2021/5/18 下午3:30
 * Desc: 
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Component
@ConfigurationProperties(prefix = "pet")
public class Pet {
    private String name;
    private Double weight;
}
