import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RadioButtonDemo extends JFrame implements ActionListener {
    JRadioButton birdButton, catButton, dogButton, rabbitButton, pigButton;
    JLabel imageLabel;

    RadioButtonDemo() {
        setTitle("RadioButtonDemo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("Pig");

        ButtonGroup group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        imageLabel = new JLabel();
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JRadioButton button = (JRadioButton) e.getSource();
                updateImage(button.getText());
            }
        };

        birdButton.addActionListener(listener);
        catButton.addActionListener(listener);
        dogButton.addActionListener(listener);
        rabbitButton.addActionListener(listener);
        pigButton.addActionListener(listener);

        //aligning the buttons on a single column
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1));
        buttonPanel.add(birdButton);
        buttonPanel.add(catButton);
        buttonPanel.add(dogButton);
        buttonPanel.add(rabbitButton);
        buttonPanel.add(pigButton);

        add(buttonPanel);

        pigButton.setSelected(true);

        pack();
        setVisible(true);
    }

    private void updateImage(String pet) {
        ImageIcon icon = new ImageIcon(pet + ".jpeg");
        //to display the image on a message box
        JOptionPane.showMessageDialog(null, "You selected: " + pet, "Selected", JOptionPane.INFORMATION_MESSAGE, icon);
    }

    public void actionPerformed(ActionEvent e) {
        
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RadioButtonDemo();
            }
        });
    }
}
