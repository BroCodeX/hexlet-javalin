package gg.jte.generated.ondemand.posts;
import exercise.dto.posts.EditPostPage;
public final class JteeditGenerated {
	public static final String JTE_NAME = "posts/edit.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,5,5,6,6,9,9,10,10,11,11,11,12,12,13,13,16,16,19,19,19,19,23,23,23,24,24,24,24,24,24,24,24,24,30,30,30,30,30,30,30,30,30,35,35,35,40,40,40,41,41,41,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, EditPostPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    ");
				if (page.getErrors() != null) {
					jteOutput.writeContent("\n        <div class=\"mb-3\">\n            <ul>\n                ");
					for (var validator : page.getErrors().values()) {
						jteOutput.writeContent("\n                    ");
						for (var error : validator) {
							jteOutput.writeContent("\n                        <li>");
							jteOutput.setContext("li", null);
							jteOutput.writeUserContent(error.getMessage());
							jteOutput.writeContent("</li>\n                    ");
						}
						jteOutput.writeContent("\n                ");
					}
					jteOutput.writeContent("\n            </ul>\n        </div>\n    ");
				}
				jteOutput.writeContent("\n\n    <div class=\"mx-auto p-4 py-md-5\">\n        <form action=\"/posts/");
				jteOutput.setContext("form", "action");
				jteOutput.writeUserContent(page.getId());
				jteOutput.setContext("form", null);
				jteOutput.writeContent("\" method=\"post\">\n            <div class=\"mb-3\">\n                <label class=\"form-label\">\n                    ID\n                    <span>");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(page.getId());
				jteOutput.writeContent("</span>\n                    <input type=\"hidden\" class=\"form-control\" name=\"id\"");
				var __jte_html_attribute_0 = page.getId();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" readonly />\n                </label>\n            </div>\n            <div class=\"mb-3\">\n                <label class=\"form-label\">\n                    NAME\n                    <input type=\"text\" class=\"form-control\" name=\"name\"");
				var __jte_html_attribute_1 = page.getName();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" />\n                </label>\n            </div>\n            <div class=\"mb-3\">\n                <label class=\"form-label\">BODY</label>\n                <textarea class=\"form-control\" rows=\"20\" cols=\"70\" type=\"text\" name=\"body\">");
				jteOutput.setContext("textarea", null);
				jteOutput.writeUserContent(page.getBody());
				jteOutput.writeContent("</textarea>\n            </div>\n            <input type=\"submit\" class=\"btn btn-primary\" value=\"Сохранить\" />\n        </form>\n    </div>\n");
			}
		});
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		EditPostPage page = (EditPostPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
