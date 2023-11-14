import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;  // Import the List interface
import java.util.ArrayList;  // Import the ArrayList class

class Question {
    private String questionText;
    private String correctAnswer;

    public Question(String questionText, String correctAnswer) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public boolean checkAnswer(String userAnswer) {
        return correctAnswer.equalsIgnoreCase(userAnswer);
    }
}

class Quiz {
    private JFrame frame;
    private JLabel questionLabel;
    private JTextField answerField;
    private JButton submitButton;

    private Question currentQuestion;
    private List<Question> questions;  // Change the type to List<Question>
    private int score;

    public Quiz() {
        frame = new JFrame("Quiz App");
        questionLabel = new JLabel();
        answerField = new JTextField(15);
        submitButton = new JButton("Submit");

        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        initializeUI();
        initializeQuiz();

        frame.setVisible(true);
    }

    private void initializeUI() {
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAnswerSubmission();
            }
        });

        frame.add(questionLabel);
        frame.add(answerField);
        frame.add(submitButton);
    }

    private void initializeQuiz() {
        // Create questions
        Question question1 = new Question("What is the capital of France?", "Paris");
        Question question2 = new Question("Which programming language is known for its 'write once, run anywhere' philosophy?", "Java");
        Question question3 = new Question("What is the largest mammal on Earth?", "Blue whale");

        // Add questions to the quiz
        questions = new ArrayList<>(Arrays.asList(question1, question2, question3));  // Use ArrayList and Arrays.asList

        // Start the quiz
        startQuiz();
    }

    private void startQuiz() {
        score = 0;
        if (!questions.isEmpty()) {
            currentQuestion = questions.remove(0);
            questionLabel.setText(currentQuestion.getQuestionText());
            answerField.setText("");
        }
    }

    private void handleAnswerSubmission() {
        String userAnswer = answerField.getText();
        if (currentQuestion.checkAnswer(userAnswer)) {
            JOptionPane.showMessageDialog(frame, "Correct!");
            score++;
        } else {
            JOptionPane.showMessageDialog(frame, "Incorrect. The correct answer is: " + currentQuestion.getQuestionText());
        }

        if (!questions.isEmpty()) {
            currentQuestion = questions.remove(0);
            questionLabel.setText(currentQuestion.getQuestionText());
            answerField.setText("");
        } else {
            endQuiz();
        }
    }

    private void endQuiz() {
        JOptionPane.showMessageDialog(frame, "Quiz completed. Your score: " + score + "/" + (questions.size() + score));
        frame.dispose();
    }
}

public class QuizApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Quiz::new);
    }
}