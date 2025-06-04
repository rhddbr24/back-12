import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class PenApp1 extends Frame{
    public int oldx = 0;
    public int oldy = 0;
    public int newx = 0;
    public int newy = 0;
    public String message = "";

    public static void main(String[] args) {
        PenApp1 window = new PenApp1();
        window.setVisible(true);
    }

    public PenApp1(){
        setSize(600,500);
        setTitle("Pen 응용");
        MouseKeeper mouse = new MouseKeeper();
        addMouseListener(mouse);

        Scanner s = new Scanner(System.in);
        System.out.print("출력할 메시지를 입력하세요: ");
        message = s.next();
    }

    private class MouseKeeper extends MouseAdapter{

        public void mousePressed(MouseEvent e){
            newx = e.getX();
            newy = e.getY();
            repaint ();
        }
    }

    public void paint(Graphics g){
        g.drawLine(oldx, oldy, newx, newy);
        g.drawString(message, newx, newy);
        oldx = newx;
        oldy = newy;
    }

}
