package agh.ics.oop.gui;

import agh.ics.oop.IEngine;
import agh.ics.oop.SimulationEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel implements ActionListener {

    public TextField heightText=new TextField(),
            widthText=new TextField(),
            moveEnergyText=new TextField(),
            plantEnergyText=new TextField(),
            startEnergyText=new TextField(),
            jungleRatioText=new TextField(),
            animalCountText=new TextField();
    public MenuPanel() {
       setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        //labely danych dla jednej mapy
        JLabel heightLabel = new JLabel("Insert Height of the map: ");
        JLabel widthLabel = new JLabel("Insert Width of the map: ");
        JLabel moveEnergyLabel = new JLabel("Insert Move Energy of the Animal: ");
        JLabel plantEnergyLabel = new JLabel("Insert Plant energy of the plant: ");
        JLabel jungleRatioLabel = new JLabel("Insert Jungle Ratio of the jungle: ");
        JLabel startEnergyLabel = new JLabel("Insert start energy of the animal: ");
        JLabel animalCountLabel = new JLabel("Insert number of animals: ");
        //pola tekstowe
        //height
        heightText.setText("10");
        heightLabel.setLabelFor(heightText);
        //width
        widthText.setText("10");
        heightLabel.setLabelFor(widthText);
        //moveEnergy
        moveEnergyText.setText("1");
        moveEnergyLabel.setLabelFor(moveEnergyText);
        //plantEnergyText
        plantEnergyText.setText("10");
        plantEnergyLabel.setLabelFor(plantEnergyText);
        //jungleRatioText
        jungleRatioText.setText("0.5");
        jungleRatioLabel.setLabelFor(jungleRatioText);
        //startEnergyText
        startEnergyText.setText("100");
        startEnergyLabel.setLabelFor(startEnergyText);
        //animalCount
        animalCountText.setText("10");
        animalCountLabel.setLabelFor(animalCountText);

        //panele

        //height
        JPanel heightPanel = new JPanel();
        //heightPanel.setLayout(new BoxLayout(heightPanel,BoxLayout.X_AXIS));
        heightPanel.add(heightLabel);
        heightPanel.add(heightText);
        //width
        JPanel wdithPanel = new JPanel();
        wdithPanel.add(widthLabel);
        wdithPanel.add(widthText);
        //moveEnergy
        JPanel moveEnergyPanel = new JPanel();
        moveEnergyPanel.add(moveEnergyLabel);
        moveEnergyPanel.add(moveEnergyText);
        //plantEnergy
        JPanel plantEnergyPanel = new JPanel();
        plantEnergyPanel.add(plantEnergyLabel);
        plantEnergyPanel.add(plantEnergyText);
        //jungleRatio
        JPanel jungleRatioPanel = new JPanel();
        jungleRatioPanel.add(jungleRatioLabel);
        jungleRatioPanel.add(jungleRatioText);
        //startEnergy
        JPanel startEnergyPanel = new JPanel();
        startEnergyPanel.add(startEnergyLabel);
        startEnergyPanel.add(startEnergyText);
        //animalCount
        JPanel animalCountPanel = new JPanel();
        animalCountPanel.add(animalCountLabel);
        animalCountPanel.add(animalCountText);

        //MainPanel

        JLabel map1Label = new JLabel("First map variables");
        JPanel map1Panel = new JPanel();
        map1Panel.add(map1Label);

        //testing
        JCheckBox reproducing = new JCheckBox("Magic reproducing");
        JPanel reproducingPanel = new JPanel();
        reproducingPanel.add(reproducing);


        add(map1Panel);
        add(heightPanel);
        add(wdithPanel);
        add(moveEnergyPanel);
        add(plantEnergyPanel);
        add(jungleRatioPanel);
        add(startEnergyPanel);
        add(animalCountPanel);
        add(reproducingPanel);


        //submit przycisk
        JButton start = new JButton("Submit");
        start.addActionListener(this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(start);
        add(buttonPanel);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        IEngine engine = new SimulationEngine(
                Integer.parseInt(heightText.getText()),
                Integer.parseInt(widthText.getText()),
                Integer.parseInt(moveEnergyText.getText()),
                Integer.parseInt(plantEnergyText.getText()),
                Double.parseDouble(jungleRatioText.getText()),
                Integer.parseInt(startEnergyText.getText()),
                Integer.parseInt(animalCountText.getText())
        );
     IEngine engine2 = new SimulationEngine(
             Integer.parseInt(heightText.getText()),
             Integer.parseInt(widthText.getText()),
             Integer.parseInt(moveEnergyText.getText()),
             Integer.parseInt(plantEnergyText.getText()),
             Double.parseDouble(jungleRatioText.getText()),
             Integer.parseInt(startEnergyText.getText()),
             Integer.parseInt(animalCountText.getText())
     );
        new MapSimulation2(engine,engine2);
    }
}
