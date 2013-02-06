package org.kieda.core;
import org.kieda.util.console.Console;
import org.kieda.util.error.InvalidInputException;

/**
 * This is the wrapper for any Core you may want to have in a project.
 * Just extend this class, implement the methods, and then you will have a
 * nicely threaded Core on its own!
 * 
 * 
 * @author kieda
 */
public abstract class AbstractCore implements Runnable{

    //the initialization of the core/what should be running initially.
    {
        System.setProperty("project_name", projectName());
        System.setProperty("project_version", projectVersion());
//        Console.open(); //provides an entry point to the console
        state = CoreState.INITIALIZE;//begin in initialization
        Thread t = new Thread(this); // open up this thread
        t.start();
        
        
        //auto-initializes the thread. No need to initialze the thread outside 
        //of this class.
    }

    // the current time, or the time according to the System's millisecond time
    // this variable is non-useful to the client for two raisins
    //    (a)    milliseconds suck, and the time is not relevant to any 
    //           time that is used in the program. 
    //    (b)    this time is used as a "step" to get the dt from the previous
    //           time that the core went through a loop. 
    private static long currentTime;

    // the time that went between this iteration of the loop and the last 
    // iteration of the loop. Note-worthy - this dt is not in seconds, 
    // but in milliseconds.
    public static float dt;

    // the time that the core was started.
    //     NOTE:   this variable is non-final, in case that the client
    //             wants to "turn-back time", re-boot the Core, or
    //             even go into the future.
    //     NOTE 2: this variable is actually in system time millis.
    //             so, it is a good idea if you want to reset your
    //             to set it to the current system time. 
    private static long startingTime;

    // the current time that the core is at. This is the time since the
    // Core's inception. NOTE: this time is in milliseconds, not in
    // seconds.
    public static float time;

    // the period or the interval that the core will wait between this 
    // execution of the core and the next execution of the core.
    private static long PERIOD = 30;

   /**
    * this method is called to update the times for the core. it's a 
    * good idea NOT for the client to call this method, as it is 
    * automatically called in the Core loop.
    */
    public void updateTime(){
        currentTime = System.currentTimeMillis();
        float tp = time;
        time = (float)(currentTime - startingTime);
        dt = time - tp;
    }

   /**
    * this is the function the client creates to update everything that 
    * you would want to update. For example, you could update the screen
    * on a frame, or update an algorithm or some shit.
    */ 
    public abstract void update();
    
   /**
    * the client fills in this method in order for the core to properly
    * initialize drizz.
    */
    public abstract void initialize();

   /**
    * this is the function that the client should fill in if a request to
    * exit has been called. It handles closing the environment the client 
    * made
    */
    public abstract void exit();

   /**
    * the client should fill out what the project name/version they're in.
    * This is method essentially sets the system property "project_name"
    * to this value. 
    * This value is important for interfacing with Console or Disp.
    */
    protected abstract String projectName();

   /**
    * the client should fill out this method detailing what version
    * the project is at.
    * This is nice for interfacing with Disp and Console
    */ 
    protected abstract String projectVersion();
    
   /**
    * this returns the project name that the user set in a static 
    * and public fashion (how quaint!)
    */
    public static String project_name(){
        return System.getProperty("project_name");
    }

   /**
    * this method returns the project version that the client set 
    * in a public and static fashion (neat!)
    */
    public static String project_version(){
        return System.getProperty("project_version");
    }

   /**
    * the current state of affairs. To be replaced with an integer-mask.
    * 
    * I'll talk about the integer mask, because that's the cool part!
    *
    *     0000 0000 0000 0000  0000 0000 0000 0000  <--- the integer mask
    *
    * every 4 bits in the 8*4 bit int represents an instruction. There are
    * a set of eight instructions that can be executed. In addition, this is
    * noce because the bits are ordered. Here's a list of current ideas for 
    * instructions.
    *
    *    0000     -- NOP, no operation, do nothing
    *    0001     -- Initialize
    *    1001     -- Initialize, and then set the mask to NOP.
    *    0010     -- update
    *    1010     -- update, and then set this operation to NOP
    *    0011     -- update time
    *    1011     -- update time, and then set this operation to NOP
    *    0100     -- calls the exit function
    *    1100     -- exit, then set this operation to NOP
    *    0101     -- exits the loop
    *
    * these commands are processed every iteration of the loop. Here are a few
    * examples of some instructions. NOP is not listed:
    *    1001     -- initialize the first time
    *    0011     -- update time
    *    0010     -- update
    */ 
    public static CoreState state;
    public enum CoreState{
        INITIALIZE,  //in the state of initialization. This state jumps into RUNNING immediately after it finishes.
        RUNNING, //the time is being updated and the canvas is being drawn
        SUSPENDED, //the canvas is being drawn but the time is not being updated
        BROKEN, //neither the canvas is being drawn nor the time is updated
        EXIT,//exits 
        ONLY_INITIALIZE
    }
    public static void setCoreState(CoreState c){
        state = c;
    }
    protected void initializeTime(){
        startingTime = System.currentTimeMillis();
        dt = 1f;//to prevent dividing by zero errors. Also, the 
                           //best time for a loop to come to completetion.
        time = 0f;
        currentTime = startingTime;
    }
    @Override public void run(){
        initializeTime();
        exit:while(true){ 
            sw:switch(state){
                case INITIALIZE:
                    state = CoreState.RUNNING;
                    //immediately set the state to running and begin running
                    initialize();
                    //initialize happens afterwords, in case if the user wants to
                    //jump into a different state after initialization.
                case RUNNING:
                    updateTime();
                case SUSPENDED:
                    update();
                    break sw;
                case BROKEN:
                    break sw;
                case EXIT:
                    break exit;
                case ONLY_INITIALIZE:
                    initialize();
            }
            try {
                
                Thread.currentThread().sleep(PERIOD);
            } catch (InterruptedException ex) {}
        }exit();
    }
   /**
    * this method sets the interval for which the loop should wait. Setting the
    * the interval to a negative number will result in an exception being called.
    */
    public void setPeriod(long interval) {
        try{
            if(interval<0) throw new InvalidInputException("Can't have an interval less than zero, "
                + interval);
            PERIOD = interval;
        } catch(Exception e){e.printStackTrace();}
    }
}
