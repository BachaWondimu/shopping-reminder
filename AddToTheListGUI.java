package OOP_Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddToTheListGUI extends JFrame implements ActionListener {
    JButton addToList;
    JButton goBack;
    JButton cancel;
    JLabel dairyLabel;
    JTextArea dairyArea;
    JLabel pCareLabel;
    JTextArea pCareArea;
    JLabel produceLabel;
    JTextArea produceArea;
    JLabel othersLabel;
    JTextArea othersArea;
    JPanel panel2;
    JPanel panel1;
    JPanel panel3;

    AddToTheListGUI() {
        //add page
        //submit/ Cancel/Go back
        addToList = new JButton("submit");
        addToList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ArrayList<String> list = new ArrayList<>();
                GroceryBLL bll= new GroceryBLL();
                String[] dairy = dairyArea.getText().split(",");
               String [] produce = produceArea.getText().split(",");
                String[] pCare = pCareArea.getText().split(",");
                String[] others = othersArea.getText().split(",");
                //list = makeaArrayList(dairy,pCare,produce,others);
              bll.setPersonalCare(pCare,true);
              bll.setDairy(dairy,true);
              bll.setOther(others,true);
              bll.setProduce(produce,true);
              dispose();
              new ShoppingListGUI();
            }
        });


        goBack = new JButton("Go Back");
        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ShoppingListGUI();
            }
        });
        cancel = new JButton("Exit");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });

        //Dairy
        dairyLabel = new JLabel("Dairy");
        dairyArea = new JTextArea();

        //Personal_Care
        pCareLabel = new JLabel("Personal_Care");
        pCareArea = new JTextArea();

        //Produce
        produceLabel = new JLabel("Produce");
        produceArea = new JTextArea();

        //Others
        othersLabel = new JLabel("Others");
        othersArea = new JTextArea();





    /*
   JPanel
     */

        panel1 = new JPanel();
        panel1.setBackground(Color.orange);
        panel1.setBounds(10, 10, 150, 500);
        panel1.setLayout(new GridLayout(4, 1, 10, 20));


        panel2 = new JPanel();
        panel2.setBackground(Color.green);
        panel2.setBounds(155, 10, 400, 500);
        panel2.setLayout(new GridLayout(4, 1, 10, 20));


        panel3 = new JPanel();
        panel3.setBackground(Color.RED);
        panel3.setBounds(150, 520, 300, 150);
        panel3.setLayout(new GridLayout(1, 3, 10, 20));


        panel1.add(dairyLabel);
        panel1.add(pCareLabel);
        panel1.add(produceLabel);
        panel1.add(othersLabel);

        panel2.add(dairyArea);
        panel2.add(pCareArea);
        panel2.add(produceArea);
        panel2.add(othersArea);

        panel3.add(cancel);
        panel3.add(addToList);
        panel3.add(goBack);


        add(panel1);
        add(panel2);
        add(panel3);


        setTitle("myWeeklyGrocery");
        setSize(580, 700);
        setLayout(null);
        setVisible(true);
        setFocusable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    private static ArrayList<String> makeaArrayList(String[] dairy,String[] pCare,String[] produce,String[]others) {
        ArrayList<String> myList = new ArrayList<>();
        String[][] tempList = {dairy,pCare,produce,others};
        for(int i=0;i< tempList.length;i++){
            for (int j=0; j<tempList[i].length; j++){
                myList.add(tempList[i][j]);
            }
        }
        return myList;
    }
}

class main {
    public static void main(String[] args) {
        new AddToTheListGUI();
    }
}