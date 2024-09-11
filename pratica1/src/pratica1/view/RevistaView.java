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

import pratica1.control.RevistaController;
import pratica1.model.Livro;
import pratica1.model.Revista;

public class RevistaView {
	
	public RevistaView(List<Revista> revistas, List<Livro> livros) {
		JFrame janela = new JFrame("Revistas");
		janela.setSize(300, 130);
		janela.setLayout(new BorderLayout());		
		
		JLabel titulo = new JLabel("Titulo");
		JTextField campoTitulo = new JTextField(10);
		JLabel org = new JLabel("Org");
		JTextField campoOrg = new JTextField(10);
		JLabel vol = new JLabel("Vol");
		JTextField campoVol = new JTextField(10);
		JLabel nro = new JLabel("Nro");
		JTextField campoNro = new JTextField(10);
		JLabel ano = new JLabel("Ano");
		JTextField campoAno = new JTextField(10);
		
		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setLayout(new GridLayout(3, 2));
		painelPrincipal.add(titulo);
		painelPrincipal.add(campoTitulo);
		painelPrincipal.add(org);
		painelPrincipal.add(campoOrg);
		painelPrincipal.add(vol);
		painelPrincipal.add(campoVol);
		painelPrincipal.add(nro);
		painelPrincipal.add(campoNro);
		painelPrincipal.add(ano);
		painelPrincipal.add(campoAno);
		
		JButton botaoIncluir = new JButton("Incluir");
		JButton botaoLivros = new JButton("Livros");
		JButton botaoListagem = new JButton("Listagem");
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setLayout(new GridLayout(1, 3));
		painelBotoes.add(botaoIncluir);
		painelBotoes.add(botaoLivros);
		painelBotoes.add(botaoListagem);
		
		janela.getContentPane().add(painelPrincipal, BorderLayout.NORTH);
		janela.getContentPane().add(painelBotoes, BorderLayout.SOUTH);
		
		botaoListagem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RevistaController.ListarRevistas(revistas);
				
			}
		});
		
		botaoLivros.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new LivroView(livros, revistas);
			}
		});
		
		botaoIncluir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String titulo = campoTitulo.getText();
				String org = campoOrg.getText();
				int vol = Integer.parseInt(campoVol.getText());
				int nro = Integer.parseInt(campoNro.getText());
				int ano = Integer.parseInt(campoAno.getText());
				
				RevistaController.incluirRevista(revistas, titulo, org, vol, nro, ano);
				
				campoTitulo.setText("");
				campoOrg.setText("");
				campoVol.setText("");
				campoNro.setText("");
				campoAno.setText("");
			}
		});
		
		janela.setVisible(true);
	}
}
