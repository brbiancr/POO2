package pratica1.control;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import pratica1.model.Revista;

public class RevistaController {

	public static void ListarRevistas(List<Revista> revistas) {
		JFrame janelaListaRevistas = new JFrame("Revistas");
		janelaListaRevistas.setSize(300, 130);
		
		JTextArea textoArea = new JTextArea();
		textoArea.setEditable(false);
		
		for(Revista revista: revistas)
			textoArea.append("Revista: " + revista.getTitulo() + "Org: " + revista.getOrg() + 
					"Vol: " + revista.getVol() + "Nro: " + revista.getNro() + "Ano: " + revista.getAno());
		
		janelaListaRevistas.add(new JScrollPane(textoArea), BorderLayout.CENTER);
		
		janelaListaRevistas.setVisible(true);
	}
	
	public static void incluirRevista(List<Revista> revistas, String titulo, String org, int vol, int nro, int ano) {
		Revista revista = new Revista(titulo, ano, org, vol, nro);
		
		revistas.add(revista);
	}
}
