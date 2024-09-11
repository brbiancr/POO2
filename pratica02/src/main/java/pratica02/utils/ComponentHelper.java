package pratica02.utils;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ComponentHelper {
	
	public JTextField criarCampoComLabel(String label, JPanel painel) {
        JLabel titulo = new JLabel(label);
        JTextField campo = new JTextField(10);
        painel.add(titulo);
        painel.add(campo);
        return campo;
    }
}
