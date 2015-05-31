
/******************************************************************************/
/* 
 * Package fr.easytime.database                                                  
 * Gestion de la base de données.
*/ 
/******************************************************************************/
/* 
 * Création : 20 mai 2015                  
 *  Auteur   : Peter HOWSE                  
 *  But      : Gestion de la base (Création mise à jour 
 *  Classe   : DataBaseContent        
 */	
/******************************************************************************/
/* 
 * Modifier le :                             
 * Par :                                   
 * classe :                                                                   
 * Objet : 
*/ 
/******************************************************************************/

package fr.easytime.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "easytimetable.db";
	private static final int DATABASE_VERSION = 1;

	/***************************************************************************/
	/* 
	 * Methode : DataBaseContent (constructeur)                         
	 * Objet : Constructeur initialisant le context pour la class.
	 * Par : Peter HOWSE                                  
	 * In  : Context  Environnement de l'appelant.
	 * Out : Ras                                                               
	 */ 
	/***************************************************************************/
  
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	} //DatabaseHelper
   
	/***************************************************************************/
	/* 
	 * Methode : onCreate (constructeur)                         
	 * Objet : Méthode appelée pendant la création de la base de données
	 * Par : Peter HOWSE                                  
	 * In  : Base
	 * Out : Ras                                                            
	 */ 
	/***************************************************************************/

	@Override
	public void onCreate(SQLiteDatabase database) {
		TableUser.onCreate(database);
	}

	/***************************************************************************/
	/* 
	 * Methode : onUpgrade (constructeur)                         
	 * Objet :  Méthode appelée pendant une mise a jour de la base de  
	 *          données, par exemple vous augmentez sa version 
	 * Par : Peter HOWSE                                  
	 * In  : Base, versionprécédent, version nouvelle
	 * Out : RAS                                                             
	 */ 
	/***************************************************************************/
 
	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion,
			int newVersion) {
		TableUser.onUpgrade(database, oldVersion, newVersion);
	}
}//DatabaseHelper
