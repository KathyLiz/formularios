package com.mycompany.dataconverter;

import com.example.util.Convertidor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.net.ServerSocket;
import java.net.Socket;

public class RequestHandler implements Runnable {
  private final Socket client;
  ServerSocket serverSocket = null;
  Convertidor converter = new Convertidor();

    public RequestHandler(Socket client) {
      this.client = client;
    }

    @Override
    public void run() {
	try (
	       BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
	       BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));) {
	         System.out.println("Thread started with name:" + Thread.currentThread().getName());
	         String userInput;

	    while ((userInput = in.readLine()) != null) {
	      //
              userInput=userInput.replaceAll("[^A-Za-z0-9 íóúéá{}\":,]", "");
              System.out.println("Received message from " + Thread.currentThread().getName() + " : " + userInput);
              try{
                  converter.convertirJson(userInput);
              }catch(Exception e){
                  System.out.println("Excepcion" + e);
              }
              
	      writer.write("You entered from service: " + userInput);
	      writer.newLine();
	      writer.flush();
	    }
	} catch (IOException e) {
	    System.out.println("I/O exception: " + e);
	  } catch (Exception ex) {
	    System.out.println("Exceprion in Thread Run. Exception : " + ex);
	  }
    }

}