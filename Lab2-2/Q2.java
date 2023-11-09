public class Q2 {
    public static void main(String[] args) {
        StringBuffer jacked = new StringBuffer("Hello World Program.");
        System.out.println("Append: " + jacked.append("I Love Java"));
        System.out.println("insert: " + jacked.insert(5, "I like c++"));
        System.out.println("replace: " + jacked.replace(5, 10, "Java is Easy"));
        System.out.println("delete: " + jacked.delete(0, 5));
        System.out.println("charAt: " + jacked.charAt(0));
        jacked.setCharAt(1, 'a');
        System.out.println("setCharAt: " + jacked);
        System.out.println("length: " + jacked.length());
        System.out.println("capacity: " + jacked.capacity());
        jacked.ensureCapacity(100);
        System.out.println("ensureCapacity: " + jacked.capacity());
        System.out.println("toString: " + jacked.toString());
        System.out.println("toString[start]: " + jacked.substring(3));
        System.out.println("substring[start and end]: " + jacked.substring(1, 5));
    }
}