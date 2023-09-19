package JavaLayout.Flow;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//main

public class Main {
    public static void main(String[] args) {
        new Principal().setVisible(true);
    }
}

//Criação dos componentes da interface

class Principal extends JFrame {
    private JTextField fieldPeso;
    private JTextField fieldAltura;
    private JButton calcular;
    private JLabel peso;
    private JLabel lblAltura;
    private JLabel lblResultado;

    //Configuracões

    public Principal() {
        setConfig();
    }

    //Layout

    private void setConfig() {
        this.setTitle("Calculadora de IMC");
        this.setSize(355, 150);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.lightGray);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        fieldPeso = new JTextField(10);
        fieldAltura = new JTextField(10);
        calcular = new JButton("Calcular");
        peso = new JLabel("Peso(Kg):");
        lblAltura = new JLabel("Altura(m):");
        lblResultado = new JLabel("Resultado:");

        calcular.addActionListener(new EventoCalculaIMC());

        inputPanel.add(peso);
        inputPanel.add(fieldPeso);
        inputPanel.add(lblAltura);
        inputPanel.add(fieldAltura);

        this.add(inputPanel);
        this.add(calcular);
        this.add(lblResultado);
    }

    //Calculadora

    class EventoCalculaIMC implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double peso = Double.parseDouble(fieldPeso.getText());
                double altura = Double.parseDouble(fieldAltura.getText());

                double imc = peso / Math.pow(altura, 2);

                DecimalFormat df = new DecimalFormat("#0.0");

                String resultado = "Resultado: " + df.format(imc);

                if (imc < 18.5) {
                    resultado += " Abaixo do peso";
                } else if (imc < 24.9) {
                    resultado += " Peso ideal";
                } else if (imc < 29.9) {
                    resultado += " Levemente acima do peso";
                } else if (imc < 34.9) {
                    resultado += " Primeiro grau de obesidade";
                } else if (imc < 39.9) {
                    resultado += " Segundo grau de obesidade";
                } else
                    resultado += " Obesidade mórbida";

                lblResultado.setText(resultado);
            } catch (ArithmeticException ar) {
                JOptionPane.showMessageDialog(null, "Erro aritmético, causa: " + ar.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro, causa: " + ex.getMessage() + ", Utilize o formato '0.00'");
            }
        }
    }
}
