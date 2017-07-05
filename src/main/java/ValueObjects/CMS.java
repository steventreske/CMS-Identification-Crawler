package ValueObjects;

public enum CMS{
	Contano,
	Drupal,
	Egotec,
	ExpressionEngine,
	Imperia,
	OpenCMS,
	ProcessWire,
	PyroCMS,
	UnbekanntesCMS,
	SharePoint,
	Typo3;
	
	public boolean isUnbekannt(){
		return this == CMS.UnbekanntesCMS;
	}
	
	@Override
	public String toString(){
		switch (this) {
		case Contano:
			return "Contano";
		case Drupal:
			return "Drupal";
		case Egotec:
			return "Egotec";
		case ExpressionEngine:
			return "ExpressionEngine";
		case Imperia:
			return "Imperia";
		case OpenCMS:
			return "OpenCMS";
		case ProcessWire:
			return "ProcessWire";
		case PyroCMS:
			return "Pyro CMS";
		case SharePoint:
			return "SharePoint";
		case Typo3:
			return "Typo3";
		case UnbekanntesCMS:
			return "Unbekanntes CMS";
		default:
			return "Unbekanntes CMS";
		}
	}
}