package exercise;

public class NamedRoutes {
    public static String usersPath() {
        return "/users";
    }

    public static String usersBuildPath() {
        return "/users/build";
    }

    public static String userPath(Long id) {
        return userPath(String.valueOf(id));
    }

    public static String userPath(String id) {
        return "/users/" + id;
    }
}
