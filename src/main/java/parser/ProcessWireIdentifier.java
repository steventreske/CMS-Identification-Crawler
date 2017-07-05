package parser;

import ValueObjects.CMS;
import ValueObjects.Site;
import helper.IdentifierHelper;

public class ProcessWireIdentifier implements ICMSIdentifier {
	private Site site;
	
	public ProcessWireIdentifier(Site site) {
		this.site = site;
	}

	@Override
	public CMS identify() {
		if (this.isProcessWireInJavaScriptInlineScript()) {
			return CMS.ProcessWire;
		}
		return CMS.UnbekanntesCMS;
	}

	private boolean isProcessWireInJavaScriptInlineScript() {
		return IdentifierHelper.FindSomethingInInlineJavaScript(site, "ProcessWire");
	}

}
