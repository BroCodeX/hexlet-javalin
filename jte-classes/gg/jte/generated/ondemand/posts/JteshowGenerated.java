package gg.jte.generated.ondemand.posts;
import exercise.dto.posts.PostPage;
import exercise.util.NamedRoutes;
public final class JteshowGenerated {
	public static final String JTE_NAME = "posts/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,6,6,9,9,9,13,13,13,15,16,16,16,16,16,16,16,16,16,17,19,19,19,20,20,20,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, PostPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <main>\n            <div class=\"mx-auto p-4 py-md-5\">\n                <h1>");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getPost().getName());
				jteOutput.writeContent("</h1>\n            </div>\n\n            <div class=\"mx-auto p-4 py-md-5\">\n                ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(page.getPost().getBody());
				jteOutput.writeContent("\n            </div>\n            ");
				jteOutput.writeContent("\n            <a");
				var __jte_html_attribute_0 = NamedRoutes.editPost(page.getPost().getId());
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">Edit this post</a>\n            ");
				jteOutput.writeContent("\n        </main>\n    ");
			}
		});
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		PostPage page = (PostPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
