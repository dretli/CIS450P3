
import java.time.LocalTime;
import java.time.ZoneId;

public class Car {
	int cid;
        LocalTime arrivalTime;
	Car(Directions dir, int cid) {
		this.cid = cid;
	    ArriveIntersection(dir);
	    CrossIntersection(dir);
	    ExitIntersection(dir);
	}
	private void ArriveIntersection(Directions dir) {
            this.arrivalTime = LocalTime.now(ZoneId.of("America/New_York")); //Car.arrivalTime gets set once ArriveIntersection() is entered.
		// TODO Auto-generated method stub
		
	}
	private void CrossIntersection(Directions dir) {
		// TODO Auto-generated method stub
		
	}
	private void ExitIntersection(Directions dir) {
		// TODO Auto-generated method stub
		
	}

}
