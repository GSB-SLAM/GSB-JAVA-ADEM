package fr.bonaparte.suividevosfrais.BDD;

import android.database.sqlite.SQLiteDatabase;

/**
 * Classe d'outils. Ouvre et ferme la base de données.
 *
 */
public class OutilsBdd {

    protected SQLiteDatabase bdd;
    protected BddGsbApp bddGsbApp;

    public OutilsBdd() {

    }

    /**
     * Procédure d'ouverture de la base de données
     * en écriture.
     */
    public void ouvre() {
        bdd = bddGsbApp.getWritableDatabase();
    }

    public void ouvreLecture(){
        bdd = bddGsbApp.getReadableDatabase();
    }

    /**
     * Procédure de fermeture de la base de données.
     */
    public void ferme() {
        bdd.close();
    }

    /**
     * Fonction qui retourne la base de données.
     * @return bdd
     */
    public SQLiteDatabase getBdd() {
        return bdd;
    }
}
