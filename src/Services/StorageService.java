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
        return new ArrayList<MusicShow>();
    }

    public void saveMusicShows(ArrayList<MusicShow> musicShows){
        System.out.println(musicShows);
    }

    public ArrayList<TheaterShow> getTheaterShows(){
        return new ArrayList<TheaterShow>();
    }

    public void saveTheaterShows(ArrayList<TheaterShow> theaterShows){
        System.out.println(theaterShows);
    }


}
