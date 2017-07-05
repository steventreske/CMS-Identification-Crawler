package Parser;

import org.junit.Assert;
import org.junit.Test;

import ValueObjects.CMS;
import ValueObjects.Site;
import parser.DrupalIdentifier;
import parser.ICMSIdentifier;

public class DrupalIdentifierTest {
	@Test
	public void ShouldReturnUnbekanntesCMSWhenThereIsNoHintForTypo3(){
		// Arrange
		String html = "<html><head></head><body></body></html>";
		ICMSIdentifier drupal = new DrupalIdentifier(new Site(html, null));
		
		// Act
		CMS result = drupal.identify();
		
		// Assert
		Assert.assertEquals(CMS.UnbekanntesCMS, result);
	}
	
	@Test
	public void ShouldReturnDrupalWhenThereIsDrupalWireInJavaScript(){
		// Arrange
		String html = "<script type=\'text/javascript\'>Drupal</script>";
		ICMSIdentifier drupal = new DrupalIdentifier(new Site(html, null));
		
		// Act
		CMS result = drupal.identify();
		
		// Assert
		Assert.assertEquals(CMS.Drupal, result);
	}
	
	@Test
	public void ShouldReturnDrupalWhenThereIsDrupalInJavaScriptSrcPath(){
		// Arrange
		String html = "<script type=\"text/javascript\" src=\"drupal\"></script>";
		ICMSIdentifier drupal = new DrupalIdentifier(new Site(html, null));
		
		// Act
		CMS result = drupal.identify();
		
		// Assert
		Assert.assertEquals(CMS.Drupal, result);
	}
}
