import javax.swing.*;

public class MyResturant extends JFrame {
    JLabel Customer,Name,Contact;
    JTextField tfNumber, tfName,tfContact;
    MyResturant(){
         setTitle("Resturant and Coffee");
         setSize(600,500);

         Customer=new JLabel("Customer No:");
         Customer.setBounds(20,20,120,30);

         getContentPane().add(Customer);

         setVisible(true);

    }
    public static void main (String [] args)
    {

    }
}
