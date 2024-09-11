package pratica02.control;

import java.util.List;

import pratica02.model.Revista;

public class RevistasController {
	
	private List<Revista> revistas;

    public RevistasController(List<Revista> revistas) {
        this.revistas = revistas;
    }

    public void incluirRevista(String titulo, int ano, String org, int vol, int num) {
        Revista revista = new Revista(titulo, ano, org, vol, num);
        revistas.add(revista);
    }

    public List<Revista> getRevistas() {
        return revistas;
    }
}