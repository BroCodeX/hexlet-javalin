@import exercise.NamedRoutes
@import exercise.dto.users.UserPage
@param UserPage page

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<form action="${NamedRoutes.userPath(page.getUser().getId())}" method="patch">
    <h1>Update User</h1>
    <div>
        <label>
            First Name
            <input type="text" name="firstName" value="${page.getUser().getFirstName()}"/>
        </label>
    </div>
    <div>
        <label>
            Last Name
            <input type="text" name="lastName" value="${page.getUser().getLastName()}" />
        </label>
    </div>
    <div>
        <label>
            Email
            <input type="email" required name="email" value="${page.getUser().getEmail()}"/>
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

<form action="${NamedRoutes.userPath(page.getUser().getId())}" method="delete">
    <h1>Delete User</h1>
    <div>
        <label>
            ID
            <input type="text" name="id"/>
        </label>
    </div>
    <input type="submit" value="Submit" />
</form>
</html>
