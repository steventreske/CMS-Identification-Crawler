package Parser;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ValueObjects.CMS;
import ValueObjects.Cookie;
import ValueObjects.Site;
import parser.ExpressionEngineIdentifier;
import parser.ICMSIdentifier;

public class ExpessionEngineIdentifierTest {
	@Test
	public void ShouldReturnUnbekanntesCMSWhenThereIsNoHintForExpessionEngine(){
		// Arrange
		String html = "<html><head></head><body></body></html>";
		ICMSIdentifier expressionEngine = new ExpressionEngineIdentifier(new Site(html, null));
		
		// Act
		CMS result = expressionEngine.identify();
		
		// Assert
		Assert.assertEquals(CMS.UnbekanntesCMS, result);
	}
	
	@Test
	public void ShouldReturnExpressionEngineWhenCookieNameStartsWithExp_(){
		// Arrange
		List<Cookie> cookies = new ArrayList<>();
		cookies.add(new Cookie("exp_blabla", "blabla"));
		ICMSIdentifier expressionEngine = new ExpressionEngineIdentifier(new Site("", cookies));
				
		// Act
		CMS result = expressionEngine.identify();
			
		// Assert
		Assert.assertEquals(CMS.ExpressionEngine, result); 
	}
	
	@Test
	public void ShouldReturnUnbekanntesCMSWhenCookieNameIsUnknown(){
		// Arrange
		List<Cookie> cookies = new ArrayList<>();
		cookies.add(new Cookie("sdfasdfasdf", "blabla"));
		ICMSIdentifier expressionEngine = new ExpressionEngineIdentifier(new Site("", cookies));
				
		// Act
		CMS result = expressionEngine.identify();
			
		// Assert
		Assert.assertEquals(CMS.UnbekanntesCMS, result); 
	}
}
