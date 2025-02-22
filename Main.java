import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số cần kiểm tra
        System.out.print("Nhập số cần kiểm tra: ");
        int number = scanner.nextInt();

        boolean isPrime = true;

        // Kiểm tra tính nguyên tố
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime && number > 1) {
            System.out.println(number + " là số nguyên tố.");
        } else {
            System.out.println(number + " không phải là số nguyên tố.");
        }

        scanner.close();
    }
}
