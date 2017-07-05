package parser;

import ValueObjects.CMS;
import ValueObjects.Site;
import helper.IdentifierHelper;

public class OpenCMSIdentifier implements ICMSIdentifier {
	private Site site;
	
	public OpenCMSIdentifier(Site site) {
		this.site = site;
	}

	@Override
	public CMS identify() {
		if (this.isMetaGeneratorTagFound()) {
			return CMS.OpenCMS;
		}
		return CMS.UnbekanntesCMS;
	}
	
	private boolean isMetaGeneratorTagFound() {
		String metaContent = IdentifierHelper.GetMetaSystemContent(this.site);
		return metaContent != null && metaContent.contains("OPENCMS");
	}
}
