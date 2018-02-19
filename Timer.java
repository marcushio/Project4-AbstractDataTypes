
/**
 * @author Marcus Trujillo
 * Assignment number 4
 * Used for the timing of operations such as loading structures and searches in the program.
 * 
 * CS2050-003
 * @version 1.1
 */
import java.text.DecimalFormat; 

public class Timer
{
    DecimalFormat formatter; 
    private static final int BILLION = 1000000000;
    private static final int THOUSAND = 1000; 
    double startCPUTime; 
    double startClockTime; 
    double endCPUTime; 
    double endClockTime; 
    
    /**
     * Sets the start time for both CPU and clock. 
     */
    public void start(){
        startCPUTime = System.nanoTime(); 
        startClockTime = System.currentTimeMillis(); 
    }
    
    
    /**
     * Sets stop time for both CPU and clock
     */
    public void stop(){
        endCPUTime = System.nanoTime(); 
        endClockTime = System.currentTimeMillis(); 
    }
    
    
    /**
     * Gives the time elapsed between the last start and stop times. 
     * @return results the times in both CPU and clock times.
     */
    public String reportTimes(){
        DecimalFormat formatter = new DecimalFormat("0.00000000");
        double finalCPUTime = (endCPUTime - startCPUTime)/BILLION; 
        double finalClockTime = (endClockTime - startClockTime)/THOUSAND;
        String results = formatter.format(finalCPUTime) + " seconds CPU time    " + 
                         formatter.format(finalClockTime) + " seconds clock time"; 
        return results; 
    }
}
