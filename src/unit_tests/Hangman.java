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
	static String word;
	 JFrame f=new JFrame();
	 JPanel p=new JPanel();
	static ArrayList<JLabel> labels=new ArrayList<JLabel>();
public static void main(String[] args) {
	Hangman x= new Hangman();
	x.makeUI();
	word=makeWord();
	System.out.println(word);
	x.addJLabels(word);
	
}
public void addJLabels(String word) {
	JLabel l;
	for(int i =0;i<word.length();i++) {
		l=new JLabel();
		l.setText("_");
		labels.add(l);
		p.add(l);
	}
}
public void makeUI() {
	f.addKeyListener(this);
	p = new JPanel();
	f.add(p);
	f.setVisible(true);
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
	System.out.println(e.getKeyChar());
	// TODO Auto-generated method stub
	for(int i=0;i<word.length();i++) {
		if((""+e.getKeyChar()).equals(word.substring(i, i+1))) {
			System.out.println("ues");
			labels.get(i).setText(""+e.getKeyChar());
		}
	}
		
}
}
