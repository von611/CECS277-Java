
public class Multiply {
	public static void main (String[] args) {
		
	}
	public int addition(int x, int y) {
		if (x == 0) {
			return 0;
		} else if (y == 0) {
			return 0;
		} else {
			return x + addition(x, y - 1);
		}
	}
}
