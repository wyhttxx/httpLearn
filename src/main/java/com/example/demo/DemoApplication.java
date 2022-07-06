package com.example.demo;

//@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws InterruptedException {
//        SpringApplication.run(DemoApplication.class, args);
        HttpServer httpServer = new HttpServer(8081);
        httpServer.start();
    }

}
