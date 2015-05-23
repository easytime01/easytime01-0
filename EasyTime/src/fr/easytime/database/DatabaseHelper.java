package fr.easytime.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

  private static final String DATABASE_NAME = "easytimetable.db";
  private static final int DATABASE_VERSION = 1;

   public DatabaseHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  // Méthode appelée pendant la création de la base de données
  @Override
  public void onCreate(SQLiteDatabase database) {
    Table.onCreate(database);
  }

  // Méthode appelée pendant une mise a jour de la base de  
  // données, par exemple vous augmentez sa version 
  @Override
  public void onUpgrade(SQLiteDatabase database, int oldVersion,
      int newVersion) {
    Table.onUpgrade(database, oldVersion, newVersion);
  }
}