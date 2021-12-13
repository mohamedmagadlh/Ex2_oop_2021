package api.Gui;

import api.api.NodeData;
import api.imp.DWG;
import api.imp.DWGAlgo;
import api.imp.impGeoLocation;
import api.imp.impNodeData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Myframe extends JFrame implements ActionListener, MouseListener {
    public static void main(String[] args) {
        new Myframe(graphalgo);
    }

    Window window;
    MenuItem load = new MenuItem("Load");
    MenuItem save = new MenuItem("Save");
    MenuItem addNode = new MenuItem("AddNode");
    MenuItem removeNode = new MenuItem("RemoveNodes");
    MenuItem connect = new MenuItem("ConnectNodes");
    MenuItem removeEdge = new MenuItem("RemoveEdge");
    MenuItem shortestPath = new MenuItem("ShortestPath");
    MenuItem shortestPathDist = new MenuItem("shortestPathDist");
    MenuItem isConnected = new MenuItem("isConnected");
    MenuItem center = new MenuItem("Center");
    MenuItem tsp = new MenuItem("TSP");

    ////////////////////////////
    public void init() {
        this.setLayout(new FlowLayout());
        this.setTitle("Directed Weighted Graph ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(260, 120, 1000, 500);
        this.setVisible(true);
    }

    static DWGAlgo graphalgo = new DWGAlgo();

    public Myframe( DWGAlgo graphalgo )
 {
        init();
        graphalgo.load("C:\\Users\\moham\\OneDrive\\Desktop\\Ex2_oop_2021\\json\\G1.json");
        addMenu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addNode) {
            JPanel addnode = new JPanel();
            JTextField key = new JTextField(8);
            JTextField x = new JTextField(8);
            JTextField y = new JTextField(8);
            JTextField z = new JTextField(8);
            ////////////////////////////
            addnode.add(Box.createVerticalStrut(10));
            addnode.add(new JLabel("id"));
            addnode.add(key);
            addnode.add(Box.createVerticalStrut(10));
            addnode.add(new JLabel("x"));
            addnode.add(x);
            addnode.add(Box.createVerticalStrut(10));
            addnode.add(new JLabel("y"));
            addnode.add(y);
            addnode.add(Box.createVerticalStrut(10));
            addnode.add(new JLabel("z"));
            addnode.add(z);
            ////////////////////////////
            int addeN = JOptionPane.showConfirmDialog(null, addnode, "",
                    JOptionPane.CANCEL_OPTION);

            System.out.println(JOptionPane.OK_OPTION);
            if (addeN == JOptionPane.OK_OPTION) {
                try {
                    int id = Integer.parseInt(key.getText());
                    Double x1 = Double.parseDouble(x.getText());
                    Double y1 = Double.parseDouble(y.getText());
                    Double z1 = Double.parseDouble(z.getText());
                    //////////////////////////
                    if (graphalgo.getGraph() != null) {
                        graphalgo.getGraph().addNode(new impNodeData(id, new impGeoLocation(x1, y1, z1), 0, "", 0));
                    } else {
                        DWG graph = new DWG();
                        impNodeData node = new impNodeData(id, new impGeoLocation(x1, y1, z1), 0, "", 0);
                        graph.addNode(node);
                        graphalgo.init(graph);
                    }
                    drawN(id, x1, y1, z1);
                } catch (NumberFormatException ex) {
                    return;
                }
                if (e.getSource() == removeNode) {
                    JPanel removenode = new JPanel();
                    JTextField removeid = new JTextField(8);
                    removenode.add(new JLabel(""));
                    removenode.add(removeid);

                    int removenodes = JOptionPane.showConfirmDialog(null, removenode, "", JOptionPane.CANCEL_OPTION);
                    if (removenodes == JOptionPane.OK_OPTION) {
                        try {
                            int id = Integer.parseInt(removeid.getText());
                            graphalgo.getGraph().removeNode(id);
                        } catch (IllegalArgumentException ex) {
                            return;
                        }
                    }
                }
                if (e.getSource() == removeEdge) {
                    JPanel removedge = new JPanel();
                    JTextField removesrc = new JTextField(8);
                    JTextField removedest = new JTextField(8);
                    removedge.add(removesrc);
                    removedge.add(removedest);
                    removedge.add(Box.createVerticalStrut(10));

                    int removedges = JOptionPane.showConfirmDialog(null, removedge, "", JOptionPane.CANCEL_OPTION);

                    if (removedges == JOptionPane.OK_OPTION) {
                        try {
                            int src = Integer.parseInt(removesrc.getText());
                            int dest = Integer.parseInt(removedest.getText());
                            graphalgo.getGraph().removeEdge(src, dest);
                        } catch (NumberFormatException ex) {
                            return;
                        }
                    }
                }
                if (e.getSource() == connect) {
                    JPanel addedge = new JPanel();
                    JTextField src = new JTextField(8);
                    JTextField dest = new JTextField(8);
                    JTextField w = new JTextField(8);
                    addedge.add(src);
                    addedge.add(Box.createVerticalStrut(10));
                    addedge.add(dest);
                    addedge.add(w);

                    int addedges = JOptionPane.showConfirmDialog(null, addedge, "", JOptionPane.CANCEL_OPTION);
                    if (addedges == JOptionPane.OK_OPTION) {
                        try {
                            int src1 = Integer.parseInt(src.getText());
                            int dest1 = Integer.parseInt(dest.getText());
                            double w1 = Double.parseDouble(w.getText());
                            if (graphalgo.getGraph().nodeSize() > 1) {
                                graphalgo.getGraph().connect(src1, dest1, w1);
                            }
                        } catch (NumberFormatException ex) {
                            return;
                        }
                    }
                }
                if (e.getSource() == shortestPath) {
                    JPanel shortestPath = new JPanel();
                    JTextField src = new JTextField(8);
                    JTextField dest = new JTextField(8);
                    shortestPath.add(new JLabel(""));
                    shortestPath.add(src);
                    shortestPath.add(Box.createVerticalStrut(10));
                    shortestPath.add(new JLabel(""));
                    shortestPath.add(dest);

                    int shortestPaths = JOptionPane.showConfirmDialog(null, shortestPath, "", JOptionPane.CANCEL_OPTION);
                    if (shortestPaths == JOptionPane.OK_OPTION) {
                        try {
                            int src1 = Integer.parseInt(src.getText());
                            int dest1 = Integer.parseInt(dest.getText());

                            String shortestPathl = graphalgo.shortestPath(src1, dest1).toString();
                            shortestPathl = shortestPathl.substring(1, shortestPathl.length() - 1);

                        } catch (NumberFormatException ex) {
                            return;
                        }
                    }

                }
                if (e.getSource() == shortestPathDist) {
                    JPanel shortestPathDist = new JPanel();
                    JTextField src = new JTextField(8);
                    JTextField dest = new JTextField(8);
                    shortestPathDist.add(new JLabel(""));
                    shortestPathDist.add(src);
                    shortestPathDist.add(Box.createVerticalStrut(10));
                    shortestPathDist.add(new JLabel(""));
                    shortestPathDist.add(dest);
                    int shortestPathDists = JOptionPane.showConfirmDialog(null, shortestPathDist, "", JOptionPane.CANCEL_OPTION);
                    if (shortestPathDists == JOptionPane.OK_OPTION) {
                        try {

                            int src1 = Integer.parseInt(src.getText());
                            int dest1 = Integer.parseInt(dest.getText());
                            double short1 = graphalgo.shortestPathDist(src1, dest1);
                        } catch (NumberFormatException ex) {
                            return;
                        }
                    }

                }
                if (e.getSource() == tsp) {

                    JTextField tsplist = new JTextField(8);
                    JPanel tsp = new JPanel();
                    tsp.add(new JLabel(""));
                    tsp.add(tsplist);

                    int tsps = JOptionPane.showConfirmDialog(null, tsp, "", JOptionPane.CANCEL_OPTION);
                    if (tsps == JOptionPane.OK_OPTION) {
                        try {
                            String[] tspstring = tsplist.getText().split("");
                            List<NodeData> arrayList = new ArrayList<>();
                            for (int i = 0; i < tspstring.length; i++) {
                                NodeData crr = graphalgo.getGraph().getNode(Integer.parseInt(tspstring[i]));
                                arrayList.add(crr);
                            }
                            String tspl = graphalgo.tsp(arrayList).toString();
                            tspl = tspl.substring(1, tspl.length() - 1);
                        } catch (NumberFormatException ex) {
                            return;
                        }
                    }

                }if (e.getSource() == isConnected) {
                    System.out.println("yes isConnected ");
                }else{
                    System.out.println("no is not Connected ");
                }
            }

        }
    }

    public void drawN(int key, Double x, Double y, Double z) {
        return;
    }

    public void save(String src) {
        graphalgo.save(src);
    }

    protected void load(String src) {
        graphalgo = new DWGAlgo();
        graphalgo.load(src);

    }

    public void addMenu() {
        MenuBar bar = new MenuBar();
        Menu actionsMenu = new Menu("Actions");
        Menu algorithmsMenu = new Menu("Algorithms");
        bar.add(actionsMenu);
        bar.add(algorithmsMenu);
        this.setMenuBar(bar);
        ////////////////////////////
        load.addActionListener(this);
        save.addActionListener(this);
        addNode.addActionListener(this);
        connect.addActionListener(this);
        removeNode.addActionListener(this);
        removeEdge.addActionListener(this);
        actionsMenu.add(load);
        actionsMenu.add(save);
        actionsMenu.add(addNode);
        actionsMenu.add(connect);
        actionsMenu.add(removeNode);
        actionsMenu.add(removeEdge);
        ////////////////////////////
        shortestPath.addActionListener(this);
        shortestPathDist.addActionListener(this);
        tsp.addActionListener(this);
        isConnected.addActionListener(this);
        center.addActionListener(this);
        algorithmsMenu.add(shortestPath);
        algorithmsMenu.add(shortestPathDist);
        algorithmsMenu.add(tsp);
        algorithmsMenu.add(isConnected);
        algorithmsMenu.add(center);
    }

    ////////////////////////////
    @Override
    public void mouseClicked(MouseEvent e) {
        return;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        return;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        return;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        return;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        return;
    }
}





