
/**
 * @author Marcus Trujillo
 * Assignment number
 * Brief Description of class Loader here.
 * 
 * CS2050-003
 * @version 
 */
import java.io.File; 
import java.util.*; 

public class Loader
{   
    Scanner reader; 
    String filename; 
    
    /**
     * Instantiates the loader with a Scanner to read from a .txt file
     */
    public Loader(String filename){
        this.filename = filename; 
    
    }
    
    
    /**
     * Counts how many words are in the file
     */
    public int count(){
        int count = 0; 
        try(Scanner reader = new Scanner(new File(filename))){
            while(reader.hasNextLine()){
                reader.nextLine();
                count++; 
            }
        } catch(Exception ex){
            System.out.println("Could not read file to count"); 
        }
        return count; 
    }
    
    
     /**
     * Loads up a Java LinkedList<> queue or stack from file of user's choosing.
     */
    public LinkedList loadLinkedList(LinkedList list){
        try(Scanner reader = new Scanner(new File(filename))){
            while(reader.hasNext()){
                list.add(reader.next()); 
            }
        } catch(Exception ex){
            System.out.println("Could not load"); 
        }
        return list; 
    }
    
    
    /**
     * Loads up a Java Stack<> from the file of user's choosing. 
     */
    public Stack loadJavaStack(Stack stack){
        try(Scanner reader = new Scanner(new File(filename))){
            while(reader.hasNext()){
                stack.push(reader.next()); 
            }
        } catch(Exception ex){
            System.out.println("Could not load"); 
        }
        return stack; 
    }
    
    
    /**
     * Loads a Java LinkedList<> stack from the file of user's choosing. 
     */
    public LinkedList loadLinkedStack(LinkedList stack){
        try(Scanner reader = new Scanner(new File(filename))){
            while(reader.hasNext()){
                stack.push(reader.next()); 
            }
        } catch(Exception ex){
            System.out.println("Could not load"); 
        }
        return stack; 
    }
    
    
    /**
     * Loads up a simple linked list stack from file of user's choosing.
     */
    public MyLinkedStack loadMyStack(MyLinkedStack stack){
        try(Scanner reader = new Scanner(new File(filename))){
            while(reader.hasNext()){
                stack.push(reader.next()); 
            }
        } catch(Exception ex){
            System.out.println("Could not load"); 
        }
        return stack; 
    }
    
    
    /**
     * Loads up a simple linked list queue from file of user's choosing.
     */
    public MyLinkedQueue loadMyQueue(MyLinkedQueue queue){
         try(Scanner reader = new Scanner(new File(filename))){
            while(reader.hasNext()){
                queue.enqueue(reader.next()); 
            }
        } catch(Exception ex){
            System.out.println("Could not load"); 
        }
        return queue; 
    }
    
    
    /**
     * Loads up a doubly linked list from file of user's choosing. 
     */
    public MyDoublyLinkedList loadMyDoublyLinkedList(MyDoublyLinkedList doublyLinkedList){
        try(Scanner reader = new Scanner(new File(filename))){
            while(reader.hasNext()){
                doublyLinkedList.add(reader.next()); 
            }
        } catch(Exception ex){
            System.out.println("Could not load"); 
        }
        return doublyLinkedList; 
    }
}
