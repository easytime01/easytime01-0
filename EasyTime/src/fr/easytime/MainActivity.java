/******************************************************************************/
/* 
 * Package fr.easytime                                                  
 * Gestion de l'application partie activité
*/ 
/******************************************************************************/
/* 
 * Création : 20 mai 2015                  
 *  Auteur   : Peter HOWSE                  
 *  But      :  Gestion de l'activité de l'activité principale de l'application.
 *  Classe   : MainActivity        
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
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
public class MainActivity extends Activity {

	/***************************************************************************/
	/* 
	 * Methode : onCreate                          
	 * Objet : Initialisation de l'activité (écran) gérant la partie principale 
	 *         de l'application   
	 * Par : Peter HOWSE                                  
	 * In  : Bundle
	 * Out : Ras                                                            
	 */ 
	/***************************************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final Button loginButton = (Button) findViewById(R.id.button1);
        loginButton.setOnClickListener(new OnClickListener() {

        	// Function : onClick - événement                          
        	// Objet : Initialisation de l'activité (écran) gérant la création 
        	// Par : Peter HOWSE                                  
        	// In  : view
        	// Out : Ras  

        	@Override
        	public void onClick(View v) {
        		Intent intent = new Intent(MainActivity.this, ConnectActivity.class);
        		startActivity(intent);
        	}//onClick
        });//OnClickListener
    } //onCreate
}//MainActivity
