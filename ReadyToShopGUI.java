package OOP_Project;

import OOP.Shopping_ListGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ReadyToShopGUI extends JFrame {//implements ActionListener {

    JPanel dairyPanel;
    JPanel pCarePanel;
    JPanel producePanel;
    JPanel othersPanel;
    GroceryBLL bll;
    JPanel[] panels;
    JLabel dayL;
    JLabel dateL;
    JLabel timeL;
    JPanel timePanel;

    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    SimpleDateFormat timeFormat;


    JButton exit;
    JButton goBack;
    JButton save;
    JPanel exitPanel;



    String[] dairy;
    String[] pCare;
    String[] produce;
    String[] others;





    ReadyToShopGUI() {






        save = new JButton("save");

        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayL = new JLabel();
        dateL = new JLabel();
        timeL = new JLabel();
        timePanel = new JPanel();
        timePanel.setBounds(50, 30, 500, 50);
        timePanel.setOpaque(true);
        timePanel.add(dateL);
        timePanel.add(dateL);
        timePanel.add(timeL);



        dairyPanel = new JPanel();
        dairyPanel.setBounds(50, 100, 500, 150);
        pCarePanel = new JPanel();
        pCarePanel.setBounds(50, 250, 500, 150);
        producePanel = new JPanel();
        producePanel.setBounds(50, 400, 500, 150);
        othersPanel = new JPanel();
        othersPanel.setBounds(50, 550, 500, 150);


        bll = new GroceryBLL();
        dairy = bll.getDairy();
        pCare = bll.getPersonalCare();
        produce = bll.getProduce();
        others = bll.getOther();
        panels = new JPanel[]{dairyPanel, pCarePanel, producePanel, othersPanel};
        String[][] types = {dairy, pCare, produce, others};



        String[] fpaths = {"Dairy.txt","personalCare.txt", "Produce.txt", "Others.txt"};
        GroceryDAL dal = new GroceryDAL();


        ArrayList<JCheckBox> checkBoxes = new ArrayList<>();




        for (int i = 0; i < 4; i++) {
            for (String str : types[i]) {
                JCheckBox x = new JCheckBox(str);
                panels[i].add(x);
                String path = fpaths[i];
                checkBoxes.add(x);
               save.addActionListener(e -> {
                   if(x.isSelected()) {
                       dal.delete(str, path);

                   }
                   dispose();

               });

            }
        }


        goBack = new JButton("Go Back");
        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ShoppingListGUI();
            }
        });
        exit= new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });




        exitPanel = new JPanel();
        exitPanel.setBounds(50, 715, 300, 150);
        exitPanel.add(goBack);
        exitPanel.add(exit);
        exitPanel.add(save);


        add(timePanel);
        for (JPanel panel : panels) {
            add(panel);
        }
        add(exitPanel);
        setTitle("myWeeklyGrocery");
        setSize(580, 1000);
        setLayout(null);
        setVisible(true);
        setFocusable(false);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

       setTime();
    }




    public void setTime() {
        timeL.setText(timeFormat.format(Calendar.getInstance().getTime()));
        dayL.setText(dayFormat.format(Calendar.getInstance().getTime()));
        dateL.setText(dateFormat.format(Calendar.getInstance().getTime()));
    }
}

class check {
    public static void main(String[] args) {
        new ReadyToShopGUI();
    }
}