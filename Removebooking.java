import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class Remove extends JFrame{
JLabel idlebel,namelabel;
JTextField idtextfield,nametextfield;
JButton cancelbutton,removebutton;
    Remove(){
        setTitle("Remove Pessanger");
        setSize(600,400);
        setVisible(true);  

        GridLayout grid = new GridLayout(3,2);
        this.setLayout(null);

        idlebel=new JLabel("Id :");

        idtextfield=new JTextField();

        cancelbutton=new JButton("Cancel");
        removebutton=new JButton("Remove");

        this.add(idlebel);
        idlebel.setBounds(200, 80, 100, 50);
        this.add(idtextfield);
        idtextfield.setBounds(250, 80, 100, 50);
        
        


        this.add(cancelbutton);
        cancelbutton.setBounds(150, 240, 100, 40);
        this.add(removebutton);
        removebutton.setBounds(300, 240, 100, 40);

         removebutton.addActionListener(new ActionListener() {
            
                @Override  
            
              public void actionPerformed(ActionEvent e){
                int ID=Integer.parseInt(idtextfield.getText());
                  String DB_URL = "jdbc:mysql://localhost:3306/airline";
                  String USER = "root";
                  String PASS = "";
                   try {
                  Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                  Statement stmt = conn.createStatement();
                  String sql = "DELETE FROM addbooking WHERE Id           = "+ID;
                  stmt.executeUpdate(sql);
                  System.out.println("Record DELETED successfully...");
              } catch (Exception s) {
                  s.printStackTrace();
              }
                }
              });
              cancelbutton.addActionListener(event-> {
                
                this.dispose();
              });

    }
}
