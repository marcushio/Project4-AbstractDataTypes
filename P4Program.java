
/**
 * @author Marcus Trujillo
 * Assignment number
 * Brief Description of class P4Program here.
 * 
 * CS2050-003
 * @version 
 */

import java.util.*; 
import java.io.*; 

public class P4Program
{   
    Scanner keyboard; 
    /**
     * 
     */
    public P4Program(){
        keyboard = new Scanner(System.in); 
    }
    /**
     * 
     */
    private void menuActions(){
        System.out.println("Please select an option below by it's designated letter"); 
        String menuChoice = keyboard.nextLine(); 
        switch(menuChoice){
            case "a" : 
                       break; 
            case "b" : 
                       break;  
            case "c" : 
                       break; 
            case "d" : 
                       break; 
            case "e" : 
                       break;    
            case "f" : 
                       break; 
            case "g" : 
                       break;           
        }
    }
    
    /**
     * 
     */
    public static void main(String[] args){
        P4Program p4 = new P4Program(); 
        p4.menuActions();
    }
}
