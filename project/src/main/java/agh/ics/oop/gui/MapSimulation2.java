package agh.ics.oop.gui;

import agh.ics.oop.IEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MapSimulation2 implements ActionListener, KeyListener {

    public IEngine engine,engine2;
    public Timer timer;
    public JFrame frame;
    public JPanel main;//skupia rożne elementy symulacji
    public JPanel main2;//skupia rożne elementy symulacji
    public JPanel MAIN;//skupia rożne elementy symulacji
    boolean running=false;

    public AnimalSimulation animalSimulation,animalSimulation2;
    public Diagram diagram,diagram2;

    public MapSimulation2(IEngine engine,IEngine engine2){
        this.engine=engine;
        this.engine2=engine2;

        frame = new JFrame("Simulation");
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addKeyListener(this);// spacja pauza

        AnimalSimulation animalSimulation = new AnimalSimulation(this,engine);
        animalSimulation.setSize(new Dimension(1,1));
        this.animalSimulation=animalSimulation;

        Diagram diagram = new Diagram(this,engine);
        diagram.setSize(1,1);
        this.diagram=diagram;

        AnimalSimulation animalSimulation2 = new AnimalSimulation(this,engine2);
        animalSimulation.setSize(new Dimension(1,1));
        this.animalSimulation2=animalSimulation;

        Diagram diagram2 = new Diagram(this,engine2);
        diagram.setSize(1,1);
        this.diagram2=diagram;


        main=new JPanel();
        main2=new JPanel();
        //main.setLayout((new GridLayout(1,2)));
        main.add(diagram);
        main.add(animalSimulation);
        main2.add(diagram2);
        main2.add(animalSimulation2);

        MAIN = new JPanel();
        MAIN.add(main);
        MAIN.add(main2);

        frame.add(main);
        //frame.add(main2);

        startSimulation();

    }
    public void startSimulation(){
        running=true;
        timer = new Timer(1000,this);//1 sekundy refreshu
        timer.start();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (running){
            main.repaint();
            engine.run();
            //engine2.run();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            running = !running;
            if (!running){
                timer.stop();
            }
            else{
                timer.start();
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }

}
