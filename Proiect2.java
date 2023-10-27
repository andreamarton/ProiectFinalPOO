package cabinetVeterinar;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class Proiect2 extends JFrame {
    private JButton ButonAdaugare; ///buton pt adaugarea datelor
    private JPanel MyPanel;
    private JLabel NumeStapan; ///text sa stie utilizatorul ce sa introduca
    private JTextField NumeStapanTF;///din acest textfield se va citi numele stapanului
    private JLabel SpecieAnimal;
    private JTextField SpecieAnimalTF;///din acest textfield se va citi specia animalului
    private JLabel Status;
    private JRadioButton TipConsult;
    private JRadioButton TipInternat;
    private JTextField AfisarePacientiTF;
    private JButton AfisareIntroduceri;
    private JLabel CodCip;
    private JTextField codCipTF;
    public List<CabinetVet> pacient = new ArrayList<>();

    public Proiect2() {
        ButonAdaugare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CabinetVet stapan =new CabinetVet(); ///se creaza obiectul
                try {
                    if (NumeStapanTF.getText().isEmpty())
                        throw new InvalidNameException("INTRODUCETI TOATE DATELE");
                    else {
                        if(!NumeStapanTF.getText().matches("[aA-zZ]+$")) {
                            throw new InvalidNameException("NU INTRODUCETI DECAT LITERE");
                        }
                        else
                            stapan.setName(NumeStapanTF.getText());

                    }
                }catch (InvalidNameException a) {
                    AfisarePacientiTF.setText (a.getMessage());
                }
                try {
                    if (SpecieAnimalTF.getText().isEmpty())
                        throw new InvalidNameException("INTRODUCETI TOATE DATELE");
                    else {
                        stapan.setSpecieAnimal(SpecieAnimalTF.getText());
                    }
                }catch (InvalidNameException a) {
                    AfisarePacientiTF.setText (a.getMessage());
                }
                try {
                    if (codCipTF.getText().isEmpty())
                        throw new InvalidNameException("INTRODUCETI TOATE DATELE"); //in caz ca nu s-a introdus nimic
                    else {
                        stapan.setCodCip(codCipTF.getText());///se face citirea codului
                    }
                }catch (InvalidNameException a) {
                    AfisarePacientiTF.setText (a.getMessage());
                }
                if (TipConsult.isSelected()) {
                    stapan.setStatus(0);
                }
                if(TipInternat.isSelected())
                    stapan.setStatus(1);

                pacient.add(stapan);
                //afisatre fereastra modala
                JOptionPane.showMessageDialog(null,"Adaugare cu succes","FEREASTRA CONFIRMARE",JOptionPane.INFORMATION_MESSAGE);
            }

        });
        AfisareIntroduceri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String listaAf="LISTA DATE INTRODUSE: ";
                StringBuffer sb;
                sb = new StringBuffer();
                for(int i=0;i<pacient.size();i++)
                {
                    sb.append(listaAf);
                    sb.append("Stapan: ");
                    sb.append(pacient.get(i).getName());
                    sb.append(" specie: ");
                    sb.append(pacient.get(i).getSpecieAnimal());
                    sb.append(" status: ");
                    sb.append(pacient.get(i).getStatus());
                    sb.append("numarul cipului: ");
                    sb.append(pacient.get(i).getCodCip());
                    sb.append((System.lineSeparator()));
                }
                AfisarePacientiTF.setText(String.valueOf(sb));
            }
        });
    }
    public static void main(String [] args) {
        Proiect2 frame = new Proiect2();
        frame.setContentPane(frame.MyPanel);
        frame.setTitle("Lista");
        frame.setSize(50000, 50000);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}