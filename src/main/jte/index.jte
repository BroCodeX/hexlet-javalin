@import exercise.util.NamedRoutes
@import exercise.dto.posts.MainPage
@param MainPage page


@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
            <main>
                <a href="${NamedRoutes.postsPath()}">Все посты</a>
                @if(!page.isVisited())
                    <div class="message">
                        Это сообщение показывается только один раз. Если вы хотите увидеть его снова, сотрите куки
                    </div>
                @endif
            </main>
        </div>
    `
)
