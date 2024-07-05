package gg.jte.generated.ondemand.users;
import exercise.NamedRoutes;
import exercise.dto.users.UsersPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,9,9,11,11,15,15,15,15,15,15,15,15,15,19,19,22,22,22,25,25,25,25,25,25,28,28,28,28,28,28,28,28,28,28,28,28,31,31,33,33,33,35,35,35,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\n<html lang=\"en\">\n<head>\n    <meta charset=\"utf-8\" />\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n</head>\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <h1>Пользователи</h1>\n\n        <div class=\"mb-3\">\n            <a");
				var __jte_html_attribute_0 = NamedRoutes.usersBuildPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">Зарегистрировать нового пользователя</a>\n        </div>\n\n        <table class=\"table table-striped\">\n            ");
				for (var user : page.getUsers()) {
					jteOutput.writeContent("\n                <tr>\n                    <td>\n                        ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(user.getId());
					jteOutput.writeContent("\n                    </td>\n                    <td>\n                        ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(user.getFirstName());
					jteOutput.writeContent(" ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(user.getLastName());
					jteOutput.writeContent("\n                    </td>\n                    <td>\n                        <a");
					var __jte_html_attribute_1 = NamedRoutes.userPath(user.getId());
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_1);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(user.getLastName());
					jteOutput.writeContent("</a>\n                    </td>\n                </tr>\n            ");
				}
				jteOutput.writeContent("\n        </table>\n    ");
			}
		});
		jteOutput.writeContent("\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
