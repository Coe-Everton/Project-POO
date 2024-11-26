import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuBar extends JFrame {
    public  MenuBar(ArrayList<String> logins, ArrayList<String> senhas) {
        setTitle("Menu de opções JFrame - POO-BCCII");
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new FlowLayout());

        JMenuBar menuBar = new JMenuBar(); // criando o menu em barra
        menuBar.setPreferredSize(new Dimension(1280,20)); // setando dimenssoes

        // Criando as opções do menu
        JMenu menuOpcoes = new JMenu("Opções"); // criando menu opções
        JMenu menuSair = new JMenu("Sair");

        // Add itens as opções do menu
        JMenuItem itemCadastro = new JMenuItem("Cadastro");
        JMenuItem itemSair = new JMenuItem("Sair");
        JMenuItem itemLogOut = new JMenuItem("Log out");

        // Vinculando os intens as opções do menu
        menuSair.add(itemSair);
        menuSair.add(itemLogOut);
        menuOpcoes.add(itemCadastro);

        menuBar.add(menuOpcoes);
        menuBar.add(menuSair);

        itemCadastro.addActionListener(e->{
            dispose();
            TelaDeCadastroDeProdutos telaDeCadastroDeProdutos = new TelaDeCadastroDeProdutos(logins, senhas);
        });
        itemLogOut.addActionListener(e->{
            dispose();
            Main main = new Main(logins, senhas);
        });
        itemSair.addActionListener(e->{System.exit(0);});

        add(menuBar);
        setVisible(true);
    }
}
