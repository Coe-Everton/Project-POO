import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TelaDeCadastroDeLogin extends JFrame {
    public TelaDeCadastroDeLogin(ArrayList<String> logins, ArrayList<String> senhas) {
        setTitle("Cadastro de Login JFrame - POO-BCCII");
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridLayout(4,1));

        //Panel de Tela De Cadastro De Login
        JPanel PanelTelaDeCadastroDeLogin = new JPanel();
        JLabel LabelTelaDeCadastroDeLogin = new JLabel("Cadastro de Login");
        LabelTelaDeCadastroDeLogin.setFont(new Font("Arial", Font.BOLD, 45));
        PanelTelaDeCadastroDeLogin.add(LabelTelaDeCadastroDeLogin);

        //Panel de Login
        JPanel PanelCadastroDeLogin = new JPanel();
        JLabel LabelCadastroDeLogin = new JLabel("Cadastro de Login");
        PanelCadastroDeLogin.add(LabelCadastroDeLogin);
        JTextField TextFieldCadastroDeLogin = new JTextField(20);
        PanelCadastroDeLogin.add(TextFieldCadastroDeLogin);

        //Panel de Senha
        JPanel PanelCadastroDeSenha = new JPanel();
        JLabel LabelCadastroDeSenha = new JLabel("Senha");
        PanelCadastroDeSenha.add(LabelCadastroDeSenha);
        JPasswordField TextFieldCadastroDeSenha = new JPasswordField(20);
        PanelCadastroDeSenha.add(TextFieldCadastroDeSenha);

        //Panel Botão de Cadastro Do login
        JPanel PanelButtonCadastrarLogin = new JPanel();
        JButton ButtonCadastrarLogin = new JButton("Cadastrar");
        PanelButtonCadastrarLogin.add(ButtonCadastrarLogin);

        ButtonCadastrarLogin.addActionListener(e->{
            dispose();
            CadastrarLogin(logins, senhas, TextFieldCadastroDeLogin, TextFieldCadastroDeSenha);
            Main main = new Main(logins, senhas);
        });

        add(PanelTelaDeCadastroDeLogin);
        add(PanelCadastroDeLogin);
        add(PanelCadastroDeSenha);
        add(PanelButtonCadastrarLogin);
        setVisible(true);
    }
    public void CadastrarLogin(ArrayList<String> login, ArrayList<String> senha, JTextField TextFieldCadastroDeLogin, JTextField TextFieldCadastroDeSenha) {
        login.add(TextFieldCadastroDeLogin.getText());
        senha.add(TextFieldCadastroDeSenha.getText());
        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
    }
}
