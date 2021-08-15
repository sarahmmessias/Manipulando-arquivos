package ManipulandoArquivos;

import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Form extends JFrame implements ActionListener{
		
	private static final long serialVersionUID = 1L;
	private static LerEEscreverTXT ler;
	private JPanel painel;
	private JButton bttMostrar, bttSalvar, bttLn, bttMaisc, bttMinus, bttCarac;
	private JTextArea textArea;
	private JLabel texto;
	
	Form(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Manipulação de arquivo de texto");
		setSize(750, 700);
		painel = new JPanel();
		setContentPane(painel);
		setLocationRelativeTo(null);
		setLayout(null);
		
		bttMostrar = new JButton("Ler arquivo");
		bttMostrar.setBounds(50, 20, 160, 40);
		painel.add(bttMostrar);
		bttMostrar.addActionListener(this);
		
		bttSalvar = new JButton("Salvar alterações");
		bttSalvar.setBounds(250, 20, 160, 40);
		painel.add(bttSalvar);
		bttSalvar.addActionListener(this);
		
		bttLn = new JButton("Exibir quantidade de linhas");
		bttLn.setBounds(450, 20, 210, 40);
		painel.add(bttLn);
		bttLn.addActionListener(this);
		
		bttMaisc = new JButton("Deixar contéudo em maiúsculo");
		bttMaisc.setBounds(10, 80, 235, 40);
		painel.add(bttMaisc);
		bttMaisc.addActionListener(this);
		
		bttMinus = new JButton("Deixar contéudo em minúsculo");
		bttMinus.setBounds(255, 80, 235, 40);
		painel.add(bttMinus);
		bttMinus.addActionListener(this);
		
		bttCarac = new JButton("Exibir quantidade de caracteres");
		bttCarac.setBounds(500, 80, 220, 40);
		painel.add(bttCarac);
		bttCarac.addActionListener(this);

		textArea = new JTextArea();
		textArea.setBounds(26, 140, 680, 425);
		painel.add(textArea);
		
		texto = new JLabel();
		texto.setBounds(26, 560, 680, 40);
		painel.add(texto);
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bttMostrar) { //Mostra o conteúdo salvo
			textArea.setText(ler.abrir());
		}
		
		if(e.getSource() == bttSalvar) { //Salva o conteúdo
			ler.salvar(textArea.getText());
		}
		
		if(e.getSource() == bttLn) { //Quantidade de linhas
			try {
				texto.setText("Quantidade de linhas do arquivo: "+ ler.QuantLns()+" linha(s).");
			} catch (IOException err) {
				JOptionPane.showMessageDialog(null, "Erro ao carregar arquivo: " + err);
			}
		}
		
		if(e.getSource() == bttMaisc) { //Deixa o conteúdo do arquivo em maiúsculo
			ler.salvar(textArea.getText().toUpperCase());
			textArea.setText(ler.abrir());
		}
		
		if(e.getSource() == bttMinus) { //Deixa o conteúdo do arquivo em minúsculo
			ler.salvar(textArea.getText().toLowerCase());
			textArea.setText(ler.abrir());
		}
		
		if(e.getSource() == bttCarac) { //Quantidade de caracteres
			try {
				texto.setText("Quantidade de caracteres: "+ ler.QuantCarac()+" caractere(s).");
			} catch (IOException err) {
				JOptionPane.showMessageDialog(null, "Erro ao carregar arquivo: " + err);
			}
		}	
		
	}
	
	public static void main(String[] args) {
		ler = new LerEEscreverTXT();
		new Form().setVisible(true);
	}

}