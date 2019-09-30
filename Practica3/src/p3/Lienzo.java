package p3;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nassr
 * @author yusef
 * 
 */
public class Lienzo extends JPanel {
   
    private LinkedList<Point2D> puntos;
    
        
    private Color colorPincel;
    private Color colorFondo;
    
    public Lienzo(){
        puntos = new LinkedList<>();
        this.colorPincel = Color.BLUE;
        this.colorFondo = Color.RED;
    }
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(colorFondo);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(colorPincel);
        drawPoints(g2d, puntos);
    }
    
    
    
    private void drawPoints(Graphics2D g2d, LinkedList<Point2D> listaDePuntos){
        listaDePuntos.forEach((punto) -> {
            g2d.fillOval((int) punto.getX(), (int) punto.getY(), 10, 10);
        });
    }

    public void paint(Point2D punto){
        puntos.add(punto);
        if (puntos.size() > 5) puntos.removeFirst();
    }
    
    public void setColorDeFondo(Color color){
        this.colorFondo = color;
        repaint();
    }
    
    public void setColorDePincel(Color color){
        this.colorPincel = color;
        repaint();
 }
    
    public void CleanPoints(){
        puntos.clear();
    }
}
