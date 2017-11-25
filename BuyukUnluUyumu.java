import java.util.Scanner;

public class BuyukUnluUyumu {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a word: ");
		String word = scan.nextLine();
		scan.close();
		BuyukUnluUyumu b = new BuyukUnluUyumu();
		boolean result = b.new ControlState().isObeyTheGreatVowelHarmonyRule(word);
	}

	class ControlState {
		final char[] thickVowels = { 'a', 'ı', 'u', 'o', 'A', 'I', 'U', 'O' };
		final char[] thinVowels = { 'e', 'i', 'ü', 'ö', 'E', 'İ', 'Ü', 'Ö' };
		boolean mResult;

		void controlWhat(String word) {
			for (int i = 0; i < getSize(word); i++) {
				for (int j = 0; j < thickVowels.length; j++) {
					if (word.charAt(i) == thickVowels[j]) {
						mResult = printResult(thinVowels, i, word);
						return;
					} else if (word.charAt(i) == thinVowels[j]) {
						mResult = printResult(thickVowels, i, word);
						return;
					}
				}
			}
		}

		boolean printResult(char[] arr, int n, String word) {
			for (int k = n + 1; k < getSize(word); k++) {
				for (int l = 0; l < arr.length; l++) {
					if (word.charAt(k) == arr[l]) {
						return false;
					}
				}
			}
			return true;
		}

		int getSize(String word) {
			return word.length();
		}

		boolean isObeyTheGreatVowelHarmonyRule(String word) {
			controlWhat(word);
			return mResult;
		}
	}
}
