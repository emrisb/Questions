
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PazarGunleriniBulma {

	public static void main(String[] args) {

		Calendar calendarStart = Calendar.getInstance();
		calendarStart.set(Calendar.DATE, 01);
		calendarStart.set(Calendar.MONTH, Calendar.JANUARY);
		calendarStart.set(Calendar.YEAR, 1900);
		// Date startDate = calendarStart.getTime();

		Calendar calendarEnd = Calendar.getInstance();
		calendarEnd.set(Calendar.DATE, 31);
		calendarEnd.set(Calendar.MONTH, Calendar.DECEMBER);
		calendarEnd.set(Calendar.YEAR, 2000);
		// Date endDate = calendarEnd.getTime();

		/*
		 * System.out.println(startDate); System.out.println(endDate);
		 */

		PazarGunleriniBulma pgb = new PazarGunleriniBulma();
		/*
		 * prints the dates which the first day of month is Sunday.
		 */
		pgb.new FindFirstDaySunday(calendarStart, calendarEnd).printFirstDaySunday();

		// prints the first days of month.
		// pgb.new FindFirstDaySunday(calendarStart, calendarEnd).printFirstDaysOfMonths();
	}

	class FindFirstDaySunday {
		List<Date> firstDaysOfMonthsList;
		List<Date> firstDaySundayList;
		Calendar mCalendarStart, mCalendarEnd;
		Date dateStart, dateEnd;
		SimpleDateFormat sdfForDate;
		SimpleDateFormat sdfForDay;

		public FindFirstDaySunday(Calendar calendarStart, Calendar calendarEnd) {
			this.mCalendarStart = calendarStart;
			this.mCalendarEnd = calendarEnd;
			dateStart = calendarStart.getTime();
			dateEnd = calendarEnd.getTime();
			sdfForDate = new SimpleDateFormat("dd/MM/yyyy");
			sdfForDay = new SimpleDateFormat("EEEE");
			firstDaysOfMonthsList = new ArrayList<>();
			firstDaySundayList = new ArrayList<>();
			findFirstDaysOfMonths();
		}

		void findFirstDaysOfMonths() {
			firstDaysOfMonthsList.add(dateStart);
			while (mCalendarStart.before(mCalendarEnd)) {
				mCalendarStart.set(Calendar.DATE, mCalendarStart.getActualMaximum(Calendar.DATE));
				if (mCalendarStart.before(mCalendarEnd)) {
					mCalendarStart.add(Calendar.DATE, 1);
					firstDaysOfMonthsList.add(mCalendarStart.getTime());
				}
			}
		}

		void printFirstDaySunday() {
			for (Date d : firstDaysOfMonthsList) {
				if (sdfForDay.format(d).equalsIgnoreCase("Sunday")) {
					firstDaySundayList.add(d);
					System.out.println(sdfForDate.format(d) + " - " + sdfForDay.format(d));
				}
			}
			System.out.println("Sunday List Size: " + getSizeOf(firstDaySundayList));
			System.out.println("First Day List Size: " + getSizeOf(firstDaysOfMonthsList));
		}

		void printFirstDaysOfMonths() {
			for (Date d : firstDaysOfMonthsList) {
				System.out.println(sdfForDate.format(d) + " - " + sdfForDay.format(d));
			}
		}

		int getSizeOf(List<Date> dateList) {
			return dateList.size();
		}

	}
}
