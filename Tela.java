import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Tela extends JFrame implements ActionListener
{
   private JTextField txt;   //JTextField é um campo editavel pelo usuario.
   private JLabel lblTexto;  //JLabel é um campo que não é editavel pelo usuario;
   private JButton btnMostrar, btnLimpar, btnSair; //JButton é um botão;
   
   public void actionPerformed (ActionEvent e)
   {
      if(e.getSource() == btnMostrar)
      {
         String texto = txt.getText();
         JOptionPane.showMessageDialog(null, texto);  
      }
      else if(e.getSource() == btnLimpar)
      {   
         txt.setText("");  
      }
      else if(e.getSource() == btnSair)
      {
         System.exit(0);
      }
   }  
   
   public Tela ()
   {
      super("Opções disponiveis");
      JPanel painelSuperior = new JPanel (new GridLayout(1, 1));
      JPanel painelEntrada = new JPanel (new FlowLayout());
      
      txt = new JTextField(10);
      lblTexto = new JLabel("Texto: ");
      painelSuperior.add(lblTexto);
      painelSuperior.add(txt);
      painelEntrada.add(painelSuperior);
      
      JPanel painelBotoes = new JPanel (new FlowLayout());
      btnMostrar = new JButton("Mostrar");
      btnLimpar = new JButton("Limpar");
      btnSair = new JButton("Sair");
      
      btnMostrar.addActionListener(this); //Botão Observado pela tela
      btnLimpar.addActionListener(this);  //Botão Observado pela tela
      btnSair.addActionListener(this);    //Botão Observado pela tela

      painelBotoes.add(btnMostrar);
      painelBotoes.add(btnLimpar);
      painelBotoes.add(btnSair);
      
      Container painelDeConteudo = getContentPane();
      
      painelDeConteudo.setLayout(new BorderLayout());
      
      painelDeConteudo.add(painelEntrada, BorderLayout.CENTER);   //Posicionamento do painel
      painelDeConteudo.add(painelBotoes, BorderLayout.SOUTH);     //Posicionamento do painel
      
      setSize(300, 120);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Quando clicar no X ele fecha a aplicação
      setLocationRelativeTo(null);  //Centraliza a tela;
      setVisible(true); //Torna a tela visivel
   }
   
   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         public void run()
         {
            new Tela();
         }
      });
     
   }
}