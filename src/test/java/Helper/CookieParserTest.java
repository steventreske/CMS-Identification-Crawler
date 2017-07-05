package Helper;

import org.junit.Test;

import ValueObjects.Cookie;
import helper.CookieParser;
import org.junit.Assert;

public class CookieParserTest {
	@Test
	public void shouldProduceCookieWithName(){
		// Arrange
		String cookieString = "testcookie=testvalue; expires=Mon, 03-Jul-2017 20:37:38 GMT; path=/; httponly";

		// Act
		Cookie result = new CookieParser(cookieString).parse();
		
		// Assert
		Assert.assertEquals("testcookie", result.getName());
	}
	
	@Test
	public void shouldProduceCookieWithValue(){
		// Arrange
		String cookieString = "testcookie=testvalue; expires=Mon, 03-Jul-2017 20:37:38 GMT; path=/; httponly";

		// Act
		Cookie result = new CookieParser(cookieString).parse();
		
		// Assert
		Assert.assertEquals("testvalue", result.getValue());
	}
}
