
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
 */
public class Lienzo extends JPanel {
   
    private LinkedList<Point2D> puntos;
    
    public Lienzo(){
        puntos = new LinkedList<>();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        dibujaPuntos(g2d, puntos);
    }
    
    private void dibujaPuntos(Graphics2D g2d, LinkedList<Point2D> listaDePuntos){
        g2d.setColor(Color.BLACK); // ----
        listaDePuntos.forEach((punto) -> {
            g2d.fillOval((int) punto.getX(), (int) punto.getY(), 10, 10);
        });
    }

    public void pintarEnLienzo(Point2D punto){
        puntos.add(punto);
        if (puntos.size() > 5) puntos.removeFirst();
    }
}
