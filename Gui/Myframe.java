package api.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import api.Gui.CirclePanel;
public class Myframe extends JFrame implements ActionListener, MouseListener {
    JButton addnodeButt, removenodeButt, addedgeButt, removedgeButt;
    JPanel jPanel;
    Myframe() {
        addnodeButt = new JButton();
        removenodeButt = new JButton();
        addedgeButt = new JButton();
        removedgeButt = new JButton();
        /////////////////////////////
        addnodeButt.setBounds(620, 622, 0, 0);
        addnodeButt.setSize(120, 40);
        addnodeButt.setVisible(true);
        /////////////////////////////
        removenodeButt.setBounds(500, 622, 0, 0);
        removenodeButt.setSize(120, 40);
        removenodeButt.setVisible(true);
        /////////////////////////////
        addedgeButt.setBounds(400, 622, 0, 0);
        addedgeButt.setSize(100, 40);
        addedgeButt.setVisible(true);
        /////////////////////////////
        removedgeButt.setBounds(300, 622, 0, 0);
        removedgeButt.setSize(100, 40);
        removedgeButt.setVisible(true);
        /////////////////////////////
        addnodeButt.setText("addnode");
        addnodeButt.setFocusable(false);
        addnodeButt.setBackground(Color.lightGray);
        /////////////////////////////
        removenodeButt.setText("removenode");
        removenodeButt.setFocusable(false);
        removenodeButt.setBackground(Color.lightGray);
        /////////////////////////////
        addedgeButt.setText("addedge");
        addedgeButt.setFocusable(false);
        addedgeButt.setBackground(Color.lightGray);
        /////////////////////////////
        removedgeButt.setText("removedge");
        removedgeButt.setFocusable(false);
        removedgeButt.setBackground(Color.lightGray);
        ////////////////////////////
        addnodeButt.addActionListener(this);
        removenodeButt.addActionListener(this);
        addedgeButt.addActionListener(this);
        removedgeButt.addActionListener(this);
        this.addMouseListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        this.pack();
        setSize(750, 700);
        setVisible(true);
        ///////////////////////
        this.add(addnodeButt);
        this.add(removenodeButt);
        this.add(addedgeButt);
        this.add(removedgeButt);


    }

    public static void main(String[] args) {
        new Myframe();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addnodeButt) {
            System.out.println("addnode");
        }
        if (e.getSource() == removenodeButt) {
            System.out.println("removenode");
        }
        if (e.getSource() == addedgeButt) {
            System.out.println("addedge");
        }
        if (e.getSource() == removedgeButt) {
            System.out.println("removedge");
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        Graphics g = getGraphics() ;
        g.setColor(Color.pink);
        g.fillOval(e.getX(),e.getY(),40,40);
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}