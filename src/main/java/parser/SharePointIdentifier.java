package parser;

import ValueObjects.CMS;
import ValueObjects.Site;

public class SharePointIdentifier implements ICMSIdentifier {
	private Site site;
	public SharePointIdentifier(Site site) {
		this.site = site;
	}

	@Override
	public CMS identify() {
		if (this.isSharePointCommentFound()) {
			return CMS.SharePoint;
		}
		return CMS.UnbekanntesCMS;
	}

	private boolean isSharePointCommentFound() {
		String sharePointTitleComment = "<!-- page title - overridden by asp:content on pages or page layouts -->";
		String sharePointManagerComment = "<!-- page manager interacts with script and the sharepoint object model -->";
		String sharePointJavaScriptComment = "<!-- load SharePoint javascript -->";
		return 	this.containsComment(sharePointTitleComment) ||
				this.containsComment(sharePointManagerComment) ||
				this.containsComment(sharePointJavaScriptComment);
	}
	
	private boolean containsComment(String comment){
		return this.site.getHtml().contains(comment);
	}

}
