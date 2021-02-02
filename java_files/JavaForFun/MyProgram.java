import java.awt.*;
import javax.swing.*;

public class MyProgram extends JFrame {
	
	public void run() {
		JFrame frame = new JFrame("First App in Eclipse!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(640, 480);
		frame.setResizable(false);
		
		Container container = frame.getContentPane();
		
		JButton button = new JButton("bruh");
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(frame.getWidth() / 2, frame.getHeight()));
		panel.setLayout(new GridBagLayout());
		panel.add(button, new GridBagConstraints());
		
		DrawPanel drawPanel = new DrawPanel();
		drawPanel.setPreferredSize(new Dimension(frame.getWidth() / 2, frame.getHeight()));
		
		
		container.add(panel, BorderLayout.EAST);
		container.add(drawPanel, BorderLayout.WEST);
		
		
		frame.setVisible(true);
		
	}
	
	class DrawPanel extends JPanel {
		private int x = 0;
		private int y = 0;
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Color.GRAY);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
			g.setColor(Color.GREEN);
			g.fillOval(x, y, 60, 60);
		}
	}

	public static void main(String[] args) {
		MyProgram mypg = new MyProgram();
		mypg.run();
	}
}
