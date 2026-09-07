import java.util.Objects;

public class Task4 {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA-001", "Алина", 100000, 8.0);
        CreditAccount credit = new CreditAccount("CA-002", "Игорь", 5000, 20000);

        System.out.println("=== Исходные счета ===");
        System.out.println(savings);
        System.out.println(credit);

        System.out.println("\n=== Начисление процентов на накопительный счёт ===");
        savings.addInterest();
        System.out.println(savings);

        System.out.println("\n=== Перевод денег между счетами ===");
        savings.transfer(credit, 15000);
        System.out.println(savings);
        System.out.println(credit);

        System.out.println("\n=== Снятие с кредитного счёта в минус ===");
        credit.withdraw(18000);
        System.out.println(credit);

        System.out.println("\n=== Копирующий конструктор ===");
        SavingsAccount savingsCopy = new SavingsAccount(savings);
        savingsCopy.deposit(1000);
        System.out.println("Оригинал: " + savings);
        System.out.println("Копия:    " + savingsCopy);

        System.out.println("\n=== equals() ===");
        Account sameNumberAccount = new Account("SA-001", "Другое имя", 0);
        System.out.println("savings.equals(sameNumberAccount) = " + savings.equals(sameNumberAccount));
        System.out.println("savings.equals(credit) = " + savings.equals(credit));
    }
}

interface Transferable {
    void transfer(Account target, double amount);
}

class Account implements Transferable {

    private final String accountNumber;
    private final String owner;
    protected double balance;

    public Account(String accountNumber, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public Account(Account other) {
        this.accountNumber = other.accountNumber;
        this.owner = other.owner;
        this.balance = other.balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма пополнения должна быть положительной");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма снятия должна быть положительной");
        }
        if (amount > balance) {
            throw new IllegalStateException("Недостаточно средств на счёте " + accountNumber);
        }
        balance -= amount;
    }

    @Override
    public void transfer(Account target, double amount) {
        this.withdraw(amount);
        target.deposit(amount);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return accountNumber.equals(account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    @Override
    public String toString() {
        return String.format("%s [№%s, владелец: %s, баланс: %.2f]",
                getClass().getSimpleName(), accountNumber, owner, balance);
    }
}

class SavingsAccount extends Account {

    private final double interestRate;

    public SavingsAccount(String accountNumber, String owner, double balance, double interestRate) {
        super(accountNumber, owner, balance);
        this.interestRate = interestRate;
    }

    public SavingsAccount(SavingsAccount other) {
        super(other);
        this.interestRate = other.interestRate;
    }

    public void addInterest() {
        double interest = balance * interestRate / 100;
        deposit(interest);
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", ставка: %.1f%%", interestRate);
    }
}

class CreditAccount extends Account {

    private final double creditLimit;

    public CreditAccount(String accountNumber, String owner, double balance, double creditLimit) {
        super(accountNumber, owner, balance);
        this.creditLimit = creditLimit;
    }

    public CreditAccount(CreditAccount other) {
        super(other);
        this.creditLimit = other.creditLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма снятия должна быть положительной");
        }
        if (balance - amount < -creditLimit) {
            throw new IllegalStateException("Превышен кредитный лимит по счёту " + getAccountNumber());
        }
        balance -= amount;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", кредитный лимит: %.2f", creditLimit);
    }
}
