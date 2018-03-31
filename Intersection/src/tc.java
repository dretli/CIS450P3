
import java.util.ArrayList;
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
        ArrayList<ArrayList<Point>> points = new ArrayList<ArrayList<Point>>();
        for (int i = 0; i < 5; i++) {
            ArrayList<Point> circleOfPoints = new ArrayList<Point>();
            for (int j = 0; j < 5; j++) {
                circleOfPoints.add(new Point(i, j));
            }
            points.add(circleOfPoints);
        }

        //only run when all directions locks are obtained that are needed
        createCarThreads(); //this creates all of the threads, at their appropriate arrival times using Thread.sleep() as an offset

    }

    public static void createCarThreads() throws InterruptedException {
        Directions dir;
        
        dir = new Directions();
        dir.set_dir_original('N');
        dir.set_dir_target('N');
        Thread.sleep(1100);
        CarThread car0Thread = new CarThread(dir, 0);

        dir = new Directions();
        dir.set_dir_original('N');
        dir.set_dir_target('N');
        Thread.sleep(2000 - 1100);
        CarThread car1Thread = new CarThread(dir, 1);

        dir = new Directions();
        dir.set_dir_original('N');
        dir.set_dir_target('W');
        Thread.sleep(3300 - 2000);
        CarThread car2Thread = new CarThread(dir, 2);

        dir = new Directions();
        dir.set_dir_original('S');
        dir.set_dir_target('S');
        Thread.sleep(3500 - 3300);
        CarThread car3Thread = new CarThread(dir, 3);
        
        dir = new Directions();
        dir.set_dir_original('S');
        dir.set_dir_target('E');
        Thread.sleep(4200 - 3500);
        CarThread car4Thread = new CarThread(dir, 4);

        dir = new Directions();
        dir.set_dir_original('N');
        dir.set_dir_target('N');
        Thread.sleep(4400 - 4200);
        CarThread car5Thread = new CarThread(dir, 5);

        dir = new Directions();
        dir.set_dir_original('E');
        dir.set_dir_target('N');
        Thread.sleep(5700 - 4400);
        CarThread car6Thread = new CarThread(dir. 6);

        dir = new Directions();
        dir.set_dir_original('W');
        dir.set_dir_target('N');
        Thread.sleep(5900 - 5700);
        CarThread car7Thread = new CarThread(dir, 7);

    }

}
