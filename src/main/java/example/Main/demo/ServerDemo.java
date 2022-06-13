package example.Main.demo;

import example.Main.ServerApiService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class ServerDemo {
    public static void main(String[] args) {


        Server server = ServerBuilder.forPort(9090).addService(new ServerApiService()).build();
        try {
            server.start();
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
