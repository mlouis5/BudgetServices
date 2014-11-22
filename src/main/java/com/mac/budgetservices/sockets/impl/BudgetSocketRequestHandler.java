/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.budgetservices.sockets.impl;

import com.mac.budgetservices.User;
import com.mac.budgetservices.sockets.WebSocketRequestHandler;
import com.mac.servicerequestor.ServiceRequestor;
import com.mac.socketsessionmanager.SocketSessionManager;
import javax.ejb.EJB;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author MacDerson
 */
@ServerEndpoint("/request")
public class BudgetSocketRequestHandler implements WebSocketRequestHandler{

    @EJB(name = "SocketSessionManagerImpl")
    SocketSessionManager sessionManager;
    @EJB
    ServiceRequestor<User> userRequestor;
    
    @Override
    @OnMessage
    public String onMessage(String message) {
        return null;
    }

    @Override
    @OnOpen
    public void connect(Session session) {
        sessionManager.addSession(session);
    }

    @Override
    @OnClose
    public void onClose(Session session) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @OnError
    public void onError(Throwable error) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
