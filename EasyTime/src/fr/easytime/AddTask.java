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
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;

// import du projet
import fr.easytime.database.DataBaseContent;
import fr.easytime.database.TableTask;
//import fr.easytime.tools.Check;

public class AddTask extends Activity {

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
	  Uri todoUri = Uri.parse(DataBaseContent.CONTENT_URI + "/" + 10);
	  
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtask);
         // Associer les éléments de la page à des objets 
        final Button buttonAjouter = (Button) findViewById(R.id.buttonAjouter);
        final EditText editTextReference = (EditText) findViewById(R.id.editTextMessage);          
        final EditText editTextDescription = (EditText) findViewById(R.id.editTextDescription);   
        final EditText editTextDureeMini = (EditText) findViewById(R.id.editTextDureeMini); 
   
	   
        // Associer un événement à un bouton 
        buttonAjouter.setOnClickListener(new OnClickListener() {
       	 
        	// Function : onClick - événement                          
        	// Objet : Initialisation de l'activité (écran) gérant la création 
        	// Par : Peter HOWSE                                  
        	// In  : view
        	// Out : Ras  
        	
        	@Override
        	public void onClick(View v) {   
        	//	Check EasyTimeCheckMail ;
        	//EasyTimeCheckMail = new Check();
        		String reference = editTextReference.getText().toString();
        		String description = editTextDescription.getText().toString() ;
        		String dureemini = editTextDureeMini.getText().toString();
         		
      		    ContentValues values = new ContentValues();
        		values.put(TableTask.COLUMN_TASK_REF, reference);
        		values.put(TableTask.COLUMN_TASK_DES, description);
        		values.put(TableTask.COLUMN_TASK_MIN, dureemini);	
        		values.put(TableTask.COLUMN_TASK_ETAT, "");
        		DataBaseContent EasytimeDataBaseContent = new DataBaseContent() ;
        		
        		todoUri = getContentResolver().insert(EasytimeDataBaseContent.CONTENT_URI, values);
        		    

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
            case R.id.add:
        	    Intent intent = new Intent(AddTask.this, AddTask.class);
                startActivity(intent);         	
               return true;
         case R.id.quitter:
               //Pour fermer l'application il suffit de faire finish()
               finish();
               return true;
         }
         return false;
         }//
 
} //ConnectActivity
