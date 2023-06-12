import java.math.BigInteger;
import java.util.Scanner;

public class Main {




    // Interfaz para la serie de Fibonacci
    public interface Fibonacci {
        BigInteger calcularFibonacci(int n);
    }

    // Clase que implementa la interfaz Fibonacci
    public static class FibonacciRecursivo implements Fibonacci {
        @Override
        public BigInteger calcularFibonacci(int n) {
            if (n == 0 || n == 1) {
                return BigInteger.valueOf(n);
            }
            return calcularFibonacci(n - 1).add(calcularFibonacci(n - 2));
        }

        public void main(String[] args) {
            Fibonacci fibonacci = new FibonacciRecursivo();

            Scanner sc = new Scanner(System.in);
            System.out.print("Introduce el número de elementos a mostrar de la serie: ");
            int limite = sc.nextInt();
            sc.close();

            System.out.println("Serie de Fibonacci hasta el término " + limite + ":");
            for (int i = 0; i < limite; i++) {
                BigInteger resultado = fibonacci.calcularFibonacci(i);
                System.out.print(resultado + ", ");
            }
        }
    }
}
