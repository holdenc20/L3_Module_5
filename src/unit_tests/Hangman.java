package unit_tests;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Hangman implements KeyListener{
	static int lives=7;
	JLabel livesLabel=new JLabel();
	static String word;
	 JFrame f=new JFrame();
	 JPanel p=new JPanel();
	 static int wordleng=0;
	static ArrayList<JLabel> labels=new ArrayList<JLabel>();
public static void main(String[] args) {
	Hangman x= new Hangman();
	x.makeUI();
	word=makeWord();
	wordleng=word.length();
	lives=wordleng/3+3;
	System.out.println(word);
	x.addJLabels(word);
	x.setSiz();
	
}
public void addJLabels(String word) {
	JLabel l;
	
	for(int i =0;i<word.length();i++) {
		l=new JLabel();
		l.setText("_");
		labels.add(l);
		p.add(l);
	}
	p.add(livesLabel);
	livesLabel.setText("You have "+lives+" live left!");
}
public void makeUI() {
	f.addKeyListener(this);
	p = new JPanel();
	f.add(p);
	f.setVisible(true);
	
	
}
public void setSiz() {
	f.setSize(400, 500);
}
public static String makeWord() {
	ArrayList<String> words=new ArrayList<String>();
	int lines=0;
	try {
	LineNumberReader lnr = new LineNumberReader(new FileReader(new File("/usr/share/dict/words")));
	lnr.skip(Long.MAX_VALUE);// Skip to the end
	lines = lnr.getLineNumber();
	lnr.close();
	BufferedReader br = new BufferedReader(new FileReader(new File("/usr/share/dict/words")));
	for (int i = 0; i < lines; i++) {
		words.add(br.readLine()); // adds every line to the array
	}
	br.close();
	} catch (IOException e) {
	e.printStackTrace();
}
	Random r = new Random();
	int x=r.nextInt(lines);
	return words.get(x);
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyReleased(KeyEvent e) {
	int b=wordleng;
	
	// TODO Auto-generated method stub
	for(int i=0;i<word.length();i++) {
		if((""+e.getKeyChar()).equals(word.substring(i, i+1).toLowerCase())) {
			labels.get(i).setText(""+e.getKeyChar());
			b=wordleng-1;
		}
	}
	if(wordleng!=b) {
		wordleng--;
	}
	else {
		lives--;
	}
	if(lives<1) {
		JLabel lose=new JLabel();
		p.removeAll();
		p.repaint();
		p.add(lose);
		lose.setText("You Lose");
	}
	int x=0;
	for(;x<labels.size();x++) {
		if(labels.get(x).getText().equals("_")) {
			break;
		}
	}	
	
	if(x==labels.size()) {
		JLabel win=new JLabel();
		p.removeAll();
		p.repaint();
		p.add(win);
		win.setText("You Win");
	}
	livesLabel.setText("You have "+lives+" live left!");
}
}
