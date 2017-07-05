package Parser;

import org.junit.Assert;
import org.junit.Test;

import ValueObjects.CMS;
import ValueObjects.Site;
import parser.ICMSIdentifier;
import parser.ProcessWireIdentifier;

public class ProcessWireIdentifierTest {
	@Test
	public void ShouldReturnUnbekanntesCMSWhenThereIsNoHintForTypo3(){
		// Arrange
		String html = "<html><head></head><body></body></html>";
		ICMSIdentifier processWire = new ProcessWireIdentifier(new Site(html, null));
		
		// Act
		CMS result = processWire.identify();
		
		// Assert
		Assert.assertEquals(CMS.UnbekanntesCMS, result);
	}
	
	@Test
	public void ShouldReturnProcessWireWhenThereIsProcessWireInJavaScript(){
		// Arrange
		String html = "<script type=\'text/javascript\'>ProcessWire</script>";
		ICMSIdentifier processWire = new ProcessWireIdentifier(new Site(html, null));
		
		// Act
		CMS result = processWire.identify();
		
		// Assert
		Assert.assertEquals(CMS.ProcessWire, result);
	}
}
