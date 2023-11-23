package org.example.view;

import org.example.model.Note;

import java.util.List;

public class NoteViewImpl implements NoteView {
    @Override
    public void displayNotes(List<Note> notes) {
        for (Note note : notes) {
            System.out.println("Topic: " + note.getTopic());
            System.out.println("Content: " + note.getContent());
            System.out.println("Date: " + note.getDate());
            System.out.println("Time: " + note.getTime());
            System.out.println("-----------------------");
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

}
