package com.gch.main.initMethod;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * APP启动时自动执行
 * Created by Administrator on 2018/1/15.
 */
@Component
@Order(value = 1)
public class DbTypeApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println("APP Start");
    }

}
