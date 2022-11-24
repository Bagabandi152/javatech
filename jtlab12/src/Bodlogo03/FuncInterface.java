package Bodlogo03;


@FunctionalInterface
public interface FuncInterface {

    default String[] split(String s, String regex) {
        if (isRegexArray(regex)) {
            return customSplit(s, regex, "array");
        } else {
            return customSplit(s, regex, "word");
        }
    }

    String[] customSplit(String s, String regex, String type);

    default boolean isRegexArray(String regex) {
        return (regex.charAt(0) == '[' && regex.charAt(regex.length() - 1) == ']');
    }

}
