import java.util.concurrent.Semaphore;

public class Point {
	public int index1;
	public int index2;
	private Semaphore semaphore;
	Directions dir;
	
	Point(int index1, int index2){
		this.index1 = index1;
		this.index2 = index2;
		//create semaphore?
	}

	//returns whether or not we can acquire semaphore
	public boolean tryAcquire(){
		return semaphore.tryAcquire();
	}
	public void acquireLock(int cid, Directions dir){
		try {
			semaphore.acquire();
			//save the directions of the car who has the lock so if the next car 
			//is going the same they can cross
			this.dir = dir;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void releaseLock(){
		semaphore.release();
	}
	
	//to be used by car coming and going in the same directions
	public void interrupt(){
		
	}
}
