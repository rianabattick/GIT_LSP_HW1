package org.howard.edu.lsp.assignment2;

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String creditCardNumber;

    public CreditCardPayment(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using credit card " + creditCardNumber);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String emailAddress;

    public PayPalPayment(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal account " + emailAddress);
    }
}

class BitcoinPayment implements PaymentStrategy {
    private String bitcoinAddress;

    public BitcoinPayment(String bitcoinAddress) {
        this.bitcoinAddress = bitcoinAddress;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Bitcoin address " + bitcoinAddress);
    }
}

class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount) {
        paymentStrategy.pay(amount);
    }
}

public class PaymentStrategyDriver {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Using credit card payment
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        cart.checkout(100.0);

        // Using PayPal payment
        cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
        cart.checkout(50.0);

        // Using Bitcoin payment
        cart.setPaymentStrategy(new BitcoinPayment("1AaBbCcDdEeFfGgHh"));
        cart.checkout(75.0);
    }
}
