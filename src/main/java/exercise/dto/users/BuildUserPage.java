package exercise.dto.users;

import java.util.List;
import java.util.Map;

import exercise.model.User;
import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BuildUserPage {
    private List<User> users;
    private String firstName;
    private String email;
    private Map<String, List<ValidationError<Object>>> errors;
}
