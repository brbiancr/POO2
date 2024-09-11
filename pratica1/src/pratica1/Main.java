package pratica1;

import java.util.ArrayList;
import java.util.List;

import pratica1.model.Livro;
import pratica1.model.Revista;
import pratica1.view.LivroView;

public class Main {
	public static void main(String[] args) {
		
		List<Livro> livros = new ArrayList<Livro>();
		List<Revista> revistas = new ArrayList<Revista>();
		
		new LivroView(livros, revistas);
	}
}
