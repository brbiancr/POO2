package pratica1.model;

public class Revista extends MaterialBibliotecario{
	private String org;
	private int vol;
	private int nro;
	
	public Revista() {
		super();
	}
	
	public Revista(String titulo, int ano, String org, int vol, int nro) {
		super(titulo, ano);
		this.org = org;
		this.vol = vol;
		this.nro = nro;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public int getVol() {
		return vol;
	}

	public void setVol(int vol) {
		this.vol = vol;
	}

	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}
}
