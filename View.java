import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame implements ActionListener{
      JButton view;
        View()
        {
            view=new JButton("View");
            view.setBounds(100, 50, 300, 30);
            view.addActionListener(this);
            this.add(view);
            setSize(900, 900);
            setVisible(true);
            setTitle("View All Pessanger");
            setLocation(300, 30);
         }
     
          public void actionPerformed(ActionEvent e)
          {
            if(e.getSource()==view)
            {
              String url = "jdbc:mysql://localhost:3306/airline";
              String username = "root";
              String password = "";
        
         try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection connection = DriverManager.getConnection(url, username, password);
         String query = "SELECT * FROM addbooking";
         PreparedStatement preparedStatement = connection.prepareStatement(query);
         ResultSet resultSet = preparedStatement.executeQuery();
         DefaultTableModel tableModel = new DefaultTableModel();
         tableModel.addColumn("Id");
         tableModel.addColumn("Name");
         tableModel.addColumn("Class");
         tableModel.addColumn("Travaldate");
         tableModel.addColumn("TotalPrice");
         tableModel.addColumn("From");
         tableModel.addColumn("To");
         tableModel.addColumn("Ticketnumber");
         while (resultSet.next()) {
          String id = resultSet.getString("Id");
          String name = resultSet.getString("Name");
          String clas = resultSet.getString("Class");
          String travel = resultSet.getString("Traveldate");
          String totalprice= resultSet.getString("TotalPrice");
          String from = resultSet.getString("From");
          String to = resultSet.getString("To");
          String ticketnumber = resultSet.getString("Ticketnumber");
      tableModel.addRow(new Object[]{id, name, clas, travel,totalprice,from,to,ticketnumber});
 }
   JTable bookTable = new JTable(tableModel);
   JScrollPane scrollPane = new JScrollPane(bookTable);
   getContentPane().removeAll();   
   getContentPane().add(scrollPane);
   revalidate(); 
   resultSet.close();
   preparedStatement.close();
   connection.close();
  } 
  catch (Exception obj) {
     obj.printStackTrace();
     JOptionPane.showMessageDialog(null, "Error: Unable to retrieve book information.");
      }
    }
 }
}
