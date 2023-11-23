package org.example.view;

import org.example.model.Note;

import java.util.List;

public interface NoteView {
    void displayNotes(List<Note> notes);
    void displayMessage(String message);

}
