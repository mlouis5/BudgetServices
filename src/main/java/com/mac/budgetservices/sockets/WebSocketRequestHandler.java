/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.budgetservices.sockets;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

/**
 *
 * @author MacDerson
 */
public interface WebSocketRequestHandler {
    @OnOpen
    public void connect(Session session);//, @PathParam("email") String email

    @OnMessage
    public String onMessage(String message);
    
    @OnClose
    public void onClose(Session session);
    
    @OnError
    public void onError(Throwable error);
}
