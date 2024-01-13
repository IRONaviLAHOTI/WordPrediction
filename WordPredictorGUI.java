package GUI;
import DataSetAnalyzer.Analyzer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordPredictorGUI extends JFrame {

    private JTextField inputTextField;
    private JButton processButton;
    private JLabel resultLabel;

    public WordPredictorGUI() {
        // Set up the JFrame
        setTitle("Word Processor");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        inputTextField = new JTextField(20);
        processButton = new JButton("Process");
        resultLabel = new JLabel("Result: ");

        // Set up the layout
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter a word: "));
        inputPanel.add(inputTextField);
        inputPanel.add(processButton);

        // Add action listener to the button
        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processWord();
            }
        });

        // Add components to the JFrame
        add(inputPanel, BorderLayout.NORTH);
        add(resultLabel, BorderLayout.CENTER);

        // Set the JFrame to be visible
        setVisible(true);
    }

    private void processWord() {
        // Get the input word from the text field
        String inputWord = inputTextField.getText();
        String outputWord = Analyzer.predictor(inputWord,"C:\\Users\\DELL\\Desktop\\PROGRAMMING\\JAVA\\WordPredictor\\test.txt");
        // Perform some processing (in this case, just displaying the input word)
        String processedWord = "Processed: " + outputWord;

        // Update the result label
        resultLabel.setText(processedWord);
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordPredictorGUI();
            }
        });
    }
}
