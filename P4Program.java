
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
    
    Stack javaStack; 
    LinkedList javaLinkedStack; 
    MyLinkedStack myStack;
    LinkedList javaLinkedQueue; 
    MyLinkedQueue myQueue;
    MyDoublyLinkedList doublyLinked; 
    
    
    String filename;
    String stats; 
    String LS = System.lineSeparator(); 
    
    boolean running; 
    
    /**
     * 
     */
    public P4Program(){
        running = true; 
        keyboard = new Scanner(System.in); 
        timer = new Timer(); 
        
        
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
                       loader = new Loader(filename); 
                       break; 
            case "b" : if(filename != null){
                            System.out.println("Loading from " + filename + LS);
                            int count = loader.count();
                            stats = "There are " + count + "words in the list." + LS; 
                            
                            javaStack = new Stack(); 
                            timer.start(); 
                            javaStack = loader.loadJavaStack(javaStack); 
                            timer.stop(); 
                            stats += "Stack - Stack<> class:       " + timer.reportTimes() + LS; 
                            
                            javaLinkedStack = new LinkedList(); 
                            timer.start(); 
                            javaLinkedStack = loader.loadLinkedList(javaLinkedStack); 
                            timer.stop(); 
                            stats += "Stack - LinkedList<>:        " + timer.reportTimes() + LS; 
                            
                            myStack = new MyLinkedStack(); 
                            timer.start(); 
                            myStack = loader.loadMyStack(myStack); 
                            timer.stop(); 
                            stats += "Stack - simple linked list:  " + timer.reportTimes() + LS; 
                            
                            javaLinkedQueue = new LinkedList(); 
                            timer.start(); 
                            javaLinkedQueue = loader.loadLinkedList(javaLinkedQueue); 
                            timer.stop(); 
                            stats += "Queue - LinkedList<>:        " + timer.reportTimes() + LS; 
                            
                            myQueue = new MyLinkedQueue(); 
                            timer.start(); 
                            myQueue = loader.loadMyQueue(myQueue); 
                            timer.stop(); 
                            stats += "Queue - simple linked list: " + timer.reportTimes() + LS; 
                            
                            doublyLinked = new MyDoublyLinkedList(); 
                            timer.start();
                            doublyLinked = loader.loadMyDoublyLinkedList(doublyLinked); 
                            timer.stop(); 
                            stats += "Doubly list:                " + timer.reportTimes() + LS;  
                            
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
        String userInput = null; 
        try{
            userInput = keyboard.nextLine(); 
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
        while(p4.running){
            p4.menuActions();
        }
    }
}
