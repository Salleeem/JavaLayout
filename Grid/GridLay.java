import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GridLay{
    public static void main(String[] args) {
        new Principal().setVisible(true);
    }
}
 
class Principal extends JFrame{
    private JTextField fieldPeso;
    private JTextField fieldAltura;
    private JButton calcular;
    private JLabel  peso;
    private JLabel lblAltura;
    private JLabel lblResultado;

    public Principal(){
        setConfig();
    }
 
    private void setConfig() {
       
        this.setTitle("Calculadora de IMC");
        this.setSize(600, 150);
        this.setLayout(new GridLayout(0, 2));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.lightGray);
         
        fieldPeso=new JTextField();
        fieldAltura=new JTextField();
        calcular=new JButton("Calcular");
        peso=new JLabel("Peso:");
        lblAltura=new JLabel("Altura:");
        lblResultado=new JLabel("Resultado:");
         
      
        calcular.addActionListener(new EventoCalculaIMC());
         
        this.add(peso);
        this.add(lblAltura);
        this.add(fieldPeso);
        this.add(fieldAltura);
        this.add(lblResultado);
        this.add(calcular);
    }
 
    class EventoCalculaIMC implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
 
              
                double peso=Double.parseDouble(fieldPeso.getText());
                double altura=Double.parseDouble(fieldAltura.getText());
             
                double imc=peso/Math.pow(altura,2);
 
          
                DecimalFormat df=new DecimalFormat("#0.0");
 
                String resultado="Resultado: "+df.format(imc);
                 
             
                if(imc < 18.5){
                    resultado+=" Abaixo do peso";
                }
                else if(imc < 24.9){
                    resultado+=" Peso ideal";
                }
                else if(imc < 29.9){
                    resultado+=" Levemente acima do peso";
                }
                else if(imc < 34.9){
                    resultado+=" Primeiro grau de obesidade";
                }
                else if(imc < 39.9){
                    resultado+=" Segundo grau de obesidade";
                }
                else
                    resultado+=" Obesidade mórbida";
 
             
                lblResultado.setText(resultado);
 
            }catch (ArithmeticException ar) {
                JOptionPane.showMessageDialog(null, "Erro aritmético, causa: "+ar.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro desconhecido, causa: "+ex.getMessage());
            }
        }
    }
 
}
 

