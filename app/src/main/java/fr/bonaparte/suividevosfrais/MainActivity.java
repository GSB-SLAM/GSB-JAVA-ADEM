package fr.bonaparte.suividevosfrais;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import fr.bonaparte.suividevosfrais.BDD.FraisFBDD;
import fr.bonaparte.suividevosfrais.BDD.FraisHFBDD;
import fr.bonaparte.suividevosfrais.BDD.IdBDD;

/**
 * MainActivity.java
 * 
 * Classe MainActivity qui hérite de la classe Activity.
 * Elle est associée au layout activity_main.xml.
 * Permet d'afficher le menu principal de l'application
 *
 */
public class MainActivity extends Activity {

    static Activity thisActivity = null;
    private IdBDD idBdd;
    private FraisFBDD fraisFBdd;
    private FraisHFBDD fraisHBdd;
	
	/**
	 * Création de l'interface Menu Principal.
	 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idBdd = new IdBDD(this);
        fraisFBdd = new FraisFBDD(this);
        fraisHBdd = new FraisHFBDD(this);
        thisActivity = this;


        // chargement des méthodes événementielles
        cmdMenu_clic(((ImageButton) findViewById(R.id.cmdKm)), KmActivity.class);
        cmdMenu_clic(((ImageButton) findViewById(R.id.cmdHf)), HfActivity.class);
        cmdMenu_clic(((ImageButton) findViewById(R.id.cmdHfRecap)), HfRecapActivity.class);
        cmdMenu_clic(((ImageButton) findViewById(R.id.cmdNuitee)), NuitActivity.class);
        cmdMenu_clic(((ImageButton) findViewById(R.id.cmdEtape)), EtapeActivity.class);
        cmdMenu_clic(((ImageButton) findViewById(R.id.cmdRepas)), RepasActivity.class);
        cmdMenu_clic(((ImageButton) findViewById(R.id.cmdReport)), ReportActivity.class);
        cmdTransfert_clic();
    }

    /**
     * Création du Setting Menu.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    /**
     * Evennement sur le clic du bouton Paramètres identifiant
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    	
        case R.id.action_settings:

        	// ouvre l'activité
			Intent intent = new Intent(MainActivity.this, LoginActivity.class) ;
			startActivity(intent);
			finish();
            return true;
            
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    

    /**
     * Sur la sélection d'un bouton dans l'activité principale ouverture de l'activité correspondante.
     */
    private void cmdMenu_clic(ImageButton button, final Class classe) {
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                // ouvre l'activité
                Intent intent = new Intent(MainActivity.this, classe);
                startActivity(intent);
            }
        });
    }

    /**
     * Procédure qui permet d'afficher un message qui vient d'un autre thread.
     *
     * @param message : est le message à afficher.
     */
    public static void receptMessage(String message) {
        Toast.makeText(thisActivity, message, Toast.LENGTH_LONG).show();
    }

    /**
     * Cas particulier du bouton pour le transfert d'informations vers le serveur
     */
    private void cmdTransfert_clic() {
        findViewById(R.id.cmdReport).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                // envoi les informations sérialisées vers le serveur
                // en construction
            }
        });
    }


}
