/******************************************************************************/
/* 
 * Package fr.easytime                                                  
 * Gestion de l'application partie activité
*/ 
/******************************************************************************/
/* 
 * Création : 20 mai 2015                  
 *  Auteur   : Peter HOWSE                  
 *  But      :  Gestion de l'activité de connexion.
 *  Classe   : ConnectActivity        
 */	
/******************************************************************************/
/* 
 * Modifier le :                             
 * Par :                                   
 * classe :                                                                   
 * Objet : 
*/ 
/******************************************************************************/

package fr.easytime;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// import du projet
import fr.easytime.database.DataBaseContent;
import fr.easytime.tools.Check;

public class CreationCompte extends Activity {

	/***************************************************************************/
	/* 
	 * Methode : onCreate                          
	 * Objet : Initialisation de l'activité (écran) gérant la création 
	 *         du compte
	 * Par : Peter HOWSE                                  
	 * In  : Bundle
	 * Out : Ras                                                            
	 */ 
	/***************************************************************************/
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creationcompte);
         // Associer les éléments de la page à des objets 
        final Button loginButton = (Button) findViewById(R.id.button1);
        final EditText editText1 = (EditText) findViewById(R.id.editText1);          
        
        // Associer un événement à un bouton 
        loginButton.setOnClickListener(new OnClickListener() {
       	 
        	// Function : onClick - événement                          
        	// Objet : Initialisation de l'activité (écran) gérant la création 
        	// Par : Peter HOWSE                                  
        	// In  : view
        	// Out : Ras  
        	
        	@Override
        	public void onClick(View v) {   
        		Check EasyTimeCheckMail ;
        		EasyTimeCheckMail = new Check();
        		DataBaseContent EasytimeDataBaseContent = new DataBaseContent(v.getContext()) ;
        		if (EasyTimeCheckMail.CheckMail(editText1.getText().toString()) == true) {
        			EasytimeDataBaseContent.open();	
        			EasytimeDataBaseContent.insertUser("Peter", "Howse");
        		}
        		else {
        			Toast.makeText(null, "Merci de saisir un mail !!", Toast.LENGTH_LONG).show();
        		}
        	} //onClick
		}); //OnClickListener
    } //onCreate
	/***************************************************************************/
	/* 
	 * Methode : onCreateOptionsMenu                          
	 * Objet : Initialisation des menus (clic sur 3 points ou bouton menu).
	 *         de l'application   
	 * Par : Peter HOWSE                                  
	 * In  : Menu
	 * Out : Ras                                                            
	 */ 
	/***************************************************************************/
  
    public boolean onCreateOptionsMenu(Menu menu) {
 
        //Création d'un MenuInflater qui va permettre d'instancier un Menu XML en un objet Menu
        MenuInflater inflater = getMenuInflater();
        //Instanciation du menu XML spécifier en un objet Menu
        inflater.inflate(R.menu.mainmenu, menu);
 
        //Il n'est pas possible de modifier l'icône d'en-tête du sous menu via le fichier XML on le fait donc en JAVA
    	//menu.getItem(0).getSubMenu().setHeaderIcon(R.drawable.option_white);
 
        return true;
     }

    /***************************************************************************/
	/* 
	 * Methode : onOptionsItemSelected                          
	 * Objet : Sélection d'un choix dans le menu
	 *         de l'application   
	 * Par : Peter HOWSE                                  
	 * In  : menu
	 * Out : Ras                                                            
	 */ 
	/***************************************************************************/

    public boolean onOptionsItemSelected(MenuItem item) {
         //On regarde quel item a été cliqué grâce à son id et on déclenche une action
         switch (item.getItemId()) {
            case R.id.option:
               Toast.makeText(this, "Option", Toast.LENGTH_SHORT).show();
               return true;
            case R.id.favoris:
                Toast.makeText(this, "Favoris", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.stats:
                Toast.makeText(this, "Stats", Toast.LENGTH_SHORT).show();
                return true;
           case R.id.quitter:
               //Pour fermer l'application il suffit de faire finish()
               finish();
               return true;
         }
         return false;
         }//
 
} //ConnectActivity
