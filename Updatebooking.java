import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class Update extends JFrame {
    JLabel namelabel,totalpricelabel,ticketnumberlabel,idlabel,fromlabel,tolabel,datelabel,classlabel;
    JTextField nametextfield,totaltexfield,ticketnumbertextfield,idtextfield,fromtextfield,totextfield,datetextfield,classtextfield;
    JButton searchbutton,cancelbutton,updatebutton;
    Update(){
        setTitle("Update Booking");
        setSize(600, 400);
        setVisible(true);

        GridLayout grid =new GridLayout(6,2);
        this.setLayout(null);

        namelabel=new JLabel("Name :");
        namelabel.setBounds(60, 240, 60, 30);
        totalpricelabel=new JLabel("Total price :");
        totalpricelabel.setBounds(60, 280, 60, 30);
        ticketnumberlabel=new JLabel("Ticket Number :");
        ticketnumberlabel.setBounds(60, 320, 60, 30);
        idlabel=new JLabel("Id  :");
        idlabel.setBounds(60, 30, 60, 30);
        fromlabel=new JLabel("From   :");
        fromlabel.setBounds(60, 80, 60, 30);
        tolabel=new JLabel("To  :");
        tolabel.setBounds(60, 120, 60, 30);
        datelabel=new JLabel("Date  :");
        datelabel.setBounds(60, 160, 60, 30);
        classlabel=new JLabel("Class  :");
        classlabel.setBounds(60, 200, 60, 30);

        nametextfield=new JTextField();
        nametextfield.setBounds(140, 240, 100, 30);
        totaltexfield=new JTextField();
        totaltexfield.setBounds(140, 280, 100, 30);
        ticketnumbertextfield=new JTextField();
        ticketnumbertextfield.setBounds(140, 320, 100, 30);
        idtextfield=new JTextField(); 
        idtextfield.setBounds(140, 30, 100, 30);  
        fromtextfield=new JTextField();   
        fromtextfield.setBounds(140, 80, 100, 30);
        totextfield=new JTextField();
        totextfield.setBounds(140, 120, 100, 30);
        datetextfield=new JTextField();   
        datetextfield.setBounds(140, 160, 100, 30);
        classtextfield=new JTextField(); 
        classtextfield.setBounds(140, 200, 100, 30);
        
        searchbutton=new JButton("Search");
        searchbutton.setBounds(250, 30, 100, 30);
        cancelbutton=new JButton("Cancel");
        cancelbutton.setBounds(270, 250, 100, 30);
        updatebutton=new JButton("Update");
        updatebutton.setBounds(400, 250, 100, 30);

        this.add(idlabel);
        this.add(idtextfield);
        this.add(searchbutton);

        this.add(namelabel);
        this.add(nametextfield);

        this.add(totalpricelabel);
        this.add(totaltexfield);

        this.add(ticketnumberlabel);
        this.add(ticketnumbertextfield);

        this.add(fromlabel);
        this.add(fromtextfield);

        this.add(tolabel);
        this.add(totextfield);

        this.add(datelabel);
        this.add(datetextfield);

        this.add(classlabel);
        this.add(classtextfield);

        this.add(cancelbutton);
        this.add(updatebutton);

          updatebutton.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e) {
                String DB_URL = "jdbc:mysql://localhost:3306/airline";
                String USER = "root";
                String PASS = "";
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
                    String query = "UPDATE addbooking SET `From`=?, `To`=?, Traveldate=?, Class=?, Name=?, TotalPrice=?, Ticketnumber=? WHERE Id=?";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, fromtextfield.getText());
                    preparedStatement.setString(2, totextfield.getText());
                    preparedStatement.setString(3, datetextfield.getText());
                    preparedStatement.setString(4, classtextfield.getText());
                    preparedStatement.setString(5, nametextfield.getText());
                    preparedStatement.setString(6, totaltexfield.getText());
                    preparedStatement.setString(7, ticketnumbertextfield.getText());
                    preparedStatement.setString(8, idtextfield.getText());

                    int rowsUpdated = preparedStatement.executeUpdate();
                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(null, "Updated successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "Update failed");
                    }
                    preparedStatement.close();
                    connection.close();
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: Unable to update the passenger.");
                }
            }
  });
  searchbutton.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
        String DB_URL = "jdbc:mysql://localhost:3306/airline";
        String USER = "root";
        String PASS = "";
        try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection connection = DriverManager.getConnection(DB_URL  , USER, PASS);
         String query = "SELECT * FROM addbooking WHERE Id=?";
         PreparedStatement preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, idtextfield.getText());
         ResultSet resultSet = preparedStatement.executeQuery();
         if (resultSet.next()) {
           fromtextfield.setText(resultSet.getString("From"));
           totextfield.setText(resultSet.getString("To"));
           datetextfield.setText(resultSet.getString("Traveldate"));
           classtextfield.setText(resultSet.getString("Class"));
           nametextfield.setText(resultSet.getString("Name"));
           totaltexfield.setText(resultSet.getString("TotalPrice"));
           ticketnumbertextfield.setText(resultSet.getString("Ticketnumber"));

     } else {
           JOptionPane.showMessageDialog(null, "Pessanger not found.");
     }
     resultSet.close();
     preparedStatement.close();
     connection.close();
   } catch (ClassNotFoundException | SQLException ex) {
         ex.printStackTrace();
         JOptionPane.showMessageDialog(null, "Error: Unable to search for the Pessanger.");
   }
    }
  });
   }
}