
import java.time.LocalTime;

import java.time.ZoneId;
import static java.time.temporal.ChronoUnit.MILLIS;;
public class Car {
	int cid;
        LocalTime arrivalTime;
    Directions dir;
	Car(Directions dir, int cid) {
		this.dir = dir;
		this.cid = cid;
	    ArriveIntersection(dir);
	    CrossIntersection(dir);
	    ExitIntersection(dir);
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
