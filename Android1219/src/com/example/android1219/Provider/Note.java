package com.example.android1219.provider;

import android.net.Uri;

public class Note {

	public static final String table_name = "note";
	public static final String NOTE_ID = "_id";
	public static final String TITLE = "title";
	public static final String TEXT = "text";

	public static final Uri CONTENT_URI = Uri.parse("content://"
			+ NotesContentProvider.AUTHORITY + "/"+table_name);
	public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.jwei512.notes";
}