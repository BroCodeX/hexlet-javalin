@import exercise.NamedRoutes
@import exercise.dto.users.UsersPage
@param UsersPage page

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
@template.layout.page(
    content = @`
        <h1>Пользователи</h1>

        <div class="mb-3">
            <a href="${NamedRoutes.usersBuildPath()}">Зарегистрировать нового пользователя</a>
        </div>

        <table class="table table-striped">
            @for(var user : page.getUsers())
                <tr>
                    <td>
                        ${user.getId()}
                    </td>
                    <td>
                        ${user.getFirstName()} ${user.getLastName()}
                    </td>
                    <td>
                        <a href="${NamedRoutes.userPath(user.getId())}">${user.getLastName()}</a>
                    </td>
                </tr>
            @endfor
        </table>
    `
)
</html>
