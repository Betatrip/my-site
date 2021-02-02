import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TicTacToe extends JFrame {
	int delta = 1;
	int xScore = 0;
	int oScore = 0;
	ArrayList<MyButton> buttonList = new ArrayList<MyButton>();
	private ArrayList[] lines = new ArrayList[8];
	JFrame chooseFrame = new JFrame();
	JFrame inputFrame = new JFrame();
	JLabel winner;
	JButton exit;
	JButton restart;
	JPanel gameField;
	String playerX = "Игрок1";
	String playerO = "Игрок2";
	
	public TicTacToe() {
		chooseFrame.setUndecorated(true);
		exit = new JButton("Выход");
		restart = new JButton("Начать заново");
		exit.setFocusPainted(false);
		restart.setFocusPainted(false);
		exit.addActionListener(e ->  {
			System.exit(0);
		});
		
		restart.addActionListener(e -> {
			startNewGame();
		});
		
		chooseFrame.setSize(400, 200);
		chooseFrame.getRootPane().setBorder(BorderFactory.createMatteBorder(40, 30, 40, 30, new Color(185, 176, 255)));
		chooseFrame.setLocationRelativeTo(null);
		chooseFrame.setLayout(new GridLayout(3, 1, 0, 10));
		winner = new JLabel("", SwingConstants.CENTER);
		chooseFrame.add(winner);
		chooseFrame.add(restart);
		chooseFrame.add(exit);
		
		gameField = new JPanel();
		gameField.setBackground(new Color(153, 153, 255));
		gameField.setLayout(new GridLayout(3, 3, 30, 30));
		this.add(gameField);
		
		this.setTitle("Tic Tac Toe");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.getRootPane().setBorder(BorderFactory.createMatteBorder(30, 30, 30, 30, new Color(153, 153, 255)));
	}
	
	public void startNewGame() {
		chooseFrame.setVisible(false);
		buttonList.clear();
		buttonList = createButtons();
		gameField.removeAll();

		for (MyButton button : buttonList) {
			button.setLabelText("");
			gameField.add(button);
		}
		
		this.add(gameField);
		
		this.setVisible(true);
		
		if (xScore == 0 && oScore == 0) {
			for (MyButton button : buttonList) {
				button.setEnabled(false);
			}
			JTextField inputField1 = new JTextField(9);
			JTextField inputField2 = new JTextField(9);
			inputField1.setBackground(new Color(204, 204, 255));
			inputField2.setBackground(new Color(204, 204, 255));
			JButton okButton = new JButton("OK");
			okButton.addActionListener(e -> {
				if (inputField1.getText().length() != 0)
					playerX = inputField1.getText();
				if (inputField2.getText().length() != 0)
					playerO = inputField2.getText();
				inputFrame.setVisible(false);
				for (MyButton button : buttonList) {
					button.setEnabled(true);
				}
			});
			inputFrame.setSize(400, 200);
			inputFrame.setLocationRelativeTo(null);
			inputFrame.setUndecorated(true);
			inputFrame.getContentPane().setLayout(new GridLayout(5, 0, 0, 10));
			inputFrame.getContentPane().setBackground(new Color(185, 176, 255));
			inputFrame.getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, new Color(140, 153, 255)));
			inputFrame.getContentPane().add(new JLabel("Имя игрока за крестики:"));
			inputFrame.getContentPane().add(inputField1);
			inputFrame.getContentPane().add(new JLabel("Имя игрока за нолики:"));
			inputFrame.getContentPane().add(inputField2);
			inputFrame.getContentPane().add(okButton);
			inputFrame.setVisible(true);
		} else {
			inputFrame.setVisible(false);
		}
	}
	
	private ArrayList<MyButton> createButtons() {
		for (int i = 0; i < 9; i++) {
			MyButton button = new MyButton();
			button.setEnabled(true);
			buttonList.add(button);
		}
		
		for (int i = 0; i < 8; i++) {
			lines[i] = new ArrayList<MyButton>();
		}
		
		for (ArrayList<MyButton> l : lines) {
			l.clear();
		}
		
		for (int i = 0; i < 9; i += 4) {
			lines[0].add(buttonList.get(i));
		}
		
		for (int i = 2; i < 7; i += 2) {
			lines[1].add(buttonList.get(i));
		}
		
		for (int i = 0; i < 3; i++) {
			lines[2].add(buttonList.get(i));
			lines[3].add(buttonList.get(i + 3));
			lines[4].add(buttonList.get(i + 6));
		}
		
		for (int i = 0; i < 7; i += 3) {
			lines[5].add(buttonList.get(i));
			lines[6].add(buttonList.get(i + 1));
			lines[7].add(buttonList.get(i + 2));
		}

		
		return buttonList;
	}
	
	class MyButton extends JButton {
		private JLabel label;
		private String symbol;
		
		public MyButton() {
			label = new JLabel();
			label.setVisible(false);
			label.setFont(new Font("Arial", Font.PLAIN, 100));
			label.setAlignmentX(Component.CENTER_ALIGNMENT);
			this.setFocusPainted(false);
			this.setBackground(new Color(102, 102, 255));
			this.setForeground(new Color(102, 102, 255));
			this.add(label);
			this.setFont(new Font("Arial", Font.PLAIN, 40));
			this.addActionListener(e -> {
				if (delta > 0) {
					label.setForeground(new Color(189, 144, 240));
					label.setText("X");
					this.setSymbol("X");
				} else {
					label.setForeground(new Color(144, 203, 249));
					label.setText("O");
					this.setSymbol("O");
				}
				delta = -delta;
				
				label.setVisible(true);
				
				this.setEnabled(false);
				
				check();
			});
		}
		
		public void check() {
			int count = 0;
			for (ArrayList<MyButton> l : lines) {
				if (getLineSymbol(l) == "X") {
					xScore += 1;
					gameOver(playerX + " победил(-а)!");
				} else if (getLineSymbol(l) == "O") {
					oScore += 1;
					gameOver(playerO + " победил(-а)!");
				}
			}
		}
		
		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}
		
		private String getSymbol() {
			return symbol;
		}
		
		public void setLabelText(String s) {
			label.setText(s);
		}
	}
	
	public String getLineSymbol(ArrayList<MyButton> list) {
		int x = 0;
		int o = 0;
		String s = "";
		
		for (MyButton button : list) {
			if (button.getSymbol() == "X") {
				x += 1;
			} else if (button.getSymbol() == "O") {
				o += 1;
			}
		}
		
		if (x == 3) {
			s = "X";
		} else if (o == 3) {
			s = "O";
		}
		
		return s;
	}
	
	public void gameOver(String s) {
		for (MyButton button : buttonList) {
			button.setEnabled(false);
		}
		
		winner.setText(s + " Счёт" + xScore + ":" + oScore);
		chooseFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		game.startNewGame();
	}
}
