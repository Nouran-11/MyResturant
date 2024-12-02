import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

public class MyResturant extends JFrame {
    JLabel Customer, Name, Contact, Food, Drink, Type;
    JTextField tfNumber, tfName, tfContact;
    JButton reset, print, receipt;
    JComboBox<String> cb1, cb2;
    JRadioButton r1, r2;
    JTextArea area1;
    int total , dprice=0 , fprice=0;


    MyResturant() {
        setTitle("Restaurant and Coffee");
        setSize(800, 500);
        setLayout(null);


        Customer = new JLabel("Customer No:");
        Customer.setBounds(20, 20, 120, 30);

        Name = new JLabel("Name:");
        Name.setBounds(20, 60, 120, 30);

        Contact = new JLabel("Contact:");
        Contact.setBounds(20, 100, 120, 30);

        Food = new JLabel("Food:");
        Food.setBounds(20, 200, 120, 30);

        String[] Foods = {"select food","Pizza", "Burger", "Steak"};
        cb1 = new JComboBox<>(Foods);
        cb1.setBounds(150, 200, 120, 30);

        Drink = new JLabel("Drinks:");
        Drink.setBounds(20, 250, 120, 30);

        String[] Drinks = {"select a drink","Coke", "Juice", "Water"};
        cb2 = new JComboBox<>(Drinks);
        cb2.setBounds(150, 250, 120, 30);

        Type = new JLabel("Type:");
        Type.setBounds(20, 300, 120, 30);

        r1 = new JRadioButton("Diet");
        r2 = new JRadioButton("Normal");
        r1.setBounds(200, 300, 100, 30);
        r2.setBounds(300, 300, 100, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);


        tfNumber = new JTextField();
        tfNumber.setBounds(150, 20, 200, 30);

        tfName = new JTextField();
        tfName.setBounds(150, 60, 200, 30);

        tfContact = new JTextField();
        tfContact.setBounds(150, 100, 200, 30);


        area1 = new JTextArea();
        area1.setBounds(400, 150, 300, 200);
        area1.setEditable(false);
        area1.setBorder(BorderFactory.createEtchedBorder());


        reset = new JButton("Reset");
        reset.setBounds(400, 100, 80, 40);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfNumber.setText("");
                tfContact.setText("");
                tfName.setText("");
                cb1.setSelectedIndex(0);
                cb2.setSelectedIndex(0);
                bg.clearSelection();
                area1.setText("");
            }
        });

        receipt = new JButton("Receipt");
        receipt.setBounds(500, 100, 80, 40);
        receipt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String type = r1.isSelected() ? "Diet" : r2.isSelected() ? "Normal" : "None";
                area1.setText("Happy Order\n");
                area1.append("Customer Number: " + tfNumber.getText() + "\n");
                area1.append("Name: " + tfName.getText() + "\n");
                area1.append("Contact: " + tfContact.getText() + "\n");
                area1.append("Food: " + cb1.getSelectedItem() + "\n");
                area1.append("Drink: " + cb2.getSelectedItem() + "\n");
                area1.append("Type: " + type + "\n");

                switch (cb1.getSelectedIndex()) {
                    case 0:
                        fprice = 0;
                        break;
                    case 1:
                        fprice = 200;
                        break;
                    case 2:
                        fprice = 300;
                        break;
                    case 3:
                        fprice = 400;
                        break;

                }
                switch (cb2.getSelectedIndex()) {
                    case 0:
                        dprice = 0;
                        break;
                    case 1:
                        dprice = 20;
                        break;
                    case 2:
                        dprice = 30;
                        break;
                    case 3:
                        dprice = 5;
                        break;
                }
                total = fprice +dprice;
                area1.setText(area1.getText()+"\n Total = " + total);
            }
        });

        print = new JButton("Print");
        print.setBounds(600, 100, 80, 40);
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    area1.print();
                } catch (PrinterException ex) {
                    JOptionPane.showMessageDialog(null, "Print Error: " + ex.getMessage());
                }
            }
        });


        getContentPane().add(Customer);
        getContentPane().add(Name);
        getContentPane().add(Contact);
        getContentPane().add(Food);
        getContentPane().add(Drink);
        getContentPane().add(Type);
        getContentPane().add(tfNumber);
        getContentPane().add(tfName);
        getContentPane().add(tfContact);
        getContentPane().add(reset);
        getContentPane().add(receipt);
        getContentPane().add(print);
        getContentPane().add(cb1);
        getContentPane().add(cb2);
        getContentPane().add(r1);
        getContentPane().add(r2);
        getContentPane().add(area1);


        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MyResturant();
    }
}
