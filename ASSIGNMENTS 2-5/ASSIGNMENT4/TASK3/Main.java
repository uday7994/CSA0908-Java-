import java.awt.*;import java.awt.event.*;import java.awt.image.*;import java.util.*;
public class Main {
 static class PadModel {java.util.List<Point> points=new ArrayList<>();void click(int x,int y){points.add(new Point(x,y));}void paint(Graphics g){for(Point p:points)g.fillOval(p.x-3,p.y-3,6,6);}}
 public static void main(String[] args){PadModel p=new PadModel();p.click(20,30);p.click(60,80);p.click(100,40);
  System.out.println("Clicks: "+p.points.size());for(Point q:p.points)System.out.println("Stored point: "+q.x+","+q.y);
  System.out.println("paint() redraws stored points after repaint/minimise/restore.");
 }
}
