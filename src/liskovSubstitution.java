//3. Liskov Substitution Principle (LSP)

//Definition: Subtypes must be substitutable for their base types without altering the correctness of the program.
// Base class
abstract class Payment {
    public abstract void pay(double amount);
}

// Subclass 1
class CreditCardPayment extends Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

// Subclass 2
class DebitCardPayment extends Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Debit Card");
    }
}

// ❌ Wrong Subclass (LSP Violation)
class GiftCardPayment extends Payment {
    public void pay(double amount) {
        throw new UnsupportedOperationException("Gift Card cannot make direct payments!");
    }
}
public class liskovSubstitution {
    static void main() {
        Payment credit = new CreditCardPayment();
        Payment debit = new DebitCardPayment();

        // Works fine
        credit.pay(500);
        debit.pay(200);

        // ❌ Violates LSP
        Payment gift = new GiftCardPayment();
        gift.pay(100); // Runtime crash - violates substitutability
    }
}
