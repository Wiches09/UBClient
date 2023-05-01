/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.realfinalclient;

/**
 *
 * @author helld
 */
public class HandlerMethod {
    private UserCollector player;
    
    public void setPlayerConID(String username, String connectID){
        player = new UserCollector(username, connectID);
        player.toString();
    }


}
