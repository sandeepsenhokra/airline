import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class Remove2 extends JFrame{
JLabel idlabel, label1;
JTextField idtextfield;
JButton cancelbutton,removebutton;
    Remove2(){
        setTitle("Remove Hostess");
        setSize(500,300);
        setLocation(200, 100);
        setVisible(true);

        idlabel=new JLabel("Id  :");
        idlabel.setBounds(200, 100, 60, 40);

        idtextfield=new JTextField();
        idtextfield.setBounds(250, 100, 60, 40);

        cancelbutton=new JButton("Cancel");
        cancelbutton.setBounds(120, 200, 100, 40);
        removebutton=new JButton("Remove");
        removebutton.setBounds(240, 200, 100, 40);
        label1 = new JLabel();

        this.add(idlabel);
        this.add(idtextfield);

        this.add(cancelbutton);
        this.add(removebutton);
        this.add(label1);

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
                  String sql = "DELETE FROM addhostess WHERE Id           = "+ID;
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
