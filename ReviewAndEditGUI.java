package OOP_Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class ReviewAndEditGUI extends JFrame {


    JButton save;
    JButton goBack;
    JButton cancel;
    JPanel panel3;


    JTextArea prompt;
    JLabel dairyLabel;
    JTextArea dairyArea;
    JLabel pCareLabel;
    JTextArea pCareArea;
    JLabel produceLabel;
    JTextArea produceArea;
    JLabel othersLabel;
    JTextArea othersArea;
    GroceryBLL bll;


    JScrollPane pCareScrollPane;
    JScrollPane produceScrollPane;
    JScrollPane otherScrollPane;
    JScrollPane dairyScrollPane;


    ReviewAndEditGUI() {
        bll = new GroceryBLL();
        //search

        String str = "Type in the item you want to add " +
                "in the below area and press the save button.\n" +
                "You can also delete an item. Do not forget to hit the save " +
                "button to retain your \nupdate.";
        prompt = new JTextArea(str);
        prompt.setEditable(false);
        prompt.setBackground(Color.ORANGE);
        prompt.setOpaque(true);
        prompt.setBounds(50, 10, 500, 70);

        //Dairy
        dairyLabel = new JLabel("Dairy");
        dairyLabel.setBounds(50, 85, 500, 25);
        dairyArea = new JTextArea();
        dairyArea.setFont(new Font("Arial", Font.PLAIN, 15));
        dairyArea.setText(makeText(bll.getDairy()));
        dairyScrollPane = new JScrollPane(dairyArea);
        dairyScrollPane.setBounds(50, 110, 500, 150);
        dairyScrollPane.setBackground(Color.green);


        //Personal_Care
        pCareLabel = new JLabel("Personal Care");
        pCareLabel.setBounds(50, 265, 500, 25);
        pCareArea = new JTextArea();
        pCareArea.setText(makeText(bll.getPersonalCare()));
        pCareScrollPane = new JScrollPane(pCareArea);
        pCareScrollPane.setBounds(50, 290, 500, 150);
        pCareScrollPane.setBackground(Color.BLUE);


        //Produce
        produceLabel = new JLabel("Produce");
        produceLabel.setBounds(50, 440, 500, 25);
        produceArea = new JTextArea();
        produceArea.setText(makeText(bll.getProduce()));
        produceScrollPane = new JScrollPane(produceArea);
        produceScrollPane.setBounds(50, 465, 500, 150);
        produceScrollPane.setBackground(Color.RED);

        //Others
        othersLabel = new JLabel("Others");
        othersLabel.setBounds(50, 620, 500, 25);
        othersArea = new JTextArea();
        othersArea.setText(makeText(bll.getOther()));
        otherScrollPane = new JScrollPane(othersArea);
        otherScrollPane.setBounds(50, 645, 500, 150);
        otherScrollPane.setBackground(Color.cyan);


        //save button
        save = new JButton("Save");
        save.setFont(new Font("Arial", 20, 24));
        save.setForeground(Color.green);
        save.setBackground(Color.green);
        save.setOpaque(true);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bll.setDairy(dairyArea.getText().toLowerCase().split("\n"), false);
                bll.setPersonalCare(pCareArea.getText().toLowerCase().split("\n"), false);
                bll.setProduce(produceArea.getText().toLowerCase().split("\n"), false);
                bll.setOther(othersArea.getText().toLowerCase().split("\n"),false);
                dispose();
                new ShoppingListGUI();
            }
        });

        //Go back button
        goBack = new JButton("Go Back");
        goBack.setFont(new Font("Arial", 20, 24));
        goBack.setForeground(Color.magenta);
        goBack.setBackground(Color.yellow);
        goBack.setOpaque(true);
        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ShoppingListGUI();
            }
        });


        //Cancel button
        cancel = new JButton("Exit");
        cancel.setFont(new Font("Arial", 20, 24));
        cancel.setForeground(Color.red);
        cancel.setBackground(Color.red);
        cancel.setOpaque(true);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        panel3 = new JPanel();
        panel3.setBackground(Color.blue);
        panel3.setBounds(50, 800, 500, 150);
        panel3.setLayout(new GridLayout(1, 3, 10, 20));
        panel3.add(cancel);
        panel3.add(save);
        panel3.add(goBack);

        add(prompt);
        add(dairyLabel);
        add(dairyScrollPane);
        add(pCareLabel);
        add(pCareScrollPane);
        add(produceLabel);
        add(produceScrollPane);
        add(othersLabel);
        add(otherScrollPane);
        add(panel3);


        setTitle("myWeeklyGrocery");
        setSize(580, 1000);
        setLayout(null);
        setVisible(true);
        setFocusable(false);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }
    private String makeText(String[] strings) {
        Arrays.sort(strings);
        int counter = 1;
        String temp = "";
        for (String item : strings) {
            if (!item.isEmpty()) {
                String str = item;
                while (str.charAt(0) == ' ') {
                    str = str.trim();
                }

                if (48 <= str.charAt(0) && str.charAt(0) <= 57) {
                    temp += str + "\n";
                } else {
                    temp += "" + counter + ") " + str + "\n";
                    counter++;
                }
            }
        }
        return temp;
    }

}

class mai {
    public static void main(String[] args) {
        new ReviewAndEditGUI();
    }
}
