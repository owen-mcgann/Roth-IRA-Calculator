import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

public class RothGraph extends JFrame {

    private ArrayList<Double> accountBalanceData;
    private int currentAge;
    private int retirementAge;

    public RothGraph(ArrayList<Double> accountBalanceData, int currentAge, int retirementAge) {
        this.accountBalanceData = accountBalanceData;
        this.currentAge = currentAge;
        this.retirementAge = retirementAge;
        initUI();
    }

    private void initUI() {
        setTitle("ROTH IRA Account Balance vs Age");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGraph(g);
            }
        };

        panel.setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));

        panel.add(headerPanel, BorderLayout.NORTH);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }

    private void drawGraph(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        // Draw title
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 18));
        String title = "Account Balance vs Age";
        int titleWidth = g2d.getFontMetrics().stringWidth(title);
        g2d.drawString(title, (width - titleWidth) / 2, 30);

        // Draw axis labels
        g2d.setFont(new Font("Arial", Font.PLAIN, 12));
        int ageLabelWidth = g2d.getFontMetrics().stringWidth("Age");
        int ageLabelHeight = g2d.getFontMetrics().getHeight();
        g2d.drawString("Age", (width - ageLabelWidth) / 2, height - ageLabelHeight);
        g2d.drawString("Account Balance (USD)", 10, 20);

        // Draw age labels on X-axis
        for (int i = currentAge; i <= retirementAge; i += 4) {
            int x = 70 + ((i - currentAge) / 4) * (width - 120) / ((retirementAge - currentAge) / 4);
            g2d.drawString(String.valueOf(i), x - 5, height - 30);
        }

        // Draw account balance labels on Y-axis
        double maxBalance = getMaxBalance(accountBalanceData);
        for (double i = maxBalance; i >= 0; i -= maxBalance / 4) {
            int y = height - 50 - (int) ((maxBalance - i) * (height - 100) / maxBalance);
            g2d.drawString("$" + formatNumber(i), 25, y + 5);
        }

        // Draw X-axis border
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(70, height - 50, width - 50, height - 50);

        // Draw Y-axis border
        g2d.drawLine(70, 50, 70, height - 50);

        // Draw top border
        g2d.drawLine(70, 50, width - 50, 50);

        // Draw right border
        g2d.drawLine(width - 50, 50, width - 50, height - 50);

        // Draw gridlines
        drawGridlines(g2d);

        // Draw account balance data points and plot lines
        if (accountBalanceData != null && accountBalanceData.size() > 1) {
            int ageSpacing = (width - 120) / (accountBalanceData.size() - 1);

            // Draw account balance line
            drawLine(g2d, accountBalanceData, ageSpacing, maxBalance, Color.BLUE, "Account Balance");
        }

        // Draw key higher up on the screen
        drawLegend(g2d, width, height);
    }

    private void drawLine(Graphics2D g2d, ArrayList<Double> data, int ageSpacing, double maxBalance, Color color, String label) {
        GeneralPath path = new GeneralPath();
        path.moveTo(70, getHeight() - 50 - (int) ((data.get(0) / maxBalance) * (getHeight() - 100)));

        for (int i = 0; i < data.size(); i++) {
            int x = 70 + i * ageSpacing;
            int y = getHeight() - 50 - (int) ((data.get(i) / maxBalance) * (getHeight() - 100));
            g2d.setColor(color);
            g2d.fillOval(x - 5, y - 5, 10, 10);

            path.lineTo(x, y);
        }

        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(2));
        g2d.draw(path);
    }

    private void drawGridlines(Graphics2D g2d) {
        g2d.setColor(Color.LIGHT_GRAY);
        int width = getWidth();
        int height = getHeight();
        int ageSpacing = (width - 120) / 11;

        // Draw vertical gridlines
        for (int i = 1; i < 11; i++) {
            int x = 70 + i * ageSpacing;
            g2d.drawLine(x, 50, x, height - 50);
        }

        // Draw horizontal gridlines
        for (int i = 1; i < 5; i++) {
            int y = 50 + i * (height - 100) / 4;
            g2d.drawLine(70, y, width - 50, y);
        }
    }

    private void drawLegend(Graphics2D g2d, int width, int height) {
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.PLAIN, 14));
        int keyX = width - 250;
        int keyY = 10;

        g2d.drawString("Key:", keyX, keyY);
        drawLegendEntry(g2d, keyX, keyY, Color.BLUE, "Account Balance Yearly");
    }

    private void drawLegendEntry(Graphics2D g2d, int keyX, int keyY, Color color, String label) {
        g2d.setColor(color);
        g2d.drawLine(keyX + 70, keyY + 10, keyX + 90, keyY + 10);
        g2d.drawString(label, keyX + 110, keyY + 15);
    }

    private double getMaxBalance(ArrayList<Double> data) {
        if (data == null || data.isEmpty()) {
            return 0;
        }

        double max = data.get(0);
        for (double balance : data) {
            if (balance > max) {
                max = balance;
            }
        }
        return max;
    }

    private String formatNumber(double number) {
        return String.format("%,.0f", number);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Replace this with your actual data
            ArrayList<Double> accountBalanceData = new ArrayList<>();
            // Populate accountBalanceData with your data
            int currentAge = 21;
            int retirementAge = 60;

            RothGraph accountBalanceGraph = new RothGraph(accountBalanceData, currentAge, retirementAge);
            accountBalanceGraph.setVisible(true);
        });
    }
}

//TODO:
//Fix the Y-Axis MaxBalance issues within the graph
//Make the graph cleaner and look better
//When you go over and under a certain number for the 
//Try and fix txtWriter so it will uop