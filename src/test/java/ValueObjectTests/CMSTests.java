package ValueObjectTests;

import org.junit.Assert;
import org.junit.Test;

import ValueObjects.CMS;

public class CMSTests {
	@Test
	public void shouldReturnTrueWhenCMSIsUnbekannt(){
		// Arrange
		CMS cms = CMS.UnbekanntesCMS;
		
		// Act 
		boolean result = cms.isUnbekannt();
		
		// Assert
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void shouldReturnFalseWhenCMSIsNotUnbekannt(){
		// Arrange
		CMS cms = CMS.Typo3;
		
		// Act 
		boolean result = cms.isUnbekannt();
		
		// Assert
		Assert.assertEquals(false, result);
	}
}
