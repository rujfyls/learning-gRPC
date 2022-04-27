package ru.feduncov;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        Server server = ServerBuilder.forPort(8080).addService(new GreetingServiceImpl()).build();
        try {
            server.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Server started!");

        try {
            server.awaitTermination();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
