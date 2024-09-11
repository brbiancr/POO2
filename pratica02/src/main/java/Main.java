import java.util.ArrayList;
import java.util.List;

import pratica02.model.Livro;
import pratica02.model.Revista;
import pratica02.model.Video;
import pratica02.view.LivroView;

public class Main {
	public static void main(String[] args) {
		
		List<Livro> livros = new ArrayList<Livro>();
		List<Revista> revistas = new ArrayList<Revista>();
		List<Video> videos = new ArrayList<Video>();
		
		new LivroView(livros, revistas, videos);
	}
}
