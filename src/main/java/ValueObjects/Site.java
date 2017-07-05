package ValueObjects;

import java.util.List;

public class Site {
	private String html;
	private List<Cookie> cookies;
	
	public Site(String html, List<Cookie> cookies) {
		this.html = html;
		this.cookies = cookies;
	}

	public String getHtml() {
		return html;
	}

	public List<Cookie> getCookies() {
		return cookies;
	}
}
