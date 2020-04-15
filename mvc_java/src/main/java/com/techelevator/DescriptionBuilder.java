package com.techelevator;

public class DescriptionBuilder {
	/*

	 * 
	 * <h4>Format</h4> <p>Single Elimination 1v1, 3 Stock, No items</p>
	 * 
	 * </div> <div class="tournamentRules"> <h2>Rules</h2> <ul> LIST ITEMS
	 * </ul> </div> 
	 * 
	 * <div class="tournamentPrizes"> <h2>Prizes</h2>
	 * 
	 * <ol> <li>Bragging rights, maybe some money</li> <li>You didn't get third</li>
	 * <li>You placed, so that's something</li> <li>Fourth place huh...</li> </ol>
	 * </div> <div class="tournamentSchedule"> <h2>Schedule</h2> --%>
	 */
	public static String formatTaggedDesc(String format, String rules, String prizes) {
		return "<h4>Format</h4> <p>" +format + "</p></div></div> <div class=\"tournamentRules\"> <h2>Rules</h2><p>"
				+ rules + "</p><div class=\"tournamentPrizes\"> <h2>Prizes</h2><p>" + prizes + "</p></div>";
		
	}
	
	public static String formatDesc(String format, String rules, String prizes) {
		return "Format: /n" + format + "/n/nRules:/n" + rules + "/n/nPrizes:/n";
		
	}
}
