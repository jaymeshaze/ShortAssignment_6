
package shortassignment_6;

import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Kris Hayes
 */
class LogThread extends Thread {
   private Thread t;
   private String threadName;
   private EventThread event1;
   
   //creates a new log thread that includes the event thread to log
   LogThread(String name, EventThread eventThread) {
      threadName = name;
      event1 = eventThread;
      System.out.println("Creating " +  threadName );
   }
   
   public void run() {
      System.out.println("Running " +  threadName );
      try {
        while(event1.isAlive()){

            Thread.sleep(500);

            //writes current arraylist from event thread to file
            PrintWriter writer = new PrintWriter("log.txt");
            for(int i = 0; i<event1.getList().size();i++){
                writer.print(event1.getList().get(i)+ "\n");
            }
            writer.close();
        }
      }catch (InterruptedException|IOException e) {
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
}
