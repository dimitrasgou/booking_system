package Services;

import Entities.MusicShow;

import java.util.ArrayList;

public class MusicShowService extends EntityService
{
    private ArrayList<MusicShow> musicShows;

    MusicShowService(){
        loadMusicShows();
    }

    public void loadMusicShows()
    {
        musicShows = storageService.getMusicShows();
    }

    public void save()
    {
        storageService.saveMusicShows(musicShows);
    }

    public void insert(String id, String title, String venue, String date, String singer) {
        //validation


        //if passes
        musicShows.add(new MusicShow(id, title, venue, date, singer));
    }

    public void delete(String code) {
        for (MusicShow show :musicShows) {
            if (show.getCode().equals(code) ) {
                musicShows.remove(show);
            }
            else if (musicShows.isEmpty()
            )System.out.println("Music Show not found");
        }

    }
    public MusicShow SearchMusicShow(String code) {
        for (MusicShow show : musicShows ){
            if (show.getCode().equals(code)){
                System.out.println("Music show found");
                return show;
            }
            else
                System.out.println("Music show not found");
        }
        return null;
    }


    public void update(MusicShow show,String id, String title, String venue, String date, String singer)
    {
        show.setCode(id);
        show.setTitle(title);
        show.setTheater(venue);
        show.setDate(date);
        show.setSingerName(singer);

    }

    public void remove(MusicShow show){
        musicShows.remove(show);
    }

    public void AllMusicShows() {
        System.out.println("====Music Show ist====");
        int i=1;
        for (Entities.MusicShow show : musicShows) {
            System.out.println("  ==================== no" + i);
            System.out.println("ID number..........: " + show.getCode());
            System.out.println("Title..............: " + show.getTitle());
            System.out.println("Venue..............: " + show.getTheater());
            System.out.println("Date...............: " + show.getDate());
            System.out.println("Singer.............: " + show.getSingerName());

            i++;
        }
    }
}
