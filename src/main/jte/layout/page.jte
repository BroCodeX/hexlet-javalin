@import gg.jte.Content

@param Content content
@param Content mainLink
@param Content footer

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Макет сайта</title>
</head>
<body>
<header>
    <h1>This is Header</h1>
</header>
<nav>
    ${mainLink}
</nav>
<div class="content">
    ${content}
</div>
@if (footer != null)
    <div class="footer">
        ${footer}
    </div>
@endif
</body>
</html>
