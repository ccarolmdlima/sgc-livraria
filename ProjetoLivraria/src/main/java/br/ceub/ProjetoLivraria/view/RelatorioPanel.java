package br.ceub.ProjetoLivraria.view;

import br.ceub.ProjetoLivraria.client.ApiClient;

import javax.swing.*;
import java.awt.*;

public class RelatorioPanel extends JPanel {

    private JTextArea resultado;
    private ApiClient api = new ApiClient();

    public RelatorioPanel() {
        setLayout(new BorderLayout());

        JPanel botoes = new JPanel(new FlowLayout());

        JButton btnClientes = new JButton("Relatório de Clientes");
        JButton btnProdutos = new JButton("Relatório de Produtos");

        botoes.add(btnClientes);
        botoes.add(btnProdutos);

        resultado = new JTextArea();
        resultado.setEditable(false);

        add(botoes, BorderLayout.NORTH);
        add(new JScrollPane(resultado), BorderLayout.CENTER);

        btnClientes.addActionListener(e -> listarClientes());
        btnProdutos.addActionListener(e -> listarProdutos());
    }

    private void listarClientes() {
        try {
            resultado.setText(api.get("/clientes"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao gerar relatório: " + ex.getMessage());
        }
    }

    private void listarProdutos() {
        try {
            resultado.setText(api.get("/produtos"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao gerar relatório: " + ex.getMessage());
        }
    }
}