package array;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Array {

    public static Scanner scanner = new Scanner(System.in);

    /**
     * Crea y devuelve un array del tamaño recibido por parámetro (entre 3 y 6)
     *
     * @param arraySize tamaño del array
     * @return array del tamaño seleccionado
     * @throws NumberNotValidException número no válido
     */
    public int[] createArray(int arraySize) throws NumberNotValidException {
        if (arraySize < 3 || arraySize > 6) {
            throw new NumberNotValidException("Number not valid.");
        }
        return new int[arraySize];
    }

    /**
     * Rellena el array con los datos recibidos por consola, asegurando que sean números enteros.
     *
     * @param array array a ser rellenado
     * @return array con los datos introducidos
     */
    public int[] fillArray(int[] array) {
        System.out.println("Dame los datos del array:");
        for (int i = 0; i < array.length; i++) {
            boolean validInput = false;
            while (!validInput) {
                try {
                    array[i] = scanner.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Not a valid digit");
                    scanner.next(); // Limpiar buffer
                }
            }
        }
        return array;
    }

    /**
     * Muestra el número en la posición indicada por el usuario (ajustando a índice 0-based).
     *
     * @param array array con datos
     */
    public void showNumber(int[] array) {
        System.out.println("Give me the position");
        try {
            int pos = scanner.nextInt() - 1; // ajuste de posición en array

            if (pos < 0 || pos >= array.length) {
                throw new ArrayIndexOutOfBoundsException("Index " + (pos + 1) + " out of bounds for length " + array.length);
            }

            System.out.println(array[pos]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Not a valid digit");
            scanner.next(); // limpiar buffer
        }
    }

    public static void main(String[] args) {
        Array arrayMethods = new Array();
        int[] array;

        try {
            System.out.println("Dame la longitud del array(3,4,5,6):");
            int size = scanner.nextInt();
            array = arrayMethods.createArray(size);

            // Llenar array
            array = arrayMethods.fillArray(array);

            // Menú
            while (true) {
                System.out.println("1-Show number\n0-Exit");
                int option = scanner.nextInt();

                if (option == 0) {
                    break;
                } else if (option == 1) {
                    arrayMethods.showNumber(array);
                } else {
                    System.out.println("Invalid option.");
                }
            }

        } catch (NumberNotValidException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Not a valid digit");
        } finally {
            scanner.close();
        }
    }
}