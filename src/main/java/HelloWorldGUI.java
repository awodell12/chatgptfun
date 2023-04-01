import javax.swing.*;

public class HelloWorldGUI extends JFrame {

    public HelloWorldGUI() {
        super("Hello World GUI");
        JLabel label = new JLabel("Hello World");
        label.setHorizontalAlignment(SwingConstants.CENTER); // center the label horizontally
        label.setVerticalAlignment(SwingConstants.CENTER); // center the label vertically
        getContentPane().add(label); // add the label to the content pane
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(300,200);
    }
}
