package parser;

import ValueObjects.CMS;
import ValueObjects.Site;

public class ContanoIdentifier implements ICMSIdentifier {
	private Site site;
	
	public ContanoIdentifier(Site site) {
		this.site = site;
	}

	@Override
	public CMS identify() {
		if (this.containsContanoComment()) {
			return CMS.Contano;
		}
		return CMS.UnbekanntesCMS;
	}

	private boolean containsContanoComment() {
		String continueComment = "<!-- indexer::continue -->";
		String stopComment = "<!-- indexer::stop -->";
		
		return this.site.getHtml().contains(continueComment) ||
			   this.site.getHtml().contains(stopComment);
	}

}
