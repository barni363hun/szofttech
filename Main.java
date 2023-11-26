import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		TransportApp t = new TransportApp();
Scanner sc = new Scanner(System.in);
 for (int i = 0; i<2;) {
		t.startMenu();
		System.out.println("x - Kilépés");
		
		if (sc.nextLine() == "x"){
			i = 100;
		}
		System.out.println("======\n\n\n\n\n");
 }
	
	}
}
