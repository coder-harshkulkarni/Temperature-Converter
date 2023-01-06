import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame implements ActionListener {

    JPanel topPanel = new JPanel(new BorderLayout());
    JLabel topPanelLabel = new JLabel("Temperature Convertor");
    JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 50));
    JLabel inputLabel = new JLabel("Enter Temperature :");
    JTextField inputTextField = new JTextField();
    JLabel selectTemp = new JLabel(" To ");
    String[] degree = {"Celsius", "Fahrenheit"};
    JComboBox comboBox1 = new JComboBox(degree);
    JComboBox comboBox2 = new JComboBox(degree);
    JTextField outputTextField = new JTextField();

    Frame() {
        // top panel start
        topPanel.setPreferredSize(new Dimension(100, 100));
        topPanel.setBackground(Color.DARK_GRAY);
        // top panel end

        // top panel label start
        topPanelLabel.setFont(new Font("Comic sans Ms", Font.PLAIN, 50));
        topPanelLabel.setForeground(Color.WHITE);
        topPanelLabel.setBorder(BorderFactory.createBevelBorder(1));
        topPanelLabel.setVerticalAlignment(SwingConstants.CENTER);
        topPanelLabel.setHorizontalAlignment(SwingConstants.CENTER);
        // top panel label end

        // adding components inside top panel start
        topPanel.add(topPanelLabel);
        // adding components inside top panel end

        // main panel start
        mainPanel.setBackground(Color.GRAY);
        // main panel end

        // input label start
        inputLabel.setFont(new Font("Comic sans Ms", Font.BOLD, 25));
        // input label end

        // inputTextField start
        inputTextField.setPreferredSize(new Dimension(500, 40));
        inputTextField.setFont(new Font(null, Font.PLAIN, 25));
        inputTextField.setBorder(BorderFactory.createBevelBorder(1));
        inputTextField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    inputTextField.setEditable(true);
                } else if(ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    inputTextField.setEditable(true);
                } else {
                    inputTextField.setEditable(false);
                }
            }
        });
        // inputTextField end

        // selectTemp label start
        selectTemp.setFont(new Font("Comic sans Ms", Font.BOLD, 25));
        // selectTemp label end

        // outputTextField start
        outputTextField.setPreferredSize(new Dimension(500, 40));
        outputTextField.setFont(new Font("Comic sans Ms", Font.PLAIN, 25));
        outputTextField.setBorder(BorderFactory.createBevelBorder(1));
        outputTextField.setEditable(false);
        // outputTextField end

        // comboBox1 start
        comboBox1.setSelectedItem(null);
        comboBox1.setFont(new Font("Comic sans Ms", Font.PLAIN, 25));
        comboBox1.setBorder(BorderFactory.createBevelBorder(1));
        comboBox1.addActionListener(this);
        // comboBox1 end

        // comboBox2 start
        comboBox2.setSelectedItem(null);
        comboBox2.setFont(new Font("Comic sans Ms", Font.PLAIN, 25));
        comboBox2.setBorder(BorderFactory.createBevelBorder(1));
        comboBox2.addActionListener(this);
        // comboBox2 end

        // adding components inside main panel start
        mainPanel.add(inputLabel);
        mainPanel.add(inputTextField);
        mainPanel.add(comboBox2);
        mainPanel.add(selectTemp);
        mainPanel.add(comboBox1);
        mainPanel.add(outputTextField);
        // adding components inside main panel end

        // Frame start
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Harsh Temperature Convertor");
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        // Frame end

        // add components inside Frame start
        this.add(topPanel, BorderLayout.NORTH);
        this.add(mainPanel);
        // add components inside Frame end
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (comboBox1.getSelectedIndex() == 1 && comboBox2.getSelectedIndex() == 0) {
            double getTemp = Double.parseDouble(inputTextField.getText());
            double outTemp = (getTemp * 9 / 5) + 32;
            outputTextField.setText(outTemp + " °F");
        } else if (comboBox1.getSelectedIndex() == 0 && comboBox2.getSelectedIndex() == 1) {
            double getTemp = Double.parseDouble(inputTextField.getText());
            double outTemp = (getTemp - 32) * 5 / 9;
            outputTextField.setText(outTemp + " °C");
        } else if (comboBox1.getSelectedIndex() == 0 && comboBox2.getSelectedIndex() == 0) {
            outputTextField.setText(inputTextField.getText()+ " °C");
        } else if (comboBox1.getSelectedIndex() == 1 && comboBox2.getSelectedIndex() == 1) {
            outputTextField.setText(inputTextField.getText() + " °F");
        }
    }
}
