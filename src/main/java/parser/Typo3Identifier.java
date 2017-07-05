package parser;

import java.util.function.Predicate;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ValueObjects.CMS;
import ValueObjects.Site;

public class Typo3Identifier implements ICMSIdentifier {
	Predicate<Element> fileadmin = element -> element.attr("src").contains("fileadmin");
	Predicate<Element> typo3 = element -> element.attr("href").contains("typo3");

	
	private Document doc;
	private Site site;
	
	public Typo3Identifier(Site site) {
		this.site = site;
		this.doc = Jsoup.parse(site.getHtml());
	}

	public CMS identify() {
		if (this.containsTypo3Comment()) {
			return CMS.Typo3;
		}
		
		if (this.contains(this.typo3)) {
			return CMS.Typo3;
		}
		
		if (this.contains(this.fileadmin)) {
			return CMS.Typo3;
		}
		
		return CMS.UnbekanntesCMS;
	}
	
	private boolean contains(Predicate<Element> condition){
		Elements elements = doc.getAllElements();
		for (Element element : elements) {
			if (condition.test(element)) {
				return true;
			}
		}
		return false;
	}

	private boolean containsTypo3Comment() {
		String typo3Comment = "<!-- " +
				  "	This website is powered by TYPO3 - inspiring people to share! " +
				  "	TYPO3 is a free open source Content Management Framework initially created by Kasper Skaarhoj and licensed under GNU/GPL. " +
				  "	TYPO3 is copyright 1998-2017 of Kasper Skaarhoj. Extensions are copyright of their respective owners. " +
				  "	Information and contribution at https://typo3.org/ " +
				  " -->";
		
		return this.site.getHtml().contains(typo3Comment);
	}


}
