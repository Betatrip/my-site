package clock;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Clocks {
	public static void main(String[] args) throws InterruptedException {
			JFrame frame = new JFrame("Digital Clock");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(600, 300);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			TimeLabel label = new TimeLabel();
			label.setHorizontalAlignment(SwingConstants.CENTER);
			frame.getContentPane().add(label);
			frame.setVisible(true);
	}
}

class TimeLabel extends JLabel {
	@Override
	public void paintComponent(Graphics g) {
		String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		this.setFont(new Font("Verdana", Font.PLAIN, 80));
		this.setText(timeStamp);
		super.paintComponent(g);
	}
}
