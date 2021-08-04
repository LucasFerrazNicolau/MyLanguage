import java.util.Scanner;
public class MainClass {
	public static void main(String args[]) {
		Scanner _key = new Scanner(System.in);
double a;
double b;
String l1;
a = _key.nextDouble();

b = _key.nextDouble();

l1 = _key.nextLine();

System.out.println(l1);
a = 1*b-8;

if (a>b) {
System.out.println(a);} else {System.out.println(b);}

	}
}