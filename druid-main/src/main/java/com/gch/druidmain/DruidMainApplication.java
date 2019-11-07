package com.gch.druidmain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = {"com.gch.druidmain", "com.gch.druidmodule1", "com.gch.druidmodule2"})
public class DruidMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(DruidMainApplication.class, args);
    }

}
