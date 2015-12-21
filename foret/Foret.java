package foret;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import gui.MyFrame;

public class Foret
{
    public final static int hauteur = 50;
    public final static int largeur = 250;
    public final static int probabilite = 50;
    private Arbre[][] arbres;
    private MyFrame myFrame;

    public Foret()
    {
        arbres = new Arbre[hauteur][largeur];
        for (int i=0; i<hauteur ; i++)
        {
            for (int j=0; j<largeur ; j++)
            {
                arbres[i][j] = new Arbre(new Position(i, j));
                if (i>0)
                    arbres[i][j].ajouterArbre(arbres[i-1][j]);
                if (j>0)
                    arbres[i][j].ajouterArbre(arbres[i][j-1]);
            }
        }
        myFrame = new MyFrame();
    }

    public boolean update(int tour)
    {
        //tour++;
        boolean fini = true;
        for (int i=0; i<hauteur ; i++)
        {
            for (int j=0; j<largeur ; j++)
            {
                //if (arbres[i][j].getUpdated() != tour)
                {
                    if (arbres[i][j].appliqueEffet(tour))
                        fini = false;
                }
            }
        }
        return fini;
    }

    public Arbre[][] getArbres()
    {
        return arbres;
    }

    public BufferedImage toImage()
    {
        BufferedImage img = new BufferedImage(largeur*4, hauteur*4, BufferedImage.TYPE_INT_RGB);
        for (int i=0; i<hauteur ; i++)
        {
            for (int j=0; j<largeur ; j++)
            {
                for(int k=0 ; k<4 ; k++)
                    for(int l=0 ; l<4 ; l++)
                    {
                        if (arbres[i][j].getEtat().getClass().equals(EnFeu.class))
                            img.setRGB(j*4+l, i*4+k, Color.red.getRGB());
                        else if (arbres[i][j].getEtat().getClass().equals(EnCendre.class))
                            img.setRGB(j*4+l, i*4+k, Color.gray.getRGB());
                        else
                            img.setRGB(j*4+l, i*4+k, Color.green.getRGB());
                    }
            }
        }
        return img;
    }

    public void sauvegarderImage(BufferedImage img)
    {
        File f = new File("resultat.png");
        try
        {
            ImageIO.write(img, "PNG", f);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void updateGui(BufferedImage img)
    {
        myFrame.setImage(img);
    }

    public static void main(String[] args)
    {
        Foret f = new Foret();
        Position position = Position.random();
        f.getArbres()[position.getX()][position.getY()].mettreFeu(-1);
        //f.getArbres()[125][125].mettreFeu(0);
        boolean continuer = true;
        BufferedImage img = null;
        int i=0;
        while (continuer)
        {
            if (f.update(i))
                continuer = false;
            i++;
            img = f.toImage();
            f.updateGui(img);
        }
        f.sauvegarderImage(img);
        System.out.println("Simulation terminée.");
    }
}
