package cabinetVeterinar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    private boolean ok1 =false;
    private boolean ok2=false;
    private boolean ok3=false;

    public Proiect2(int statusMed) {

        setTitle("CABINET VETERINAR");

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel = new JPanel();
        MyPanel.setBackground(Color.lightGray); //setarea culorii pt cab vet
        MyPanel.setLayout(new GridLayout(7, 2));
        MyPanel.setFont(new Font("Times New Roman", Font.BOLD, 40));
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

        //alegerea culorii pentru casetele constante scrise
        TipConsult.setForeground(Color.blue);
        TipInternat.setForeground(Color.blue);
        ButonAdaugare.setForeground(Color.red);
        NumeStapan.setForeground(Color.black);
        SpecieAnimal.setForeground(Color.black);
        Status.setForeground(Color.black);
        CodCip.setForeground(Color.black);
        AfisareIntroduceri.setForeground(Color.blue);

        NumeStapanTF.setForeground(Color.black);
        SpecieAnimalTF.setForeground(Color.white);
        Status.setForeground(Color.black);
        codCipTF.setForeground(Color.GRAY);
        AfisarePacientiTF.setForeground(Color.white);

        //setarea culorii fundalului pentru casetele de completare
        codCipTF.setBackground(Color.BLACK);
        AfisarePacientiTF.setBackground(Color.black);
        ButonAdaugare.setBackground(Color.white);
        NumeStapanTF.setBackground(Color.LIGHT_GRAY);
        SpecieAnimalTF.setBackground(Color.black);

        //modificarea fontului scrisului static
        NumeStapan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        SpecieAnimal.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        CodCip.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        Status.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        AfisareIntroduceri.setFont(new Font("Arial", Font.BOLD, 15));
        ButonAdaugare.setFont(new Font("Arial", Font.BOLD, 15));
        //modif scrisului pe care il vom adauga noi
        codCipTF.setFont(new Font("Arial", Font.BOLD, 18));
        NumeStapanTF.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 18));
        SpecieAnimalTF.setFont(new Font("Monaco", Font.ITALIC, 18));
        AfisarePacientiTF.setFont(new Font("Times New Roman", Font.PLAIN, 18));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel = new JPanel();
        MyPanel.setBackground(Color.LIGHT_GRAY); //setarea culorii pt cab vet
        MyPanel.setLayout(new GridLayout(10, 2));
        MyPanel.setBounds(100, 100, 75, 25);

        MyPanel.add(NumeStapan);
        MyPanel.add(NumeStapanTF);
        MyPanel.add(SpecieAnimal);
        MyPanel.add(SpecieAnimalTF);
        MyPanel.add(Status);
        MyPanel.add(TipConsult);
        MyPanel.add(new JLabel()); //empty label for spacing
        MyPanel.add(TipInternat);
        MyPanel.add(CodCip);
        MyPanel.add(codCipTF);
        MyPanel.add(new JLabel()); //empty label for spacing
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
                        else {
                            ok1=true;
                            stapan.setName(NumeStapanTF.getText());
                        }
                    }
                }catch (InvalidNameException a) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                                JOptionPane.showMessageDialog(null,a.getMessage(),"EROARE",JOptionPane.ERROR_MESSAGE);
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
                        else {
                            ok2=true;
                            stapan.setSpecieAnimal(SpecieAnimalTF.getText());
                        }
                    }
                }catch (InvalidNameException a) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            JOptionPane.showMessageDialog(null,a.getMessage(),"EROARE",JOptionPane.ERROR_MESSAGE);
                        }
                    });
                }
                try {
                    if (codCipTF.getText().isEmpty())
                        throw new InvalidNameException("INTRODUCETI TOATE DATELE"); //in caz ca nu s-a introdus nimic
                    else {
                        //validare date
                        if(!codCipTF.getText().matches("[0-9]+$")) {
                            throw new InvalidNameException("NU INTRODUCETI DECAT CIFRE LA CIP");
                        }
                        else {
                            ok3=true;
                            stapan.setCodCip(codCipTF.getText());///se face citirea codului
                        }
                    }
                }catch (InvalidNameException a) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            JOptionPane.showMessageDialog(null,a.getMessage(),"EROARE",JOptionPane.ERROR_MESSAGE);

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
                if(ok1 & ok2 & ok3)
                    JOptionPane.showMessageDialog(null,"Adaugare cu succes","FEREASTRA CONFIRMARE",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        AfisareIntroduceri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> listaPacienti = new ArrayList<>();
                MediciCabVet m1=new MediciCabVet();
                //afisarea listei cu toti pacientii
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
                    sb.append(m1);
                }
                AfisarePacientiTF.setListData(listaPacienti.toArray());
                ///scrierea datelor intr-un fisier text
                try {
                    FileWriter fileWriter = new FileWriter("pacienti.txt");
                    PrintWriter printWriter = new PrintWriter(fileWriter);
                    for (String patientInfo : listaPacienti) {
                        printWriter.println(patientInfo);
                    }
                    printWriter.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,"Eroare de salvare a  datelor in fisier","EROARE",JOptionPane.ERROR_MESSAGE);
                    //mesaj eroare
                }
                    ///scrierea datelor intr-un fisier text
                    try {
                        FileWriter fileWriter = new FileWriter("pacienti.txt");
                        PrintWriter printWriter = new PrintWriter(fileWriter);
                        for (String patientInfo : listaPacienti) {
                            printWriter.println(patientInfo);
                        }
                        printWriter.close();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null,"Eroare de salvare a  datelor in fisier","EROARE",JOptionPane.ERROR_MESSAGE);
                        //mesaj eroare
                    }
            }

        });
        add(MyPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(false);
    }
}
