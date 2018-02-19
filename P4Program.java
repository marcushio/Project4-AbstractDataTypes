
/**
 * @author Marcus Trujillo
 * Assignment number 4
 * This assignment deals with implementing the Stack and Queue abstract data types (ADTs). Stack is implemented with the java's LinkedList<> and Stack<> classes,
 * and a simple linked list. Queue is implemented with java's LinkedList<> class and a simple linked list. We also implemented our own DoublyLinkedList. The program 
 * provides the user with the options to a)enter a file they wish to use as input b)fill all the ADTs from the file they entered c)search the ADTs by word d)search
 * the ADTs by index key e)show the timing stats gained from loading and searching f)write the stats to a .txt file and g) lastly, exit the program. Program doesn't accept
 * blank documents. 
 * Implementations for linked list and doubly linked list used code from Sedgewick's algorithms book as permission to use code from the book was given. 
 * 
 * CS2050-003
 * 
 */

import java.util.*; 
import java.io.*; 

public class P4Program
{   
    Scanner keyboard; 
    BufferedWriter writer; 
    Timer timer; 
    Loader loader; 
    
    Stack<String> javaStack; 
    LinkedList<String> javaLinkedStack; 
    MyLinkedStack<String> myStack;
    LinkedList<String> javaLinkedQueue; 
    MyLinkedQueue<String> myQueue;
    DoublyLinkedList<String> doublyLinked; 
    
    String filename;
    public static final String OUTPUT_FILENAME = "P4Output.txt"; 
    String stats; 
    String LS = System.lineSeparator(); 
    
    boolean running; 
    
    /**
     * Instantiate the class with setting the main loop boolean to true and making a new keyboard and timer for the object to use. 
     */
    public P4Program(){
        running = true; 
        keyboard = new Scanner(System.in); 
        timer = new Timer();
        stats = "";
    }
    
    
    /**
     * The main menu for the user to select their options from. Each case in switch dispatches the necessary methods for that option. 
     */
    private void menuActions(){
        System.out.println("Please select an option below by its designated letter (case sensitive)"); 
        System.out.println("[a] - Enter name of file that you will load structures from." + LS + 
                           "[b] - Load all structures from file. " + LS + 
                           "[c] - Search by typing in a word. " + LS + 
                           "[d] - Search by index number." + LS + 
                           "[e] - Show statistics." + LS + 
                           "[f] - Write statistics to a .txt file." + LS + 
                           "[g] - Exit the program." + LS); 
        String menuChoice = takeInput(); 
        switch(menuChoice){
            case "a" : System.out.println("Please input a file name"); 
                       filename = takeInput(); 
                       try(Scanner scanner = new Scanner(new File(filename))){
                           scanner.nextLine(); 
                           loader = new Loader(filename); 
                       }catch(FileNotFoundException ex){
                           System.out.println("That file does not exist or is unreadable, try another."); 
                       }catch(IllegalStateException ex){
                           System.out.println("Could not read doc. Try again"); 
                       }catch(NoSuchElementException ex){
                           System.out.println("File is blank. Invalid");
                           filename = null; 
                       }
                       break; 
            case "b" : loadStructures();
                       break;  
            case "c" : System.out.println("Please enter a term to search for");
                       String searchTerm = takeInput(); 
                       wordSearch(searchTerm); 
                       break;  
            case "d" : System.out.println("Please enter a number key to search by"); 
                       try{
                           int searchKey = Integer.parseInt(takeInput()); 
                           System.out.println(keySearch(searchKey)); 
                       }catch(NumberFormatException ex){ 
                           System.out.println("Only numeric input is allowed here"); 
                       }
                       break; 
            case "e" : if(stats == null){
                            System.out.println("No data has been collected yet"); 
                       } else System.out.println(stats); 
                       break;    
            case "f" : try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File(OUTPUT_FILENAME), true))){
                            writer.write(stats);    
                       } catch(Exception ex){
                           System.out.println("Error: couldn't print to file"); 
                       }
                       System.out.println("Written to file" + OUTPUT_FILENAME + LS); 
                       break; 
            case "g" : System.out.println("Wasn't this a great program? Goodbye."); 
                       running = false; 
                       keyboard.close(); 
                       System.exit(0); 
                       break;     
            default: System.out.println("Invalid input."); 
        }
    }
    
    
    /**
     * Get's input from what the user typed
     * @return userInput - the string the user typed. 
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
     * Searches the Java LinkedList<> Stack, Java LinkedList<> Queue, and DoublyLinked List for a word
     */
    private String wordSearch(String searchTerm){
        String result = "no results made"; 
        try{
          if(javaLinkedStack.indexOf(searchTerm) < 0){
             return "Error: Word not present";
          } else{
           timer.start(); 
           System.out.println(searchTerm + " found at: " + javaLinkedStack.indexOf(searchTerm) + " in Stack" + LS); 
           timer.stop(); 
           result = "Search for "+ searchTerm + " in Stack took :        " + timer.reportTimes() + LS;
           
           timer.start(); 
           System.out.println(searchTerm + " found at: " + javaLinkedQueue.indexOf(searchTerm) + " in Queue " + LS); 
           timer.stop(); 
           result += "Search for "+ searchTerm + " in Queue took :        " + timer.reportTimes() + LS;
           
           timer.start(); 
           System.out.println(searchTerm + " found at: " + doublyLinked.indexOf(searchTerm) + " in Doubly Linked" + LS);                      
           timer.stop(); 
           result += "Search for "+ searchTerm + " in Doubly linked took : " + timer.reportTimes() + LS;
           stats += result; 
          }
        } catch(Exception ex){
           System.out.println("Error term not found. "); 
        }
        return result; 
    }
    
    
    /**
     * Loads all the structures with the data from the input file. If a data file hasn't been loaded we tell the user this is the case. 
     */
    private void loadStructures(){
        if(filename != null){
            System.out.println("Loading from " + filename + LS);
            int count = loader.count();
            stats += "There are " + count + " words in the list." + LS; 
                            
            javaStack = new Stack<String>(); 
            timer.start(); 
            javaStack = loader.loadJavaStack(javaStack); 
            timer.stop(); 
            stats += "Stack - Stack<> class:       " + timer.reportTimes() + LS; 
                            
            javaLinkedStack = new LinkedList<String>(); 
            timer.start(); 
            javaLinkedStack = loader.loadLinkedStack(javaLinkedStack); 
            timer.stop(); 
            stats += "Stack - LinkedList<>:        " + timer.reportTimes() + LS; 
                            
            myStack = new MyLinkedStack<String>(); 
            timer.start(); 
            myStack = loader.loadMyStack(myStack); 
            timer.stop(); 
            stats += "Stack - simple linked list:  " + timer.reportTimes() + LS; 
                            
            javaLinkedQueue = new LinkedList<String>(); 
            timer.start(); 
            javaLinkedQueue = loader.loadLinkedQueue(javaLinkedQueue); 
            timer.stop(); 
            stats += "Queue - LinkedList<>:        " + timer.reportTimes() + LS; 
                            
            myQueue = new MyLinkedQueue<String>(); 
            timer.start(); 
            myQueue = loader.loadMyQueue(myQueue); 
            timer.stop(); 
            stats += "Queue - simple linked list:  " + timer.reportTimes() + LS; 
                            
            doublyLinked = new DoublyLinkedList<String>(); 
            timer.start();
            doublyLinked = loader.loadMyDoublyLinkedList(doublyLinked); 
            timer.stop(); 
            stats += "Doubly linked list:          " + timer.reportTimes() + LS;                
        } else System.out.println("A valid filename hasn't been entered.");
    }
    
    
    /**
     * Search for a word at the key entered by the user. Stats are taken on the search and the result is printed. 
     */
    private String keySearch(int searchKey){
        String result = "";
        try{
            timer.start();
            String stackResult = javaLinkedStack.get(searchKey);
            timer.stop();
            result = "Stack:  " + stackResult + " found at " + searchKey + " in : " + timer.reportTimes()+ LS;
                           
            timer.start(); 
            String queueResult = javaLinkedQueue.get(searchKey);
            timer.stop(); 
            result +="Queue:  " + queueResult + " found at " + searchKey + " in : " + timer.reportTimes()+ LS;
                           
            timer.start(); 
            String doublyResult = doublyLinked.get(searchKey); 
            timer.stop();
            result +=  "Doubly: " + doublyResult + " found at " + searchKey + " in : " + timer.reportTimes() + LS;    
                           
            stats += result; 
        }catch(Exception ex){
            System.out.println("Error: key does not exist (either because it's not in the structure or you haven't loaded a structure)"); 
        }  
        return result;
    }
    
    
    /**
     * The main method. Simply calls the menu while running is true. 
     */
    public static void main(String[] args){
        P4Program p4 = new P4Program(); 
        do{
            p4.menuActions();
        }while(p4.running);
    }
}
