/******************************************************************************/
/* 
 * Package fr.easytime                                                  
 * Gestion de l'application partie activit�
*/ 
/******************************************************************************/
/* 
 * Cr�ation : 20 mai 2015                  
 *  Auteur   : Peter HOWSE                  
 *  But      :  Gestion de l'activit� de connexion.
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
import android.content.Intent;
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
	 * Objet : Initialisation de l'activit� (�cran) g�rant la cr�ation 
	 *         du compte
	 * Par : Peter HOWSE                                  
	 * In  : Bundle
	 * Out : Ras                                                            
	 */ 
	/***************************************************************************/
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creationcompte);
         // Associer les �l�ments de la page � des objets 
        final Button loginButton = (Button) findViewById(R.id.buttonAjouter);
        final EditText editText1 = (EditText) findViewById(R.id.editText1);          
        final EditText editText2 = (EditText) findViewById(R.id.editText2);   
        final EditText editText4 = (EditText) findViewById(R.id.editText4); 
        // Associer un �v�nement � un bouton 
        loginButton.setOnClickListener(new OnClickListener() {
       	 
        	// Function : onClick - �v�nement                          
        	// Objet : Initialisation de l'activit� (�cran) g�rant la cr�ation 
        	// Par : Peter HOWSE                                  
        	// In  : view
        	// Out : Ras  
        	
        	@Override
        	public void onClick(View v) {   
        		Check EasyTimeCheckMail ;
        		EasyTimeCheckMail = new Check();
        		
        		if (EasyTimeCheckMail.CheckMail(editText1.getText().toString())
        			&& EasyTimeCheckMail.CheckMdp(editText2.getText().toString(),editText4.getText().toString())) {
            			DataBaseContent EasytimeDataBaseContent = new DataBaseContent() ;
        	    		EasytimeDataBaseContent.open(v.getContext());	
        	    		EasytimeDataBaseContent.insertUser(editText1.getText().toString(), editText2.getText().toString());   			
        		}
        		else {
        			Toast.makeText(v.getContext(),    EasyTimeCheckMail.getErreur() , Toast.LENGTH_SHORT).show();
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
 
        //Cr�ation d'un MenuInflater qui va permettre d'instancier un Menu XML en un objet Menu
        MenuInflater inflater = getMenuInflater();
        //Instanciation du menu XML sp�cifier en un objet Menu
        inflater.inflate(R.menu.mainmenu, menu);
 
        //Il n'est pas possible de modifier l'ic�ne d'en-t�te du sous menu via le fichier XML on le fait donc en JAVA
    	//menu.getItem(0).getSubMenu().setHeaderIcon(R.drawable.option_white);
 
        return true;
     }

    /***************************************************************************/
	/* 
	 * Methode : onOptionsItemSelected                          
	 * Objet : S�lection d'un choix dans le menu
	 *         de l'application   
	 * Par : Peter HOWSE                                  
	 * In  : menu
	 * Out : Ras                                                            
	 */ 
	/***************************************************************************/

    public boolean onOptionsItemSelected(MenuItem item) {
         //On regarde quel item a �t� cliqu� gr�ce � son id et on d�clenche une action
         switch (item.getItemId()) {
            case R.id.add:
          	    Intent intent = new Intent(CreationCompte.this, AddTask.class);
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
