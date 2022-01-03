package agh.ics.oop.gui;

import agh.ics.oop.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MapSimulation extends JPanel {

    public static void main(String[] args) {
        IEngine engine = new SimulationEngine(18,8,2,15,0.7,40,15);
        new MapSimulation(engine);
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Simulation");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new MapSimulation(engine));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
    private IWorldMap toSimulate;
    private IEngine era;
    public MapSimulation(IEngine engine) {
        this.toSimulate=engine.getEngineMap();
        this.era=engine;
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newDay();
                repaint();
            }
        });
        timer.start();
    }

    public void newDay() {
        era.run();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 1000);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        for(int x=0;x<toSimulate.getWidth();x++){
            for (int y=0;y< toSimulate.getHeight();y++){
                if (toSimulate.isJungle(new Vector2d(x,y))){
                    g2d.setColor(new Color(34, 66, 20, 255));
                    g2d.fillRect(x*30,y*30,30,30);
                }
                else {
                    g2d.setColor(new Color(96, 94, 22, 255));
                    g2d.fillRect(x*30,y*30,30,30);
                }
                if (toSimulate.isOccupied(new Vector2d(x,y))){
                    //g2d.fillOval(tab[i], tab[i+1], 30, 30);
                    if (toSimulate.objectAt(new Vector2d(x,y)) instanceof Animal){
                        g2d.setColor(new Color(93, 55, 17));
                        g2d.fillOval(x*30,y*30,30,30);
                    }
                    else{
                        g2d.setColor(new Color(135, 166, 83));
                        g2d.fillOval(x*30,y*30,30,30);
                    }
                }
            }
        }
    }

}
