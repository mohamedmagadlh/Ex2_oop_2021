package api.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class window extends JFrame implements ActionListener {
    int width;
    int length;

    JTextField text = new JTextField();
    Myframe myframe;

    JButton save = new JButton("Save");
    JButton load = new JButton("Load");
    JButton addnode = new JButton("addnode");
    JButton addedge = new JButton("addedge");
    JButton removenode = new JButton("removenode");
    JButton removerdge = new JButton("removerdge");

    public window(String flag, Myframe myframe) {

        this.myframe = myframe;
        if(flag.equals("addnode")){
            this.setLayout(new FlowLayout());
            text.setSize(385,45);
            addnode.addActionListener(this);
            this.add(addnode);
            this.add(new Label("id"));
            this.add(new Label("geolocation"));
            this.add(text);
            this.pack();
        }
        if (flag.equals("load")) {
            this.setLayout(new FlowLayout());
            text.setSize(385,45);
            load.addActionListener(this);
            this.add(load);
            this.add(new Label("Pt"));
            this.add(text);
            this.pack();
        }
        if (flag.equals("save")) {
            this.setLayout(new FlowLayout());
            text.setSize(385,45);
            save.addActionListener(this);
            this.add(save);
            this.add(new Label("Pt"));
            this.add(text);
            this.pack();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == save) {
            myframe.save(text.getText());
            this.dispose();
        } else if (e.getSource() == load) {
            myframe.load(text.getText());
            this.dispose();
        }

    }
}

