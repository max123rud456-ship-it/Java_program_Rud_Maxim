class NegativeBalanceException extends Exception {
    public NegativeBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма пополнения должна быть положительной");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws NegativeBalanceException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма снятия должна быть положительной");
        }
        if (balance - amount < 0) {
            throw new NegativeBalanceException(
                    String.format("Недостаточно средств: баланс %.2f, попытка снять %.2f", balance, amount));
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return String.format("Счёт[владелец=%s, баланс=%.2f]", owner, balance);
    }
}

public class Task3_BankAccount {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Иван Иванов", 1000.0);
        System.out.println("Начальное состояние: " + account);

        double[] withdrawals = {200.0, 500.0, 400.0, -50.0};

        for (double amount : withdrawals) {
            try {
                account.withdraw(amount);
                System.out.printf("Снято %.2f. Текущий баланс: %.2f%n", amount, account.getBalance());
            } catch (NegativeBalanceException e) {
                System.out.println("Ошибка (отрицательный баланс): " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка (некорректная сумма): " + e.getMessage());
            }
        }

        System.out.println("Итоговое состояние: " + account);
    }
}
