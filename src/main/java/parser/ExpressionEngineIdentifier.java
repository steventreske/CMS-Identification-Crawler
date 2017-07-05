package parser;

import ValueObjects.CMS;
import ValueObjects.Cookie;
import ValueObjects.Site;

public class ExpressionEngineIdentifier implements ICMSIdentifier {
	private Site site;
	
	public ExpressionEngineIdentifier(Site site) {
		this.site = site;
	}

	@Override
	public CMS identify() {
		if (this.containsExpressionEngineCookie()) {
			return CMS.ExpressionEngine;
		}
		return CMS.UnbekanntesCMS;
	}

	private boolean containsExpressionEngineCookie() {
		if (site.getCookies() == null) {
			return false;
		}
	
		for (Cookie cookie : this.site.getCookies()) {
			if (this.cookiePraefixIsExp_(cookie)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean cookiePraefixIsExp_(Cookie cookie){
		String cookiePraefix = cookie.getName().substring(0, 4);
		return cookiePraefix.matches("exp_");
	}

}
