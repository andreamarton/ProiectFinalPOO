package cabinetVeterinar;

import javax.swing.*;
import java.awt.*;
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

    public Proiect2(int statusMed) {

        setTitle("CABINET VETERINAR");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel = new JPanel();
        MyPanel.setLayout(new GridLayout(10, 2));

        NumeStapan = new JLabel("Nume Stapan:");
        NumeStapanTF = new JTextField();
        SpecieAnimal = new JLabel("Specie Animal:");
        SpecieAnimalTF = new JTextField();
        Status = new JLabel("Status:");
        TipConsult = new JRadioButton("Consult");
        TipInternat = new JRadioButton("Internat");
        CodCip = new JLabel("Cod Cip:");
        codCipTF = new JTextField();
        AfisarePacientiTF = new JTextField();
        AfisarePacientiTF.setEditable(false);

        MyPanel.add(NumeStapan);
        MyPanel.add(NumeStapanTF);
        MyPanel.add(SpecieAnimal);
        MyPanel.add(SpecieAnimalTF);
        MyPanel.add(Status);
        MyPanel.add(TipConsult);
        MyPanel.add(new JLabel()); // Add an empty label for spacing
        MyPanel.add(TipInternat);
        MyPanel.add(CodCip);
        MyPanel.add(codCipTF);
        MyPanel.add(new JLabel()); // Add an empty label for spacing
        MyPanel.add(ButonAdaugare);
        MyPanel.add(AfisarePacientiTF);
        MyPanel.add(AfisareIntroduceri);

        ButtonGroup statusGroup = new ButtonGroup();
        statusGroup.add(TipConsult);
        statusGroup.add(TipInternat);

        ButonAdaugare = new JButton("Adauga Pacient");

        ButonAdaugare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CabinetVet stapan =new CabinetVet(); ///se creaza obiectul
                try {
                    if (NumeStapanTF.getText().isEmpty())
                        throw new InvalidNameException("INTRODUCETI TOATE DATELE");
                    else {
                        if(!NumeStapanTF.getText().matches("[aA-zZ]+$")) {
                            throw new InvalidNameException("NU INTRODUCETI DECAT LITERE LA NUME");
                        }
                        else
                            stapan.setName(NumeStapanTF.getText());

                    }
                }catch (InvalidNameException a) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            AfisarePacientiTF.setText(String.valueOf(a.getMessage()));

                        }
                    });
                }
                try {
                    if (SpecieAnimalTF.getText().isEmpty())
                        throw new InvalidNameException("INTRODUCETI TOATE DATELE");
                    else {
                        if(!SpecieAnimalTF.getText().matches("[aA-zZ]+$")) {
                            throw new InvalidNameException("NU INTRODUCETI DECAT LITERE LA SPECIE");
                        }
                        stapan.setSpecieAnimal(SpecieAnimalTF.getText());
                    }
                }catch (InvalidNameException a) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            AfisarePacientiTF.setText(String.valueOf(a.getMessage()));

                        }
                    });
                }
                try {
                    if (codCipTF.getText().isEmpty())
                        throw new InvalidNameException("INTRODUCETI TOATE DATELE"); //in caz ca nu s-a introdus nimic
                    else {
                        if(!codCipTF.getText().matches("[0-9]+$")) {
                            throw new InvalidNameException("NU INTRODUCETI DECAT CIFRE LA CIP");
                        }
                        stapan.setCodCip(codCipTF.getText());///se face citirea codului
                    }
                }catch (InvalidNameException a) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            AfisarePacientiTF.setText(String.valueOf(a.getMessage()));

                        }
                    });
                }
                if (TipConsult.isSelected()) {
                    stapan.setStatus(0);
                }
                if(TipInternat.isSelected())
                    stapan.setStatus(1);

                pacient.add(stapan);
                //Fereastra de mesaj-modala
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
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        AfisarePacientiTF.setText(String.valueOf(sb));

                    }
                });
            }
        });
        add(MyPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String [] args) {
        new MediciCabVet();

        Proiect2 frame = new Proiect2(0);
        frame.setVisible(true);
    }
}