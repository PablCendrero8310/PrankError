package panels;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;
public class Message_Panel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Color color;
	
	public Message_Panel(Color c) {
		this.color=c;
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D) g;
		Rectangle2D rectangle=new Rectangle2D.Double(0,0,getWidth(), getHeight());
		g2.setPaint(color);
		g2.fill(rectangle);
	
	}
}
