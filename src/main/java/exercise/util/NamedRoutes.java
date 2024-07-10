package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    public static String postsPath() {
        return "/posts";
    }

    public static String buildPostPath() {
        return "/posts/build";
    }

    public static String postPath(Long id) {
        return postPath(String.valueOf(id));
    }

    public static String postPath(String id) {
        return "/posts/" + id;
    }

    public static String editPost(Long id) {
        return postPath(id) + "/edit";
    }

    public static String editPost(String id) {
        return postPath(id) + "/edit";
    }

    public static String update(String id) {
        return postPath(id);
    }

    public static String sessionsPath() {
        return "/sessions";
    }
    public static String sessionsPathBuild() {
        return sessionsPath() + "/build";
    }
}
