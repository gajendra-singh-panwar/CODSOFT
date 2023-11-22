import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StudentGrade extends JFrame  implements ActionListener{
    JLabel title,name,marks1,marks2,marks3,marks4,marks5,result,totalmarks,percentage,grade;
    JTextField namefield,marksfield1,marksfield2,marksfield3,marksfield4,marksfield5;
    JButton result_button;
    int total=0;
    float percent;
    char Grade;
    String Student_name;
StudentGrade(){
    // creating out main frame
    this.setLayout(null);
    this.setSize(750,850);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Student Grade Calculator ");


    // set the title of  our frame
    title = new JLabel("Student Grade Calculator ");
    title.setBounds(50, 10, 700, 50);
    title.setFont(new Font("Algerian",Font.BOLD,40));
    title.setForeground(new Color(200,45,150));



    // label for student name
    name = new JLabel("Enter Student Name : ");
    name.setBounds(50, 70, 300, 50);
    name.setFont(new Font("Verdana",Font.ITALIC,20));
    name.setForeground(new Color(145,125,255));


    // taking input of student name
    namefield = new JTextField();
    namefield.setBounds(350, 85, 300, 30);
    namefield.setFont(new Font("Verdana",Font.ITALIC,20));


   




    // label for marks of  subject no. 1
    marks1 = new JLabel("Enter Marks of Computer :");
    marks1.setBounds(50,165,300,50);
    marks1.setFont(new Font("Verdana",Font.ITALIC,20));
    marks1.setForeground(new Color(240,150,0));



    // taking input of  subject 1
    marksfield1 = new JTextField();
    marksfield1.setBounds(350,180,300,30);
    marksfield1.setFont(new Font("Verdana",Font.ITALIC,20));



     // label for marks of  subject no. 2
    marks2 = new JLabel("Enter Marks of Maths :");
    marks2.setBounds(50,215,300,50);
    marks2.setFont(new Font("Verdana",Font.ITALIC,20));
    marks2.setForeground(new Color(240,150,0));



    // taking input of  subject 2
    marksfield2 = new JTextField();
    marksfield2.setBounds(350,230,300,30);
    marksfield2.setFont(new Font("Verdana",Font.ITALIC,20));


     // label for marks of  subject no. 3
    marks3 = new JLabel("Enter Marks of Physics :");
    marks3.setBounds(50,265,300,50);
    marks3.setFont(new Font("Verdana",Font.ITALIC,20));
    marks3.setForeground(new Color(240,150,0));



    // taking input of  subject 3
    marksfield3 = new JTextField();
    marksfield3.setBounds(350,280,300,30);
    marksfield3.setFont(new Font("Verdana",Font.ITALIC,20));



     // label for marks of  subject no. 4
    marks4 = new JLabel("Enter Marks of Hindi :");
    marks4.setBounds(50,315,300,50);
    marks4.setFont(new Font("Verdana",Font.ITALIC,20));
    marks4.setForeground(new Color(240,150,0));



    // taking input of  subject 4
    marksfield4 = new JTextField();
    marksfield4.setBounds(350,330,300,30);
    marksfield4.setFont(new Font("Verdana",Font.ITALIC,20));



     // label for marks of  subject no. 5
    marks5 = new JLabel("Enter Marks of English :");
    marks5.setBounds(50,365,300,50);
    marks5.setFont(new Font("Verdana",Font.ITALIC,20));
    marks5.setForeground(new Color(240,150,0));



    // taking input of  subject 5
    marksfield5 = new JTextField();
    marksfield5.setBounds(350,380,300,30);
    marksfield5.setFont(new Font("Verdana",Font.ITALIC,20));





    



    // button to show the total result
    result_button = new JButton("See Result");
    result_button.setBounds(300,450,150,30);
    result_button.setFont(new Font("Roboto",Font.BOLD,20));
    result_button.setForeground(new Color(255,100,18));
    result_button.setBackground(new Color(100,250,250)); 
    result_button.setFocusable(false);
    result_button.addActionListener(this);



    // this will show the name of student with a string
    result = new JLabel("Getting your Result ");
    result.setBounds(80,500,670,50);
    result.setFont(new Font("Times New Roman",Font.BOLD,30));
    result.setForeground(Color.RED);



    // this will display total marks of student 
    totalmarks = new JLabel("your total marks : ");
    totalmarks.setBounds(150,570,500,50);
    totalmarks.setFont(new Font("Times New Roman",Font.PLAIN,30));
    totalmarks.setForeground(Color.BLACK);



    // this will display the overall percentage of student 
    percentage = new JLabel("your percentage are : ");
    percentage.setBounds(150,650,500,50);
    percentage.setFont(new Font("Times New Roman",Font.PLAIN,30));
    percentage.setForeground(new Color(67,45,89));




    // this will display grade of student
    grade =  new JLabel("you got Grade : ");
    grade.setBounds(150,720,500,50);
    grade.setFont(new Font("Times New Roman",Font.PLAIN,30));
    grade.setForeground(new Color(78,123,231));




    // intially we won't show the result to student so 
    result.setVisible(false);
    totalmarks.setVisible(false); 
    percentage.setVisible(false); 
    grade.setVisible(false); 
 

    // adding all elements to our main frame 
    this.add(title);
    this.add(name);
    this.add(namefield);
    this.add(marks1);
    this.add(marksfield1);
    this.add(marks2);
    this.add(marksfield2);
    this.add(marks3);
    this.add(marksfield3);
    this.add(marks4);
    this.add(marksfield4);
    this.add(marks5);
    this.add(marksfield5);
    this.add(result_button);
    this.add(result);
    this.add(totalmarks);
    this.add(percentage);
    this.add(grade);
    this.setVisible(true);

   
}
    public static void main(String[] args) {
        StudentGrade student = new StudentGrade();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
      
         if(e.getSource()==result_button){

            Student_name = namefield.getText();

            total +=Integer.parseInt(marksfield1.getText());
            total +=Integer.parseInt(marksfield2.getText());
            total +=Integer.parseInt(marksfield3.getText());
            total +=Integer.parseInt(marksfield4.getText());
            total +=Integer.parseInt(marksfield5.getText());



           

            percent= total/5;


            if(percent>=0&&percent<33)
                Grade = 'F';
            else if(percent>=33&&percent<50)
            Grade = 'D';
            else if(percent>=50&&percent<70)
             Grade = 'C';
             else if(percent>=70&&percent<85)
              Grade = 'B';
            else Grade = 'A';


            //setting student's result
            result.setText("Hello! "+Student_name+" Your Result is here :");
            totalmarks.setText("Your total marks are : "+total);
            percentage.setText("You Percentage are : "+percent+"%");
            grade.setText("You Got "+Grade+" Grade");
            // showing result to student 
            result.setVisible(true);
            totalmarks.setVisible(true); 
            percentage.setVisible(true); 
            grade.setVisible(true); 







        }
    }
}