package DoomMaze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoomMaze {
	private JButton startButton, first, second, third;
	private JPanel titlePanel, gamePanel, choicePanel;
	private JPanel startButtonPanel;
	private JLabel titleLabel;
	private JFrame frame;
	private JTextArea TextField;
	private Container contain;
	private Font slime = new Font("Algerian", Font.BOLD, 80);
	private Font miniSlime = new Font("Algerian", Font.BOLD, 30);
	private TitleScreenHandler TSH = new TitleScreenHandler();
	private ChoiceOption choices = new ChoiceOption();
	private String pos, monster, yourChoice;
	public DoomMaze() {
		frame = new JFrame("Doom Maze");
		frame.setSize(900,600);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contain = frame.getContentPane();
		
		titlePanel = new JPanel();
		titlePanel.setBounds(0,0, 900, 400);
		titlePanel.setBackground(Color.black);
		
		titleLabel = new JLabel("Doom Maze");
		titleLabel.setForeground(Color.red);
		titleLabel.setBounds(0, 0, 800, 400);
		titleLabel.setFont(slime);
		
		titlePanel.add(titleLabel);
		contain.add(titlePanel);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(0,400,900,300);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("Start Adventure!");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.red);
		startButton.setFont(slime);
		startButton.setFocusPainted(false);
		startButton.addActionListener(TSH);
		
		startButtonPanel.add(startButton);
		
		contain.add(startButtonPanel);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new DoomMaze();
	}
	public void gameScreen() {
		startButtonPanel.setVisible(false);
		titlePanel.setVisible(false);
		
		gamePanel = new JPanel();
		gamePanel.setBounds(0, 0, 900, 200);
		gamePanel.setBackground(Color.black);
		
		TextField = new JTextArea("Where would you like to go first?");
		TextField.setBounds(0,0,900,200);
		TextField.setBackground(Color.black);
		TextField.setForeground(Color.red);
		TextField.setFont(miniSlime);
		TextField.setLineWrap(true);
		gamePanel.add(TextField);
		
		contain.add(gamePanel);
	
		choicePanel = new JPanel();
		choicePanel.setBounds(0,200,900,400);
		choicePanel.setBackground(Color.black);
		choicePanel.setLayout(new GridLayout(1,3));
		
		first = new JButton("first");
		first.setBackground(Color.black);
		first.setForeground(Color.red);
		first.setFont(miniSlime);
		first.setFocusPainted(false);
		first.addActionListener(choices);
		first.setActionCommand("1");
		choicePanel.add(first);
		
		second = new JButton("second");
		second.setBackground(Color.black);
		second.setForeground(Color.red);
		second.setFont(miniSlime);
		second.setFocusPainted(false);
		second.addActionListener(choices);
		second.setActionCommand("2");
		choicePanel.add(second);
		
		third = new JButton("third");
		third.setBackground(Color.black);
		third.setForeground(Color.red);
		third.setFont(miniSlime);
		third.setFocusPainted(false);
		third.addActionListener(choices);
		third.setActionCommand("3");
		choicePanel.add(third);
		
		contain.add(choicePanel);
		start();
	}
	public void start() {
		pos = "start";
		TextField.setText("You have entered the dungeon, three paths, where do you go?");
		first.setText("Left");
		second.setText("Middle");
		third.setText("Right");
	}
	public void spider() {
		pos = "spider";
		monster = pos;
		TextField.setText("Giant spiders are lurking in the darkness. However, there is a chest.");
		first.setText("Go back");
		second.setText("Fight");
		third.setText("Hide");
	}
	public void cyclops() {
		pos = "cyclops";
		monster = pos;
		TextField.setText("Cyclops are roaming. They don't notice you.");
		first.setText("Run by");
		second.setText("Attack");
		third.setText("Go back");
	}
	public void centaur() {
		pos = "centaur";
		monster = "pos";
		TextField.setText("Doors close, and a drunken centaur is angerily killing its underlings");
		first.setText("fight");
		second.setText("");
		third.setText("");

	}
	public void hideFromSpider() {
		pos = "hideFromSpider";
		monster = "spider";
		TextField.setText("The spiders are unable to find you. They get into a blood thirsty rage and fight each other");
		first.setText("Go back");
		second.setText("Try to run");
		third.setText("");
	}
	public void wyvern() {
		pos = "wyverns";
		monster = "wyverns";
		TextField.setText("Doors slam shut. An ancient wyvern is sleeping in his cave");
		first.setText("Throw rock");
		second.setText("Greet");
		third.setText("Sneak attack");
	}
	public void awaken() {
		pos = "woke";
		TextField.setText("The wyvern has risen and flies at you");
		first.setText("Duck");
		second.setText("Panic");
		third.setText("");
	}
	public void death() {
		pos = "death";
		TextField.setText(monster + " got the best of you!!!");
		first.setText("Restart");
		second.setText("");
		third.setText("");
	}
	public void victory() {
		TextField.setText("The wyvern has missed and as crushed by falling rocks. You now have reached the end");
		first.setText("");
		second.setText("");
		third.setText("");
	}
	
	public class TitleScreenHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			gameScreen();
		}
	}
	public class ChoiceOption implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			yourChoice = e.getActionCommand();
			if(pos.equals("start")) {
				start();
				if(yourChoice.equals("1")) {
					spider();	
				}else if(yourChoice.equals("2")) {
					cyclops();
				}else if(yourChoice.equals("3")) {
					centaur();
				}
			}else if(pos.equals("spider")) {
				if(yourChoice.equals("1")) {
					start();	
				}else if(yourChoice.equals("2")) {
					death();
				}else if(yourChoice.equals("3")) {
					hideFromSpider();
				}
			}else if(pos.equals("death")) {
				if(yourChoice.equals("1")) {
					start();
				}
			}else if(pos.equals("hideFromSpider")) {
				if(yourChoice.equals("1")) {
					start();
				}else if(yourChoice.equals("2")) {
					death();
				}
			}else if(pos.equals("cyclops")) {
				if(yourChoice.equals("1")) {
					wyvern();
				}else if(yourChoice.equals("2")) {
					death();
				}else if(yourChoice.equals("3")) {
					start();
				}
			}else if(pos.equals("centaur")) {
				if(yourChoice.equals("1")) {
					death();
				}
			}else if(pos.equals("wyverns")) {
				if(yourChoice.equals("3")) {
					death();
				}else {
					awaken();
				}
			}else if(pos.equals("woke")) {
				if(yourChoice.equals("1")) {
					victory();
				}else if(yourChoice.equals("2")) {
					death();
				}
			}
		}
	}
}
