import java.awt.*;
import java.awt.event.*;

public class GuiEventHandling {
    public static void main(String[] args) {
        // Create a frame
        Frame frame = new Frame("AWT Frame Example");
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(2,1));

        // Create a text field
        TextField textField = new TextField(20);
        frame.add(textField);

        // Create a button
        Button button = new Button("Click Me");
        frame.add(button);

        // Add action listener to the button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("Asalamualikum");
            }
        });

        // Add window listener to close the window
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}