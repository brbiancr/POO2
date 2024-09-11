package pratica1.control;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import pratica1.model.Livro;

public class LivroController {

	public static void listarLivros(List<Livro> livros) {
		JFrame janelaListaLivros = new JFrame("Livros");
		janelaListaLivros.setSize(300, 130);
		
		JTextArea textoArea = new JTextArea();
		textoArea.setEditable(false);
		
		for(Livro livro: livros)
			textoArea.append("Livro: " + livro.getTitulo() + "Autor: " + livro.getAutor() + 
					"Ano: " + livro.getAno());
		
		janelaListaLivros.add(new JScrollPane(textoArea), BorderLayout.CENTER);
		
		janelaListaLivros.setVisible(true);
	}
	
	public static void incluirLivro(List<Livro> livros, String titulo, String autor, int ano) {
		Livro livro = new Livro(titulo, ano, autor);
		
		livros.add(livro);
	}
}
