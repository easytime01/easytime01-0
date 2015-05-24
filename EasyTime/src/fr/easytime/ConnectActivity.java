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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// import du projet
import fr.easytime.database.DataBaseContent;
import fr.easytime.tools.Check;

public class ConnectActivity extends Activity {

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
        setContentView(R.layout.activity_connect);
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
        			EasytimeDataBaseContent.insertUserEasyTime("Peter", "Howse");
        		}
        		else {
        			Toast.makeText(null, "Merci de saisir un mail !!", Toast.LENGTH_LONG).show();
        		}
        	} //onClick
		}); //OnClickListener
    } //onCreate
} //ConnectActivity
