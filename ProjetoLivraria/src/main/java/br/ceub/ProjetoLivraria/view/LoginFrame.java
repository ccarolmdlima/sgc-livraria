package br.ceub.ProjetoLivraria.view;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtSenha;

    public LoginFrame() {
        setTitle("Login - SGC Livraria");
        setSize(350, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

        txtUsuario = new JTextField();
        txtSenha = new JPasswordField();

        add(new JLabel("Usuário:"));
        add(txtUsuario);
        add(new JLabel("Senha:"));
        add(txtSenha);

        JButton btnEntrar = new JButton("Entrar");
        add(btnEntrar);

        btnEntrar.addActionListener(e -> login());
    }

    private void login() {
        String usuario = txtUsuario.getText();
        String senha = new String(txtSenha.getPassword());

        if (usuario.equals("admin") && senha.equals("1234")) {
            JOptionPane.showMessageDialog(this, "Login realizado com sucesso!");
            new MainFrame().setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}