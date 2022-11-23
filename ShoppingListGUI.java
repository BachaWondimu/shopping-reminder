package OOP_Project;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ShoppingListGUI extends JFrame implements ActionListener {
    JButton review;
    JButton add;
    JButton shop;
    JPanel SASPanel;

    JLabel dayL;
    JLabel dateL;
    JLabel timeL;
    JPanel timePanel;

    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    SimpleDateFormat timeFormat;


    ShoppingListGUI() {

//set O'clock
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayL = new JLabel();
        dateL = new JLabel();
        timeL = new JLabel();
        timePanel = new JPanel();
        timePanel.add(dateL);
        timePanel.add(dateL);
        timePanel.add(timeL);
        timePanel.setBounds(50, 30, 500, 100);


        //Add
        add = new JButton("Add to my List");
        add.setForeground(Color.green);
        add.setFont(new Font("Arial", 10, 21));
        add.addActionListener(this);

        //Search
        review = new JButton("Edit my List");
        review.setForeground(Color.blue);
        review.setFont(new Font("Arial", 10, 21));
        review.addActionListener(this);
        //Shop
        shop = new JButton("Ready to Shop");
        shop.setForeground(Color.red);
        shop.setFont(new Font("Arial", 10, 21));
        shop.addActionListener(this);

        SASPanel = new JPanel();
        SASPanel.setBackground(Color.cyan);
        SASPanel.setBounds(50, 150, 500, 150);
        SASPanel.setLayout(new GridLayout(1, 3, 5, 10));
        SASPanel.add(add);
        SASPanel.add(review);
        SASPanel.add(shop);


        add(timePanel);
        add(SASPanel);
        setTitle("myWeeklyGrocery");
        setSize(600, 400);
        setLayout(null);
        setVisible(true);
        setFocusable(false);
        setResizable(false);
        setLocationRelativeTo(null);
        setBackground(Color.BLUE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setTime();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {
            dispose();
            new AddToTheListGUI();
        }
        if (e.getSource() == review) {
            dispose();
            new ReviewAndEditGUI();
        }
        if (e.getSource() == shop) {

            dispose();
            new ReadyToShopGUI();

        }

    }


    public void setTime() {
        timeL.setText(timeFormat.format(Calendar.getInstance().getTime()));
        dayL.setText(dayFormat.format(Calendar.getInstance().getTime()));
        dateL.setText(dateFormat.format(Calendar.getInstance().getTime()));
    }
}

class M {
    public static void main(String[] args) {
        new ShoppingListGUI();
    }
}