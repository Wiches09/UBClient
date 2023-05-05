/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.realfinalclient;

import org.json.JSONObject;

// receive from both server and client
public class MessageReceiver extends RealFinalClient {

    private static JSONObject jobj;
    private JSONObject n_content;
    private String content;
    private HandlerChecker checker;
    private Object check;
    private MessageSender send;
    private static String handler;

    public MessageReceiver(String message) throws Exception {
        jobj = new JSONObject(message);
        n_content = null; // to use if contenobj = new JSONObject(message);t is a object
        System.out.println("JSON Object: " + jobj); //messsage checker

        String status = jobj.getString("status");

        if (status.equals("OK")) {
            handler = jobj.getString("handler");
            if (jobj.has("content")) { // good message from server
                check = jobj.get("content");
                if (check instanceof JSONObject) {
                    System.out.println("c_Obj");
                    n_content = jobj.getJSONObject("content");
                    System.out.println("new content: " + n_content);
                } else {
                    content = jobj.getString("content");
                    System.out.println("content: " + content);
                }
                
                HandlerChecker.check(jobj, handler);
                
                
            }
        } else { //error message from server
            System.out.println("e_Obj");
            n_content = jobj.getJSONObject("error");
            System.out.println("new content: " + n_content);
            System.out.println("Status: " + jobj.getString("status"));
            System.out.println("Error: " + n_content.getString("error"));
            System.out.println("Description: " + n_content.getString("description"));
        }
    }

}
