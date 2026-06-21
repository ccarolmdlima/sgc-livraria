package br.ceub.ProjetoLivraria.view;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("SGC Livraria");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane abas = new JTabbedPane();

        abas.addTab("Clientes", new ClientePanel());
        abas.addTab("Produtos", new ProdutoPanel());
        abas.addTab("Vendas", new VendaPanel());
        abas.addTab("Relatórios", new RelatorioPanel());

        add(abas);
    }
}