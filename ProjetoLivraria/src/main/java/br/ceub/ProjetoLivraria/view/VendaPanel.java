package br.ceub.ProjetoLivraria.view;

import br.ceub.ProjetoLivraria.client.ApiClient;

import javax.swing.*;
import java.awt.*;

public class VendaPanel extends JPanel {

    private JTextField clienteId, usuarioId, produtoId, quantidade, precoUnitario, vendaId;
    private JTextArea resultado;
    private ApiClient api = new ApiClient();

    public VendaPanel() {
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(7, 2, 5, 5));

        clienteId = new JTextField();
        usuarioId = new JTextField();
        produtoId = new JTextField();
        quantidade = new JTextField();
        precoUnitario = new JTextField();
        vendaId = new JTextField();

        form.add(new JLabel("ID Cliente:"));
        form.add(clienteId);
        form.add(new JLabel("ID Usuário:"));
        form.add(usuarioId);
        form.add(new JLabel("ID Produto:"));
        form.add(produtoId);
        form.add(new JLabel("Quantidade:"));
        form.add(quantidade);
        form.add(new JLabel("Preço Unitário:"));
        form.add(precoUnitario);
        form.add(new JLabel("ID Venda para Buscar:"));
        form.add(vendaId);

        JButton btnVenda = new JButton("Registrar Venda");
        JButton btnBuscar = new JButton("Buscar Venda");

        form.add(btnVenda);
        form.add(btnBuscar);

        resultado = new JTextArea();
        resultado.setEditable(false);

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(resultado), BorderLayout.CENTER);

        btnVenda.addActionListener(e -> registrarVenda());
        btnBuscar.addActionListener(e -> buscarVenda());
    }

    private void registrarVenda() {
        try {
            String json = String.format("""
                    {
                      "cliente": {
                        "id": %s
                      },
                      "usuario": {
                        "id": %s
                      },
                      "itens": [
                        {
                          "produto": {
                            "id": %s
                          },
                          "quantidade": %s,
                          "precoUnitario": %s
                        }
                      ]
                    }
                    """,
                    clienteId.getText(),
                    usuarioId.getText(),
                    produtoId.getText(),
                    quantidade.getText(),
                    precoUnitario.getText()
            );

            String resposta = api.post("/vendas", json);
            resultado.setText(resposta);
            JOptionPane.showMessageDialog(this, "Venda registrada!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao registrar venda: " + ex.getMessage());
        }
    }

    private void buscarVenda() {
        try {
            resultado.setText(api.get("/vendas/" + vendaId.getText()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar venda: " + ex.getMessage());
        }
    }
}