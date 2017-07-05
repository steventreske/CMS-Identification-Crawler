package Parser;

import org.junit.Assert;
import org.junit.Test;

import ValueObjects.CMS;
import ValueObjects.Site;
import parser.ICMSIdentifier;
import parser.Typo3Identifier;

public class Typo3IdentifierTest {
	@Test
	public void ShouldReturnUnbekanntesCMSWhenThereIsNoHintForTypo3(){
		// Arrange
		String html = "<html><head></head><body></body></html>";
		ICMSIdentifier typo3 = new Typo3Identifier(new Site(html, null));
		
		// Act
		CMS result = typo3.identify();
		
		// Assert
		Assert.assertEquals(CMS.UnbekanntesCMS, result);
	}
	
	@Test
	public void ShouldReturnTypo3WhenTypo3IsFoundInHref(){
		// Arrange
		String html = "<link rel=\"shortcut icon\" href=\"/typo3conf/ext/sb_config7/Resources/Public/Icons/favicon.ico\" type=\"image/x-icon\">";
		ICMSIdentifier typo3 = new Typo3Identifier(new Site(html, null));
		
		// Act
		CMS result = typo3.identify();
		
		// Assert
		Assert.assertEquals(CMS.Typo3, result);
	}
	
	@Test
	public void ShouldReturnTypo3WhenTypo3CommentIsFound(){
		// Arrange
		String html = "	<html><head><!-- " +
					  "	This website is powered by TYPO3 - inspiring people to share! " +
					  "	TYPO3 is a free open source Content Management Framework initially created by Kasper Skaarhoj and licensed under GNU/GPL. " +
					  "	TYPO3 is copyright 1998-2017 of Kasper Skaarhoj. Extensions are copyright of their respective owners. " +
					  "	Information and contribution at https://typo3.org/ " +
					  " --></head><body></body></html>";
		ICMSIdentifier typo3 = new Typo3Identifier(new Site(html, null));
		
		// Act
		CMS result = typo3.identify();
		
		// Assert
		Assert.assertEquals(CMS.Typo3, result);
	}
	
	@Test
	public void ShouldReturnTypo3WhenFileadminIsFoundInScr(){
		// Arrange
		String html = "<img src=\"fileadmin/_processed_/a/f/csm_2017-06-28_Button_IK2017_ad5a007035.jpg\" width=\"1260\" height=\"350\"  class=\"img-responsive\"  alt=\"\" >";
		ICMSIdentifier typo3 = new Typo3Identifier(new Site(html, null));
				
		// Act
		CMS result = typo3.identify();
			
		// Assert
		Assert.assertEquals(CMS.Typo3, result);
	}
}
