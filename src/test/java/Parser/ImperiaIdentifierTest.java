package Parser;

import org.junit.Assert;
import org.junit.Test;

import ValueObjects.CMS;
import ValueObjects.Site;
import parser.ICMSIdentifier;
import parser.ImperiaIdentifier;

public class ImperiaIdentifierTest {
	@Test
	public void ShouldReturnUnbekanntesCMSWhenThereIsNoHintForImperia(){
		// Arrange
		String html = "<html><head></head><body></body></html>";
		ICMSIdentifier imperia = new ImperiaIdentifier(new Site(html, null));
		
		// Act
		CMS result = imperia.identify();
		
		// Assert
		Assert.assertEquals(CMS.UnbekanntesCMS, result);
	}
	
	@Test
	public void ShouldReturnImperiaWhenImperiaIsFoundInSrc(){
		// Arrange
		String html = "<img src=\"/imperia/md/images/presse/fotos/2016/tansania_gewuerze.jpg\" />";
		ICMSIdentifier imperia = new ImperiaIdentifier(new Site(html, null));
		
		// Act
		CMS result = imperia.identify();
		
		// Assert
		Assert.assertEquals(CMS.Imperia, result);
	}
	
	@Test
	public void ShouldReturnImperiaWhenImperiaCommentIsFound(){
		// Arrange
		String html = "<!-- IMPERIA";
		ICMSIdentifier imperia = new ImperiaIdentifier(new Site(html, null));
		
		// Act
		CMS result = imperia.identify();
		
		// Assert
		Assert.assertEquals(CMS.Imperia, result);
	}
}
