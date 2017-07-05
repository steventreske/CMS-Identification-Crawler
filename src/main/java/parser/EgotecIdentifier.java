package parser;

import ValueObjects.CMS;
import ValueObjects.Site;
import helper.IdentifierHelper;

public class EgotecIdentifier implements ICMSIdentifier {
	private Site site;
	
	public EgotecIdentifier(Site site) {
		this.site = site;
	}

	@Override
	public CMS identify() {
		if (this.isMetaGeneratorTagFound()) {
			return CMS.Egotec;
		}
		return CMS.UnbekanntesCMS;
	}

	private boolean isMetaGeneratorTagFound() {
		String metaContent = IdentifierHelper.GetMetaGeneratorContent(this.site);
		return metaContent != null && metaContent.contains("EGOTEC");
	}

}
