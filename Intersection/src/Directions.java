
public class Directions {
    private char dir_original;
	private char dir_target;

	Directions(char orig, char targ){
		dir_original = orig;
		dir_target = targ;
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
