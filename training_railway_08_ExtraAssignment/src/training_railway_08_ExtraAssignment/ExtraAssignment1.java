package training_railway_08_ExtraAssignment;

public class ExtraAssignment1 {
	public static void main(String[] args) {

		Ex03Q01c();
	}

	static void Ex03Q01a() {
		int x = 10;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("x ");
			}
			System.out.println();
		}
	}

	static void Ex03Q01b() {
		int x = 10;
		for (int i = x; i > 0; i--) {
			for (int j = i; j > 0; j--) {
				System.out.print("x ");
			}
			System.out.println();
		}
	}

	static void Ex03Q01c() {
		int x = 10;
		for (int i = 0; i < x; i++) {
			{
				for (int j = 0; j < i; j++) {
					System.out.print("  ");
				}
				for (int z = x - i; z > 0; z--) {
					System.out.print("x ");
				}
			}
			System.out.println();
		}
	}

	static void Ex03Q01d() {
		int x = 10;
		for (int i = 0; i < x; i++) {
			{
				for (int j = x - i; j > 0; j--) {
					System.out.print(" ");
				}
				
				for (int z = 0; z < i; z++) {
					System.out.print("x");
				}

			}
			System.out.println();
		}
	}
}