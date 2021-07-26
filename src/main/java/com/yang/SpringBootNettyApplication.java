package com.yang;

import com.yang.netty.BingoServer;
import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootNettyApplication implements CommandLineRunner {

    @Resource
    private BingoServer bingoServer;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootNettyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        bingoServer.run();
    }

}
