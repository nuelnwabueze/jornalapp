package com.example.android.jornalapp.model;

/**
 * Created by USER on 6/29/2018.
 */

public class Note {

    private String noteTitle;
    private String noteContent;
    private String date;

    public Note(String noteTitle, String noteContent, String date) {
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
        this.date = date;
    }

    public Note() {
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}