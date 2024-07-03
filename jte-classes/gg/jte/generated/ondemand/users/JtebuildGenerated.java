package gg.jte.generated.ondemand.users;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "users/build.jte";
	public static final int[] JTE_LINE_INFO = {26,26,26,26,26,26,26,26,26,26,26};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("<form action=\"/users\" method=\"post\">\n    <div>\n        <label>\n            First Name\n            <input type=\"text\" name=\"firstName\" />\n        </label>\n    </div>\n    <div>\n        <label>\n            Last Name\n            <input type=\"text\" name=\"lastName\" />\n        </label>\n    </div>\n    <div>\n        <label>\n            Email\n            <input type=\"email\" required name=\"email\" />\n        </label>\n    </div>\n    <div>\n        <label>\n            Password\n            <input type=\"password\" required name=\"password\" />\n        </label>\n    </div>\n    <input type=\"submit\" value=\"Submit\" />\n</form>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
