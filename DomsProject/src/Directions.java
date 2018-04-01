
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

public class Directions {
    private char dir_original;
	private char dir_target;
	//locked points

	Directions(char orig, char targ){
		this.dir_original = orig;
		this.dir_target = targ;
	}
	
	//create method to figure out which type of turn it is (Left, Right, Straight)
	//return the seconds it takes to complete the turn
	
	
	
	//figure out which points need to be locked based on chart
	public int[] pointsNeeded(){
		
		if(dir_original == 'N'){
			if(dir_target == 'N'){
				//O-N, T-N, 0-0, 1-0, 2-0, 2-3, 4-2 (STRAIGHT)
				int[] lock = {0, 0, 1, 0, 2, 0, 2, 3, 4, 2};
				return lock;
			}
			else if(dir_target == 'E'){
				//O-N, T-E, 0-0, 1-0, 2-0, 4-3 (RIGHT)
				int[] lock = {0, 0, 1, 0, 2, 0, 4, 3};
				return lock;
			}
			else if(dir_target == 'W'){
				//O-N, T-W, 0-0, 1-0, 3-0, 3-1, 2-2, 4-1 (LEFT)
				int[] lock = {0, 0, 1, 0, 3, 0, 3, 1, 2, 2, 4, 1};
				return lock;
			}
		}
		else if(dir_original == 'S'){
			if(dir_target == 'S'){
				//O-S, T-S, 0-2, 1-2, 2-2, 1-1, 4-0 (STRAIGHT)
				int[] lock = {0, 2, 1, 2, 2, 2, 1, 1, 4, 0};
				return lock;
			}
			else if(dir_target == 'W'){
				//O-S, T-W, 0-2, 1-2, 2-2, 4-1 (RIGHT)
				int[] lock = {0, 2, 1, 2, 2, 2, 4, 1};
				return lock;
			}
			else if(dir_target == 'E'){
				//O-S, T-E, 0-2, 1-2, 3-2, 3-3, 2-0, 4-3 (LEFT)
				int[] lock = {0, 2, 1, 2, 3, 2, 3, 3, 2, 0, 4, 3};
				return lock;
			}
		}
		else if(dir_original == 'E'){
			if(dir_target == 'E'){
				//O-E, T-E, 0-1, 1-1, 2-1, 1-0, 4-3 (STRAIGHT)
				int[] lock = {0, 1, 1, 1, 2, 1, 1, 0, 4, 3};
				return lock;
			}
			else if(dir_target == 'S'){
				//O-E, T-S, 0-1, 1-1, 2-1, 4-0 (RIGHT)
				int[] lock = {0, 1, 1, 1, 2, 1, 4, 0};
				return lock;
			}
			else if(dir_target == 'N'){
				//O-E, T-N, 0-1, 1-1, 3-0, 3-3, 2-3, 4-2 (LEFT)
				int[] lock = {0, 1, 1, 1, 3, 0, 3, 3, 2, 3, 4, 2};
				return lock;
			}
		}
		else if(dir_original == 'W'){
			if(dir_target == 'W'){
				//O-W, T-W, 0-3, 1-3, 2-3, 1-2, 4-1 (STRAIGHT)
				int[] lock = {0, 3, 1, 3, 2, 3, 1, 2, 4, 1};
				return lock;
			}
			else if(dir_target == 'N'){
				//O-W, T-N, 0-3, 1-3, 2-3, 4-2 (RIGHT)
				int[] lock = {0, 3, 1, 3, 2, 3, 4, 2};
				return lock;
			}
			else if(dir_target == 'S'){
				//O-W, T-S, 0-3, 1-3, 3-3, 3-0, 2-1, 4-0 (LEFT)
				int[] lock = {0, 3, 1, 3, 3, 3, 3, 0, 2, 1, 4, 0};
				return lock;
			}
		}
		return null;
	}
	
    public char getDir_original() {
		return dir_original;
	}

	public void setDir_original(char dir_original) {
		this.dir_original = dir_original;
	}

	public char getDir_target() {
		return dir_target;
	}

	public void setDir_target(char dir_target) {
		this.dir_target = dir_target;
	}
}
