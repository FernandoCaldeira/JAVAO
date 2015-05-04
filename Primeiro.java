import java.awt.Container;

import java.awt.event.*;

import javax.swing.*;

public class Primeiro extends JFrame implements ActionListener {
	JLabel ola, quote1,quote11, quote2, hinv;
	JButton iniciar; 
	Container contentor1;
	
	
	public Primeiro(){
		
		setTitle("Menu");
		setSize(500,500);
		setLocation(200,300);
		
		contentor1 = getContentPane();
		contentor1.setLayout(null);
		
		iniciar = new JButton("Iniciar");
		iniciar.setBounds(200, 80, 100, 20);
		iniciar.addActionListener(this);
		iniciar.setActionCommand("Abrir");
		contentor1.add(iniciar);
		
		
		quote1 = new JLabel("If you love life, don't waste time,");
		quote1.setBounds(145,150,220,20);
		contentor1.add(quote1);
		
		quote11 = new JLabel("for time is what life is made up of.");
		quote11.setBounds(145,170,220,20);
		contentor1.add(quote11);
		
		quote2 = new JLabel ("-Bruce Lee");
		quote2.setBounds(290,195,150,20);
		contentor1.add(quote2);
		
		
		ola = new JLabel("Bem-vindo");
		ola.setBounds(215,30,100,20);
		contentor1.add(ola);
		
		//Add Imagem
		ImageIcon inv;
		inv = new ImageIcon("/Users/fernandocaldeira/Desktop/Red_Clock.png");
		hinv = new JLabel(inv);
		hinv.setLocation(70, 70);
		hinv.setVisible(true);
		contentor1.add(hinv);
		hinv.setBounds(200,200,400,400);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
		
		if(cmd.equals("Abrir")){
			dispose();
			new Segundo();
		}
	}
	
	
	public static void main(String[] args) {
		Primeiro janela = new Primeiro();
		janela.setVisible(true);
	}
	
}
