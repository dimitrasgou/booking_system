package Services;

import java.util.Scanner;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);
    private static ClientService clientService = new ClientService();
    private static MusicShowService musicShowService = new MusicShowService();
    private static TheaterShowService theaterShowService = new TheaterShowService();

    public static void initBaseMenu() {
        System.out.println("__________*** M E N U ***___________");
        System.out.println("====================================");
        System.out.println("      What would you like to do?\n");
        System.out.println("Insert-Edit-Delete Information of Theater Entities Show..................1");
        System.out.println("Insert-Edit-Delete Information of Music Entities Show....................2");
        System.out.println("Insert-Edit-Delete Information of Entities Client........................3");
        System.out.println("Book a ticket for a Theater Entities.Show................................4");
        System.out.println("Book a ticket for a Music.. Entities.Show................................5");
        System.out.println("View Statistics..........................................................6");
        System.out.println("Exit the Menu............................................................7");
        System.out.println("\n\nEnter your choice:");

        String choice = getNextLine();


        switch (choice) {
            case "1":
                subMenuTheater();
                break;
            case "2":
                subMenuMusic();
                break;
            case "3":
                subMenuClients();
                break;
            case "4":
                System.out.println("Booking Theater");
                break;
            case "5":
                System.out.println("Booking Music");
                break;
            case "6":
                System.out.println("View statistics");
                break;
            case "7":
                saveAndExit();
            default:
                System.out.println("Please choose one of the available actions");
                initBaseMenu();
        }

    }

    private static void saveAndExit() {
        System.out.println("Save and Exiting...");
        clientService.save();
        musicShowService.save();
        clientService.save();
        System.exit(0);
    }

    private static void subMenuTheater() {
        System.out.println("__________*** T H E A T E R S ***___________");
        System.out.println("============================================");
        System.out.println("         What would you like to do?\n");
        System.out.println("Insert a new Theater Show....................................................1");
        System.out.println("Edit an existing Theater Show................................................2");
        System.out.println("Delete an existing Theater Show .............................................3");
        System.out.println("Back to Main Menu............................................................4");
        System.out.println("\n\nEnter your choice:");

        String choice = getNextLine();

        switch (choice) {
            case "1":
                //
                break;
            case "2":
                //
                break;
            case "3":
                //
                break;
            case "4":
                initBaseMenu();
            default:
                System.out.println("Please choose one of the available actions");
                subMenuTheater();
        }

    }

    private static void subMenuMusic() {
        System.out.println("__________*** M U S I C ***___________");
        System.out.println("======================================");
        System.out.println("     What would you like to do?\n");
        System.out.println("Insert a new Music Show....................................................1");
        System.out.println("Edit an existing Music Show................................................2");
        System.out.println("Delete an existing Music Show .............................................3");
        System.out.println("Back to Main Menu............................................................4");
        System.out.println("\n\nEnter your choice:");

        String choice = getNextLine();

        switch (choice) {
            case "1":
                //
                break;
            case "2":
                //
                break;
            case "3":
                //
                break;
            case "4":
                initBaseMenu();
            default:
                System.out.println("Please choose one of the available actions");
                subMenuMusic();
        }
    }

    private static void subMenuClients() {
        System.out.println("__________*** C L I E N T S ***___________");
        System.out.println("==========================================");
        System.out.println("       What would you like to do?\n");
        System.out.println("Insert a new Client....................................................1");
        System.out.println("Edit an existing Client................................................2");
        System.out.println("Delete an existing Client .............................................3");
        System.out.println("Back to Main Menu............................................................4");
        System.out.println("\n\nEnter your choice:");

        String choice = getNextLine();

        switch (choice) {
            case "1":
                String id = getUserInput("Enter client id:");
                String firstName = getUserInput("Enter client firstname:");
                String surName = getUserInput("Enter client surName:");
                String email = getUserInput("Enter client email:");
                String phone = getUserInput("Enter client phone:");
                try{
                    clientService.insert(id, firstName, surName, email, phone);
                }catch (Exception exception){
                    System.out.println(exception.getMessage());
                }
                subMenuClients();
                break;
            case "2":
                //
                break;
            case "3":
                //
                break;
            case "4":
                initBaseMenu();
            default:
                System.out.println("Please choose one of the available actions");
                subMenuClients();
        }
    }

    private static String getUserInput(String message) {
        System.out.println(message);
        return getNextLine();
    }

    private static String getNextLine() {
        return scanner.nextLine();
    }
}
