/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.worldwidewhat.server;

import dk.worldwidewhat.server.net.NetworkInterface;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lh
 */
public class Server {
    private final int _serverPort = 8090;
    private NetworkInterface _networkInterface;
    
    
    public Server(){
        
    }
    
    public void init(){
        try{
            _networkInterface = new NetworkInterface(_serverPort);
            
        } catch (Exception ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);            
        }                
    }
    
    public void start(){
        if(_networkInterface == null) return;
        if(_networkInterface.isRunning()) return;
        try {
            _networkInterface.start();
        } catch (Exception ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public static void main(String args[]) {
        Server server = new Server();
        server.init();
        server.start();
    }
   
}