package gg.jte.generated.ondemand;
import exercise.util.NamedRoutes;
import exercise.dto.posts.MainPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,5,5,7,7,10,10,10,10,10,10,10,10,10,12,12,16,16,18,18,19,19,19,21,21,24,24,24,25,25,25,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage page) {
		jteOutput.writeContent("\n\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <div class=\"mx-auto p-4 py-md-5\">\n            <main>\n                <a");
				var __jte_html_attribute_0 = NamedRoutes.postsPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">Все посты</a>\n                <h1>Info about Cookie</h1>\n                ");
				if (!page.isVisited()) {
					jteOutput.writeContent("\n                    <div class=\"message\">\n                        Это сообщение показывается только один раз. Если вы хотите увидеть его снова, сотрите куки\n                    </div>\n                ");
				}
				jteOutput.writeContent("\n                <h1>Info about Session</h1>\n                ");
				if (page.getCurrentUser() != null) {
					jteOutput.writeContent("\n                    Добро пожаловать, ");
					jteOutput.setContext("main", null);
					jteOutput.writeUserContent(page.getCurrentUser());
					jteOutput.writeContent(".\n                    Чтобы разлогиниться, удалите куку JSESSIONID из браузера\n                ");
				}
				jteOutput.writeContent("\n            </main>\n        </div>\n    ");
			}
		}, null);
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage page = (MainPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
