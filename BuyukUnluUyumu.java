import java.util.Scanner;

public class BuyukUnluUyumu {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a word: ");
		String word = scan.nextLine();
		scan.close();
		BuyukUnluUyumu b = new BuyukUnluUyumu();
		b.new ControlState(word).controlWhat();

	}

	class ControlState {
		char[] kalin = { 'a', 'ı', 'u', 'o', 'A', 'I', 'U', 'O' };
		char[] ince = { 'e', 'i', 'ü', 'ö', 'E', 'İ', 'Ü', 'Ö' };
		String mWord = "";

		ControlState(String word) {
			this.mWord = word;
		}

		void controlWhat() {
			for (int i = 0; i < getSize(); i++) {
				for (int j = 0; j < kalin.length; j++) {
					if (mWord.charAt(i) == kalin[j]) {
						printResult(ince, i);
						return;
					} else if (mWord.charAt(i) == ince[j]) {
						printResult(kalin, i);
						return;
					}
				}
			}
		}

		void printResult(char[] arr, int n) {
			for (int k = n + 1; k < getSize(); k++) {
				for (int l = 0; l < arr.length; l++) {
					if (mWord.charAt(k) == arr[l]) {
						System.out.println(mWord + " kelimesi " + "büyük ünlü uyumuna uymaz.");
						return;
					}
				}
			}
			System.out.println(mWord + " kelimesi " + "büyük ünlü uyumuna uyar.");
		}

		int getSize() {
			return mWord.length();
		}
	}
}
