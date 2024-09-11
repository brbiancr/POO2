package pratica02.control;

import java.util.List;

import pratica02.model.Livro;

public class LivrosController {
	
	private List<Livro> livros;
	
	public LivrosController(List<Livro> livros) {
		this.livros = livros;
	}
	
	public void incluirLivro(String titulo, String autor, int ano) {
		Livro livro = new Livro(titulo, ano, autor);
		
		livros.add(livro);		
	}
}
