
import java.time.LocalTime;
import java.time.ZoneId;
//O-N, T-N, 0-0, 1-0, 2-0, 2-3, 4-2 (STRAIGHT)
//O-N, T-E, 0-0, 1-0, 2-0, 4-3 (RIGHT)
//O-N, T-W, 0-0, 1-0, 3-0, 3-1, 2-2, 4-1 (LEFT)
//O-S, T-S, 0-2, 1-2, 2-2, 1-1, 4-0 (STRAIGHT)
//O-S, T-W, 0-2, 1-2, 2-2, 4-1 (RIGHT)
//O-S, T-E, 0-2, 1-2, 3-2, 3-3, 2-0, 4-3 (LEFT)
//O-E, T-E, 0-1, 1-1, 2-1, 1-0, 4-3 (STRAIGHT)
//O-E, T-S, 0-1, 1-1, 2-1, 4-0 (RIGHT)
//O-E, T-N, 0-1, 1-1, 3-0, 3-3, 2-3, 4-2 (LEFT)
//O-W, T-W, 0-3, 1-3, 2-3, 1-2, 4-1 (STRAIGHT)
//O-W, T-N, 0-3, 1-3, 2-3, 4-2 (RIGHT)
//O-W, T-S, 0-3, 1-3, 3-3, 3-0, 2-1, 4-0 (LEFT)

public class tc {

    public static LocalTime startTime = LocalTime.now(ZoneId.of("America/New_York")); //this time is essentially our "0.00" time. Start counting time from here.

    public static void main(String[] args) throws InterruptedException {
        //create intersection
    	//create points
    	Points.createPoints();

        //only run when all directions locks are obtained that are needed
        createCarThreads(); //this creates all of the threads, at their appropriate arrival times using Thread.sleep() as an offset

    }

    //this method creates the 8 car threads (hardcoded from assignment details) Each thread will instantiate a car object
    @SuppressWarnings("unused")
	public static void createCarThreads() throws InterruptedException {
        System.out.println("Creating Car Threads Now");
        Points.setStartTime();//set the start time
        Car carThread0 = new Car(new Directions('N','N'), 0, 1100);
        Car carThread1 = new Car(new Directions('N','N'), 1, 2000 - 1100);
        Car carThread2 = new Car(new Directions('N','W'), 2, 3300 - 2000);
        Car carThread3 = new Car(new Directions('S','S'), 3, 3500 - 3300);
        Car carThread4 = new Car(new Directions('S','E'), 4, 4200 - 3500);
        Car carThread5 = new Car(new Directions('N','N'), 5, 4400 - 4200);
        Car carThread6 = new Car(new Directions('E','N'), 6, 5700 - 4400);
        Car carThread7 = new Car(new Directions('W','N'), 7, 5900 - 5700);
    }

}
