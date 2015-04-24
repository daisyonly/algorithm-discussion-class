package fre4;

public class IntegertoRoman {

	public String intToRoman(int num) {
		String[] romanPieces = { "", "I", "II", "III", "IV", "V", "VI", "VII",
				"VIII", "IX", "", "X", "XX", "XXX", "XL", "L", "LX", "LXX",
				"LXXX", "XC", "", "C", "CC", "CCC", "CD", "D", "DC", "DCC",
				"DCCC", "CM", "", "M", "MM", "MMM", "MMMM" };
		return romanPieces[num / 1000 + 30]
				+ romanPieces[(num / 100) % 10 + 20]
				+ romanPieces[(num / 10) % 10 + 10] + romanPieces[num % 10];

	}

	public String intToRoman2(int num) {
		String str = "";
		String symbol[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };
		int value[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		for (int i = 0; num != 0; ++i) {
			while (num >= value[i]) {
				num -= value[i];
				str += symbol[i];
			}
		}
		return str;
	}
}
