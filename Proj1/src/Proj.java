
public class Proj {
	public static void main (String args[]) {
		int x = 4;
		int y = 5;
		int result = addition(x , y);
		System.out.println(result);
	}
	public static int addition(int x, int y){
		if (x == 0) {
			return 0;
		} else if (y == 0) {
			return 0;
		} else {
			return x + addition(x, y - 1);
		}
	}
}
