import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class txtWriter {

    private String fileName;

    public txtWriter(String userName) {
        this.fileName = userName + ".txt";
    }

    public void writeUserData(User user) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            // Append user data to the file
            writer.println("UserName: " + user.getUserName());
            writer.println("CurrentBalance: " + user.getCurrentBalance());
            writer.println("RetirementAge: " + user.getRetirementAge());
            writer.println("AssumedAnnualContributions: " + user.getAssumedAnnualContributions());
            writer.println("CurrentAge: " + user.getCurrentAge());
            writer.println("InterestRate: " + user.getInterestRate());
            writer.println("CurrentIncome: " + user.getCurrentIncome());
            writer.println();  // Add a line break for better readability

            System.out.println("User data written to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Example usage
        User user = new User("JohnDoe", 50000, 65, 6000, 30, 0.05, 75000);
        txtWriter txtWriter = new txtWriter(user.getUserName());
        txtWriter.writeUserData(user);
    }
}
