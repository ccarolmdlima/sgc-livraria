package br.ceub.ProjetoLivraria.view;

import br.ceub.ProjetoLivraria.client.ApiClient;

import javax.swing.*;
import java.awt.*;

public class ProdutoPanel extends JPanel {

    private JTextField nome, descricao, preco, estoque;
    private JTextArea resultado;
    private ApiClient api = new ApiClient();

    public ProdutoPanel() {
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(5, 2, 5, 5));

        nome = new JTextField();
        descricao = new JTextField();
        preco = new JTextField();
        estoque = new JTextField();

        form.add(new JLabel("Nome do Livro:"));
        form.add(nome);
        form.add(new JLabel("Descrição:"));
        form.add(descricao);
        form.add(new JLabel("Preço:"));
        form.add(preco);
        form.add(new JLabel("Estoque:"));
        form.add(estoque);

        JButton btnSalvar = new JButton("Salvar Produto");
        JButton btnListar = new JButton("Listar Produtos");

        form.add(btnSalvar);
        form.add(btnListar);

        resultado = new JTextArea();
        resultado.setEditable(false);

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(resultado), BorderLayout.CENTER);

        btnSalvar.addActionListener(e -> salvarProduto());
        btnListar.addActionListener(e -> listarProdutos());
    }

    private void salvarProduto() {
        try {
            String json = String.format("""
                    {
                      "nome": "%s",
                      "descricao": "%s",
                      "preco": %s,
                      "estoque": %s
                    }
                    """, nome.getText(), descricao.getText(), preco.getText(), estoque.getText());

            String resposta = api.post("/produtos", json);
            resultado.setText(resposta);
            JOptionPane.showMessageDialog(this, "Produto cadastrado!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar produto: " + ex.getMessage());
        }
    }

    private void listarProdutos() {
        try {
            resultado.setText(api.get("/produtos"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao listar produtos: " + ex.getMessage());
        }
    }
}