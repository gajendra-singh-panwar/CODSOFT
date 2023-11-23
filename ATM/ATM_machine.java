import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;


// creating a diffrent class for user account data 

 class User_Data {
    int bank_balance ;

    // constructor to initialize user account
    User_Data(){
        bank_balance = 0;
    }
    // method to get the total account balance of user
    public int getBalance(){
        return bank_balance;
    }

    // method to add money to user account
    public void addBalance(int money){
        bank_balance +=money ;
    }

    // method to withdraw money if possible
    public String Withdraw(int amount){
        if(bank_balance <amount){
            return "  Not Sufficient Balance ";
        }
        if(amount<1000)
        return "   Minimum Rs. 1000 is possible";

        if(amount >10000)
        return "    Maximum of Rs. 10000 is possible";
         
        bank_balance -=amount;
        return "   Withdrawl Successfull";
    }
    
}

// our main class starts here
public class ATM_machine extends JFrame implements ActionListener{

   

    // initializing all the required components
    JLabel welcome,display;
    JTextField text;
    JButton withdraw,deposit,balance,insert ,confirm;
    Border blackline = BorderFactory.createLineBorder(new Color(1, 22, 51));
    User_Data user;

    // constructor of main class to initialize our frame
    ATM_machine(){

        // defined our user account here
        user = new User_Data();

        // creating our ATM MACHINE i.e. creating the main frame
        this.setLayout(null);
        this.setSize(700,500);
        this.setTitle("ATM INTERFACE");
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(25, 90, 176));


        // the main heading of our ATM MACHINE 
        welcome = new JLabel("Welcome to our ATM");
        welcome.setBounds(100,20,600,50);
        welcome.setFont(new Font("Times New Roman",Font.BOLD,50));
        welcome.setForeground(new Color(255, 245, 228));


        // ATM MACHINE SCREEN to display messages to user
        display = new JLabel("  How can i help you ?");
        display.setBounds(130,100,400,100);
        display.setFont(new Font("Verdana",Font.PLAIN,30));
        display.setForeground(new Color(255,250,205));
        display.setBackground(new Color(0, 53, 123));
        display.setOpaque(true);
        display.setBorder(blackline);


        // text field to take input from user
        text = new JTextField("Enter Amount");
        text.setBounds(130,100,400,100);
        text.setFont(new Font("Verdana",Font.PLAIN,30));
        text.setForeground(new Color(255,250,205));
        text.setBackground(new Color(0, 53, 123));
        text.setOpaque(true);
        text.setBorder(blackline);
        text.setVisible(false);


        // button to confirm the deposit operation
        insert = new JButton("Confirm");
        insert.setBounds(530,130,150,30);
        insert.setFont(new Font("Roboto",Font.PLAIN,20));
        insert.setForeground(new Color(255,250,230));
        insert.setBackground(new Color(32, 176, 56));
        insert.setFocusable(false);
        insert.addActionListener(this);
        insert.setEnabled(false);
        insert.setVisible(false);


        //  this is a button in our ATM MACHINE visible when user want to withdram money 
        // it is a button to confirm the withdraw operations
        confirm = new JButton("Confirm");
        confirm.setBounds(530,130,150,30);
        confirm.setFont(new Font("Roboto",Font.PLAIN,20));
        confirm.setForeground(new Color(255,250,230));
        confirm.setBackground(new Color(32, 176, 56));
        confirm.setFocusable(false);
        confirm.addActionListener(this);
        confirm.setEnabled(false);
        confirm.setVisible(false);




        // button in our ATM to  check bank balance
        balance = new JButton("Check Balance");
        balance.setBounds(230,230,200,30);
        balance.setFont(new Font("Roboto",Font.PLAIN,20));
        balance.setFocusable(false);
        balance.setForeground(new Color(255,250,230));
        balance.setBackground(new Color(32, 176, 56));
        balance.addActionListener(this);


        // button in ATM to deposit money in account
        deposit = new JButton("Deposit");
        deposit.setBounds(230,280,200,30);
        deposit.setFont(new Font("Roboto",Font.PLAIN,20));
        deposit.setForeground(new Color(255,250,230));
        deposit.setBackground(new Color(32, 176, 56));
        deposit.setFocusable(false);
        deposit.addActionListener(this);



        // button in ATM to withdram money from account
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(230,330,200,30);
        withdraw.setFont(new Font("Roboto",Font.PLAIN,20));
        withdraw.setForeground(new Color(255,250,230));
        withdraw.setBackground(new Color(32, 176, 56));
        withdraw.setFocusable(false);
        withdraw.addActionListener(this);


        // adding all the components i.e. labels ,buttons and text field to our main frame 
        this.add(welcome);
        this.add(display);
        this.add(text);
        this.add(insert);
        this.add(confirm);
        this.add(balance);
        this.add(deposit);
        this.add(withdraw);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // our main method starts here
    public static void main(String[] args) {

        // creating object of our main ATM MACHINE class
        ATM_machine atm = new ATM_machine();
    }


    // method overrided of ACTIONLISTENER interface to perform various click operations of buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        display.setFont(new Font("Verdana",Font.PLAIN,30));

        // defining functionality of CHECK BALANCE button
       if(e.getSource()==balance){

        display.setFont(new Font("Verdana",Font.PLAIN,20));
        display.setText("Your Account Balance : "+user.getBalance());
       }

       // defining functionality of DEPOSIT button
       if(e.getSource()==deposit){

        display.setVisible(false);
        text.setVisible(true);
        insert.setEnabled(true);
        insert.setVisible(true);
       

       }


       // defining functionality of WITHDRAW button 
       if(e.getSource()==withdraw){

        display.setVisible(false);
        text.setVisible(true);
        confirm.setEnabled(true);
        confirm.setVisible(true);
       
       }

       // defining functionality of CONFIRM button of DEPOSIT operation
       if(e.getSource()==insert){
         int amount = Integer.parseInt(text.getText());
        user.addBalance(amount);
        display.setVisible(true);
        text.setVisible(false);
        insert.setEnabled(false);
        insert.setVisible(false);
        text.setText("Enter Amount");
        display.setText("Deposit Successfull  ");
       }

       // defining functionality of CONFIRM button of WITHDRAW operation.
       if(e.getSource()==confirm){
         int amount = Integer.parseInt(text.getText());
         display.setVisible(true);
         text.setText("Enter Amount");
        display.setFont(new Font("Verdana",Font.PLAIN,20));
        display.setText(user.Withdraw(amount));
        text.setVisible(false);
        confirm.setEnabled(false);
        confirm.setVisible(false);
       }
    }
}
// our code finishes here 
// THANK YOU FOR VISITING