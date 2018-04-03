
import java.time.LocalTime;

import java.time.ZoneId;
import static java.time.temporal.ChronoUnit.MILLIS;
import java.util.ArrayList;

;

public class Car extends Thread {

    int cid;
    LocalTime arrivalTime;
    Directions dir;
    public int sleepTime;
    Point[] points;

    Car(Directions dir, int cid, int sleepTime) throws InterruptedException {
        this.dir = dir;
        this.cid = cid;
        this.sleepTime = sleepTime;
        Thread.sleep(sleepTime);    //sleep before starting car thread
        this.start();
    }

    @Override
    public void run() {
//        try {
        // Displaying the thread that is running
        System.out.println("Car Thread "
                + Thread.currentThread().getId()
                + " is running with a cid of: " + this.cid
                + " Sleep Time is: " + (float) sleepTime / 1000);

        ArriveIntersection(dir);
        CrossIntersection(dir);
        ExitIntersection(dir);

//        } catch (Exception e) {
//            // Throwing an exception
//            System.out.println("Exception is caught");
//        }
    }

    private void ArriveIntersection(Directions dir) {
        this.arrivalTime = LocalTime.now(ZoneId.of("America/New_York")); //Car.arrivalTime gets set once ArriveIntersection() is entered.

        //print the arrival time, the start time, and their difference
        System.out.println(arrivalTime + " - " + Points.getStartTime() + " = " + Points.getStartTime().until(arrivalTime, MILLIS));
        this.print("arriving");
        //get the points needed,
        //check to see if first point is available (stop sign point) before checking the rest
        //once that one is available check to see if the rest of the points are available
        points = this.dir.pointsNeeded();   //get the neeeded points for the given directions

        for (int i = 0; i < points.length; i++) {
            points[i].acquireLock(this.cid, this.dir);
        }
//        if(Points.points.get(0).get(0).tryAcquire())
//            System.out.println("SUCCESSFULY ACQUIRED");
//        else
//            System.out.println("DENIED BRO");
//        points[0].acquireLock(this.cid, this.dir);

    }

    private void CrossIntersection(Directions dir) {
        // TODO Auto-generated method stub

        this.print("crossing");
        try {
            //sleep for the appropriate number of seconds based on the turn type
            //Left = 3; Straight = 2; Right = 1
            Thread.sleep(dir.turnType() * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void ExitIntersection(Directions dir) {
        for (int i = 0; i < points.length; i++) {
            points[i].releaseLock(this.cid);
        }
        this.print("exiting");
    }

    private void print(String instruction) {
        System.out.println("Time " + "(insert time)"
                + ": Car " + this.cid
                + "(->" + this.dir.getDir_original()
                + " ->" + this.dir.getDir_target()
                + ") " + instruction);
    }

    private void printIntersection() {
        System.out.println("PRINTING INTERSECTION");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(Points.points.get(i).get(j).tryAcquire() + " ");
            }
            System.out.println("");
        }
    }

}
