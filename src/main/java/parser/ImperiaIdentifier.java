package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ValueObjects.CMS;
import ValueObjects.Site;

public class ImperiaIdentifier implements ICMSIdentifier {
	private Site site;
	public ImperiaIdentifier(Site site) {
		this.site = site;
	}

	@Override
	public CMS identify() {
		if (this.isImperiaInSrc()) {
			return CMS.Imperia;
		}
		
		if (this.isImperiaCommentFound()) {
			return CMS.Imperia;
		}
		return CMS.UnbekanntesCMS;
	}

	private boolean isImperiaCommentFound() {
		return this.site.getHtml().contains("<!-- IMPERIA");
	}

	private boolean isImperiaInSrc() {
		Document doc = Jsoup.parse(this.site.getHtml());
		Elements elements = doc.getAllElements();
		
		for (Element element : elements) {
			if (element.attr("src").contains("imperia")) {
				return true;
			}
		}
		
		return false;
	}

}
