package Services;

import Entities.Client;
import Entities.MusicShow;
import Entities.TheaterShow;

import java.io.*;
import java.util.ArrayList;



public class StorageService {
    final String Directory = System.getProperty("user.dir")+"\\records\\";


    public ArrayList<Client> getClients(){

        String FullFilename = Directory + "Clients.txt";
        ArrayList<Client> allClients = new ArrayList<Client>();
        String Line = null;
        String[] detailsArray;
        String ID;
        String firstName;
        String lastName;
        String email;
        String phone;
        Client newClient;
        System.out.println();

        try (BufferedReader Br = new BufferedReader (new InputStreamReader(new FileInputStream(FullFilename))))
        {
            while ((Line = Br.readLine ()) != null)
            {
                detailsArray = Line.split (";");
                ID = detailsArray[0];
                firstName = detailsArray[1];
                lastName = detailsArray[2];
                email = detailsArray[3];
                phone = detailsArray[4];
                newClient = new Client (ID, firstName, lastName, email, phone);
                allClients.add (newClient);
            }

            return allClients;
        }
        catch (FileNotFoundException ex)
        {
            System.out.println ("Cannot Open File...");
            return new ArrayList<Client>();
        }
        catch (IOException ex)
        {
            System.out.println ("Severe IO Error...");
            return new ArrayList<Client>();
        }
        catch (NumberFormatException ex)
        {
            System.out.println ("Data Error...: " + Line);
            return new ArrayList<Client>();
        }
    }

    public void saveClients(ArrayList<Client> clients){
        String FullFilename = Directory + "Clients.txt";
        try (PrintWriter Printwriter = new PrintWriter(FullFilename))
        {
            for (Client tmp: clients)
            {
                Printwriter.println (tmp.AsCsvLine ());
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println ("Cannot open output file");
            return;
        }

        System.out.println("Saved clients successfully");
    }

    public ArrayList<MusicShow> getMusicShows(){
        String FullFilename1 = Directory + "Musicshows.txt";
        ArrayList<MusicShow> musicShows = new ArrayList<MusicShow>();
        String Line = null;
        String[] detailsArray1;
        String ID;
        String title;
        String venue;
        String date;
        String singer;
        MusicShow newMshow;
        System.out.println();

        try (BufferedReader Br1 = new BufferedReader (new InputStreamReader(new FileInputStream(FullFilename1))))
        {
            while ((Line = Br1.readLine ()) != null)
            {
                detailsArray1 = Line.split (";");
                ID = detailsArray1[0];
                title = detailsArray1[1];
                venue = detailsArray1[2];
                date = detailsArray1[3];
                singer = detailsArray1[4];
                newMshow = new MusicShow (ID, title, venue, date, singer);
                musicShows.add (newMshow);
            }
            return musicShows;
        }
        catch (FileNotFoundException ex)
        {
            System.out.println ("Cannot Open File...");
            return new ArrayList<MusicShow>();
        }
        catch (IOException ex)
        {
            System.out.println ("Severe IO Error...");
            return new ArrayList<MusicShow>();
        }
        catch (NumberFormatException ex)
        {
            System.out.println ("Data Error...: " + Line);
            return new ArrayList<MusicShow>();
        }

    }


    public void saveMusicShows(ArrayList<MusicShow> musicShows){
        String FullFilename1 = Directory + "Musicshows.txt";
        try (PrintWriter Printwriter = new PrintWriter(FullFilename1))
        {
            for (MusicShow tmp: musicShows)
            {
                Printwriter.println (tmp.AsCsvLine ());
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println ("Cannot open output file");
            return;
        }

        System.out.println("Saved Music Shows successfully");
        System.out.println(musicShows);
    }

    public ArrayList<TheaterShow> getTheaterShows(){
        String FullFilename2 = Directory + "Theatershows.txt";
        ArrayList<TheaterShow> theaterShows = new ArrayList<TheaterShow>();
        String Line = null;
        String[] detailsArray2;
        String ID1;
        String title1;
        String venue1;
        String date1;
        String actor;
        TheaterShow newTshow;
        System.out.println();

        try (BufferedReader Br2 = new BufferedReader (new InputStreamReader(new FileInputStream(FullFilename2))))
        {
            while ((Line = Br2.readLine ()) != null)
            {
                detailsArray2 = Line.split (";");
                ID1 = detailsArray2[0];
                title1 = detailsArray2[1];
                venue1 = detailsArray2[2];
                date1 = detailsArray2[3];
                actor = detailsArray2[4];
                newTshow = new TheaterShow (ID1, title1, venue1, date1, actor);
                theaterShows.add (newTshow);
            }
            return theaterShows;
        }
        catch (FileNotFoundException ex)
        {
            System.out.println ("Cannot Open File...");
            return new ArrayList<TheaterShow>();
        }
        catch (IOException ex)
        {
            System.out.println ("Severe IO Error...");
            return new ArrayList<TheaterShow>();
        }
        catch (NumberFormatException ex)
        {
            System.out.println ("Data Error...: " + Line);
            return new ArrayList<TheaterShow>();
        }

    }

    public void saveTheaterShows(ArrayList<TheaterShow> theaterShows){
        String FullFilename2 = Directory + "Theatershows.txt";
        try (PrintWriter Printwriter = new PrintWriter(FullFilename2))
        {
            for (TheaterShow tmp: theaterShows)
            {
                Printwriter.println (tmp.AsCsvLine ());
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println ("Cannot open output file");
            return;
        }

        System.out.println("Saved Theater Shows successfully");
        System.out.println(theaterShows);
    }


}
