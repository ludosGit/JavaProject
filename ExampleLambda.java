public class ExampleLambda {
    // A lambda expression in Java is a concise way to express instances of single-method interfaces
    // (functional interfaces): clear and more readable syntax for writing anonymous functions,
    public static Runnable printLambda(){
        Runnable runnable = () -> System.out.println("Hello, Lambda!");
        return runnable;
    }
    @FunctionalInterface
        interface MathOperation {
        int operate(int a, int b);
}
    public static MathOperation customInterface(){
        MathOperation addition = (a, b) -> a + b;
        return addition;
    }

    public static void main(String[] args){
        // Example: Lambda expression for a functional interface
        // syntax: (parameters) -> expression
        Runnable runnable = printLambda();
        MathOperation math = customInterface();
        int a =1;
        int b = 2;
        // Run the lambda expression
        int c = math.operate(a, b);
        runnable.run();
        System.out.println(c);
    }
}
