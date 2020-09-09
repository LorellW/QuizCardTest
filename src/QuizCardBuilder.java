import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class QuizCardBuilder {
    private JFrame frame;
    private JTextArea question;
    private JTextArea answer;
    private ArrayList<QuizCard> cardList;

    public void go(){
        frame = new JFrame("Quiz Card Builder");
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif",Font.BOLD,24);

        question = new JTextArea(6,20);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setFont(bigFont);

        JScrollPane qScroller = new JScrollPane(question);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        answer = new JTextArea(6,20);
        answer.setFont(bigFont);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);

        JScrollPane aScroller = new JScrollPane(answer);
        aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new NextButtonActionListener());

        cardList = new ArrayList<QuizCard>();

        JLabel qLabel = new JLabel("Question");
        JLabel aLabel = new JLabel("Answer");

        mainPanel.add(qLabel);
        mainPanel.add(qScroller);
        mainPanel.add(aLabel);
        mainPanel.add(aScroller);
        mainPanel.add(nextButton);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(new NewMenuActionListener());
        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(new SaveMenuActionListener());

        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500,600);
        frame.setVisible(true);
    }

    private class NextButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            QuizCard card = new QuizCard(question.getText(),answer.getText());
            cardList.add(card);
            
        }
    }

    private class NewMenuActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class SaveMenuActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
