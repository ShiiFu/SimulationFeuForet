package foret;

import java.util.ArrayList;
import java.util.Random;

public class Arbre
{
    private ArrayList <Arbre> voisins;
    private Position position;
    private Etat etat;
    private Random random;
    private int updated;

    public Arbre(Position position)
    {
        this.position = position;
        this.etat = new Normal(this);
        voisins = new ArrayList <Arbre> ();
        random = new Random();
        this.updated = -1;
    }

    public void ajouterArbre(Arbre arbre)
    {
        if (!voisins.contains(arbre))
        {
            voisins.add(arbre);
            arbre.ajouterArbre(this);
        }
    }

    public boolean appliqueEffet(int tour)
    {
        if (this.updated != tour)
            return etat.appliqueEffet(tour);
        return true;
    }

    public void mettreFeu(int tour)
    {
        etat = new EnFeu(this);
        this.updated=tour;
    }

    public void essaieFeu(int tour)
    {
        if (this.etat.getClass().equals(Normal.class))
            if (random.nextInt(100)+1 < Foret.probabilite)
                this.mettreFeu(tour);
    }

    public void mettreEnCendre()
    {
        etat = new EnCendre(this);
    }

    public ArrayList <Arbre> getVoisins()
    {
        return voisins;
    }

    public Etat getEtat()
    {
        return this.etat;
    }

    public int getUpdated()
    {
        return this.updated;
    }

    public void incrementeUpdated()
    {
        this.updated++;
    }
}
