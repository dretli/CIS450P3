import java.time.LocalTime;
import java.time.ZoneId;
import static java.time.temporal.ChronoUnit.MILLIS;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Points {
	public static ArrayList<ArrayList<Point>> points = new ArrayList<ArrayList<Point>>();
        public static Point isNext = new Point(9,9);
	public static LocalTime startTime;

	public static void createPoints(){
		
		//create points on the intersection that cars will need to obtain locks
		//see picture for numbering scheme
        for (int i = 0; i < 5; i++) {
            ArrayList<Point> circleOfPoints = new ArrayList<Point>();
            for (int j = 0; j < 5; j++) {
                circleOfPoints.add(new Point(i, j));
            }
            points.add(circleOfPoints);
        }
	}
	
	public static LocalTime getStartTime() {
		return startTime;
	}
	public static void setStartTime() {
		startTime = LocalTime.now(ZoneId.of("America/New_York"));
	}
        
        public static String getTimeOffset(){
            double offsetSec = (startTime.until(LocalTime.now(ZoneId.of("America/New_York")), MILLIS))/1000.0;
            return String.format("%.1f", offsetSec);
        }

}
