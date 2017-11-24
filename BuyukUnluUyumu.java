import java.util.Scanner;

public class BuyukUnluUyumu {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a word: ");
		String word = scan.nextLine();
		scan.close();
		BuyukUnluUyumu b = new BuyukUnluUyumu();
		b.new ControlState().controlWhat(word);
		
	}

	class ControlState {
		final char[] thickVowels = { 'a', 'ı', 'u', 'o', 'A', 'I', 'U', 'O' };
		final char[] thinVowels = { 'e', 'i', 'ü', 'ö', 'E', 'İ', 'Ü', 'Ö' };

		public void controlWhat(String word) {
			for (int i = 0; i < getSize(word); i++) {
				for (int j = 0; j < thickVowels.length; j++) {
					if (word.charAt(i) == thickVowels[j]) {
						printResult(thinVowels, i, word);
						return;
					} else if (word.charAt(i) == thinVowels[j]) {
						printResult(thickVowels, i, word);
						return;
					}
				}
			}
		}

		void printResult(char[] arr, int n, String word) {
			for (int k = n + 1; k < getSize(word); k++) {
				for (int l = 0; l < arr.length; l++) {
					if (word.charAt(k) == arr[l]) {
						System.out.println(word + " kelimesi " + "büyük ünlü uyumuna uymaz.");
						return;
					}
				}
			}
			System.out.println(word + " kelimesi " + "büyük ünlü uyumuna uyar.");
		}

		int getSize(String word) {
			return word.length();
		}
	}
}
