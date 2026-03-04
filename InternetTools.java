package jarvis;

public class InternetTools {

    public static String process(String input) {

        input = input.toLowerCase();

        if(input.contains("time"))
            return "Time tool placeholder.";

        if(input.contains("search"))
            return "Internet search placeholder.";

        if(input.contains("hello"))
            return "Hello. How can I assist you?";

        return "I am still learning.";
    }

}
