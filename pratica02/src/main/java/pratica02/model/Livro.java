package pratica02.model;

public class Livro extends MaterialBibliotecario{
	private String autor;
	
	public Livro() {
		super();
	}

	public Livro(String titulo, int ano, String autor) {
		super(titulo, ano);
		this.autor = autor;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}	
}
