package pratica1.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pratica1.control.LivroController;
import pratica1.model.Livro;
import pratica1.model.Revista;

public class LivroView {
	
	public LivroView(List<Livro> livros, List<Revista> revistas) {
		JFrame janela = new JFrame("Livros");
		janela.setSize(300, 130);
		janela.setLayout(new BorderLayout());		
		
		JLabel titulo = new JLabel("Titulo");
		JTextField campoTitulo = new JTextField(10);
		JLabel autor = new JLabel("Autor");
		JTextField campoAutor = new JTextField(10);
		JLabel ano = new JLabel("Ano");
		JTextField campoAno = new JTextField(10);
		
		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setLayout(new GridLayout(3, 2));
		painelPrincipal.add(titulo);
		painelPrincipal.add(campoTitulo);
		painelPrincipal.add(autor);
		painelPrincipal.add(campoAutor);
		painelPrincipal.add(ano);
		painelPrincipal.add(campoAno);
		
		JButton botaoIncluir = new JButton("Incluir");
		JButton botaoRevistas = new JButton("Revistas");
		JButton botaoListagem = new JButton("Listagem");
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setLayout(new GridLayout(1, 3));
		painelBotoes.add(botaoIncluir);
		painelBotoes.add(botaoRevistas);
		painelBotoes.add(botaoListagem);
		
		janela.getContentPane().add(painelPrincipal, BorderLayout.NORTH);
		janela.getContentPane().add(painelBotoes, BorderLayout.SOUTH);
		
		botaoListagem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LivroController.listarLivros(livros);
				
			}
		});
		
		botaoRevistas.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new RevistaView(revistas, livros);
			}
		});
		
		botaoIncluir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String titulo = campoTitulo.getText();
				String autor = campoAutor.getText();
				int ano = Integer.parseInt(campoAno.getText());
				
				LivroController.incluirLivro(livros, titulo, autor, ano);
				
				campoTitulo.setText("");
				campoAutor.setText("");
				campoAno.setText("");
			}
		});
		
		janela.setVisible(true);
	}
}
