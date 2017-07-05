package main;

import java.io.IOException;
import java.net.MalformedURLException;

import ValueObjects.Site;
import helper.SiteParser;
import parser.CMSParser;
import parser.ContanoIdentifier;
import parser.DrupalIdentifier;
import parser.EgotecIdentifier;
import parser.ExpressionEngineIdentifier;
import parser.ICMSIdentifier;
import parser.ImperiaIdentifier;
import parser.OpenCMSIdentifier;
import parser.ProcessWireIdentifier;
import parser.PyroCmsIdentifier;
import parser.SharePointIdentifier;
import parser.Typo3Identifier;

public class Programm {

	public static void main(String[] args) throws MalformedURLException, IOException {
		String url = "https://www.adk-bw.de/";
		Site site = new SiteParser(url).parse();
		ICMSIdentifier parser = new CMSParser(
				new ContanoIdentifier(site),
				new DrupalIdentifier(site),
				new EgotecIdentifier(site),
				new ExpressionEngineIdentifier(site),
				new ImperiaIdentifier(site),
				new OpenCMSIdentifier(site),
				new ProcessWireIdentifier(site),
				new PyroCmsIdentifier(site),
				new SharePointIdentifier(site),
				new Typo3Identifier(site)
		);
		
		System.out.println(parser.identify());
	}

}
