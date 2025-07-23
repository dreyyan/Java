package Operations;
public class StringOperations {
    public static void main(String[] args) {
        String name = " Steve Willis" + "!";
        System.out.println(name.endsWith("!"));
        System.out.println(name.startsWith("S"));
        System.out.println(name.length());
        System.out.println(name.indexOf("e"));
        System.out.println(name.replace("e", "i"));
        System.out.println(name.toLowerCase());
        System.out.println(name.toUpperCase());
        System.out.println(name.trim());
    }
}