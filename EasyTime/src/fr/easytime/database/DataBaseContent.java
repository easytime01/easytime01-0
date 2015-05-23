package fr.easytime.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseContent {
	private Context EasyTimeDBContext;
	private SQLiteDatabase EasyTimeDB;
	private DatabaseHelper EasyTimeDBHelper;
	
	public DataBaseContent(Context c) {
		EasyTimeDBContext = c;
	}
	
	public DataBaseContent open() throws SQLException {
		EasyTimeDBHelper = new DatabaseHelper(EasyTimeDBContext);
		EasyTimeDB = EasyTimeDBHelper.getWritableDatabase();
		return this;

	}
	
	public void close() {
		EasyTimeDBHelper.close();
	}
	
	public void insertUserEasyTime(String mail, String mdp) {
		ContentValues contentValue = new ContentValues();
		contentValue.put(Table.COLUMN_MAIL, mail);
		contentValue.put(Table.COLUMN_MDP, mdp);
		EasyTimeDB.insert(Table.TABLE_USER, null, contentValue);
	}
	
	public Cursor findUserEasyTime() {
		String[] columns = new String[] { Table.COLUMN_ID,Table.COLUMN_MAIL, Table.COLUMN_MDP};
		Cursor cursor = EasyTimeDB.query(Table.TABLE_USER, columns, null,
				null, null, null, null);
		if (cursor != null) {
			cursor.moveToFirst();
		}
		return cursor;
		
	
	}
	
	public void delete(long _id) {
		EasyTimeDB.delete(Table.TABLE_USER, Table.COLUMN_ID + "=" + _id, null);
	}
}
