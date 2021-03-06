package ManipulandoArquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class LerEEscreverTXT {
	BufferedReader br; //Classe que separa um espa?o na mem?ria para leitura
	BufferedWriter bw; //Classe que separa um espa?o na mem?ria para grava??o
	String arquivo = "./bd/arquivo.txt"; //Caminho dentro do projeto (./) onde ser? salvo o arquivo
	
	void salvar(String conteudo) {
		try {
			bw = new BufferedWriter(new FileWriter(arquivo,false)); //Abre para grava??o
			bw.write(conteudo); //Imprime o conte?do do arquivo
			bw.close(); //Fecha o arquivo
		} catch (IOException e) { //Caso haja erro ao salvar ex.: disco cheio
			JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo: "+e);
		}
	}
	
	String abrir() {
		String retorno = "";
		try {
			br = new BufferedReader(new FileReader(arquivo)); //Abre o arquivo para a leitura
			String linha = ""; //Linha em branco para a leitura em etapas
			while ((linha = br.readLine()) != null) { //Enquanto linha diferente de nulo
				retorno += linha + "\n";
			}	
			br.close(); //Fecha o arquivo
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo n?o encontrado: "+ e);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao abrir arquivo: "+e);
		}
		return retorno;
	}
	
	int QuantLns() throws IOException {
		int quant = 0; 
		br = new BufferedReader(new FileReader(arquivo));
		while((br.readLine()) != null) {
			quant += 1;
		}
		return quant;
	}
	
	int QuantCarac() throws IOException {
		int quant = 0;
		String ln = "";
		br = new BufferedReader(new FileReader(arquivo));
		while((ln = br.readLine()) != null) {
			quant += ln.length();	
		}
		return quant;
	}
	
}