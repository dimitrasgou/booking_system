package Services;


import Entities.Client;
import Entities.MusicShow;
import Entities.TheaterShow;

import java.util.Scanner;
import java.util.regex.Pattern;

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
        System.out.println("View the list of Theater Shows  .............................................4");
        System.out.println("Back to Main Menu............................................................5");
        System.out.println("\n\nEnter your choice:");

        String choice = getNextLine();

        switch (choice) {
            case "1":
                String ThID = CheckCode(getUserInput("Enter theater show id:"));
                String ThTitle = getUserInput("Enter the title:");
                String ThVenue = getUserInput("Enter the venue:");
                String ThDate = getUserInput("Enter the date:");
                String actor = getUserInput("Enter the actor:");
                theaterShowService.insert(ThID, ThTitle, ThVenue, ThDate, actor);

                subMenuClients();
                break;
            case "2":
                String Code = CheckCode(getUserInput("Enter client id:"));
                TheaterShow TShow = theaterShowService.SearchTheaterShow(Code);
                String NewId = CheckCode(getUserInput("Enter new  id:"));
                String NewTitle = getUserInput("Enter new title:");
                String NewVenue = getUserInput("Enter new venue:");
                String NewDate = getUserInput("Enter new date:");
                String NewName = CheckPhone(getUserInput("Enter new name for the actor:"));

                theaterShowService.update(TShow, NewId, NewTitle, NewVenue, NewDate, NewName);
                subMenuClients();
                break;
            case "3":
                String Id = getUserInput("Enter theater show code:");
                theaterShowService.remove(theaterShowService.SearchTheaterShow(Id));
                subMenuClients();
                break;
            case "4":
                theaterShowService.AllTheaterShows();
                subMenuClients();
            case "5":
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
        System.out.println("View the list of Music Shows  .............................................4");
        System.out.println("Back to Main Menu..........................................................5");
        System.out.println("\n\nEnter your choice:");

        String choice = getNextLine();

        switch (choice) {
            case "1":
                String MID = CheckCode(getUserInput("Enter music show id:"));
                String MTitle = getUserInput("Enter the title:");
                String MVenue = getUserInput("Enter the venue:");
                String MDate = getUserInput("Enter the date:");
                String singer = getUserInput("Enter the singer:");
                musicShowService.insert(MID, MTitle, MVenue, MDate, singer);

                subMenuClients();
                break;
            case "2":
                String Code = CheckCode(getUserInput("Enter Music Show id:"));
                MusicShow MShow = musicShowService.SearchMusicShow(Code);
                String NewMId = CheckCode(getUserInput("Enter new  id:"));
                String NewMTitle = getUserInput("Enter new title:");
                String NewMVenue = getUserInput("Enter new venue:");
                String NewMDate = getUserInput("Enter new date:");
                String NewMName = CheckPhone(getUserInput("Enter new name for the singer:"));

                musicShowService.update(MShow, NewMId, NewMTitle, NewMVenue, NewMDate, NewMName);
                subMenuClients();
                break;
            case "3":
                String Id = getUserInput("Enter Music Show id:");
                musicShowService.remove(musicShowService.SearchMusicShow(Id));
                break;

            case "4":
                musicShowService.AllMusicShows();
                break;
            case "5":
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
        System.out.println("View the list of Clients  .............................................4");
        System.out.println("Back to Main Menu......................................................5");
        System.out.println("\n\nEnter your choice:");

        String choice = getNextLine();
        Client client;

        switch (choice) {
            case "1":
                String id = CheckCode(getUserInput("Enter client id:"));
                client = clientService.GetClientByCode(id);
                if(client != null){
                    System.out.println("This client already exists.");
                    subMenuClients();
                }

                String firstName = getUserInput("Enter client firstname:");
                String surName = getUserInput("Enter client surName:");
                String email = EmailValidation(getUserInput("Enter client email:"));
                String phone = CheckPhone(getUserInput("Enter client phone:"));
                clientService.insert(id, firstName, surName, email, phone);
                subMenuClients();
                break;
            case "2":
                String Code = CheckCode(getUserInput("Enter client id:"));
                client = clientService.GetClientByCode(Code);
                if(client == null){
                    System.out.println("This client does not exist.");
                    subMenuClients();
                }

                String NewFirstName = getUserInput("Enter new client firstname:");
                String NewSurName = getUserInput("Enter new client surName:");
                String NewEmail = getUserInput("Enter new client email:");
                String NewPhone = CheckPhone(getUserInput("Enter new client phone:"));

                clientService.update(client, NewFirstName, NewSurName, NewEmail, NewPhone);
                subMenuClients();
                break;
            case "3":
                String Id = getUserInput("Enter client id:");
                client = clientService.GetClientByCode(Id);
                if(client != null) clientService.remove(client);
                subMenuClients();
                break;
            case "4":
                clientService.showAllClients();
            case "5":
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

    private static String CheckPhone(String phone) {

        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        while (phone.length() != 10 || ! pattern.matcher(phone).matches()) {
            System.out.println(phone + " is not a valid phone. You must provide a number with ten digits");
            phone = scanner.nextLine();
        }

        return phone;
    }

    private static String CheckCode(String code) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        while (code.length() != 5 || ! pattern.matcher(code).matches()) {
            System.out.println(code + " is not a valid code. You must provide a number with five digits");
            code = scanner.nextLine();
        }

        return code;
    }


    private static String EmailValidation(String email) {
        Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$");

        while (! pattern.matcher(email).matches()) {
            System.out.println(email + " is not a valid email. Please provide a valid mail");
            email = scanner.nextLine();
        }

        return email;
    }
}






