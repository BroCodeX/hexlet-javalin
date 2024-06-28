@import org.example.hexlet.DTO
@param DTO push

<html>
<head>
    <title>Хекслет</title>
</head>
<body>
<h1>${push.getHeader()}</h1>
@if(push.getModels().isEmpty())
    <p>Пока не добавлено ни одного курса</p>
@else
    @for(var model : push.getModels())
        <div>
            <h2><a href="/courses/${model.getId()}">${model.getName()}</a></h2>
            <p>${model.getDescription()}</p>
        </div>
    @endfor
@endif
</body>
</html>