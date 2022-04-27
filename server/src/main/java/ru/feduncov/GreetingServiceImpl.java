package ru.feduncov;

import io.grpc.stub.StreamObserver;
import ru.feduncov.grpc.GreatingService;
import ru.feduncov.grpc.GreetingServiceGrpc;
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(GreatingService.HelloRequest helloRequest,
                         StreamObserver<GreatingService.HelloResponse> responseObserver) {

        System.out.println(helloRequest);

        GreatingService.HelloResponse response = GreatingService.HelloResponse
                .newBuilder().setGreeting("Hello from service " + helloRequest.getName() +
                        ", with hobbies = " + helloRequest.getHobbies(0)).build();

        responseObserver.onNext(response);

        responseObserver.onCompleted();
    }
}
