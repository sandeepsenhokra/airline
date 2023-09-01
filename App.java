// import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App 
{
   public static void main(String[] args) throws Exception {
    JFrame frame = new JFrame();
    
    frame.setTitle("Jagruti Airline");
    frame.setSize(600, 400);
    frame.setVisible(true);


    JMenuBar menuBar = new JMenuBar();
    
    frame.setJMenuBar(menuBar);

    JMenu booking = new JMenu("Booking");
    JMenuItem addbooking = new JMenuItem("Add");
    JMenuItem removebooking = new JMenuItem("Remove");
    JMenuItem updatebooking = new JMenuItem("Update");
    JMenuItem viewallbooking = new JMenuItem("View All");

    booking.add(addbooking);
    booking.add(removebooking);
    booking.add(updatebooking);
    booking.add(viewallbooking);

    menuBar.add(booking);

    JMenu hostess = new JMenu("Hostess");
    JMenuItem addhostess = new JMenuItem("Add");
    JMenuItem removehostess = new JMenuItem("Remove");
    JMenuItem updatehostess = new JMenuItem("Update");
    JMenuItem viewallhostess = new JMenuItem("View All");


    hostess.add(addhostess);
    hostess.add(removehostess); 
    hostess.add(updatehostess);
    hostess.add(viewallhostess);
    
    menuBar.add(hostess);
    
    addbooking.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new Add();
      }
    });

    removebooking.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new Remove();
      }
    });

     updatebooking.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new Update();
      }
    });

    viewallbooking.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new View();
      }
    });

     addhostess.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new Addhostess();
      }
    });

    removehostess.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new Remove2();
      }
    });

    updatehostess.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new Update2();
      }
    });

    viewallhostess.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new Viewhostess();
      }
    });
  
  }  
}