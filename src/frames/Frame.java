package frames;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import java.net.URL;

import javax.swing.*;

import panels.MainPanel;

public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;

	public Frame() {

		Toolkit screen = Toolkit.getDefaultToolkit();
		Dimension size_screen = screen.getScreenSize();
		int alt = size_screen.height;
		int anch = size_screen.width;
		setTitle("Prank Error");
		MainPanel panel = new MainPanel();

		add(panel);

		setBounds(anch / 4, alt / 4, anch / 2, alt / 2);
		URL icon_r = getClass().getResource("/img/icon.png");
		Image icon = screen.getImage(icon_r);

		setIconImage(icon);
		setVisible(true);

	}

}
