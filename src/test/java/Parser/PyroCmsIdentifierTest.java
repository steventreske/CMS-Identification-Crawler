package Parser;

import org.junit.Assert;
import org.junit.Test;

import ValueObjects.CMS;
import ValueObjects.Site;
import parser.ICMSIdentifier;
import parser.PyroCmsIdentifier;

public class PyroCmsIdentifierTest {
	@Test
	public void ShouldReturnUnbekanntesCMSWhenThereIsNoHintForPyroCms(){
		// Arrange
		String html = "<html><head></head><body></body></html>";
		ICMSIdentifier pyroCms = new PyroCmsIdentifier(new Site(html, null));
		
		// Act
		CMS result = pyroCms.identify();
		
		// Assert
		Assert.assertEquals(CMS.UnbekanntesCMS, result);
	}
	
	@Test
	public void ShouldReturnPyroCMSWhenCSSClassPyroImageIsFound(){
		// Arrange
		String html = "<img class=\"pyro-image\" src=\"https://www.arrrWuff.de\" width=\"374\" />";
		ICMSIdentifier pyroCms = new PyroCmsIdentifier(new Site(html, null));
		
		// Act
		CMS result = pyroCms.identify();
		
		// Assert
		Assert.assertEquals(CMS.PyroCMS, result);
	}
}
