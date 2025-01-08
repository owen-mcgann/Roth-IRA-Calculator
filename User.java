import java.io.Serializable;

public class User implements Serializable
{
    //Attributes representing user infromation/data for retirement calculator
    private String userName; //Name of user
    private double currentBalance; //Current account balance
    private int retirementAge; //Expected/desired retirement age
    private double assumedAnnualContributions; //Assumed annual contributions
    private int currentAge; //Current age of user
    private double interestRate; //Interest rate of user's account
    private double currentIncome; //Current income of user's account    

    //Constructor for User class
    public User (String userName, double currentBalance, int retirementAge, double assumedAnnualContributions, int currentAge, double interestRate, double currentIncome)
    {
        //Initialize attributes for user
        this.userName = userName;
        this.currentBalance = currentBalance;
        this.retirementAge = retirementAge;
        this.assumedAnnualContributions = assumedAnnualContributions;
        this.currentAge = currentAge;
        this.interestRate = interestRate;
        this.currentIncome = currentIncome;
    }

    //Getters and setters for access to attributes

    //Getter for userName
    public String getUserName()
    {
        return userName;
    }

    //Setter for userName
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    // Getter for currentBalance
    public double getCurrentBalance() {
        return currentBalance;
    }

    // Setter for currentBalance
    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    // Getter for retirementAge
    public int getRetirementAge() {
        return retirementAge;
    }

    // Setter for retirementAge
    public void setRetirementAge(int retirementAge) {
        this.retirementAge = retirementAge;
    }

    // Getter for assumedAnnualContributions
    public double getAssumedAnnualContributions() {
        return assumedAnnualContributions;
    }

    // Setter for assumedAnnualContributions
    public void setAssumedAnnualContributions(double assumedAnnualContributions) {
        this.assumedAnnualContributions = assumedAnnualContributions;
    }

    // Getter for currentAge
    public int getCurrentAge() {
        return currentAge;
    }

    // Setter for currentAge
    public void setCurrentAge(int currentAge) {
        this.currentAge = currentAge;
    }

    // Getter for interestRate
    public double getInterestRate() {
        return interestRate;
    }

    // Setter for interestRate
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    // Getter for currentIncome
    public double getCurrentIncome() {
        return currentIncome;
    }

    // Setter for currentIncome
    public void setCurrentIncome(double currentIncome) {
        this.currentIncome = currentIncome;
    }

     @Override
    public String toString() 
    {
        return "User: " + userName + "\n" +
                "Current Balance: " + currentBalance + "\n" +
                "Desired Retirement Age: " + retirementAge + "\n" +
                "Assumed Annual Contributions: " + assumedAnnualContributions + "\n" +
                "Current Age: " + currentAge + "\n" +
                "Interest Rate: " + interestRate + "\n" +
                "Current Income: " + currentIncome;
    }

}