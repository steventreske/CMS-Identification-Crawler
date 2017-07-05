package parser;
import ValueObjects.CMS;
import ValueObjects.Site;
import helper.IdentifierHelper;

public class DrupalIdentifier implements ICMSIdentifier {
	private Site site;
	
	public DrupalIdentifier(Site site) {
		this.site = site;
	}

	@Override
	public CMS identify() {
		if (this.isDrupalInJavaScriptInlineScript()) {
			return CMS.Drupal;
		}
		
		if (this.isDrupalFoundInJavaScriptSrc()) {
			return CMS.Drupal;
		}
		return CMS.UnbekanntesCMS;
	}

	private boolean isDrupalFoundInJavaScriptSrc() {
		return IdentifierHelper.FindSomethingInJavaScriptSrc(site, "drupal");
	}

	private boolean isDrupalInJavaScriptInlineScript() {
		return IdentifierHelper.FindSomethingInInlineJavaScript(site, "Drupal");
	}
}
