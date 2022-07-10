package Services;

import Entities.Client;
import Entities.MusicShow;
import Entities.TheaterShow;

import java.util.ArrayList;

public class StorageService {

    public ArrayList<Client> getClients(){
        return new ArrayList<Client>();
    }

    public void saveClients(ArrayList<Client> clients){
        System.out.println(clients);
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
