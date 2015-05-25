
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
import android.widget.TextView;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.database.Cursor;

//import du projet
import fr.easytime.database.DataBaseContent;
import fr.easytime.tools.Check;
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
                
        final Button loginButton = (Button) findViewById(R.id.acountcreation_createAcount);
        final TextView TextView1 = (TextView) findViewById(R.id.acountcreationemail); 
        final Button ConnexionButton = (Button) findViewById(R.id.acountcreation_connect);
              
        Cursor UserCurseur = null;
        
        DataBaseContent EasytimeDataBaseContent = new DataBaseContent(this.getBaseContext()) ;
        EasytimeDataBaseContent.open();	
        UserCurseur = EasytimeDataBaseContent.findUserEasyTime();
        TextView1.setText(UserCurseur.getString(1), TextView.BufferType.EDITABLE);
                
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
        
        ConnexionButton.setOnClickListener(new OnClickListener() {

        	// Function : onClick - événement                          
        	// Objet : Vérification des éléments saisies
        	// Par : Peter HOWSE                                  
        	// In  : view
        	// Out : Ras  

        	@Override
        	public void onClick(View v) {
        		Intent intent = new Intent(MainActivity.this, ConnectActivity.class);
          		Check EasyTimeCheckMdp ;
        		EasyTimeCheckMdp = new Check();
  
        		if (EasyTimeCheckMdp.CheckMdp("", "") == false) {
                    Toast.makeText(MainActivity.this, "Mot de passe KO !!", Toast.LENGTH_SHORT).show();
                    	
        		};
        		
        		
        		startActivity(intent);
        	}//onClick
        });//OnClickListener
        
        
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
 

    
}//MainActivity
