package com.example.android1219.provider;

import java.util.HashMap;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;
 
public class NotesContentProvider extends ContentProvider {
 
    public static final String AUTHORITY = "com.myprovider";
    private static final UriMatcher sUriMatcher;
    private static final int NOTES = 1;
    private static final int NOTES_ID = 2;
    private static HashMap<String, String> notesProjectionMap;

    private DatabaseHelper dbHelper;
 
    @Override
    public int delete(Uri uri, String where, String[] whereArgs) {
       
        switch (sUriMatcher.match(uri)) {
            case NOTES:
                break;
            case NOTES_ID:
                where = where + "_id = " + uri.getLastPathSegment();
                Log.e("test",where);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
 
        int count = this.dbHelper.delete(where, whereArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
 
    @Override
    public String getType(Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case NOTES:
                return Note.CONTENT_TYPE;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }
 
    @Override
    public Uri insert(Uri uri, ContentValues initialValues) {
        if (sUriMatcher.match(uri) != NOTES) {
            throw new IllegalArgumentException("Unknown URI " + uri);
        }
 
        ContentValues values;
        if (initialValues != null) {
            values = new ContentValues(initialValues);
        } else {
            values = new ContentValues();
        }
        long rowId = this.dbHelper.insert(values);
        
        if (rowId > 0) {
            Uri noteUri = ContentUris.withAppendedId(Note.CONTENT_URI, rowId);
            getContext().getContentResolver().notifyChange(noteUri, null);
            return noteUri;
        }
 
        throw new SQLException("Failed to insert row into " + uri);
    }
 
    @Override
    public boolean onCreate() {
        dbHelper = new DatabaseHelper(getContext());
        return true;
    }
 
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        //SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        //qb.setTables(Note.table_name);
        //qb.setProjectionMap(notesProjectionMap);
 
        switch (sUriMatcher.match(uri)) {   
            case NOTES:
                break;
            case NOTES_ID:
                selection = selection + "_id = "+ uri.getLastPathSegment();
                
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
 
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.query(Note.table_name, projection, selection, selectionArgs, null, null, sortOrder);
 
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }
 
    @Override
    public int update(Uri uri, ContentValues values, String where, String[] whereArgs) {
        int count;
        switch (sUriMatcher.match(uri)) {
            case NOTES:
                count = this.dbHelper.update(values, where, whereArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
 
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
 
    static {
        sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        sUriMatcher.addURI(AUTHORITY, Note.table_name, NOTES);
        sUriMatcher.addURI(AUTHORITY, Note.table_name + "/#", NOTES_ID);
 
        notesProjectionMap = new HashMap<String, String>();
        notesProjectionMap.put(Note.NOTE_ID, Note.NOTE_ID);
        notesProjectionMap.put(Note.TITLE, Note.TITLE);
        notesProjectionMap.put(Note.TEXT, Note.TEXT);
    }
}