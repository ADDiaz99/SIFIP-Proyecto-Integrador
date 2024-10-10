package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

public class VentanaConLinks extends JFrame {
    public VentanaConLinks() {
        
        setTitle("Ventana con Links");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
       
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBackground(new Color(245, 245, 245)); 
        panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));

        
        JLabel titulo = new JLabel("Biblioteca", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(new Color(0, 102, 204)); 
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(titulo);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20))); 
        
        
        panelPrincipal.add(crearPanelConLink("Padre Rico, Padre Pobre", "https://www.jugandoainvertir.com.ar/descargas/Padre-Rico-Padre-Pobre.pdf"));
        panelPrincipal.add(crearPanelConLink("Los secretos de la mente millonaria", "https://www.aesculapseguridaddelpaciente.org.mx/alianzapsqx/docs/quedate/libros/Los%20secretos%20de%20la%20mente%20millonaria.pdf"));
        panelPrincipal.add(crearPanelConLink("¿Cómo organizo mis finanzas personales?", "https://www.youtube.com/watch?v=r3UWLnQjcBE"));
        panelPrincipal.add(crearPanelConLink("Finanzas para la transformación Social", "https://www.youtube.com/watch?v=SSRZl8VGoB8"));
        panelPrincipal.add(crearPanelConLink("El inversor inteligente", "https://irp-cdn.multiscreensite.com/c7d8ea89/files/uploaded/El%20inversor%20inteligente%20-%20Benjamin%20Graham.pdf"));
        panelPrincipal.add(crearPanelConLink("La psicología del dinero", "https://criptoinforme.com/wp-content/uploads/2023/12/la-psicologia-del-dinero-morgan-housel.pdf"));
        panelPrincipal.add(crearPanelConLink("Piense y hágase rico", "https://www.economicas.unsa.edu.ar/afinan/informacion_general/book/piense_y_hagase_rico.pdf"));
        panelPrincipal.add(crearPanelConLink("Audiolibro: Padre rico Padre pobre", "https://www.youtube.com/watch?v=m3nikYHo6yg"));
        panelPrincipal.add(crearPanelConLink("Audiolibro: El Inversor Inteligente", "https://www.youtube.com/watch?v=ApoxJvTadk0"));
        panelPrincipal.add(crearPanelConLink("Plataformas de Trading Fiables", "https://mex-online.com/es/lp-go/usps?SFID=&utm_source=google&utm_medium=cpc&utm_campaign=Latam_ES_Google_Prospecting_Search_USPs_2024&campaignid=21632913582&adgroupid=168179483964&feeditemid=&targetid=kwd-805238644744&loc_interest_ms=9221065&loc_physical_ms=1029301&matchtype=b&network=g&device=c&devicemodel=&gclid=Cj0KCQjwjY64BhCaARIsAIfc7Ybpe9I13Vl0cJMzhyD8q2td-T3DcJWpmkg3Yz9hlm9JCLlBKXXoSNgaAhryEALw_wcB&wbraid=Cj8KCQjwjY64BhDzARIuALMjXNQBFvoBtXOuxsX_LMKWXAVSpJB3VX59KMXFRAZF9xmy4omqRCdbVeDECxoCPP0&gbraid=0AAAAADRhwb6Ob8gn9YmuXlseQmknbniW9&utm_content=text_usps_es&utm_content=&utm_term=plataformas%20de%20trading%20fiables&placement=&target=&random=7996756665868366384&adposition=&adgroup_name=Generic_ES&gad_source=1"));
        panelPrincipal.add(crearPanelConLink("Audiolibro: Piense y Hágase Rico", "https://www.youtube.com/watch?v=G5qaD-gAHI0"));

       
        add(new JScrollPane(panelPrincipal));
    }

    
    private JPanel crearPanelConLink(String texto, String url) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(Color.WHITE); 
        LineBorder defaultBorder = new LineBorder(new Color(0, 102, 204), 2, true); 
        LineBorder hoverBorder = new LineBorder(new Color(255, 153, 51), 2, true); 
        panel.setBorder(defaultBorder);

        JLabel linkLabel = new JLabel("<html><a href=''>" + texto + "</a></html>");
        linkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        linkLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        linkLabel.setForeground(new Color(0, 51, 153)); 
        linkLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(url));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "No se pudo abrir el enlace: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });

        
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBorder(hoverBorder);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBorder(defaultBorder);
            }
        });

        panel.add(linkLabel);
        return panel;
    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            VentanaConLinks ventana = new VentanaConLinks();
            ventana.setVisible(true);
        });
    }
}
