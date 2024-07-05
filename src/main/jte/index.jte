@import exercise.NamedRoutes

@template.layout.page(
    content = @`
        <a href="${NamedRoutes.usersPath()}">Пользователи</a>
    `
)
