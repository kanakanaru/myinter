package rensyuyou;

public class Rensyu2 {
	public static void main(String[] args){
		System.out.println("Hello World");
		int x;
		int y;
		x = 11;
		System.out.println("x=" + x);
		x = 13;
		y = 17;
		System.out.println("x="+x+"y="+y);
		System.out.println(x=(x+y));
		System.out.println(x=(x*y));
		x = 7;
		System.out.println(x=(x*3));
		System.out.println(x=(x/2));

		x=3;
		y=7;
		int z;
		z=x;
		x=y;
		y=z;
		System.out.println("x="+x+"y="+z);

		x=19;
		y=23;
		System.out.println(z=(x*y));
	}

}
