@import exercise.util.NamedRoutes
@import exercise.dto.posts.MainPage
@param MainPage page


@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
            <main>
                <a href="${NamedRoutes.postsPath()}">Все посты</a>
                <h1>Info about Cookie</h1>
                @if(!page.isVisited())
                    <div class="message">
                        Это сообщение показывается только один раз. Если вы хотите увидеть его снова, сотрите куки
                    </div>
                @endif
                <h1>Info about Session</h1>
                @if(page.getCurrentUser() != null)
                    Добро пожаловать, ${page.getCurrentUser()}.
                    Чтобы разлогиниться, удалите куку JSESSIONID из браузера
                @endif
            </main>
        </div>
    `
)
