package org.example;


import java.io.IOException;
import java.util.Scanner;
import org.example.model.NoteModel;
import org.example.model.NoteModelImpl;
import org.example.presenter.NotePresenter;
import org.example.presenter.NotePresenterImpl;
import org.example.view.NoteView;
import org.example.view.NoteViewImpl;
import java.io.IOException;
import java.util.Scanner;
public class App
{


    public class Main {
        public static void main(String[] args) {
            NoteModel model = new NoteModelImpl();
            NoteView view = new NoteViewImpl();
            NotePresenter presenter = new NotePresenterImpl(model, view);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("1. Create Note");
                System.out.println("2. Get All Notes");
                System.out.println("3. Get Notes By Date");
                System.out.println("4. Sort Notes By Date");
                System.out.println("5. Search Notes By Keyword");
                System.out.println("6. Save Notes To File");
                System.out.println("7. Load Notes From File");
                System.out.println("8. Exit");

                System.out.print("Choose option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // consume the newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter topic: ");
                        String topic = scanner.nextLine();
                        System.out.print("Enter content: ");
                        String content = scanner.nextLine();
                        System.out.print("Enter date: ");
                        String date = scanner.nextLine();
                        System.out.print("Enter time: ");
                        String time = scanner.nextLine();
                        presenter.createNote(topic, content, date, time);
                        break;
                    case 2:
                        presenter.getAllNotes();
                        break;
                    case 3:
                        System.out.print("Enter date: ");
                        String searchDate = scanner.nextLine();
                        presenter.getNotesByDate(searchDate);
                        break;
                    case 4:
                        presenter.sortNotesByDate();
                        break;
                    case 5:
                        System.out.print("Enter keyword: ");
                        String keyword = scanner.nextLine();
                        presenter.searchNotesByKeyword(keyword);
                        break;
                    case 6:
                        try {
                            System.out.print("Enter file path to save: ");
                            String saveFilePath = scanner.nextLine();
                            model.saveNotesToFile(saveFilePath);
                            System.out.println("Notes saved to file successfully.");
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.out.println("Error saving notes to file.");
                        }
                        break;
                    case 7:
                        try {
                            System.out.print("Enter file path to load: ");
                            String loadFilePath = scanner.nextLine();
                            model.loadNotesFromFile(loadFilePath);
                            System.out.println("Notes loaded from file successfully.");
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.out.println("Error loading notes from file.");
                        }
                        break;
                    case 8:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }

}
