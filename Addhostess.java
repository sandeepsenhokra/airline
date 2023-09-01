import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;




class Addhostess extends JFrame {
    JLabel idlabel,namelabel,emaillabel,phonelabel;
    JTextField idtextfield,nametextfield,emailtextfield,phonetextfield;
    JButton  cancelbutton,addbutton;

    Addhostess(){
        setTitle("Add Hostess");
        setSize(800,400);
        setVisible(true);

        GridLayout grid = new GridLayout(5,4);
        this.setLayout(null);

        idlabel=new JLabel("Id  :");
        idlabel.setBounds(50, 50, 100, 30);
        namelabel=new JLabel("Name  :");
        namelabel.setBounds(400, 50, 100, 30);
        emaillabel=new JLabel("E-mail  :");
        emaillabel.setBounds(50, 70, 200, 100);
        phonelabel=new JLabel("Phone :");
        phonelabel.setBounds(400, 70, 400, 100);
        
        idtextfield=new JTextField();
        idtextfield.setBounds(140, 50, 120, 30);
        nametextfield=new JTextField();
        nametextfield.setBounds(540, 50, 120, 30);
        emailtextfield=new JTextField();
        emailtextfield.setBounds(140, 100, 120, 30);
        phonetextfield=new JTextField();
        phonetextfield.setBounds(540, 100, 120, 30);
       
        
        cancelbutton=new JButton("Cancel");
        addbutton=new JButton("Add");

        this.add(idlabel);
        this.add(idtextfield);
        this.add(namelabel);
        this.add(nametextfield);
        this.add(emaillabel);
        this.add(emailtextfield);
        this.add(phonelabel);
        this.add(phonetextfield);
        

        
        this.add(cancelbutton);
        cancelbutton.setBounds(400,300,80,30);
        this.add(addbutton);
        addbutton.setBounds(550,300,80,30);

        addbutton.addActionListener(new ActionListener() {

 @Override 

    public void actionPerformed(ActionEvent e){


    String DB_URL = "jdbc:mysql://localhost:3306/airline";
    String USER = "root";
    String PASS = "";
    String sql = "INSERT INTO `addhostess` (`Id`, `Name`, `E-mail`, `Phone`) VALUES (?, ?, ?, ?)";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, idtextfield.getText());
        pstmt.setString(2, nametextfield.getText());
        pstmt.setString(3, emailtextfield.getText());
        pstmt.setLong(4, Long.parseLong(phonetextfield.getText()));
        
        int i = pstmt.executeUpdate();
        
        if (i > 0) {
            System.out.println("ROW INSERTED");
            JOptionPane.showMessageDialog(null, "Hostess Added Successfully");
            //this.dispose();
        } else {
            System.out.println("ROW NOT INSERTED");
        }
        
        conn.close();
    } catch (ClassNotFoundException c) {
        System.out.println(c);
    } catch (SQLException ob) {
        System.out.println(ob.getMessage());
    }
}
});
cancelbutton.addActionListener(event->{
       this.dispose();
    });
    }
}

