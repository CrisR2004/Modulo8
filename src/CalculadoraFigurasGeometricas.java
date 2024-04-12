import java.util.Scanner;

public class CalculadoraFigurasGeometricas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bienvenido a la Calculadora");
            System.out.println("Seleccione una operación:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            if (opcion == 5) {
                System.out.println("Saliendo...");
                break;
            }

            Operacion operacion = null;
            switch (opcion) {
                case 1:
                    operacion = new Suma();
                    break;
                case 2:
                    operacion = new Resta();
                    break;
                case 3:
                    operacion = new Multiplicacion();
                    break;
                case 4:
                    operacion = new Division();
                    break;
                default:
                    System.out.println("Opción no válida");
                    continue;
            }

            System.out.println("Ingrese el primer número:");
            double numero1 = scanner.nextDouble();
            System.out.println("Ingrese el segundo número:");
            double numero2 = scanner.nextDouble();

            double resultado = operacion.calcular(numero1, numero2);
            System.out.println("El resultado es: " + resultado);
        }

        scanner.close();
    }
}

interface Operacion {
    double calcular(double numero1, double numero2);
}

class Suma implements Operacion {
    @Override
    public double calcular(double numero1, double numero2) {
        return numero1 + numero2;
    }
}

class Resta implements Operacion {
    @Override
    public double calcular(double numero1, double numero2) {
        return numero1 - numero2;
    }
}

class Multiplicacion implements Operacion {
    @Override
    public double calcular(double numero1, double numero2) {
        return numero1 * numero2;
    }
}

class Division implements Operacion {
    @Override
    public double calcular(double numero1, double numero2) {
        if (numero2 == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return numero1 / numero2;
    }
}
