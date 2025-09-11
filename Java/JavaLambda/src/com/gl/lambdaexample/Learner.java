
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;


public class Learner {

    public static void main(String[] args) {
        BasicCalcul add =(a,b) -> a+b;
        BasicCalcul sub =(a,b) ->a-b;

        System.out.println("add " + add.operation(10,20));
        System.out.println("sub " +sub.operation(10,20));

        BiFunction<Integer, Integer,Integer> total =(a,b) ->a+b;
        System.out.println("total from bifunction : " +total.apply(50,60));

        BiFunction<Double, Integer,Double> Multiply =(a,b) ->a*b;
        System.out.println("Multiply from bifunction : " +Multiply.apply(4.5,3));


        Function<Integer,Integer> square =(a) ->a*a;
        System.out.println("Square from the function : " +square.apply(5));

        Predicate<String> greetvalid = greetMessage -> greetMessage.isEmpty();
        System.out.println("Do i have the greetMssage : " +greetvalid.test("Welcome Home"));


    }

}
