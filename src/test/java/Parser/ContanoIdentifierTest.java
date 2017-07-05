package Parser;

import org.junit.Assert;
import org.junit.Test;

import ValueObjects.CMS;
import ValueObjects.Site;
import parser.ContanoIdentifier;
import parser.ICMSIdentifier;

public class ContanoIdentifierTest {
	@Test
	public void ShouldReturnUnbekanntesCMSWhenThereIsNoHintForContano(){
		// Arrange
		String html = "<html><head></head><body></body></html>";
		ICMSIdentifier contano = new ContanoIdentifier(new Site(html, null));
		
		// Act
		CMS result = contano.identify();
		
		// Assert
		Assert.assertEquals(CMS.UnbekanntesCMS, result);
	}
	
	@Test
	public void ShouldReturnContanoWhenThereIsAContinueComment(){
		// Arrange
		String html = "<!-- indexer::continue -->";
		ICMSIdentifier contano = new ContanoIdentifier(new Site(html, null));
		
		// Act
		CMS result = contano.identify();
		
		// Assert
		Assert.assertEquals(CMS.Contano, result);
	}
	
	@Test
	public void ShouldReturnContanoWhenThereIsAStopComment(){
		// Arrange
		String html = "<!-- indexer::stop -->";
		ICMSIdentifier contano = new ContanoIdentifier(new Site(html, null));
		
		// Act
		CMS result = contano.identify();
		
		// Assert
		Assert.assertEquals(CMS.Contano, result);
	}
}
