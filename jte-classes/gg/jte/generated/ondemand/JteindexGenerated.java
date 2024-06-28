package gg.jte.generated.ondemand;
import org.example.hexlet.DTO;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,8,8,8,8,9,9,11,11,12,12,14,14,14,14,14,14,14,15,15,15,17,17,18,18,20,20,20,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, DTO push) {
		jteOutput.writeContent("\n<html>\n<head>\n    <title>Хекслет</title>\n</head>\n<body>\n<h1>");
		jteOutput.setContext("h1", null);
		jteOutput.writeUserContent(push.getHeader());
		jteOutput.writeContent("</h1>\n");
		if (push.getModels().isEmpty()) {
			jteOutput.writeContent("\n    <p>Пока не добавлено ни одного курса</p>\n");
		} else {
			jteOutput.writeContent("\n    ");
			for (var model : push.getModels()) {
				jteOutput.writeContent("\n        <div>\n            <h2><a href=\"/courses/");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(model.getId());
				jteOutput.setContext("a", null);
				jteOutput.writeContent("\">");
				jteOutput.setContext("a", null);
				jteOutput.writeUserContent(model.getName());
				jteOutput.writeContent("</a></h2>\n            <p>");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(model.getDescription());
				jteOutput.writeContent("</p>\n        </div>\n    ");
			}
			jteOutput.writeContent("\n");
		}
		jteOutput.writeContent("\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		DTO push = (DTO)params.get("push");
		render(jteOutput, jteHtmlInterceptor, push);
	}
}
