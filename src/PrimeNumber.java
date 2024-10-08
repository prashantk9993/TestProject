import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimeNumber {

    public static void main(String[] args) {
        IntStream.range(1,100).filter(x-> getPrime(x)).forEach(x-> System.out.println("Prime Number ----->"+x));
    }

    public static boolean getPrime(int num){
        int count = 0;
        for (int i=2;i<=num;i++){
            if(num%i==0){
                count++;
            }
        }
        System.out.println("Number:::"+num+" Count:::::"+count);
       return count==1;
    }
}
