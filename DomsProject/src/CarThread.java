

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

public class CarThread extends Thread {
    public Car car;
    public int sleepTime;
    
    CarThread(Directions dir, int cid, int sleepTime) throws InterruptedException{
    	this.sleepTime = sleepTime;
        Thread.sleep(sleepTime);    //sleep before creating a new car object
        car = new Car(dir, cid);
        this.start();
    }
    
    @Override
    public void run() {
        try {
            // Displaying the thread that is running
            System.out.println("Car Thread "
                    + Thread.currentThread().getId()
                    + " is running with a cid of: "+ car.cid
                    + " Sleep Time is: " + (float)sleepTime/1000);
            
//            int[] points = car.dir.pointsNeeded();
//            for(int i = 0; i < points.length; i++){
//            	System.out.println(points[i] + " " + points[++i]);
//            }

        } catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }

}
