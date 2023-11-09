
public class LearnString {
    public static void main(String[] args) {

        String inputString = "We realizes that while our workers were thriving, the \nsurrounding villages were still suffering. It became our goal to uplift their \nquality of life as well. I remember seeing a family of 4 on a motorbike in \nthe heavy Bombay rain — I knew I wanted to do more for these families who were \nrisking their lives for lack of an alternative” The alternative mentioned here \nis the Tata Nano, which soon after came as the world's cheapest car on retail \nat a starting price of only Rs 1 lakh. These were the words of Ratan Tata in a \nrecent post by Humans of Bombay which formed the basis of his decision to come \nup with a car like Tata Nano.";
        String inputString2 = inputString + "- Unknown Author";
        char outputString[] = new char[100];
        // StringBuffer stringBuffer = new StringBuffer(inputString);
        System.out.println("Char at index 1: " + inputString.charAt(1));
        System.out.println("compareTo: " + inputString.compareTo(inputString2));
        System.out.println("concat: " + inputString.concat(" End of Story"));
        System.out.println("contains: " + inputString.contains("workers were thriving"));
        System.out.println("endsWith: " + inputString.endsWith("Story"));
        System.out.println("equals: " + inputString.equals(inputString2));
        System.out.println("equalsIgnoreCase: " + inputString.equalsIgnoreCase(inputString.toUpperCase()));
        System.out.println("format: " + String.format("Input String: %s", inputString));
        System.out.println("getBytes: " + inputString.getBytes());
        inputString.getChars(1, 5, outputString, 0);
        System.out.println("getChars: " + outputString.toString());
        System.out.println("indexOf: " + inputString.indexOf('a'));
        String str1 = new String(inputString).intern(); // statement - 2
        System.out.println("intern: str 1 == str 2: " + inputString == str1);
        System.out.println("isEmpty: " + inputString.isEmpty());
        System.out.println("join: " + String.join(inputString2));
        System.out.println("lastIndexOf: " + inputString.lastIndexOf('a'));
        System.out.println("replace: " + inputString.replace('a', 'b'));
        System.out.println("replaceAll: " + inputString.replaceAll("c", "d"));
        System.out.println("split: " + inputString.split(" "));
        System.out.println("startsWith: " + inputString.startsWith("a "));
        System.out.println("length: " + inputString.length());
        System.out.println("substring: " + inputString.substring(1, 10));
        System.out.println("toCharArray: " + inputString.toCharArray().toString());
        System.out.println("toLowerCase: " + inputString.toLowerCase());
        System.out.println("toUpperCase: " + inputString.toUpperCase());
        System.out.println("trim: " + inputString.trim());
        System.out.println("valueOf: " + String.valueOf(new int[] { 1, 2, 3, 4 }));
    }
}