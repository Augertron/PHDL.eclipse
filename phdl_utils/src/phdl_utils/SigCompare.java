package phdl_utils;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * This Comparator class is used to compare vector pins that have numeric indexes inclosed in <>
 * brackets. In other words std_logic_vectors.
 */
class SigCompare implements Comparator<Object> {
	public int compare(Object o1, Object o2) {
		String i1 = (String) o1;
		String i2 = (String) o2;
		Pattern IndexPat = Pattern.compile("<[0-9]+>");
		Matcher IndexPatMatcher_o1 = IndexPat.matcher(i1);
		Matcher IndexPatMatcher_o2 = IndexPat.matcher(i2);
		// If it is a vector signal extract the vector indexes and compare them.
		if ((IndexPatMatcher_o1.find()) && (IndexPatMatcher_o2.find())) {
			Integer Index_o1 = Integer.parseInt(i1.substring(IndexPatMatcher_o1.start() + 1,
				IndexPatMatcher_o1.end() - 1));
			Integer Index_o2 = Integer.parseInt(i2.substring(IndexPatMatcher_o2.start() + 1,
				IndexPatMatcher_o2.end() - 1));
			return -Index_o1.compareTo(Index_o2);
		} else {
			return -i1.compareTo(i2);
		}
	}
}
