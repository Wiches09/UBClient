/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.realfinalclient;

/**
 *
 * @author helld
 */
public class UserCollector {

    private String username;
    private String connectID;

    public UserCollector(String username, String connectID) {
        this.username = username;
        this.connectID = connectID;
    }

    public UserCollector() {
        this.username = "";
        this.connectID = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getConnectID() {
        return connectID;
    }

    public void setConnectID(String connectID) {
        this.connectID = connectID;
    }

}
