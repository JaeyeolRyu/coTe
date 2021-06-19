package coTe.YGY;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class YGY2 {

	public static void main(String[] args) {

		String S = "admin  -wx 29 Sep 1983        833 source.h\nadmin  r-x 23 Jun 2003     854016 blockbuster.mpeg\nadmin  --x 02 Jul 1997        821 delete-this.py\nadmin  -w- 15 Feb 1971      23552 library.dll\nadmin  --x 15 May 1979  645922816 logs.zip\njane   --x 04 Dec 2010      93184 old-photos.rar\njane   -w- 08 Feb 1982  681574400 important.java\nadmin  rwx 26 Dec 1952   14680064 to-do-list.txt";

		String s = solution(S);
		System.out.println(s);
	}

	public static String solution(String S) {
		String answer = "NO FILES";

		List<String> possibleFile = new ArrayList<String>();
		Map<String, Integer> monthMap = new HashMap<String, Integer>();
		monthMap.put("Jan", 1);
		monthMap.put("Feb", 2);
		monthMap.put("Mar", 3);
		monthMap.put("Apr", 4);
		monthMap.put("May", 5);
		monthMap.put("Jun", 6);
		monthMap.put("Jul", 7);
		monthMap.put("Aug", 8);
		monthMap.put("Sep", 9);
		monthMap.put("Oct", 10);
		monthMap.put("Nov", 11);
		monthMap.put("Dec", 12);

		int maxSize = 14 * (int) Math.pow(2, 20);

		String[] fileArr = S.split("\n");

		for (int i = 0; i < fileArr.length; i++) {

			String owner = fileArr[i].substring(0, 6).replace(" ", "");
			char perm = fileArr[i].charAt(9);
			int size = Integer.parseInt(fileArr[i].substring(23, 33).replace(" ", ""));

			if (owner.equals("admin") && perm == 'x' && size < maxSize) {

				String date = fileArr[i].substring(11, 22);
				possibleFile.add(date);

			}

		}

		int minYear = Integer.MAX_VALUE;
		int minMonth = Integer.MAX_VALUE;
		int minDay = Integer.MAX_VALUE;

		for (int i = 0; i < possibleFile.size(); i++) {

			String[] file = possibleFile.get(i).split(" ");

			int year = Integer.parseInt(file[2]);
			int month = monthMap.get(file[1]);
			int day = Integer.parseInt(file[0]);

			if (year < minYear) {
				answer = possibleFile.get(i);
				minYear = year;
				minMonth = month;
				minDay = day;

			} else if (year == minYear) {

				if (month < minMonth) {
					answer = possibleFile.get(i);
					minYear = year;
					minMonth = month;
					minDay = day;

				} else if (month == minMonth) {

					if (day < minDay) {
						answer = possibleFile.get(i);
						minYear = year;
						minMonth = month;
						minDay = day;

					}

				}

			}

		}

		return answer;

	}
}