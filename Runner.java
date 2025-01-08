import javax.swing.*;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Runner extends JFrame {
    
    //Attributes
    private ArrayList<String> userNames; //List of user names

    //Constructor for Runner
    public Runner()
    {
        //Init Attributes
        userNames = new ArrayList<>();
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create an instance of the Runner class
            Runner runner = new Runner();
            // Call the method to start the GUI
            runner.startGUI();
        });
    }

    //Method to start the GUI
    private void startGUI()
    {
        Jframe frame = new Jframe("Savings Account Calculator");
        frame.setDefaultCloseOperation(Jframe.EXIT_ON_CLOSE);

        //Add GUi Components and set up event listeners as needed

        //Create a button to intiate the user input
        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> {
            // Example: Call a method to handle user input
            handleUserInput();
        });

        frame.getContentPane().add(startButton);
        frame.pack();
        frame.setVisible(true);
    }

     // Method to handle user input
     private void handleUserInput() 
     {
        // Example: Create a dialog to get user input
        String userName = JOptionPane.showInputDialog("Enter your name:");

        // Example: Check if the user already exists
        if (userNames.contains(userName)) 
        {
            // User exists, handle accordingly
            System.out.println("Welcome back, " + userName + "!");
        } 
        else 
        {
            // New user, handle accordingly
            System.out.println("Welcome, new user " + userName + "!");
            // Example: Add the new user to the list
            userNames.add(userName);
        }
        //Add additonal logic if needed:
    }
}

