import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, User> users;

    public Bank() {
        this.users = new HashMap<>();
    }

    public boolean createUser(String username, String password) {
        if (users.containsKey(username)) {
            return false;
        }
        users.put(username, new User(username, password));
        return true;
    }

    public User authenticateUser(String username, String password) {
        User user = users.get(username);
        if (user != null && user.authenticate(password)) {
            return user;
        }
        return null;
    }

    public boolean transferFunds(String fromUsername, String toUsername, double amount) {
        User fromUser = users.get(fromUsername);
        User toUser = users.get(toUsername);

        if (fromUser != null && toUser != null && fromUser.withdraw(amount)) {
            toUser.deposit(amount);
            fromUser.addTransaction("Transferred: $" + amount + " to " + toUsername);
            toUser.addTransaction("Received: $" + amount + " from " + fromUsername);
            return true;
        }
        return false;
    }
}
