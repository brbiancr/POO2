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

import pratica02.control.LivrosController;
import pratica02.model.Livro;
import pratica02.model.Revista;
import pratica02.model.Video;
import pratica02.utils.ComponentHelper;

public class LivroView {
	
	private LivrosController livrosController;
	private ComponentHelper helper;
	
	private JTextField campoTitulo;
	private JTextField campoAno;
    private JTextField campoAutor;

	public LivroView(List<Livro> livros, List<Revista> revistas, List<Video> videos) {
		
		this.livrosController = new LivrosController(livros);
		this.helper = new ComponentHelper();
		
		janelaPrincipal(livros, revistas, videos);
	}
	
	public void janelaPrincipal(List<Livro> livros, List<Revista> revistas, List<Video> videos) {
		JFrame janela = new JFrame("Livros");
		janela.setSize(300, 155);
		janela.setLayout(new BorderLayout());
		
		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setLayout(new GridLayout(3, 2));

		JPanel painelBotoes = new JPanel();
		painelBotoes.setLayout(new GridLayout(2, 2));

		campoTitulo = helper.criarCampoComLabel("Titulo", painelPrincipal);
		campoAutor = helper.criarCampoComLabel("Autor", painelPrincipal);
		campoAno = helper.criarCampoComLabel("Ano", painelPrincipal);

		JButton botaoIncluir = new JButton("Incluir");
		JButton botaoListagem = new JButton("Listagem");
		JButton botaoRevistas = new JButton("Revistas");
		JButton botaoVideos = new JButton("Videos");
		
		painelBotoes.add(botaoIncluir);
		painelBotoes.add(botaoListagem);
		painelBotoes.add(botaoRevistas);
		painelBotoes.add(botaoVideos);
		
		janela.getContentPane().add(painelPrincipal, BorderLayout.NORTH);
		janela.getContentPane().add(painelBotoes, BorderLayout.SOUTH);
		
		botaoListagem.addActionListener(e -> listarLivros(livros));
		
		botaoIncluir.addActionListener(e -> incluirLivro());

		botaoRevistas.addActionListener(e -> new RevistaView(revistas, livros, videos));
		
		botaoVideos.addActionListener(e -> new VideoView(livros, revistas, videos));
		
		janela.setVisible(true);
	}

	public void listarLivros(List<Livro> livros) {
		JFrame janelaListaLivros = new JFrame("Livros");
		janelaListaLivros.setSize(300, 130);
		
		JTextArea textoArea = new JTextArea();
        textoArea.setEditable(false);

        for(Livro livro: livros)
            textoArea.append("Livro: " + livro.getTitulo() + " Autor: "+ livro.getAutor() + " Ano: " + livro.getAno() + "\n");

        janelaListaLivros.add(new JScrollPane(textoArea), BorderLayout.CENTER);

        janelaListaLivros.setVisible(true);
	}
	
	private void incluirLivro() {
		String titulo = campoTitulo.getText();
        String autor = campoAutor.getText();
        int ano = Integer.parseInt(campoAno.getText());

        livrosController.incluirLivro(titulo, autor, ano);
        
        campoTitulo.setText("");
        campoAutor.setText("");
        campoAno.setText("");
	}
}
