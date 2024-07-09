package gg.jte.generated.ondemand.posts;
import exercise.dto.posts.PostsPage;
import exercise.util.NamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "posts/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,6,6,12,12,12,12,12,12,12,12,12,16,16,19,19,19,22,22,22,22,22,22,22,22,22,22,22,22,25,25,25,28,28,32,32,32,33,33,33,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, PostsPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <div class=\"mx-auto p-4 py-md-5\">\n            <main>\n                <h1>Все посты</h1>\n\n                <div class=\"mb-3\">\n                    <a");
				var __jte_html_attribute_0 = NamedRoutes.buildPostPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">Создать новый пост</a>\n                </div>\n\n                <table class=\"table table-striped\">\n                    ");
				for (var post : page.getPosts()) {
					jteOutput.writeContent("\n                        <tr>\n                            <td>\n                                ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(post.getId());
					jteOutput.writeContent("\n                            </td>\n                            <td>\n                                <a");
					var __jte_html_attribute_1 = NamedRoutes.postPath(post.getId());
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_1);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(post.getName());
					jteOutput.writeContent("</a>\n                            </td>\n                            <td>\n                                ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(post.getBody());
					jteOutput.writeContent("\n                            </td>\n                        </tr>\n                    ");
				}
				jteOutput.writeContent("\n                </table>\n            </main>\n        </div>\n    ");
			}
		});
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		PostsPage page = (PostsPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
