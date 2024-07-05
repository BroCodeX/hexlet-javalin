package exercise;

public class NamedRoutes {
    public static String usersPath() {
        return "/u";
    }

    public static String usersBuildPath() {
        return "/u/build";
    }

    public static String userPath(Long id) {
        return userPath(String.valueOf(id));
    }

    public static String userPath(String id) {
        return "/u/" + id;
    }
}
