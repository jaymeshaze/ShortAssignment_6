/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortassignment_6;

import java.util.ArrayList;

/**
 *
 * @author Kris Hayes
 */
class EventThread extends Thread {
   private Thread t;
   private String threadName;
   private ArrayList list1 = new ArrayList();
   
   EventThread( String name) {
      threadName = name;
      System.out.println("Creating " +  threadName );
   }
   
   public void run() {
      System.out.println("Running " +  threadName );
      //prints out 1 to 4 in 500ms intervals to console
      try {
         for(int i = 4; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", " + i);
            list1.add(i);
            // Let the thread sleep for a while.
            Thread.sleep(500);
         }
      }catch (InterruptedException e) {
         System.out.println("Thread " +  threadName + " interrupted.");
      }
      System.out.println("Thread " +  threadName + " exiting.");
   }
   //standard start method
   public void start () {
      System.out.println("Starting " +  threadName );
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
   
   public ArrayList getList(){
       return list1;
   }
}
