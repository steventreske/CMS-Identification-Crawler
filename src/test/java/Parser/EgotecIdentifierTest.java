package Parser;

import org.junit.Assert;
import org.junit.Test;

import ValueObjects.CMS;
import ValueObjects.Site;
import parser.EgotecIdentifier;
import parser.ICMSIdentifier;

public class EgotecIdentifierTest {
	@Test
	public void ShouldReturnUnbekanntesCMSWhenThereIsNoHintForErgotec(){
		// Arrange
		String html = "<html><head></head><body></body></html>";
		ICMSIdentifier ergotec = new EgotecIdentifier(new Site(html, null));
		
		// Act
		CMS result = ergotec.identify();
		
		// Assert
		Assert.assertEquals(CMS.UnbekanntesCMS, result);
	}
	
	@Test
	public void ShouldReturnErgotecWhenMetaTagIsFound(){
		// Arrange
		String html = "<meta name=\"generator\" content=\"EGOTEC 16.6.5 85699/www.EGOTEC.com\" />";
		ICMSIdentifier ergotec = new EgotecIdentifier(new Site(html, null));
		
		// Act
		CMS result = ergotec.identify();
		
		// Assert
		Assert.assertEquals(CMS.Egotec, result);
	}
}
