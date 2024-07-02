@import org.example.hexlet.DTO
@param DTO dto

@template.layout.pageForm(
content = @`
    @for(var user : dto.getModels())
<div>
        <p>Welcome, ${user.getId()} ${user.getName()} ${user.getDescription()}</p>
</div>
    @endfor
    `,
term = @`
    <div>
        <form action="/users" method="get">
            <input type="search" name="term" value="${dto.getTerm()}" />
            <input type="submit" value="Search" />
        </form>
    </div>
`
)