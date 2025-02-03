import java.util.Scanner;

class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
class ATM {
    private final int correctPin = 1234; 
    private double balance;

    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }

    public void authenticate(int enteredPin) throws InvalidPinException {
        if (enteredPin != correctPin) {
            throw new InvalidPinException("Invalid PIN! Access Denied.");
        }
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance for this withdrawal.");
        }
        balance -= amount;
        System.out.println("Withdrawal successful! Amount withdrawn: " + amount);
    }

    public void displayBalance() {
        System.out.println("Remaining Balance: " + balance);
    }
}
public class ATMSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM(5000); 

        try {
            System.out.print("Enter your PIN: ");
            int enteredPin = sc.nextInt();

            atm.authenticate(enteredPin);

            System.out.print("Enter amount to withdraw: ");
            double amount = sc.nextDouble();

            atm.withdraw(amount);
        } catch (InvalidPinException | InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter numbers only.");
        } finally {
            atm.displayBalance();
            sc.close();
        }
    }
}
