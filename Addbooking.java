import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
//import java.text.DateFormat;

class Add  {
    JLabel id,name,classlabel,traveldate,totalprice,from,to,ticketnumber;
    JTextField idtextfield,nametextfield,classtextfield,traveldatetextfield,totalpricetextfield,fromtextfield,totextfield,ticketnumbertextfield;
    JButton  cancel,add;
    Add(){
        JFrame frame = new JFrame();
        frame.setTitle("Add Pessanger");
        frame.setSize(800,400);
        frame.setVisible(true);

        GridLayout grid = new GridLayout(5,4);
        frame.setLayout(null);

        id=new JLabel("Id  :");
        id.setBounds(50, 50, 100, 30);
        name=new JLabel("Name  :");
        name.setBounds(400, 50, 100, 30);
        classlabel=new JLabel("Class  :");
        classlabel.setBounds(50, 70, 200, 100);
        traveldate=new JLabel("Travel Date :");
        traveldate.setBounds(400, 70, 400, 100);
        totalprice=new JLabel("Total Price :");
        totalprice.setBounds(50, 90, 600, 200);
        from=new JLabel("From :");
        from.setBounds(400, 90, 800, 200);
        to=new JLabel("To :");
        to.setBounds(50, 110, 1000, 300);
        ticketnumber=new JLabel("Ticket Number :");
        ticketnumber.setBounds(400, 110, 1200, 300);

        idtextfield=new JTextField();
        idtextfield.setBounds(140, 50, 120, 30);
        nametextfield=new JTextField();
        nametextfield.setBounds(540, 50, 120, 30);
        classtextfield=new JTextField();
        classtextfield.setBounds(140, 100, 120, 30);
        traveldatetextfield=new JTextField();
        traveldatetextfield.setBounds(540, 100, 120, 30);
        totalpricetextfield=new JTextField();
        totalpricetextfield.setBounds(140, 170, 120, 30);
        fromtextfield=new JTextField();
        fromtextfield.setBounds(540, 170, 120, 30);
        totextfield=new JTextField();
        totextfield.setBounds(140, 240, 120, 30);
        ticketnumbertextfield=new JTextField();
        ticketnumbertextfield.setBounds(540, 240, 120, 30);

        cancel=new JButton("Cancel");
        add=new JButton("Add");

        frame.add(id);
        frame.add(idtextfield);
        frame.add(name);
        frame.add(nametextfield);
        frame.add(classlabel);
        frame.add(classtextfield);
        frame.add(traveldate);
        frame.add(traveldatetextfield);
        frame.add(totalprice);
        frame.add(totalpricetextfield);
        frame.add(from);
        frame.add(fromtextfield);
        frame.add(to);
        frame.add(totextfield);
        frame.add(ticketnumber);
        frame.add(ticketnumbertextfield);

        
        frame.add(cancel);
        cancel.setBounds(400,300,80,30);
        frame.add(add);
        add.setBounds(550,300,80,30);

        add.addActionListener(new ActionListener() {

 @Override 

    public void actionPerformed(ActionEvent e){


    String DB_URL = "jdbc:mysql://localhost:3306/airline";
    String USER = "root";
    String PASS = "";
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
    Statement stmt = conn.createStatement();
    String sql = "insert into `addbooking`"+"(`Name`, `Class`, `Traveldate`, `TotalPrice`, `From`, `To`, `Ticketnumber`)"
    + "values('" + nametextfield.getText() + "','" + classtextfield.getText() + "'," + traveldatetextfield.getText()+","+ Integer.parseInt(totalpricetextfield.getText())+ ",'"+ fromtextfield.getText() +"','"+ totextfield.getText() +"','"+ Integer.parseInt(ticketnumbertextfield.getText())+"')";
    
    int i = stmt.executeUpdate(sql);
    if(i>0){
        System.out.println("ROW INSERTED");
        JOptionPane.showMessageDialog(frame,"Pessanger Added Successfully");
        frame.dispose();
    }
   else{
    System.out.println("ROW  NOT  INSERTED");
   }
   conn.close();
}catch(ClassNotFoundException c){
    System.out.println(c);
}
catch(SQLException SQLException){
    System.out.println(SQLException.getMessage());
}
    }
});
    }
}


