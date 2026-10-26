import java.util.Scanner;

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int itemCode = sc.nextInt();
        int quantity = sc.nextInt();
        double price;

        switch (itemCode) {
            case 1:
                price = 60;
                break;
            case 2:
                price = 50;
                break;
            case 3:
                price = 120;
                break;
            case 4:
                price = 80;
                break;
            default:
                System.out.println("Invalid choice");
                sc.close();
                return;
        }

        double total = price * quantity;
        if (total >= 500) {
            total = total * 0.90;
        }

        System.out.println("Amount payable: " + total);
        sc.close();
    }
}
