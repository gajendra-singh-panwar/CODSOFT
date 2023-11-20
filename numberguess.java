import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class numberguess extends JFrame implements ActionListener{
JLabel wel_Label,label1,label2,label3,attempts;
 JPanel panel1,panel2;
 JTextField tf;
 JButton button,button2;
 int random,count,score=100;
  Random rand = new Random();
 numberguess(){
    count = 0;
         random=rand.nextInt(100);

     System.out.println(random);
    this.setLayout(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Number Guessing Game");
    this.setSize(750,250);
    this.setResizable(false);
    this.setBackground(Color.black);


   
     wel_Label =new JLabel("Number Guessing Game");
    wel_Label.setBounds(0,0,650,70);
    wel_Label.setFont(new Font("Franklin Gothic",Font.PLAIN,40));
    wel_Label.setHorizontalAlignment(JLabel.CENTER);
    wel_Label.setForeground(Color.MAGENTA);
    wel_Label.setOpaque(true);


      panel1 = new JPanel();
     panel2= new JPanel();
    panel1.setBounds(0, 100, 750, 500);
    panel2.setBounds(0, 100, 750, 500);


     label2 =new JLabel("Enter any number b/w 1-100");
    label2.setBounds(0, 0, 750, 20);
    label2.setFont(new Font("calibre",Font.PLAIN,20));
    label2.setForeground(new Color(200,32,34));
    label2.setOpaque(true);


    attempts = new JLabel("No. of attempts : 0");
    attempts.setBounds(0,20 ,750 ,150 );


     tf=new JTextField("enter number");
    tf.setBounds(100, 200, 750, 300);


     button = new JButton("Guess");
    button.setFocusable(false);
    button.addActionListener(this);




    label3 = new JLabel();
    label3.setBounds(0, 0, 750, 400);
    label3.setFont(new Font("calibre",Font.PLAIN,30));



    button2 = new JButton("try again");
    button2.setBounds(250, 250, 100, 50);
    button2.setFocusable(false);
    button2.addActionListener(this);

    panel1.add(label2);
    panel1.add(attempts);
    panel1.add(tf);
    panel1.add(button);

    panel1.setVisible(true);

    panel2.add(label3);
    panel2.add(attempts);
    panel2.add(button2);
    panel2.setVisible(false);
    this.add(wel_Label);
    this.add(panel1);
    this.add(panel2);
    this.setVisible(true);

 }

public static void main(String[] args) {
   numberguess nm= new numberguess();
    
}

@Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource()==button){
         panel1.setVisible(false);
         panel2.setVisible(true);
        if(count<=5){
             if(count==3)
    tf.setText("last try");
            count++;
            
         attempts.setText("No. of attempts : "+count);

    String text=tf.getText();
    tf.setText("enter number");
    int n=Integer.parseInt(text);
   
   
    if(n==random)
   {
    count = 0; 
    random = rand.nextInt(100);
    System.out.println(random);
    tf.setText("enter number");
    button2.setText("play again");
    label3.setText("Great! you Won     your score : "+score);
    score = 100;
        }
        else if(n<random){
            button2.setText("try again");
            label3.setText("too low");
            if(count==5)
           {
             label3.setText("you lose");
             button2.setText("play again");
             tf.setText("enter number");
             score = 100;
             random = rand.nextInt(100);

            }
            
               
    
}

    else {
        button2.setText("try again");
         label3.setText("too high");
         if(count==5)
              {  label3.setText("you lose");
              button2.setText("play again");
              tf.setText("enter number");
              score = 100;
              random = rand.nextInt(100);

    }
                
       
    }
    score-=20;
   }
   else {
    count = 0;
    score = 100;
    button2.setText("Play again");
    label3.setText("you lose");
    random=rand.nextInt(100);
   
}
    }
else if(e.getSource()==button2){
    panel2.setVisible(false);
    panel1.setVisible(true);
}

}
}