
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
    BufferedWriter writer; 
    Timer timer; 
    Loader loader; 
    
    String filename;
    String stats; 
    String LS = System.lineSeparator(); 
    
    boolean running; 
    
    /**
     * 
     */
    public P4Program(){
        keyboard = new Scanner(System.in); 
        timer = new Timer(); 
        loader = new Loader(); 
        running = true; 
    }
    /**
     * 
     */
    private void menuActions(){
        System.out.println("Please select an option below by it's designated letter"); 
        System.out.println("[a] - Input name of file that you will load structures from." + LS + 
                           "[b] - Load all structures from file. " + LS + 
                           "[c] - Search by typing in a word. " + LS + 
                           "[d] - Search by index number." + LS + 
                           "[e] - Show statistics of the loading process." + LS + 
                           "[f] - Write statistics to a .txt file." + LS + 
                           "[g] - Exit the program." + LS); 
        String menuChoice = takeInput(); 
        switch(menuChoice){
            case "a" : System.out.println("Please input a file name"); 
                       filename = takeInput(); 
                       break; 
            case "b" : if(filename != null){
                            System.out.println("Loading from " + filename); 
                            timer.start(); 
                            loader.load(); 
                            timer.stop(); 
                            stats += "Load time: " + timer.reportTimes(); 
                       } else System.out.println("You haven't entered a filename");
                       break;  
            case "c" : System.out.println("search by word");
                       break; 
            case "d" : System.out.println("search by key"); 
                       break; 
            case "e" : if(stats.equals(null)){
                            System.out.println("Nothing has been loaded yet"); 
                       } else System.out.println(stats); 
                       break;    
            case "f" : System.out.println("write to file"); 
                       break; 
            case "g" : System.out.println("Wasn't this a great program? Goodbye."); 
                       running = false; 
                       System.exit(0); 
                       break;           
        }
    }
    
    
    /**
     * Get's input from what the user typed
     */
    private String takeInput(){
        String userInput = ""; 
        try{
            keyboard.nextLine(); 
        } catch(Exception ex){
            System.out.println("Input error - try again"); 
        }
        return userInput; 
    }
    
    
    /**
     * 
     */
    public static void main(String[] args){
        P4Program p4 = new P4Program(); 
        p4.menuActions();
    }
}
