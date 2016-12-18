import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.BorderFactory;

public class BtnsModificarEmigrar extends javax.swing.JPanel {

    public JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;

    public BtnsModificarEmigrar() {
        initComponents();
    }

    private void initComponents() {

        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();

        jButton1.setText("Modificar");

        jButton2.setText("Emigrar/Registrar");

        jButton3.setText("Limpiar");

        this.setLayout(new FlowLayout());
        this.add(jButton1);
        this.add(jButton2);
        this.add(jButton3);

        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
    }

                           
}
