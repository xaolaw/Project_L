package agh.ics.oop.gui;

import agh.ics.oop.Animal;
import agh.ics.oop.IEngine;
import agh.ics.oop.IWorldMap;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Diagram extends JPanel {

    int days=0;//przebyte dni
    int daysPassed=0;
    int firtsAnimalCount=0;
    int a2=1;
    ArrayList<Integer> animals = new ArrayList<>();
    ArrayList<Integer> grasses = new ArrayList<>();

    public MapSimulation2 simulation2;
    public IEngine engine;
    public IWorldMap map;

    public Diagram(MapSimulation2 simulation2, IEngine engine){
        this.simulation2=simulation2;
        this.engine=engine;
        this.map= engine.getEngineMap();
        this.setLayout(new FlowLayout());
        int animalCount=0;
        for (List<Animal> list:engine.getEngineMap().getAnimals().values()){
            animalCount+=list.size();
        }
        this.firtsAnimalCount=animalCount;

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setSize((int) (simulation2.frame.getWidth() * 0.4), simulation2.frame.getHeight() - 38);
        this.setLocation(0, 0);
        //wykres
        days+=1;
        g.drawLine(10,38,10,this.getHeight()/2);
        g.drawLine(10,this.getHeight()/2,this.getWidth()-10,this.getHeight()/2);
        g.drawString("days: " + days ,10,20);

        int animalCount=0;
        for (List<Animal> list:engine.getEngineMap().getAnimals().values()){
            animalCount+=list.size();
        }
        if (animals.size()%100==0){
            animals.clear();
            grasses.clear();
            daysPassed=days;
        }
        animals.add(animalCount);


        int grassCount=engine.getEngineMap().getGrasses().size();
        grasses.add(grassCount);


        int poleG = engine.getEngineMap().getHeight()*engine.getEngineMap().getWidth();
        int heiight =(this.getHeight()/2)-2;
        System.out.println(days-daysPassed);
        for (int j=0;j<animals.size();j++){
            g.setColor(new Color(182, 102, 16));
            int y = (int) (heiight-(0.25*(animals.get(j)*heiight/firtsAnimalCount)));//heiight-(scale*animals.get(j));
            if (animals.get(j)==0){
                y=heiight;
            }
            System.out.println(y);
            System.out.println(animals.get(j).toString());
            System.out.println("-----");
            g.fillOval(10+(j*5),(y),5,5);
            //roslina
            g.setColor(new Color(108, 44, 155));
            int yG = (int) (heiight-((grasses.get(j)*heiight/poleG)));

            g.fillOval(10+(j*5),yG,5,5);
        }
        //legenda
        /*g.setColor(Color.RED);
        g.setFont(new Font("Ink Free",Font.BOLD,50));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Legend:",0,45);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial",Font.BOLD,25));
        g.drawString("Jungle",15,95);
        g.drawString("Sawanna",0,145);
        g.drawString("Animal",15,195);
        g.drawString("Plant",15,245);
        g.drawString("[SPACE] - Pause",15,325);
        //jungle
        g.setColor(new Color(42, 117, 4, 255));
        g.fillRect(100,95-25,30,30);
        //sawanna
        g.setColor(new Color(155, 153, 10, 255));
        g.fillRect(110,145-25,30,30);
        //animal
        g.setColor(new Color(182, 102, 16));
        g.fillOval(100,195-25,30,30);
        //grass
        g.setColor(new Color(108, 44, 155));
        g.fillOval(100,245-25,30,30);*/
    }
}
