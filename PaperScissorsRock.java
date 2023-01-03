import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PaperScissorsRock extends JFrame implements ActionListener {

  private static final long serialVersionUID = 1L;

  private JButton paperButton;
  private JButton scissorsButton;
  private JButton rockButton;

  public PaperScissorsRock() {
    setLayout(new GridLayout(1, 3));

    paperButton = new JButton("Paper");
    scissorsButton = new JButton("Scissors");
    rockButton = new JButton("Rock");

    add(paperButton);
    add(scissorsButton);
    add(rockButton);

    paperButton.addActionListener(this);
    scissorsButton.addActionListener(this);
    rockButton.addActionListener(this);
  }

  public static void main(String[] args) {
    PaperScissorsRock frame = new PaperScissorsRock();
    frame.setTitle("Paper Scissors Rock");
    frame.setSize(300, 100);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent event) {
    Random random = new Random();
    int computerMove = random.nextInt(3);

    String computerChoice = "";
    if (computerMove == 0) {
      computerChoice = "Paper";
    } else if (computerMove == 1) {
      computerChoice = "Scissors";
    } else if (computerMove == 2) {
      computerChoice = "Rock";
    }

    String userChoice = "";
    if (event.getSource() == paperButton) {
      userChoice = "Paper";
    } else if (event.getSource() == scissorsButton) {
      userChoice = "Scissors";
    } else if (event.getSource() == rockButton) {
      userChoice = "Rock";
    }

    String result = "";
    if (computerChoice.equals(userChoice)) {
      result = "Draw!";
    } else if (computerChoice.equals("Paper") && userChoice.equals("Rock")) {
      result = "Computer wins!";
    } else if (computerChoice.equals("Scissors") && userChoice.equals("Paper")) {
      result = "Computer wins!";
    } else if (computerChoice.equals("Rock") && userChoice.equals("Scissors")) {
      result = "Computer wins!";
    } else {
      result = "You win!";
    }

    JOptionPane.showMessageDialog(this, "You chose " + userChoice + ". Computer chose " + computerChoice + ". " + result, "Result", JOptionPane.INFORMATION_MESSAGE);
  }

}
