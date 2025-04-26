package hard;

public class TestTransaction {
    public static void main(String[] args) {
        BankService service = new BankServiceImpl();
        try {
            service.transferMoney(1, 2, 500.0);
            System.out.println("Transaction successful.");
        } catch (Exception e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }
}