import java.awt.Container;
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

//som
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Segundo extends JFrame implements ActionListener {
	JTextField horas, minutos, segundos;
	static int count;
	JButton mais, menos, play;
	Container contentor;
	JList list;
	JScrollPane slider;
	JLabel temposlabel, hinv;
	
	DefaultListModel listaTemposString = new DefaultListModel();
	DefaultListModel listaTemposInt = new DefaultListModel();
	
	
	
	public Segundo(){
		
		String[] tempos = {"00:10:00","01:30:00","00:00:30","00:00:15","00:00:02",
				"00:15:34","22:30:00","00:30:30"};
		
		setTitle("Temporizador");
		setSize(500,500);
		setLocation(200,300);
		
		contentor = getContentPane();
		contentor.setLayout(null);
		
		list = new JList(listaTemposString);
		
		slider= new JScrollPane(list,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		slider.setCorner(JScrollPane.UPPER_RIGHT_CORNER, new JLabel("Temporizadores"));
		slider.setBounds(150,150,200,100);
		
		temposlabel = new JLabel ("Os temporizadores", JLabel.CENTER);
		temposlabel.setOpaque(true);
		
		contentor.add(slider);
		
		mais = new JButton ("+");
		mais.setBounds(150, 80, 100, 20);
		mais.addActionListener(this);
		mais.setActionCommand("adicionar");
		contentor.add(mais);
		
		menos = new JButton ("-");
		menos.setBounds(250,80,100,20);
		contentor.add(menos);
		
		play = new JButton("PLAY");
		play.setBounds(150, 100, 200, 20);
		play.addActionListener(this);
		play.setActionCommand("play");
		contentor.add(play);
		
		horas = new JTextField();
		horas.setBounds(145, 30, 60, 20);
		
		contentor.add(horas);
		
		
		minutos = new JTextField();
		minutos.setBounds(225, 30, 60, 20);
		contentor.add(minutos);
		
		segundos = new JTextField();
		segundos.setBounds(300, 30, 60, 20);
		contentor.add(segundos);
		
		//imagem
		ImageIcon inv;
		inv = new ImageIcon("/Users/fernandocaldeira/Desktop/Red_Clock.png");
		hinv = new JLabel(inv);
		hinv.setLocation(70, 70);
		hinv.setVisible(true);
		contentor.add(hinv);
		hinv.setBounds(200,200,400,400);
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
		
		if(cmd.equals("adicionar")){
			addTimer();
		}
		if(cmd.equals("play")) {
			System.out.println("play");
			//fazer nova fun‹o countdown()
		}
	}

	
	private void addTimer() {
		
		int horasInt;
		int minutosInt;
		int segundosInt;
		
		try {
		    horasInt = Integer.parseInt(horas.getText());
		}
		catch(NumberFormatException ex)
		{
		    System.out.println("Exception : "+ex);
		    return;
		}
		
		try {
		    minutosInt = Integer.parseInt(minutos.getText());
		}
		catch(NumberFormatException ex)
		{
		    System.out.println("Exception : "+ex);
		    return;
		}
		
		try {
		    segundosInt = Integer.parseInt(segundos.getText());
		}
		catch(NumberFormatException ex)
		{
		    System.out.println("Exception : "+ex);
		    return;
		}
			
		String temp = "" + horas.getText() + ":" + minutos.getText() + ":" + segundos.getText();
		listaTemposString.add(0,temp);
		
		int tempSegundos = segundosInt + minutosInt*60 + horasInt*3600;
		listaTemposInt.add(0, tempSegundos);
		
		System.out.println(listaTemposInt.get(0));
		
	}
	
	//descrementa‹o
	
	public void Countdown(){
        int tempo =(Integer)listaTemposInt.get(0);
        while(tempo>0){
                tempo--;
                //timer(1 segundo de cada vez);
               
        }listaTemposInt.remove(0);
        listaTemposString.remove(0);
}
	
	
	/*verificar elementos lista
	 public StartTimer(){
	 
		while(listaTempoInt.getSize()>0){
			
			Countdown();
		}
	}*/
		
	
	
	
	
	public static void main (String[]args){
		
	}
}
