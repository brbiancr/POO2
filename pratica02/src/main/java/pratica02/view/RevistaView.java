package pratica02.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import pratica02.control.RevistasController;
import pratica02.model.Livro;
import pratica02.model.Revista;
import pratica02.model.Video;
import pratica02.utils.ComponentHelper;

public class RevistaView {
	
	private RevistasController revistasController;
	private ComponentHelper helper;
	
    private JTextField campoTitulo;
    private JTextField campoOrg;
    private JTextField campoVol;
    private JTextField campoNro;
    private JTextField campoAno;
	
	public RevistaView(List<Revista> revistas, List<Livro> livros, List<Video> videos) {
		this.revistasController = new RevistasController(revistas);
		this.helper = new ComponentHelper();
		
		janelaPrincipal(revistas, videos, livros);
	}
	
	public void janelaPrincipal(List<Revista> revistas, List<Video> videos, List<Livro> livros) {
		JFrame janela = new JFrame("Revista");
		janela.setSize(300, 155);
		janela.setLayout(new BorderLayout());
		
		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setLayout(new GridLayout(3, 2));
		
		JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(2, 2));
		
		campoTitulo = helper.criarCampoComLabel("Titulo", painelPrincipal);
        campoOrg = helper.criarCampoComLabel("Org", painelPrincipal);
        campoVol = helper.criarCampoComLabel("Vol.", painelPrincipal);
        campoNro = helper.criarCampoComLabel("Nro.", painelPrincipal);
        campoAno = helper.criarCampoComLabel("Ano.", painelPrincipal);


		JButton botaoIncluir = new JButton("Incluir");
		JButton botaoListagem = new JButton("Listagem");
		JButton botaoLivros = new JButton("Livros");
		JButton botaoVideos = new JButton("Videos");
		
		painelBotoes.add(botaoIncluir);
        painelBotoes.add(botaoListagem);
        painelBotoes.add(botaoLivros);
        painelBotoes.add(botaoVideos);
		
		janela.getContentPane().add(painelPrincipal, BorderLayout.NORTH);
		janela.getContentPane().add(painelBotoes, BorderLayout.SOUTH);
		
		botaoListagem.addActionListener(e -> listarRevistas(revistas));
		
		botaoIncluir.addActionListener(e -> incluirRevista());

		botaoLivros.addActionListener(e -> new LivroView(livros, revistas, videos));
		
		botaoVideos.addActionListener(e -> new VideoView(livros, revistas, videos));
		
		janela.setVisible(true);
	}

	public void listarRevistas(List<Revista> revistas) {
		JFrame janelaListaRevistas = new JFrame("Revistas");
		janelaListaRevistas.setSize(300, 130);
		
		JTextArea textoArea = new JTextArea();
        textoArea.setEditable(false);

        for(Revista revista: revistas)
            textoArea.append("Revista: " + revista.getTitulo() + " Org: "+ revista.getOrg() + " Vol: " + revista.getVol() + " Nro: " + 
            					revista.getNro() + " Ano: " + revista.getAno() + "\n");

        janelaListaRevistas.add(new JScrollPane(textoArea), BorderLayout.CENTER);

        janelaListaRevistas.setVisible(true);
	}
	
	private void incluirRevista() {
		String titulo = campoTitulo.getText();
        String org = campoOrg.getText();
        int vol = Integer.parseInt(campoVol.getText());
        int nro = Integer.parseInt(campoNro.getText());
        int ano = Integer.parseInt(campoAno.getText());

        revistasController.incluirRevista(titulo, ano, org, vol, nro);
        
        campoTitulo.setText("");
        campoOrg.setText("");
        campoVol.setText("");
        campoNro.setText("");
        campoAno.setText("");
	}
}
