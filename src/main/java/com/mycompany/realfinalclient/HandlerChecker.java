/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.realfinalclient;

import org.json.JSONObject;

/**
 *
 * @author helld
 */
public class HandlerChecker {

    private JSONObject jobj;
    private String handler;
    

    public JSONObject getJobj() {
        return jobj;
    }

    public void setJobj(JSONObject jobj) {
        this.jobj = jobj;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public HandlerChecker(JSONObject jobj, String handler) {
        // client message
        if (!jobj.has("status")) {
            switch (handler) {
                case "auth" -> {

                }
                case "debug" -> {

                }
                case "ready" -> {

                }
                case "hit" -> {

                }
                case "stand" -> {

                }
                default -> {

                }
            }
        } // server message
        else {
            switch (handler) {
                case "CONNECTION_SUCCESS" -> {
                    System.out.println("Connected!");
                }
                case "CONNECTION_AUTHROIZED" -> {
                    System.out.println("User Autherised");
                }
                case "READY_STATE" -> {
                    
                }
                case "NEW_GAME" -> {

                }
                case "INIT_ROUND" -> {

                }
                case "UPDATE_CARDS" -> {

                }
                case "HIT_EVENT" -> {

                }
                case "STAND_EVENT" -> {

                }
                case "SWITCH_TURN" -> {

                }
                case "ROUND_WINNER" -> {

                }
                case "GAME_STOP_DUE_QUITTING" -> {

                }
                default -> {

                }
            }
        }

    }

    public HandlerChecker() {
        this.jobj = null;
        this.handler = "";
    }
}
