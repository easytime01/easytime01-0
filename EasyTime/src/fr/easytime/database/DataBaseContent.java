/******************************************************************************/
/* 
 * Package fr.easytime.database                                                  
 * Gestion de la base de données.
*/ 
/******************************************************************************/
/* 
 * Création : 20 mai 2015                  
 *  Auteur   : Peter HOWSE                  
 *  But      : Gestion du contenu (données - insert, select, update) de la
 *             base de données.                           
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
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import java.util.Arrays;
import java.util.HashSet;
import android.text.TextUtils;

import android.net.Uri;

import fr.easytime.tools.Chiffrement;

public class DataBaseContent extends ContentProvider {
	
	private static final int TASK = 10; //
	private static final int TASK_ID = 20; //
	
	private Context EasyTimeDBContext;  // Context de l'appelant
	private SQLiteDatabase EasyTimeDB; // Base de données de l'application
	private DatabaseHelper EasyTimeDBHelper; // Objet gestion de la base
	
	private static final String AUTHORITY = "fr.EasyTime.database"; // URI d'interrogation de l'application
	private static final String BASE_PATH = "easytime"; 
	public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY
	      + "/" + BASE_PATH); //  URI d'interrogation de l'application

	public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE
	      + "/easytime";
	public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE
	      + "/easytime";

	  private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	  static {
	    sURIMatcher.addURI(AUTHORITY, BASE_PATH, TASK);
	    sURIMatcher.addURI(AUTHORITY, BASE_PATH + "/#", TASK_ID);
	  }
	 
	
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
	 * Objet : Initialisation de la base à l'aide du gestionnaire de base.
	 * Par : Peter HOWSE                                  
	 * In  : Ras
	 * Out : Objet gestion des données de la base.                                                          
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
	 * Objet : Fermeture de la base de données.
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
	 * Objet : Création d'un nouveau user. Alimentation de la table USER.
	 * Par : Peter HOWSE                                  
	 * In  : Ras
	 * Out : Ras                                                          
	 */ 
	/***************************************************************************/
	
	public void insertUser(String mail, String mdp) {
		Chiffrement Md5 = new Chiffrement() ;
 		ContentValues contentValue = new ContentValues();
		contentValue.put(TableUser.COLUMN_USER_MAIL, mail);
		contentValue.put(TableUser.COLUMN_USER_MDP, Md5.encodeMd5(mdp));
		EasyTimeDB.insert(TableUser.TABLE_USER, null, contentValue);
	} //insertUser
	/***************************************************************************/
	/* 
	 * Methode : findUserEasyTime                       
	 * Objet : Recherche les utilisateurs
	 * Par : Peter HOWSE                                  
	 * In  : Cuseur (tableau de données)
	 * Out : Ras                                                          
	 */ 
	/***************************************************************************/	
	public Cursor findUser() {
		String[] columns = new String[] { TableUser.COLUMN_USER_ID,TableUser.COLUMN_USER_MAIL, TableUser.COLUMN_USER_MDP};
		Cursor cursor = EasyTimeDB.query(TableUser.TABLE_USER, columns, null,
				null, null, null, null);
		if (cursor != null) {
			cursor.moveToFirst();
		}
		return cursor;
	} //findUser
	
	/***************************************************************************/
	/* 
	 * Methode : deleteUserEasyTime                       
	 * Objet : Suppression d'un USER  à l'aide de la clef unique de la 
	 *         table USER.
	 * Par : Peter HOWSE                                  
	 * In  : RAs 
	 * Out : Ras                                                          
	 */ 
	/***************************************************************************/
	
	public void deleteUser(long _id) {
		EasyTimeDB.delete(TableUser.TABLE_USER, TableUser.COLUMN_USER_ID + "=" + _id, null);
	} //deleteUser

	/***************************************************************************/
	/* 
	 * Methode : onCreate                        
	 * Objet : 
	 * Par : Peter HOWSE                                  
	 * In  : Ras
	 * Out : Context  Environnement de l'appelant.                                                              
	 */ 
	/***************************************************************************/
	
	@Override
	public boolean onCreate() {
		EasyTimeDBHelper = new DatabaseHelper(getContext());
		return false;
	}// onCreate
	
	/***************************************************************************/
	/* 
	 * Methode : query                        
	 * Objet : 
	 * Par : Peter HOWSE                                  
	 * In  : Ras
	 * Out : cureur contenant les données                                                             
	 */ 
	/***************************************************************************/
	
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
			
		 // Utiliser SQLiteQueryBuilder à la place de la méthode query()
	    SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();

	    // vérifier si l'appelant a demandé une colonne qui n'existe pas
	    checkColumns(projection);

	    // Préciser la table
	    queryBuilder.setTables(TableTask.TABLE_TASK);

	    int uriType = sURIMatcher.match(uri);
	    switch (uriType) {
	    case TASK:
	      break;
	    case TASK_ID:
	      // ajouter l'ID à la requête d'origine
	      queryBuilder.appendWhere(TableTask.COLUMN_TASK_ID + "="
	          + uri.getLastPathSegment());
	      break;
	    default:
	      throw new IllegalArgumentException("Unknown URI: " + uri);
	    }

	    SQLiteDatabase db = EasyTimeDBHelper.getWritableDatabase();
	    Cursor cursor = queryBuilder.query(db, projection, selection,
	        selectionArgs, null, null, sortOrder);
	    // assurez-vous que les écouteurs potentiels seront notifiés
	    cursor.setNotificationUri(getContext().getContentResolver(), uri);

	    return cursor;
	}

	/***************************************************************************/
	/* 
	 * Methode : getType                        
	 * Objet : inutile mais oblicatoire pour l'héritage
	 * Par : Peter HOWSE                                  
	 * In  : Uri
	 * Out : RAS                                                             
	 */ 
	/***************************************************************************/
	
	@Override
	public String getType(Uri uri) {
		return null;
	}

	/***************************************************************************/
	/* 
	 * Methode : insert                        
	 * Objet : insertion d'une tache
	 * Par : Peter HOWSE                                  
	 * In  : Ras
	 * Out : Context  Environnement de l'appelant.                                                              
	 */ 
	/***************************************************************************/
		
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		    int uriType = sURIMatcher.match(uri);
		    SQLiteDatabase sqlDB = EasyTimeDBHelper.getWritableDatabase();
		    long id = 0;
		    switch (uriType) {
		    case TASK:
		      id = sqlDB.insert(TableTask.TABLE_TASK, null, values);
		      break;
		    default:
		      throw new IllegalArgumentException("Unknown URI: " + uri);
		    }
		    getContext().getContentResolver().notifyChange(uri, null);
		    return Uri.parse(BASE_PATH + "/" + id);
	}

	/***************************************************************************/
	/* 
	 * Methode : delete                        
	 * Objet : 
	 * Par : Peter HOWSE                                  
	 * In  : Ras
	 * Out : Context  Environnement de l'appelant.                                                              
	 */ 
	/***************************************************************************/
	
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		  int uriType = sURIMatcher.match(uri);
		    SQLiteDatabase sqlDB = EasyTimeDBHelper.getWritableDatabase();
		    int rowsDeleted = 0;
		    switch (uriType) {
		    case TASK:
		      rowsDeleted = sqlDB.delete(TableTask.TABLE_TASK, selection,
		          selectionArgs);
		      break;
		    case TASK_ID:
		      String id = uri.getLastPathSegment();
		      if (TextUtils.isEmpty(selection)) {
		        rowsDeleted = sqlDB.delete(TableTask.TABLE_TASK,
		            TableTask.COLUMN_TASK_ID + "=" + id, 
		            null);
		      } else {
		        rowsDeleted = sqlDB.delete(TableTask.TABLE_TASK,
		            TableTask.COLUMN_TASK_ID + "=" + id 
		            + " and " + selection,
		            selectionArgs);
		      }
		      break;
		    default:
		      throw new IllegalArgumentException("Unknown URI: " + uri);
		    }
		    getContext().getContentResolver().notifyChange(uri, null);
		    return rowsDeleted;
	}

	/***************************************************************************/
	/* 
	 * Methode : update                        
	 * Objet : 
	 * Par : Peter HOWSE                                  
	 * In  : Ras
	 * Out : Context  Environnement de l'appelant.                                                              
	 */ 
	/***************************************************************************/
	
	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
	    int uriType = sURIMatcher.match(uri);
	    SQLiteDatabase sqlDB = EasyTimeDBHelper.getWritableDatabase();
	    int rowsUpdated = 0;
	    switch (uriType) {
	    case TASK:
	      rowsUpdated = sqlDB.update(TableTask.TABLE_TASK, 
	          values, 
	          selection,
	          selectionArgs);
	      break;
	    case TASK_ID:
	      String id = uri.getLastPathSegment();
	      if (TextUtils.isEmpty(selection)) {
	        rowsUpdated = sqlDB.update(TableTask.TABLE_TASK, 
	            values,
	            TableTask.COLUMN_TASK_ID + "=" + id, 
	            null);
	      } else {
	        rowsUpdated = sqlDB.update(TableTask.TABLE_TASK, 
	            values,
	            TableTask.COLUMN_TASK_ID + "=" + id 
	            + " and " 
	            + selection,
	            selectionArgs);
	      }
	      break;
	    default:
	      throw new IllegalArgumentException("Unknown URI: " + uri);
	    }
	    getContext().getContentResolver().notifyChange(uri, null);
	    return rowsUpdated;
	}
	
	/***************************************************************************/
	/* 
	 * Methode : DataBaseContent (constructeur)                         
	 * Objet : Constructeur initialisant le context pour la class.
	 * Par : Peter HOWSE                                  
	 * In  : Ras
	 * Out : Context  Environnement de l'appelant.                                                              
	 */ 
	/***************************************************************************/
		
	private void checkColumns(String[] projection) {
	    String[] available = { TableTask.COLUMN_TASK_REF,
	        TableTask.COLUMN_TASK_DES, TableUser.COLUMN_USER_ID};
	    if (projection != null) {
	      HashSet<String> requestedColumns = new HashSet<String>(Arrays.asList(projection));
	      HashSet<String> availableColumns = new HashSet<String>(Arrays.asList(available));
	      // vérifier si toutes les colonnes demandées sont disponibles
	      if (!availableColumns.containsAll(requestedColumns)) {
	        throw new IllegalArgumentException("Unknown columns in projection");
	      }
	    }
	  }
	
	
}//DataBaseContent
