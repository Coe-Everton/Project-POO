import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class TelaDeCadastroDeProdutos extends JFrame {
    public TelaDeCadastroDeProdutos(ArrayList<String> logins, ArrayList<String> senhas) {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setTitle("Tela de Cadastro JFrame - POO-BCCII");
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //Panel Tela De Cadastro
        JPanel PanelTelaCadastro = new JPanel();
        JLabel LabelTelaDeCadastro = new JLabel("Tela de Cadastro");
        LabelTelaDeCadastro.setFont(new Font("Arial", Font.BOLD, 45));
        PanelTelaCadastro.setPreferredSize(new Dimension(1280,50));
        PanelTelaCadastro.add(LabelTelaDeCadastro);

        //Panel Nome do Produto
        JPanel PanelNomeDoProduto = new JPanel();
        JLabel LabelNomeDoProduto = new JLabel("Nome do produto");
        JTextField TextFieldNomeDoProduto = new JTextField(20);
        PanelNomeDoProduto.add(LabelNomeDoProduto);
        PanelNomeDoProduto.add(TextFieldNomeDoProduto);

        //Panel Marca do Produto
        JPanel PanelMarcaDoProduto = new JPanel();
        JLabel LabelMarcaDoProduto = new JLabel("Marca do produto");
        JTextField TextFieldMarcaDoProduto = new JTextField(20);
        PanelMarcaDoProduto.add(LabelMarcaDoProduto);
        PanelMarcaDoProduto.add(TextFieldMarcaDoProduto);

        //Panel Codigo do Produto
        JPanel PanelCodigoDoProduto = new JPanel();
        JLabel LabelCodigoDoProduto = new JLabel("Código do produto");
        JTextField TextFieldCodigoDoProduto = new JTextField(20);
        PanelCodigoDoProduto.add(LabelCodigoDoProduto);
        PanelCodigoDoProduto.add(TextFieldCodigoDoProduto);

        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // não deixando editar as linhas da tabela
            }
        };
        modelo.addColumn("Nome");
        modelo.addColumn("Marca");
        modelo.addColumn("Codigo");

        JPanel PanelTabela = new JPanel();
        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(new JTable(modelo));
        JTable tabela = (JTable) scroll.getViewport().getView();
        scroll.setPreferredSize(new Dimension(1000,480));
        PanelTabela.add(scroll);


        //Panel Buttons Ações
        JPanel PanelButtonsAcoes = new JPanel();
        JButton ButtonCadastrar = new JButton("Cadastrar");
        JButton ButtonDescadastrar = new JButton("Remover produto");
        PanelButtonsAcoes.setPreferredSize(new Dimension(1280, 50));
        PanelButtonsAcoes.add(ButtonCadastrar);
        PanelButtonsAcoes.add(ButtonDescadastrar);

        //Panel Button Log Out
        JPanel PanelButtonLogOut = new JPanel();
        JButton ButtonLogOut = new JButton("Log out");
        PanelButtonLogOut.setPreferredSize(new Dimension(1280, 50));
        PanelButtonLogOut.add(ButtonLogOut);



        ButtonCadastrar.addActionListener(e ->
                AddRow(TextFieldNomeDoProduto.getText(),
                        TextFieldMarcaDoProduto.getText(),
                        TextFieldCodigoDoProduto.getText(),
                        modelo));

        ButtonDescadastrar.addActionListener(e ->
                RemoveRow(tabela,
                        modelo));
        ButtonLogOut.addActionListener(e -> LogOut(logins, senhas));

        add(PanelTelaCadastro);
        add(PanelNomeDoProduto);
        add(PanelMarcaDoProduto);
        add(PanelCodigoDoProduto);
        add(PanelButtonsAcoes);
        add(PanelTabela);
        add(PanelButtonLogOut);
    }

    public void AddRow(String Nome, String Marca, String Codigo,DefaultTableModel modelo){
        if(Objects.equals(Nome, "") || Objects.equals(Marca, "")|| Objects.equals(Codigo, "")){
            JOptionPane.showMessageDialog(null, "Preencha os campos");
            return;
        }
        modelo.addRow(new Object[]{Nome, Marca, Codigo});
    }

    public void RemoveRow(JTable tabela,DefaultTableModel modelo){
        int selectedRow = tabela.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um produto");
            return;
        }
        modelo.removeRow(selectedRow);
        JOptionPane.showMessageDialog(null, "Produto excluido com sucesso!");
    }

    public void LogOut(ArrayList<String> logins, ArrayList<String> senhas){
        dispose();
        JOptionPane.showMessageDialog(null, "Log out");
        Main main = new Main(logins, senhas);
    }
}
