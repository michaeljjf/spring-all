package com.jiangjf.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = "com.jiangjf")
@PropertySource("classpath:test.properties")
public class SpringConfig {
}
