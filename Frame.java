import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Frame extends JFrame implements ActionListener
{
	JFrame frame1;

	ArrayList <Integer> l= new ArrayList<Integer>();
	
	Font fontt= new Font("Bodoni MT", Font.PLAIN, 18);
	Font font= new Font("Bodoni MT", Font.PLAIN, 25); 
	Font fonttt= new Font("Bodoni MT", Font.PLAIN, 12); 
	
	JButton aggiungi= new JButton ("aggiungi");
	JButton visualizza= new JButton ("visualizza");
	JButton rimuovi= new JButton ("rimuovi");
	JButton okay= new JButton ("okay");

	JLabel label0= new JLabel ("Visualizza: ");
	JLabel label1= new JLabel ("Aggiungi: ");
	JLabel label= new JLabel ("");
		
	JTextArea a= new JTextArea(4,15);
	JTextArea b= new JTextArea(4,15);
	JTextArea c= new JTextArea(4,15);
	
	public Frame() 
	{
		super("Frame");
		setSize (500, 300);
		Container cont= this.getContentPane();
		
		frame1 = new JFrame("uno");
		frame1.setSize(200,200);
		frame1.add(c);
		
		c.setBounds(115,80 ,200, 20);
		
		frame1.add(okay);
		/*okay.setFont(fonttt);
		okay.setBounds(20,150,10,10);*/
		//il problema è nelle dimensioni del tasto "okay",la dimensione del pulsante è stata impostata con il metodo "setBounds()". 
		//Questo rende il pulsante troppo piccolo per essere visualizzato correttamente. Prova a cercare il metodo SetPreferredSize() ed il suoo funzionamento!
		cont.add(aggiungi);
		aggiungi.setFont(fonttt);
		aggiungi.setBounds(20,150, 100, 40);
		
		cont.add(visualizza);
		visualizza.setFont(fonttt);
		visualizza.setBounds(140,150, 100, 40);
			
		cont.add(rimuovi);
		rimuovi.setFont(fonttt);
		rimuovi.setBounds(260,150, 100, 40);
			
		cont.add(label0);
		label0.setBounds(40, 100, 250, 50);
		label0.setFont(fontt);
			
		cont.add(label1);
		label1.setBounds(40, 70,200, 40);
		label1.setFont(fontt);
		
		cont.add(a);
		a.setBounds(115,80 ,200, 25);
		a.setFont(fontt);
		
		cont.add(b);
		b.setBounds(123,114 ,200, 25);
		b.setFont(fontt);
			
		aggiungi.addActionListener(this);
		visualizza.addActionListener(this);
		okay.addActionListener(this);
		rimuovi.addActionListener(this);
			
		cont.add(label);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == aggiungi) 
		{
			int n=Integer.parseInt(a.getText());
			l.add(n);
		}
		else if (e.getSource() == visualizza) 
		{
			int temp=0;
			for(int h=0; h<l.size(); h++)
			{
				for(int j=0; j<l.size()-1; j++)
				{
					if(l.get(j)>l.get(j+1))
					{
						temp=l.get(j);
						l.set(j,l.get(j+1));
						l.set(j+1,temp);
					}
				}
			}
			b.setText(l+"");
		}	
		else if (e.getSource() == rimuovi) 
		{
			frame1.setVisible(true);	
		}
		else  if (e.getSource() == okay) 
		{
			System.out.println("c");
			int r=Integer.parseInt(c.getText());
			
			for(int u=0; u<l.size(); u++)
			{			
				if(r==l.get(u))
				{
	                l.remove(u);
	                b.setText(""+l);
	            }
			}
			frame1.setVisible(false);
		}	
	}
}

/*Implementare una GUI in Java che consente all'utente di inserire dei numeri interi in un ArrayList e,
successivamente cliccando sui vari pulsanti, permetta di scegliere le varie opzioni:


-Visualizzare i numeri in ordine crescente(non usare il sort);

-Un tasto che, all'inserimento di ogni numero, permetta di aggiungere un nuovo valore nella giusta posizione 
all'interno dell'array;

-Un tasto che permette di rimuovere un numero dall'Array: viene chiesto all'utente di inserire il numero da 
rimuovere tramite una finestra di dialogo. Se il numero è presente nell'ArrayList, viene rimosso e l'ArrayList aggiornato.
*/
