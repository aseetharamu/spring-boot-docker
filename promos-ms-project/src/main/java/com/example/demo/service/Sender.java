package com.example.demo.service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Sender {

  private final static String QUEUE_NAME = "hello";
  private static int count = 0;
  
  public static void send() throws Exception {
	  //creates connection to RabbitMQ
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    
    //creates channel - connect to helloQueue
    Channel channel = connection.createChannel();
    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    
    
  //Start sending messages
    String message = "Hello World! " + count++;      
    channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
    System.out.println(" [x] Sent '" + message + "'");
    
   //close the channel - disconnect rabbitmq
    channel.close();
    connection.close();
  }
}
