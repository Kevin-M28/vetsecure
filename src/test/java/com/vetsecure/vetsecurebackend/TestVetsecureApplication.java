package com.vetsecure.vetsecurebackend;

import org.springframework.boot.SpringApplication;

public class TestVetsecureApplication {

    public static void main(String[] args) {
        SpringApplication.from(VetsecureApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
