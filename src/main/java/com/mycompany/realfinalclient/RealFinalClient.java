package com.mycompany.realfinalclient;

import jakarta.websocket.*;
import java.net.URI;
import java.util.Scanner;

/**
 *
 * @author helld
 */
@ClientEndpoint
public class RealFinalClient {

    private HandlerMethod meth;

    public static void main(String[] args) throws Exception {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        Session session = container.connectToServer(RealFinalClient.class, new URI("ws://localhost:6000"));
        System.out.println("Connected(?)");
        UserCollector player = new UserCollector();

        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
    }

    @OnOpen
    public void onOpen(Session session) throws Exception {
        System.out.println("Connected? Maybe.");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username.");
        String username = sc.nextLine();
        String message = "{\"handler\":\"auth\",\"username\":\"" + username + "\"}";
        session.getBasicRemote().sendText(message); // send message to server

//        new MessageSender();
    }

    @OnMessage
    public void onMessage(String message) throws Exception {
        new MessageReceiver(message);
    }

}
