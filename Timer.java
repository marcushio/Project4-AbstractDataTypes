
/**
 * @author Marcus Trujillo
 * Assignment number
 * Brief Description of class Timer here.
 * 
 * CS2050-003
 * @version 
 */
import java.text.DecimalFormat; 

public class Timer
{
    DecimalFormat formatter; 
    double startCPUTime; 
    double startClockTime; 
    double endCPUTime; 
    double endClockTime; 
    /**
     * 
     */
    public void start(){
        startCPUTime = System.nanoTime(); 
        startClockTime = System.currentTimeMillis(); 
        
    }
    
    
    /**
     * 
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
        DecimalFormat formatter = new DecimalFormat("0.0000");
        String results = formatter.format((endCPUTime - startCPUTime)/1000000000) + "seconds CPU time    " + 
                         formatter.format((endClockTime - startClockTime)/1000) + "seconds clock time"; 
        return results; 
    }
        
    
}
