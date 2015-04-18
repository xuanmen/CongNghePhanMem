package bt;

public class Demo {
	public static void Nhap() {
	}

	public static void main(String[] args) {
		int n = 3;
		for (int i = 1; i <= n; i++) {
			for (int k = 1; k <= n - i; k++) {
				System.out.print(" ");
				if (k > n - i) {
					for (int a = i; a >= (k - (n - i)); a--) {
						System.out.print(a);
					}
				} else
					for (int z = 2; z <= i; z++) {
						System.out.print(z);
					}
			}
		}
	}
}
