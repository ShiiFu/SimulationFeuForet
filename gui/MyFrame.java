package gui;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import foret.Foret;

public class MyFrame extends JFrame
{
    public MyFrame (BufferedImage image)
    {
        Image contentPane = new Image(image);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(contentPane);
        this.setSize(4*Foret.hauteur+500, 4*Foret.largeur+200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public MyFrame ()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(4*Foret.largeur+50, 4*Foret.hauteur+50);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void setImage(BufferedImage image)
    {
        Image contentPane = new Image(image);
        this.setContentPane(contentPane);
        this.revalidate();
        this.repaint();
    }
}
