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

public class numberguess extends JFrame implements ActionListener {
JLabel wel_Label,label1,label2,label3,attempts;
 JPanel panel1,panel2,panel3;
 JTextField tf;
 JButton button,button2;
 int random,count,score=100;
  Random rand = new Random();
 numberguess(){
    count = 0;
     random=rand.nextInt(100);

     System.out.println(random);
   // this.setLayout(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Number Guessing Game");
    this.setSize(750,550);
    this.setResizable(false);


   
    wel_Label =new JLabel("Number Guessing Game");
    wel_Label.setBounds(0,0,650,70);
    wel_Label.setForeground(Color.RED);
    wel_Label.setFont(new Font("Franklin Gothic",Font.PLAIN,40));
   wel_Label.setHorizontalAlignment(JLabel.CENTER);
   wel_Label.setVerticalTextPosition(JLabel.TOP);
    wel_Label.setOpaque(false);


    panel1 = new JPanel();
    panel2= new JPanel();
    panel3 = new JPanel();
    panel3.setBackground(new Color(51,35,45));
    panel3.setBounds(0, 0, 750, 550);
    panel3.setOpaque(true);


    panel1.setBounds(0, 200, 700, 200);
    panel1.setBackground(new Color(45,35,51));
    panel1.setOpaque(true);

    
    panel2.setBounds(0, 400, 700, 200);
    panel2.setBackground(Color.cyan);
    panel2.setOpaque(true);


     label2 =new JLabel("Enter any number b/w 1-100");
    label2.setBounds(0, 0, 750, 20);
    label2.setFont(new Font("calibre",Font.PLAIN,20));
   // label2.setVerticalAlignment(JLabel.CENTER);
    label2.setHorizontalTextPosition(JLabel.CENTER);
    label2.setVerticalTextPosition(JLabel.CENTER);
    label2.setForeground(new Color(205,105,255));
    label2.setOpaque(false);


    attempts = new JLabel("No. of attempts : 0");
    attempts.setForeground(new Color(35,45,51));
    attempts.setVerticalAlignment(JLabel.CENTER);
    attempts.setVerticalTextPosition(JLabel.CENTER);
   // attempts.setBounds(0,20 ,750 ,150 );


     tf=new JTextField("enter number");
    tf.setBounds(100, 200, 750, 300);


     button = new JButton("Guess");
     button.setFont(new Font("MV BOLLI", Font.ITALIC, 10));
         button.setBounds(100, 300, 150, 30);

     button.setForeground(new Color(10,43,28));
     button.setBackground(new Color(86,91,99));
    button.setFocusable(false);
    button.addActionListener(this);




    label3 = new JLabel("   ");
 //   label3.setBounds(0, 0, 750, 400);
    label3.setVerticalAlignment(JLabel.CENTER);
    label3.setFont(new Font("calibre",Font.PLAIN,30));
    label3.setOpaque(false);


    button2 = new JButton("try again");
    button2.setBounds(250, 250, 100, 50);
    button2.setVerticalAlignment(JButton.CENTER);
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
    panel3.add(wel_Label);
    panel3.add(panel1);
    panel3.add(panel2);
    this.add(panel3);
    this.setVisible(true);

 }

public static void main(String[] args) {
   numberguess nm= new numberguess();
    
}

@Override
public void actionPerformed(ActionEvent e) {
  try {
    if(e.getSource()==button){
         panel1.setVisible(false);
         panel2.setVisible(true);
      
         if(count<5){
           String text=tf.getText();
         int n=Integer.parseInt(text);
   
   
                   
            tf.setText("enter number");

             
                count++;
            if(count==4)
                tf.setText("last try");
                attempts.setText("No. of attempts : "+count);

        
         if(n==random)
            {
               
                tf.setText("enter number");
                button2.setText("play again");
                if (count==5) {
                  score= 20;
                }
                label3.setText("Great! you Won     your score : "+score);
                score = 100;
                 count = 0; 
                random = rand.nextInt(100);
                System.out.println(random);
             }
             else  if(count==5)
                 {
                    label3.setText("you lose");
                    button2.setText("play again");
                    tf.setText("enter number");
                    score = 100;
                    random = rand.nextInt(100);

                 }            
        else if(n<random){
                button2.setText("try again");
                label3.setText("too low");
               
            }

    else 
    {
        button2.setText("try again");
        label3.setText("too high");       
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

  } catch (Exception m) {
   
    m.getMessage();
  }  
}
}