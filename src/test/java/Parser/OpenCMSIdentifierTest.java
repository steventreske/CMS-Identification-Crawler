package Parser;

import org.junit.Assert;
import org.junit.Test;

import ValueObjects.CMS;
import ValueObjects.Site;
import parser.ICMSIdentifier;
import parser.OpenCMSIdentifier;

public class OpenCMSIdentifierTest {
	@Test
	public void ShouldReturnUnbekanntesCMSWhenThereIsNoHintForErgotec(){
		// Arrange
		String html = "<html><head></head><body></body></html>";
		ICMSIdentifier openCms = new OpenCMSIdentifier(new Site(html, null));
		
		// Act
		CMS result = openCms.identify();
		
		// Assert
		Assert.assertEquals(CMS.UnbekanntesCMS, result);
	}
	
	@Test
	public void ShouldReturnErgotecWhenMetaTagIsFound(){
		// Arrange
		String html = "<meta name=\"system\" content=\"OpenCms 10.5.x-643563\" />";
		ICMSIdentifier openCms = new OpenCMSIdentifier(new Site(html, null));
		
		// Act
		CMS result = openCms.identify();
		
		// Assert
		Assert.assertEquals(CMS.OpenCMS, result);
	}
}
