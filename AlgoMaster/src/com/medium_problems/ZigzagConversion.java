package com.medium_problems;

public class ZigzagConversion {
	public String convert(String s, int numRows) {
		if (numRows == 1 || s.length() <= numRows)
			return s;
		StringBuilder[] sb = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i++)
			sb[i] = new StringBuilder();
		int row = 0, step = 1;
		for (char c : s.toCharArray()) {
			sb[row].append(c);
			if (row == 0)
				step = 1;
			else if (row == numRows - 1)
				step = -1;
			row += step;
		}
		StringBuilder res = new StringBuilder();
		for (StringBuilder b : sb)
			res.append(b);
		return res.toString();
	}

	public static void main(String[] args) {
		ZigzagConversion sol = new ZigzagConversion();
		String s1 = "PAYPALISHIRING";
		System.out.println(sol.convert(s1, 3)); // Output: "PAHNAPLSIIGYIR"
		System.out.println(sol.convert(s1, 4)); // Output: "PINALSIGYAHRPI"
	}
}
