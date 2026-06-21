package br.ceub.ProjetoLivraria.view;

import br.ceub.ProjetoLivraria.client.ApiClient;

import javax.swing.*;
import java.awt.*;

public class ClientePanel extends JPanel {

    private JTextField nome, cpf, email, telefone, endereco;
    private JTextArea resultado;
    private ApiClient api = new ApiClient();

    public ClientePanel() {
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(6, 2, 5, 5));

        nome = new JTextField();
        cpf = new JTextField();
        email = new JTextField();
        telefone = new JTextField();
        endereco = new JTextField();

        form.add(new JLabel("Nome:"));
        form.add(nome);
        form.add(new JLabel("CPF:"));
        form.add(cpf);
        form.add(new JLabel("Email:"));
        form.add(email);
        form.add(new JLabel("Telefone:"));
        form.add(telefone);
        form.add(new JLabel("Endereço:"));
        form.add(endereco);

        JButton btnSalvar = new JButton("Salvar Cliente");
        JButton btnListar = new JButton("Listar Clientes");

        form.add(btnSalvar);
        form.add(btnListar);

        resultado = new JTextArea();
        resultado.setEditable(false);

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(resultado), BorderLayout.CENTER);

        btnSalvar.addActionListener(e -> salvarCliente());
        btnListar.addActionListener(e -> listarClientes());
    }

    private void salvarCliente() {
        try {
            String json = String.format("""
                    {
                      "nome": "%s",
                      "cpf": "%s",
                      "email": "%s",
                      "telefone": "%s",
                      "endereco": "%s"
                    }
                    """, nome.getText(), cpf.getText(), email.getText(), telefone.getText(), endereco.getText());

            String resposta = api.post("/clientes", json);
            resultado.setText(resposta);
            JOptionPane.showMessageDialog(this, "Cliente cadastrado!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar cliente: " + ex.getMessage());
        }
    }

    private void listarClientes() {
        try {
            resultado.setText(api.get("/clientes"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao listar clientes: " + ex.getMessage());
        }
    }
}