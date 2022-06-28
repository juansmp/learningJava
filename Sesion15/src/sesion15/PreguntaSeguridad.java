package sesion15;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PreguntaSeguridad extends JFrame {

    private JPanel PnlContentPanel;
    private JTextField TxtPregunta;
    private JButton BtnGuardar;
    private JButton BtnValidar;
    private JLabel LblPregunta;
    private JLabel LblImprimir;
    private String respuesta;

    public PreguntaSeguridad() {
        setTitle("Pregunta de seguridad");

        setBounds(40, 100, 655, 502);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);
        GridLayout ejemploLayout = new GridLayout(0, 2);

        PnlContentPanel = new JPanel(ejemploLayout);

        setContentPane(PnlContentPanel);

        LblPregunta = new JLabel("¿Cuál es el nombre de tu mascota?");
        PnlContentPanel.add(LblPregunta);
        
        
        TxtPregunta = new JTextField("");
        PnlContentPanel.add(TxtPregunta);

        BtnGuardar = new JButton("Guardar");
        PnlContentPanel.add(BtnGuardar);

        BtnValidar = new JButton("Validar");
        PnlContentPanel.add(BtnValidar);

        LblImprimir = new JLabel("---");
        PnlContentPanel.add(LblImprimir);

        BtnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (TxtPregunta.getText().trim().equals("")) {
                    LblImprimir.setText("Error, no se ha ingresado una respuesta correcta");
                } else {
                    respuesta = TxtPregunta.getText();
                    LblImprimir.setText("Respuesta guardada");
                }
            }
        });
        
        BtnValidar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (TxtPregunta.getText().trim().equals(respuesta)) {
                    LblImprimir.setText("Respuesta Correcta");
                } else {
                    LblImprimir.setText("Respuesta incorrecta");
                }
            }
        });

    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                
                try {
                    PreguntaSeguridad frame = new PreguntaSeguridad();
                    frame.setVisible(true);
                } catch (Exception e) {
                    System.err.print(e.getMessage());
                }               
                
            }
        }
        );

    }
}
