/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortassignment_6;

/**
 *
 * @author Kris Hayes
 */
public class ShortAssignment_6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EventThread event1 = new EventThread("event thread - 1");
        
        LogThread log1 = new LogThread("Log Thread - 1", event1);
        
        event1.start();
        log1.start();


        

        
    }
    
}
