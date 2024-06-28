@import org.example.hexlet.DTO
@param DTO dto

<html>
<head>
    <title>Хекслет</title>
</head>
<body>
<h1>${dto.getHeader()}</h1>
@if(dto.getModels().isEmpty())
    <p>Пока не добавлено ни одного курса</p>
@else
    @for(var model : dto.getModels())
        <div>
            <h2><a href="/courses/${model.getId()}">${model.getName()}</a></h2>
            <p>${model.getDescription()}</p>
        </div>
    @endfor
@endif
</body>
</html>