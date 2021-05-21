package lesson01HW;

public class Main {
    //task 1
    public static void main(String[] args) {

        //task 2
        byte byteVar = 117;
        short shortVar = 26183;
        int intVar = -179632456;
        long longVar = 784621561634L;
        float floatVar = 17.7894F;
        double doubleVar = 127.85541674234;
        char charVal = '«';
        boolean boolVar = true;
        String stringVar = new String("Hello, World!");

        //task 3
        System.out.println(calculateExpression(12.65F, 65.124F, 78.9285F, -3.7257F));

        //task 4
        System.out.println(tenToTwenty(12, 85));

        //task 5
        System.out.println("This number is " + posNeg(7985));

        //task 6
        System.out.println(isNeg(-98));

        //task 7
        System.out.println(greet("Александр"));

        //task 8
        System.out.println("Этот год " + leapYear(2007) + ".");

    }

    // task 3
    public static float calculateExpression(float a, float b, float c, float d) {
        float result;
        result = a * (b + c/d);
        return result;
    }

    //task 4
    public static boolean tenToTwenty(int int1, int int2) { return int1 + int2 >= 10 && int1 + int2 <= 20;}

    // task 5
    public static String posNeg(int int3) {
        if (int3 >=0) {
            return "positive";
        } else {
            return "negative";
        }
    }

    //task 6
    public static boolean isNeg(int int4) {return int4 < 0;}

    //task 7
    public static String greet(String name) {
        return new String("Привет, " + name + "!");
    }

    //task 8
    public static String leapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ? "високосный" : "не високосный";
    }

}