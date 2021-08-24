//Eoin Gohery 17206413
import java.util.*;
public class Playlist
{
    public String thePlaylistName;
    Scanner input = new Scanner(System.in);
    private int p;
    public List<Track> tracks;
    
    public Playlist(String playlistName) 
    {
        this.thePlaylistName = playlistName;
        tracks = new ArrayList<Track>();
    }
    public String getPlaylistName()
    {
       return  thePlaylistName;
    }
    public void details() //ie. the toString method for displaying instance values
    {
        System.out.println("Name: " + getPlaylistName() +". "); 
        System.out.println("Number of Tracks: " + p +". "); 
        System.out.println();
    }
    public void addTrack()
    {
        p++;
        if (p<=100)
        {
            System.out.println("Tracks's title: ");
            String tempTitle = input.nextLine();
            System.out.println("Tracks's artist: ");
            String tempArtist = input.nextLine();
            System.out.println("Tracks's year: ");
            String stringYear = input.nextLine();
            int tempYear = ((Character.getNumericValue(stringYear.charAt(0))*1000) + (Character.getNumericValue(stringYear.charAt(1))*100) + (Character.getNumericValue(stringYear.charAt(2))*10) + Character.getNumericValue(stringYear.charAt(3)));
            System.out.println("Tracks's duration(in seconds): ");
            String stringDuration = input.nextLine();
            int tempDuration = ((Character.getNumericValue(stringDuration.charAt(0))*100) + (Character.getNumericValue(stringDuration.charAt(1))*10) + Character.getNumericValue(stringDuration.charAt(2)));
            Track temptrack= new Track(tempTitle, tempArtist, tempYear, tempDuration);
            tracks.add(temptrack);
            System.out.println(); 
        } else {
            System.out.print("The playlist is at max song capacity");
        }
    }
    public void remove (String trackPos)
    { 
        if (3 == trackPos.length())
        {
            tracks.remove(99);
            System.out.println("Track has been removed");
        } else if (2 == trackPos.length()) {
            tracks.remove((Character.getNumericValue(trackPos.charAt(0))*10)+(Character.getNumericValue(trackPos.charAt(0))-1));
            System.out.println("Track has been removed");
        } else if (1 == trackPos.length()) {
            tracks.remove(Character.getNumericValue(trackPos.charAt(0))-1);
            System.out.println("Track has been removed");
        }
    }
    public void playIfA(String artist) // This one deosn't work and cannot understand why, as playIfY does work
    {
        for (int i=0; i<tracks.size(); i++) {
            if (tracks.get(i).artist == artist) {
                tracks.get(i).info();
            }
        }
    }
    public void playIfY(int year)
    {
        for (int i=0; i<tracks.size(); i++) {
            if (tracks.get(i).year == year) {
                tracks.get(i).info();
            }
        }
    }    
      public void shuffle()
    {
        Collections.shuffle(tracks);
    }
    public void playAll()
    {
        for (int i=0; i<tracks.size(); i++) {
            int trackNo = i + 1;
            System.out.println("Track no: " + trackNo);
            tracks.get(i).info();
        }
    }
    public void showList()
    {
        for (int i=0; i<tracks.size(); i++) {
            int trackNo = i + 1;
            System.out.println("Track no: " + trackNo);
            tracks.get(i).info();
        }
    }
}

