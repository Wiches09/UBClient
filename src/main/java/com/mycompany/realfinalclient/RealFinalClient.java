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

    protected static Session session;
    private HandlerMethod meth;
    private MessageSender send;
    private static String aasd;
    protected static String username;

    public Session getSession() {
        return session;
    }

    public static void main(String[] args) throws Exception {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        RealFinalClient.session = container.connectToServer(RealFinalClient.class, new URI("ws://localhost:6000"));
        System.out.println("Connected(?)");
        UserCollector player = new UserCollector();

        Scanner sc = new Scanner(System.in);
        RealFinalClient.username = sc.nextLine();

        while (true) {
            String hi = sc.nextLine();
            if (hi.equals("hit")){
                MessageSender.sendMessage(session, "{\"handler\":\"hit\"}");
            }
            else if (hi.equals("debug")) {
                MessageSender.sendMessage(session, "{\"handler\":\"debug\"}");
            }
            else if (hi.equals("ready")) {
                MessageSender.sendMessage(session, "{\"handler\":\"ready\"}");
            }
            else if (hi.equals("stand")) {
                MessageSender.sendMessage(session, "{\"handler\":\"stand\"}");
            }
            else{
                break;
            }
        }
    }

    public static String getUsername() {
        return username;
    }

    @OnOpen
    public void onOpen(Session session) throws Exception {
        System.out.println("Connected? Maybe.");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username.");
        RealFinalClient.username = sc.nextLine();
        MessageSender.sendMessage(session, "{\"handler\":\"auth\",\"username\":\"" + RealFinalClient.username + "\"}");

//        new MessageSender();
    }

    @OnMessage
    public void onMessage(String message) throws Exception {
        new MessageReceiver(message);
    }
    

}
