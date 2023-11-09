package image;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

public class ImageToBytesExample extends JFrame {
    private JLabel label = new JLabel();

    public ImageToBytesExample() {
        setTitle("Image to Bytes Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        JButton button = new JButton("Import Image");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(ImageToBytesExample.this);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        // Load the selected image
                        BufferedImage image = ImageIO.read(selectedFile);
                        label.setIcon(new ImageIcon(image)); // Hiển thị ảnh trong JLabel

                        // Convert the loaded image to bytes
                        byte[] imageData = imageToBytes(image);
                        // Do something with the imageData byte array
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        setLayout(new BorderLayout());
        add(button, BorderLayout.NORTH);
        add(label, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ImageToBytesExample example = new ImageToBytesExample();
                example.setVisible(true);
            }
        });
    }

    public byte[] imageToBytes(BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos);
        return baos.toByteArray();
    }
}




