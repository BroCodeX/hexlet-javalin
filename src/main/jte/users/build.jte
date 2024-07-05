@import exercise.NamedRoutes
@import exercise.dto.users.BuildUserPage
@param BuildUserPage page

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
@if(page.getErrors() != null)
    <ul>
        @for(var validator : page.getErrors().values())
            @for(var error : validator)
                <li>${error.getMessage()}</li>
            @endfor
        @endfor
    </ul>
@endif

<form action="${NamedRoutes.usersPath()}" method="post">
    <div>
        <label>
            First Name
            <input type="text" name="firstName" value="${page.getFirstName()}"/>
        </label>
    </div>
    <div>
        <label>
            Last Name
            <input type="text" name="lastName" />
        </label>
    </div>
    <div>
        <label>
            Email
            <input type="email" required name="email" value="${page.getEmail()}"/>
        </label>
    </div>
    <div>
        <label>
            Password
            <input type="password" required name="password" />
        </label>
    </div>
    <div>
        <label>
            Password Confirmation
            <input type="password" required name="passwordConfirmation" />
        </label>
    </div>
    <input type="submit" value="Submit" />
</form>
</html>
