package com.github.cnproxy;

import com.tomaer.framework.modules.exception.annotation.EnableHandlerException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableHandlerException
public class OJBKApplication {

    public static void main(String[] args) {
        SpringApplication.run(OJBKApplication.class, args);
    }
}
