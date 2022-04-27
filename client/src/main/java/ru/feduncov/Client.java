package ru.feduncov;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import ru.feduncov.grpc.GreatingService;
import ru.feduncov.grpc.GreetingServiceGrpc;

public class Client {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext().build();

        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);

        GreatingService.HelloRequest request = GreatingService.HelloRequest.newBuilder()
                .setName("alexander").addHobbies("Programming").build();

        GreatingService.HelloResponse response = stub.greeting(request);

        System.out.println(response);

        channel.shutdownNow();
    }
}
