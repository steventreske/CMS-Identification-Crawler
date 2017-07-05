package parser;

import org.junit.Assert;
import org.junit.Test;

import ValueObjects.CMS;
import ValueObjects.Site;

public class SharePointIdentifierTest {
	@Test
	public void ShouldReturnUnbekanntesCMSWhenThereIsNoHintForErgotec(){
		// Arrange
		String html = "<html><head></head><body></body></html>";
		ICMSIdentifier sharepoint = new SharePointIdentifier(new Site(html, null));
		
		// Act
		CMS result = sharepoint.identify();
		
		// Assert
		Assert.assertEquals(CMS.UnbekanntesCMS, result);
	}
	
	@Test
	public void ShouldReturnSharPointWhenSharePointTitleCommentIsFound(){
		// Arrange
		String html = "<!-- page title - overridden by asp:content on pages or page layouts -->";
		ICMSIdentifier sharepoint = new SharePointIdentifier(new Site(html, null));
		
		// Act und Assert
		ShouldBeSharePoint(sharepoint);
	}
	
	@Test
	public void ShouldReturnSharPointWhenSharePointManagerCommentIsFound(){
		// Arrange
		String html = "<!-- page manager interacts with script and the sharepoint object model -->";
		ICMSIdentifier sharepoint = new SharePointIdentifier(new Site(html, null));
		
		// Act und Assert
		ShouldBeSharePoint(sharepoint);
	}
	
	@Test
	public void ShouldReturnSharPointWhenSharePointJavaScriptCommentIsFound(){
		// Arrange
		String html = "<!-- load SharePoint javascript -->";
		ICMSIdentifier sharepoint = new SharePointIdentifier(new Site(html, null));
		
		// Act und Assert
		ShouldBeSharePoint(sharepoint);
	}

	private void ShouldBeSharePoint(ICMSIdentifier sharepoint) {
		// Act
		CMS result = sharepoint.identify();
		
		// Assert
		Assert.assertEquals(CMS.SharePoint, result);
	}
}
