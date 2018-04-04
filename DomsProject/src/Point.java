
import java.util.concurrent.Semaphore;

public class Point {

    public int index1;
    public int index2;
    private Semaphore semaphore;
    Directions dir;
    int cid;

    Point(int index1, int index2) {
        this.index1 = index1;
        this.index2 = index2;
        this.semaphore = new Semaphore(1);
        this.dir = new Directions('X', 'X');
        this.cid = -1;
        //create semaphore?
    }

    //returns whether or not we can acquire semaphore
    public boolean tryAcquire() {
        return semaphore.tryAcquire();
    }

    public void acquireLock(int cid, Directions dir) {
        try {
            semaphore.acquire();
//            System.out.println("Semaphore " + index1 + "," + index2 + " ACQUIRED by car " + cid);
            //save the directions of the car who has the lock so if the next car 
            //is going the same they can cross
            this.dir = dir;
            this.cid = cid;
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void releaseLock(int cid) {
//        System.out.println("Semaphore " + index1 + "," + index2 + " RELEASED by car " + cid);
        semaphore.release();

    }

    //to be used by car coming and going in the same directions
    public void interrupt() {

    }

    public boolean noPermit() {
        if (semaphore.availablePermits() == 0) {
            return true;
        } else {
            return false;
        }
    }
    public int lockedBy(){
    	return this.cid;
    }
    public void numPermits() {
        System.out.println("Semaphore " + index1 + "," + index2 + " has " + semaphore.availablePermits() + " available permits");
                
    }
}
