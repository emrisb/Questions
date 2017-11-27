import java.util.ArrayList;
import java.util.List;

public class Sundays {

	public static void main(String[] args) {
		Sundays sun = new Sundays();
		sun.new FindSundays().printFirstDayOfMonthSunday();

	}

	class FindSundays {
		int[] dayNumberOfMonths = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] days = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };
		String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		List<String> firstDaysOfMonth;
		List<String> firstDayOfMonthSunday;
		int mY1, mY2;

		public FindSundays() {
			mY1 = 1900;
			mY2 = 2000;
			firstDaysOfMonth = new ArrayList<>();
			firstDayOfMonthSunday = new ArrayList<>();
			startFinding(mY1, mY2);
		}

		void startFinding(int y1, int y2) {
			for (int y = y1; y <= y2; y++) {
				for (int m = 0; m <= 11; m++) {
					for (int d = 1; d <= dayNumberOfMonths[m]; d++) {
						if (d == 1) {
							byte theDay = findDay(d, m, y);
							String firstDayOfMonth = days[theDay] + ", " + months[m] + " " + d + ", " + y;
							firstDaysOfMonth.add(firstDayOfMonth);
							if (days[theDay].equalsIgnoreCase("Sun")) {
								firstDayOfMonthSunday.add(firstDayOfMonth);
							}
						}
					}
				}
			}
		}

		byte findDay(int d, int m, int y) {
			int sumOfDays = 0, sumOfOffset = 0;
			byte day = 0;
			if (m == 0 && y == 1900) {
				return day;
			} else {
				if (y >= 1900 && y < 2000) {
					sumOfOffset += 0;
				} else if (y == 2000) {
					sumOfOffset += 6;
				}

				y %= 100;
				if (isLeapYear(y) && (m == 0 || m == 1)) {
					y = (y + y / 4) % 7;
					y -= 1;
				} else {
					y = (y + y / 4) % 7;
				}
				sumOfOffset += y;

				for (int i = 0; i < m; i++) {
					sumOfDays += dayNumberOfMonths[i];
				}
				sumOfOffset += sumOfDays % 7;
				sumOfOffset += d % 7;
				if (sumOfOffset % 7 == 0) {
					sumOfOffset %= 7;
					sumOfOffset -= 1;
					sumOfOffset += 7;
				} else {
					sumOfOffset %= 7;
					sumOfOffset -= 1;
				}
				day = (byte) sumOfOffset;
				return day;
			}
		}

		void printFirstDayOfMonthSunday() {
			for (String day : firstDayOfMonthSunday) {
				System.out.println(day);
			}
		}

		void printFirstDaysOfMonth() {
			for (String day : firstDaysOfMonth) {
				System.out.println(day);
			}
		}

		boolean isLeapYear(int y) {
			return (y % 400 == 0) ? true
					: (y % 400 != 0 && y % 100 == 0) ? false 
						: (y % 4 == 0 && y % 400 != 0) ? true 
							: false;
		}

	}
}
