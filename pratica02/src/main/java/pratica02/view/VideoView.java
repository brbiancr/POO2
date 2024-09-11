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

import pratica02.control.VideoController;
import pratica02.model.Livro;
import pratica02.model.Revista;
import pratica02.model.Video;
import pratica02.utils.ComponentHelper;

public class VideoView {
	
	private VideoController videoController;
	private ComponentHelper helper;
	
	private JTextField campoTitulo;
	private JTextField campoAno;
	private JTextField campoAutor;
	private JTextField campoDuracao;
	
	public VideoView(List<Livro> livros, List<Revista> revistas, List<Video> videos) {
		
		this.videoController = new VideoController(videos);
		this.helper = new ComponentHelper();
		
		janelaPrincipal(livros, revistas, videos);
		
	}
	
	private void janelaPrincipal(List<Livro> livros, List<Revista> revistas, List<Video> videos) {
		JFrame janela = new JFrame("Video");
		janela.setSize(300, 175);
		janela.setLayout(new BorderLayout());
		
		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setLayout(new GridLayout(4, 2));

		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setLayout(new GridLayout(2, 2));
		
		campoTitulo = helper.criarCampoComLabel("Titulo", painelPrincipal);
		campoAno = helper.criarCampoComLabel("Ano", painelPrincipal);
		campoAutor = helper.criarCampoComLabel("Autor", painelPrincipal);
		campoDuracao = helper.criarCampoComLabel("Duracao", painelPrincipal);

		JButton botaoIncluir = new JButton("Incluir");
		JButton botaoRevistas = new JButton("Revistas");
		JButton botaoLivros = new JButton("Livros");
		JButton botaoListagem = new JButton("Listagem");
		
		painelBotoes.add(botaoIncluir);
		painelBotoes.add(botaoListagem);
		painelBotoes.add(botaoRevistas);
		painelBotoes.add(botaoLivros);
		
		janela.getContentPane().add(painelPrincipal, BorderLayout.NORTH);
		janela.getContentPane().add(painelBotoes, BorderLayout.SOUTH);
		
		botaoListagem.addActionListener(e -> listarVideos(videos));
		
		botaoIncluir.addActionListener(e -> incluirVideo());

		botaoLivros.addActionListener(e -> new LivroView(livros, revistas, videos));
		
		botaoRevistas.addActionListener(e -> new RevistaView(revistas, livros, videos));
		
		janela.setVisible(true);
	}
	
	public void listarVideos(List<Video> videos) {
		JFrame janelaListaLivros = new JFrame("Videos");
		janelaListaLivros.setSize(300, 130);
		
		JTextArea textoArea = new JTextArea();
        textoArea.setEditable(false);

        for(Video video: videos)
            textoArea.append("Video: " + video.getTitulo() + " Autor: "+ video.getAutor() + " Ano: " + video.getAno() + "\n");

        janelaListaLivros.add(new JScrollPane(textoArea), BorderLayout.CENTER);

        janelaListaLivros.setVisible(true);
	}
	
	private void incluirVideo() {
		String titulo = campoTitulo.getText();
        int ano = Integer.parseInt(campoAno.getText());
        String autor = campoAutor.getText();
        double duracao = Double.parseDouble(campoDuracao.getText());

        videoController.incluirVideo(titulo, autor, ano, duracao);
        
        campoTitulo.setText("");
        campoAno.setText("");
        campoAutor.setText("");
        campoDuracao.setText("");
	}
}
