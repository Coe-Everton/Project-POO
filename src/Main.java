import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main extends JFrame {
    public Main(ArrayList<String> Login, ArrayList<String> Senha) {
    setLayout(new GridLayout(6,1));
//    setLayout(new FlowLayout());
    setTitle("Login JFrame - POO-BCCII");
    setSize(1280, 720);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel PanelTelaDeLogin = new JPanel();
    JLabel LabelTelaDeLogin = new JLabel("Tela de Login");
    LabelTelaDeLogin.setFont(new Font("Arial", Font.BOLD, 45));
    PanelTelaDeLogin.add(LabelTelaDeLogin);

    //Panel Login
    JPanel PanelLogin = new JPanel();
    JLabel LabelLogin = new JLabel("Login");
    PanelLogin.add(LabelLogin);
    JTextField TextFieldLogin = new JTextField(20);
    PanelLogin.add(TextFieldLogin);

    //Panel Senha
    JPanel PanelSenha = new JPanel();
    JLabel LabelSenha = new JLabel("Senha");
    JPasswordField JPasswordFieldSenha = new JPasswordField(20);
    PanelSenha.add(LabelSenha);
    PanelSenha.add(JPasswordFieldSenha);

    JPanel PanelButtonSubmit = new JPanel();
    JButton ButtonSubmit = new JButton("Submit");
    PanelButtonSubmit.add(ButtonSubmit);

    //Panel Button de Cadastro De Login
    JPanel PanelCadastroDeLogin = new JPanel();
    JButton ButtonCadastroDeLogin = new JButton("Cadastro de Login");
    PanelCadastroDeLogin.add(ButtonCadastroDeLogin);

    add(PanelTelaDeLogin);
    add(PanelLogin);
    add(PanelSenha);
    add(PanelButtonSubmit);
    add(PanelCadastroDeLogin);
    setVisible(true);

    ButtonSubmit.addActionListener(
            e -> { if(Login.stream()
                                    .anyMatch(login -> login.equals(TextFieldLogin.getText())) &&
                                Senha.stream()
                                    .anyMatch(senha -> senha.equals(new String(JPasswordFieldSenha.getPassword())))){
                                        System.out.println("Acesso permitido");
                                        dispose();
                                        MenuBar menuBar = new MenuBar(Login, Senha);
                             }else{
                                        JOptionPane.showMessageDialog(null, "Acesso negado");
                             }});

    ButtonCadastroDeLogin.addActionListener(e -> {
        dispose();
        TelaDeCadastroDeLogin telaDeLogin = new TelaDeCadastroDeLogin(Login, Senha);
    });

    }
    public void TelaDeCadastro (){
        System.out.println("Iniciando Tela de Cadastro");
        setLayout(new FlowLayout());
        setTitle("Calculadora JFrame - POO-BCCII");
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        ArrayList<String> Login = new ArrayList<>();
        ArrayList<String> Senha = new ArrayList<>();
        Main main = new Main(Login, Senha);
    }
}
