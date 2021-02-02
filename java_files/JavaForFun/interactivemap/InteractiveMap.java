package interactivemap;

import java.awt.*;
import javax.swing.*;

public class InteractiveMap {
	public InteractiveMap() {
		JFrame frame = new JFrame("Interactive Map");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1280, 720);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6, 10, 5, 5));
		panel.setBackground(Color.BLUE);
		for (int i = 0; i < 60; i++) {
			panel.add(new JButton("wow"));
		}
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new InteractiveMap();
	}
}
