/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.dataconverter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author oracle
 */
public class EchoServer {

 public static void main(String[] args) throws IOException {
    System.out.println("Start of main");
    if (args.length < 1) {
      System.err.println("Usage: java EchoServer <port number>");
      System.exit(1);
    }
    int portNumber = Integer.parseInt(args[0]);
    ExecutorService executor = null;
    try (ServerSocket serverSocket = new ServerSocket(portNumber);) {
      executor = Executors.newFixedThreadPool(5);
      System.out.println("Waiting for clients in port "+portNumber);
      while (true) {
        Socket clientSocket = serverSocket.accept();
        Runnable worker = (Runnable) new RequestHandler(clientSocket);
        executor.execute(worker);
      }
    }catch (IOException e) {
       System.out.println("Exception caught when trying to listen on port "
	+ portNumber + " or listening for a connection");
       System.out.println(e.getMessage());
    } finally {
        if (executor != null) {
	executor.shutdown();
	}
    }
  }
    
}
