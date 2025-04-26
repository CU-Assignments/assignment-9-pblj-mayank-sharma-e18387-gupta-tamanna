package hard;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class BankServiceImpl implements BankService {

    @Override
    public void transferMoney(int fromAccountId, int toAccountId, double amount) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Account from = session.get(Account.class, fromAccountId);
            Account to = session.get(Account.class, toAccountId);

            if (from.getBalance() < amount) {
                throw new RuntimeException("Insufficient balance!");
            }

            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);

            session.update(from);
            session.update(to);

            hard.Transaction transaction = new hard.Transaction();
            transaction.setFromAccount(fromAccountId);
            transaction.setToAccount(toAccountId);
            transaction.setAmount(amount);

            session.save(transaction);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}