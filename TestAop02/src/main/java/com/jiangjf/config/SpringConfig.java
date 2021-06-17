package com.jiangjf.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration// 配置类注解
@ComponentScan("com.jiangjf")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfig {

}
