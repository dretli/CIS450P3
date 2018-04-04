
import java.time.LocalTime;
import java.time.ZoneId;

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
    	//run methods
        ArriveIntersection(dir);
        CrossIntersection(dir);
        ExitIntersection(dir);
    }

    private void ArriveIntersection(Directions dir) {
        this.arrivalTime = LocalTime.now(ZoneId.of("America/New_York")); //Car.arrivalTime gets set once ArriveIntersection() is entered.

        this.print("arriving");
        //get the points needed,
        //check to see if first point is available (stop sign point) before checking the rest
        //once that one is available check to see if the rest of the points are available
        points = this.dir.pointsNeeded();   //get the needed points for the given directions

        points[0].acquireLock(this.cid, this.dir);  //acquire stop sign
        Points.isNext.acquireLock(this.cid, this.dir); //acquiring the right to go next
        
        
        for (int i = 1; i < points.length; i++) {         //acquire rest of points
//          if(points[i].dir.getDir_original() == this.dir.getDir_original() && points[i].dir.getDir_target() == this.dir.getDir_target()){
//            points[i].numPermits();
            if(points[i].dir.getDir_original() == this.dir.getDir_original() && points[i].noPermit() ){
                points[i].releaseLock(this.cid);       //stealing a semaphore that has the same directions as this car
            }
            points[i].acquireLock(this.cid, this.dir);  
        }


    }

    private void CrossIntersection(Directions dir) {
        this.print("crossing");
        points[0].releaseLock(this.cid);    //Releasing stop sign
        Points.isNext.releaseLock(this.cid); //Release is next
        try {
            //sleep for the appropriate number of seconds based on the turn type
            //Left = 3; Straight = 2; Right = 1
            Thread.sleep(dir.turnType() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void ExitIntersection(Directions dir) {
    	this.print("exiting");
        for (int i = 1; i < points.length; i++) {
            if(points[i].lockedBy() == this.cid)
                points[i].releaseLock(this.cid);
        }
    }

    private void print(String instruction) {
        System.out.println("Time " + Points.getTimeOffset()
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
