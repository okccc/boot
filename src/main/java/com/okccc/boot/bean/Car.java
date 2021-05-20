package com.okccc.boot.bean;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Author: okccc
 * Date: 2021/5/18 下午3:31
 * Desc: 
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@ConfigurationProperties(prefix = "mycar")
public class Car {
    private String brand;
    private Integer price;
}
