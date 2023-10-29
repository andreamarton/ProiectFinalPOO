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
    private JList AfisarePacientiTF;
    private JButton AfisareIntroduceri;
    private JLabel CodCip;
    private JTextField codCipTF;
    public List<CabinetVet> pacient = new ArrayList<>();///lista pacientilor

    public Proiect2(int statusMed) {

        setTitle("CABINET VETERINAR");

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel = new JPanel();
        MyPanel.setBackground(Color.LIGHT_GRAY); //setarea culorii pt cab vet
        MyPanel.setLayout(new GridLayout(10, 2));
        MyPanel.setBounds(100, 100, 75, 25);

        ButonAdaugare = new JButton("Adauga Pacient");
        NumeStapan = new JLabel("Nume Stapan:");
        NumeStapanTF = new JTextField();
        SpecieAnimal = new JLabel("Specie Animal:");
        SpecieAnimalTF = new JTextField();
        Status = new JLabel("Status:");
        TipConsult = new JRadioButton("Consult");
        TipInternat = new JRadioButton("Internat");
        CodCip = new JLabel("Cod Cip:");
        codCipTF = new JTextField();
        AfisarePacientiTF = new JList();


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

        ButonAdaugare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CabinetVet stapan =new CabinetVet(); ///se creaza obiectul
                try {
                    if (NumeStapanTF.getText().isEmpty())
                        throw new InvalidNameException("INTRODUCETI TOATE DATELE");
                    else {
                        //exceptie de a nu adauga cifre in campul "nume"
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
                          //AfisarePacientiTF.setText(String.valueOf(a.getMessage()));
                        }
                    });
                }
                try {
                    if (SpecieAnimalTF.getText().isEmpty())
                        throw new InvalidNameException("INTRODUCETI TOATE DATELE");
                    else {
                        //exceptie in cazul in care care introducemm cifre in acest camp
                        if(!SpecieAnimalTF.getText().matches("[aA-zZ]+$")) {
                            throw new InvalidNameException("NU INTRODUCETI DECAT LITERE LA SPECIE");
                        }
                        stapan.setSpecieAnimal(SpecieAnimalTF.getText());
                    }
                }catch (InvalidNameException a) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                           // AfisarePacientiTF.setText(String.valueOf(a.getMessage()));
                        }
                    });
                }
                try {
                    if (codCipTF.getText().isEmpty())
                        throw new InvalidNameException("INTRODUCETI TOATE DATELE"); //in caz ca nu s-a introdus nimic
                    else {
                        //exceptia in care adaugam litere in loc de cifre
                        if(!codCipTF.getText().matches("[0-9]+$")) {
                            throw new InvalidNameException("NU INTRODUCETI DECAT CIFRE LA CIP");
                        }
                        stapan.setCodCip(codCipTF.getText());///se face citirea codului
                    }
                }catch (InvalidNameException a) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                           // AfisarePacientiTF.setText(String.valueOf(a.getMessage()));

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
                ArrayList<String> listaPacienti = new ArrayList<>();
                //crearea unei liste cu toti pacientii
                for (CabinetVet cab : pacient){
                    StringBuffer sb = new StringBuffer();
                    sb.append("Stapan: ");
                    sb.append(cab.getName());
                    sb.append(" specie: ");
                    sb.append(cab.getSpecieAnimal());
                    sb.append("  status: ");
                    sb.append(cab.getStatus());
                    sb.append("  numarul cipului: ");
                    sb.append(cab.getCodCip());
                    listaPacienti.add(sb.toString());
                }
                AfisarePacientiTF.setListData(listaPacienti.toArray());
            }
        });
        add(MyPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(false);
    }
}