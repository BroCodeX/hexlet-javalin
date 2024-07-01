@import org.example.hexlet.DTO
@param DTO dto

@template.layout.page(
content = @`
    <p>Welcome, ${dto.getModels().get(0).getName()}.</p>
`,
footer = @`
    <h2>GitHub Link</h2>
    <a href="https://github.com/BroCodeX">Главная</a>
`,
mainLink = @`
    <a href="http://localhost:7070/">Главная</a>
`
)
