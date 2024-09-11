package pratica02.model;

public class Video extends MaterialBibliotecario{
	
	private String autor;
	private double duracao;
	
	public Video() {
		
	}
	
	public Video(String titulo, int ano, String autor, double duracao) {
		super(titulo, ano);
		this.autor = autor;
		this.duracao = duracao;		
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public double getDuracao() {
		return duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}
	
}
