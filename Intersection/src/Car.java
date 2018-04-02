
import java.time.LocalTime;

import java.time.ZoneId;
import static java.time.temporal.ChronoUnit.MILLIS;;
public class Car extends Thread{
	int cid;
    LocalTime arrivalTime;
    Directions dir;
    public int sleepTime;
	Car(Directions dir, int cid, int sleepTime) throws InterruptedException {
		this.dir = dir;
		this.cid = cid;
		this.sleepTime = sleepTime;
		Thread.sleep(sleepTime);    //sleep before starting car thread
		this.start();
	}
	
	
    @Override
    public void run() {
        try {
            // Displaying the thread that is running
            System.out.println("Car Thread "
                    + Thread.currentThread().getId()
                    + " is running with a cid of: "+ this.cid
                    + " Sleep Time is: " + (float)sleepTime/1000);
            
    	    ArriveIntersection(dir);
    	    CrossIntersection(dir);
    	    ExitIntersection(dir);

        } catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
	
	
	
	
	
	private void ArriveIntersection(Directions dir) {
		this.arrivalTime = LocalTime.now(ZoneId.of("America/New_York")); //Car.arrivalTime gets set once ArriveIntersection() is entered.
		
		//print the arrival time, the start time, and their difference
		System.out.println(arrivalTime + " - " + Points.getStartTime() + " = " + Points.getStartTime().until(arrivalTime, MILLIS));
		this.print("arriving");
		//get the points needed,
		//check to see if first point is available (stop sign point) before checking the rest
		//once that one is available check to see if the rest of the points are available
		int[] points = this.dir.pointsNeeded();
		
	}
	private void CrossIntersection(Directions dir) {
		// TODO Auto-generated method stub

		this.print("crossing");
		try {
			//sleep for the appropriate number of seconds based on the turn type
			//Left = 3; Straight = 2; Right = 1
			Thread.sleep(dir.turnType()*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void ExitIntersection(Directions dir) {
		// TODO Auto-generated method stub
		this.print("exiting");
	}
	private void print(String instruction){
		System.out.println("Time " + "(insert time)" 
				+ ": Car " + this.cid
				+ "(->" + this.dir.getDir_original()
				+ " ->" + this.dir.getDir_target()
				+ ") " + instruction);
	}

}
