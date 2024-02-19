/*

DAY : 7
ASSIGNMENT NO : 3

Complete the following methods in a class called DateUtil:
·boolean isLeapYear(int year): returns true if the given year is a
leap year. A year is called as a leap year if it is divisible by 4 but not by 100,
or it is divisible by 400.
·boolean isValidDate(int year, int month, int day): returns
true if the given year, month and day constitute a given date. Assume that a
year is between 1 and 9999, month is between 1 (Jan) to 12 (Dec) and day
shall be between 1 and 28|29|30|31 depending on the month and whether it is
a leap year.
·int getDayOfWeek(int year, int month, int day): returns the
day of the week, where 0 for SUN, 1 for MON, ..., 6 for SAT, for the given
date. Assume that the date given by you is valid.
·String toString(int year, int month, int day: prints the given
date in the format xxxday d mmm yyyy, for example, Tuesday 14 Feb
2012. Assume that the date given by you is valid.
To find the day of the week, follow the steps mentioned below. (Reference: Wiki -
Determination of the day of the week)
1.Based on the first two digits of the year, get the number from the following century
table.
1700-1800-1900-2000-2100-2200-2300-2400-42064206
1.Take note that the entries 4, 2, 0, 6 repeat.
2.Add to the last two digits of the year.
3.Add to the last two digit of the year divide by 4, truncate the fractional part.
4.Add to the number obtained from the following month table:
JanFebMarAprMayJunJulAugSepOctNovDecNon-Leap Year033614625035Leap
Year62same as above
1.Add to the day.
2.The sum modulus 7 gives the day of the week, where 0 for SUN, 1 for MON,..., 6
for SAT.
For example, 2012, Feb, 17
(6 + 12 + 12/4 + 2 + 17) % 7 = 5 (Fri)

*/
package net.texala.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyDate {

	private final int MIN_YEAR = 1;
	private final int MAX_YEAR = 9999;

	private final String[] strMonths = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
			"Dec" };

	private final String[] strDays = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

	private final int[] daysInMonths = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private final int[] nonLeapYearMonthNumbers = { 0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5 };

	private final int[] leapYearMonthNumbers = { 6, 2, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5 };

	public static void main(String[] args) {
		MyDate aDateUtil = new MyDate();

		System.out.println("To check whether it is a leap year or not :" +aDateUtil.isLeapYear(1900));
		System.out.println("To check whether it is a leap year or not :" +aDateUtil.isLeapYear(2000));
		System.out.println("To check whether it is a leap year or not :" +aDateUtil.isLeapYear(2011));
		System.out.println("To check whether it is a leap year or not :" +aDateUtil.isLeapYear(2012));

		System.out.println("To check whether it is a valid date :" +aDateUtil.isValidDate(2012, 2, 29));
		System.out.println("To check whether it is a valid date :" +aDateUtil.isValidDate(2011, 2, 29));
		System.out.println("To check whether it is a valid date :" +aDateUtil.isValidDate(2099, 12, 31));
		System.out.println("To check whether it is a valid date :" +aDateUtil.isValidDate(2099, 12, 32));

		System.out.println("To display the day of week in numbers" +aDateUtil.getDayOfWeek(1982, 4, 24));
		System.out.println("To display the day of week in numbers" +aDateUtil.getDayOfWeek(2000, 1, 1));
		System.out.println("To display the day of week in numbers" +aDateUtil.getDayOfWeek(2054, 6, 19));
		System.out.println("To display the day of week in numbers" +aDateUtil.getDayOfWeek(2012, 2, 17));

		aDateUtil.getDayOfWeekTest(1982, 4, 24);
		aDateUtil.getDayOfWeekTest(2000, 1, 1);
		aDateUtil.getDayOfWeekTest(2054, 6, 19);
		aDateUtil.getDayOfWeekTest(2012, 2, 17);

		System.out.println(aDateUtil.toString(2012, 2, 14));
		System.out.println(aDateUtil.toString(2014, 2, 26));
	}

	private boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

	private boolean isValidDate(int year, int month, int day) {
		if (year <= 1 || year >= 9999) {
			return false;
		}
		if (month < 1 || month > 12) {
			return false;
		}
		int monthDays = daysInMonths[month - 1];
		if (month == 2 && isLeapYear(year)) {
			monthDays++;
		}

		return (day >= 1 && day <= monthDays);

	}

	private int getDayOfWeek(int year, int month, int day) {

		int magicCenturyNumber = 6 - 2 * ((year / 100) % 4);

		int lastTwoDigitsOfYear = year % 100;

		int magicYearNumber = lastTwoDigitsOfYear / 4;

		int magicMonthNumber = isLeapYear(year) ? leapYearMonthNumbers[month - 1] : nonLeapYearMonthNumbers[month - 1];

		int magicDayNumber = day;

		return (magicCenturyNumber + lastTwoDigitsOfYear + magicYearNumber + magicMonthNumber + magicDayNumber) % 7;
	}

	private void getDayOfWeekTest(int year, int month, int day) {
		Calendar cal = new GregorianCalendar(year, month - 1, day);

		int dayNumber = cal.get(Calendar.DAY_OF_WEEK);
		String[] calendarDays = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

		System.out.println("It is " + calendarDays[dayNumber - 1]);
	}

	private String toString(int year, int month, int day) {
		if (!isValidDate(year, month, day)) {
			return "Not a valid date!";
		}
		int d = getDayOfWeek(year, month, day);
		return strDays[d] + " " + day + " " + strMonths[month - 1] + " " + year;
	}
}
