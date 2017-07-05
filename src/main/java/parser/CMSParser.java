package parser;

import ValueObjects.CMS;

public class CMSParser implements ICMSIdentifier {
	private ICMSIdentifier[] parsers;
	
	public CMSParser(ICMSIdentifier... parsers) {
		if (parsers == null || parsers.length == 0) {
			throw new IllegalArgumentException("Parser collection cant be null!");
		}
		
		this.parsers = parsers;
	}

	public CMS identify() {	
		for (ICMSIdentifier parser : parsers) {
			CMS result = parser.identify();
			if (result.isUnbekannt() == false) {
				return result;
			}
		}
		
		return CMS.UnbekanntesCMS;
	}

}
