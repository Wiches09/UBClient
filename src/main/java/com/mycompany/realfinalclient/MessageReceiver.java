/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.realfinalclient;

import org.json.JSONObject;

// receive from both server and client
public class MessageReceiver {

    private JSONObject jobj;
    private JSONObject n_content;
    private String content;
    private HandlerChecker checker;
    private Object check;

    public MessageReceiver(String message) {
        jobj = new JSONObject(message);
        n_content = null; // to use if content is a object

        System.out.println("JSON Object: " + jobj); //messsage checker

        String handler = jobj.getString("handler");
        String status = jobj.getString("status");

        if (!jobj.has("status")) { // message from client
            new HandlerChecker(jobj, handler);
        } 
        else if (status.equals("OK")) {
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
            }
            
            new HandlerChecker(jobj, handler);
        }
        else { //error message from server
            System.out.println("else");
        }
    }

}
