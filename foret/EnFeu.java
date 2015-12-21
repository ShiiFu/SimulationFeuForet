package foret;

import java.util.ArrayList;
import java.util.Iterator;

public class EnFeu implements Etat
{
    private Arbre arbre;

    public EnFeu(Arbre arbre)
    {
        this.arbre = arbre;
    }

    public boolean appliqueEffet(int tour)
    {
        Iterator iterateur = arbre.getVoisins().iterator();
        while (iterateur.hasNext())
            ((Arbre)iterateur.next()).essaieFeu(tour);
        this.arbre.mettreEnCendre();
        return true;
    }
}
