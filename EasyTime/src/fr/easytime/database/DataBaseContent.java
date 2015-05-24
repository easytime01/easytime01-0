/******************************************************************************/
/* 
 * Package fr.easytime.database                                                  
 * Gestion de la base de donn�es.
*/ 
/******************************************************************************/
/* 
 * Cr�ation : 20 mai 2015                  
 *  Auteur   : Peter HOWSE                  
 *  But      : Gestion du contenu (donn�es - insert, select, update) de la
 *             base de donn�es.                           
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

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseContent {
	
	private Context EasyTimeDBContext;  // Context de l'appelant
	private SQLiteDatabase EasyTimeDB; // Base de donn�es de l'application
	private DatabaseHelper EasyTimeDBHelper; // Objet gestion de la base
	
	/***************************************************************************/
	/* 
	 * Methode : DataBaseContent (constructeur)                         
	 * Objet : Constructeur initialisant le context pour la class.
	 * Par : Peter HOWSE                                  
	 * In  : Ras
	 * Out : Context  Environnement de l'appelant.                                                              
	 */ 
	/***************************************************************************/

	public DataBaseContent(Context c) {
		EasyTimeDBContext = c;
	}//DataBaseContent
	
	/***************************************************************************/
	/* 
	 * Methode : open                        
	 * Objet : Initialisation de la base � l'aide du gestionnaire de base.
	 * Par : Peter HOWSE                                  
	 * In  : Ras
	 * Out : Objet gestion des donn�es de la base.                                                          
	 */ 
	/***************************************************************************/

	public DataBaseContent open() throws SQLException {
		EasyTimeDBHelper = new DatabaseHelper(EasyTimeDBContext);
		EasyTimeDB = EasyTimeDBHelper.getWritableDatabase();
		return this;
	}//open
	
	/***************************************************************************/
	/* 
	 * Methode : close                       
	 * Objet : Fermeture de la base de donn�es.
	 * Par : Peter HOWSE                                  
	 * In  : Ras
	 * Out : Ras                                                          
	 */ 
	/***************************************************************************/
		
	public void close() {
		EasyTimeDBHelper.close();
	} //close
	
	/***************************************************************************/
	/* 
	 * Methode : insertUserEasyTime                       
	 * Objet : Cr�ation d'un nouveau user. Alimentation de la table USER.
	 * Par : Peter HOWSE                                  
	 * In  : Ras
	 * Out : Ras                                                          
	 */ 
	/***************************************************************************/
	
	public void insertUserEasyTime(String mail, String mdp) {
		ContentValues contentValue = new ContentValues();
		contentValue.put(Table.COLUMN_MAIL, mail);
		contentValue.put(Table.COLUMN_MDP, mdp);
		EasyTimeDB.insert(Table.TABLE_USER, null, contentValue);
	} //insertUserEasyTime
	/***************************************************************************/
	/* 
	 * Methode : findUserEasyTime                       
	 * Objet : Recherche les utilisateurs
	 * Par : Peter HOWSE                                  
	 * In  : Cuseur (tableau de donn�es)
	 * Out : Ras                                                          
	 */ 
	/***************************************************************************/	
	public Cursor findUserEasyTime() {
		String[] columns = new String[] { Table.COLUMN_ID,Table.COLUMN_MAIL, Table.COLUMN_MDP};
		Cursor cursor = EasyTimeDB.query(Table.TABLE_USER, columns, null,
				null, null, null, null);
		if (cursor != null) {
			cursor.moveToFirst();
		}
		return cursor;
	} //findUserEasyTime
	
	/***************************************************************************/
	/* 
	 * Methode : deleteUserEasyTime                       
	 * Objet : Suppression d'un USER  � l'aide de la clef unique de la 
	 *         table USER.
	 * Par : Peter HOWSE                                  
	 * In  : RAs 
	 * Out : Ras                                                          
	 */ 
	/***************************************************************************/
	
	public void deleteUserEasyTime(long _id) {
		EasyTimeDB.delete(Table.TABLE_USER, Table.COLUMN_ID + "=" + _id, null);
	} //deleteUserEasyTime
}//DataBaseContent
