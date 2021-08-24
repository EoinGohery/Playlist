//Eoin Gohery 17206413
import java.util.*;
public class Driver
    {
    private String create;
    Scanner input = new Scanner(System.in);
    public static List<Playlist> playlists = new ArrayList<Playlist>();
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        String create ="Create playlist";
        String add = "Add track";
        String showList = "List tracks";
        String remove = "Remove track";
        String previous = "Previous playlist";
        String next = "Next playlist";
        String shuffle = "Shuffle";
        String playAll = "Play all";
        String playIf ="Search";
        System.out.println("Commands: " + create +", "+ add +", "+ showList +", "+ remove);
        System.out.println(shuffle +", "+ previous +", " + next +", " + playAll +", " + playIf);
        System.out.println();
        boolean withinPlaylist = false;
        int currentPlaylist = 0;
        boolean start = true;
        while (start) 
        {   
            if (create.equals(input.nextLine()))
            {
                System.out.print("Playlist's name: ");
                String s = input.nextLine();
                Playlist tempPlaylist = new Playlist(s);
                playlists.add(tempPlaylist);
                System.out.println();
                System.out.println("New playlist created.");
                System.out.println(); 
                int tempvalue = (currentPlaylist+1);
                System.out.println("Playlist Number: " + tempvalue +". "); 
                tempPlaylist.details();
                withinPlaylist = true;
                start = false;
            } else {
                System.out.println("Create a Playlist first");
            }
        }
        while (withinPlaylist)
        {
            String command = input.nextLine();
            if (add.equals(command)) {
                playlists.get(currentPlaylist).addTrack();
            } else
            if (showList.equals(command)) {
                int tempvalue = (currentPlaylist+1);
                System.out.println("Playlist Number: " + tempvalue +". ");
                playlists.get(currentPlaylist).details();
                System.out.println();
                playlists.get(currentPlaylist).showList();
            } else
            if (remove.equals(command)) {
                System.out.println();
                System.out.print("Which track would you like to remove?(track number) ");
                String pos = input.nextLine();
                playlists.get(currentPlaylist).remove(pos);
            } else
            if (shuffle.equals(command)) {
                playlists.get(currentPlaylist).shuffle();
                System.out.println();
            }else
            if (playAll.equals(command)) {
                boolean play = true;
                while (play) {
                    System.out.print("Would you like to shuffle first? Yes or no. ");
                    String yes = "Yes";
                    String no = "No";
                    String answer = input.nextLine();
                    if (yes.equals(answer)) {
                        playlists.get(currentPlaylist).shuffle();
                        playlists.get(currentPlaylist).playAll();
                        play = false;
                    } else 
                    if (no.equals(answer)) {
                        playlists.get(currentPlaylist).playAll();
                        play = false;
                    } else {
                        play = true;
                    }
                }
            }else 
            if (playIf.equals(command)) {
                boolean play = true;
                while (play) {
                    System.out.print("Would you like to search for Artist or Year? ");
                    String searchYear = "Year";
                    String searchArtist = "Artist";
                    String answer = input.nextLine();
                    System.out.println();
                    if (searchYear.equals(answer)) {
                        System.out.print("What year would you like to search for? ");
                        String stringYear = input.nextLine();
                        int yearSearch = ((Character.getNumericValue(stringYear.charAt(0))*1000) + (Character.getNumericValue(stringYear.charAt(1))*100) + (Character.getNumericValue(stringYear.charAt(2))*10) + Character.getNumericValue(stringYear.charAt(3)));  
                        System.out.println();
                        playlists.get(currentPlaylist).playIfY(yearSearch);
                        play = false;
                    } else 
                    if (searchArtist.equals(answer)) {
                        System.out.print("Which artist would you like to search for? ");
                        String artistSearch = input.nextLine();
                        System.out.println();
                        playlists.get(currentPlaylist).playIfA(artistSearch);
                        play = false;
                    } else {
                        play = true;
                    }
                }
            }else
            if (previous.equals(command)) {
                if (currentPlaylist==0) {
                    System.out.println(); 
                    System.out.println("There are no playlist previous to the current playlist");
                    System.out.println(); 
                } else {
                    currentPlaylist--;
                    int tempvalue = (currentPlaylist+1);
                    System.out.println("Playlist Number: " + tempvalue +". ");
                    playlists.get(currentPlaylist).details();
                    System.out.println();
                }
            } else
            if (next.equals(command)) {
                if (currentPlaylist+1 == playlists.size()) {
                    System.out.println(); 
                    System.out.println("There are no playlist after the current playlist. Plese create a new playlist");
                    System.out.println();
                } else {
                    currentPlaylist++;
                    int tempvalue = (currentPlaylist+1);
                    System.out.println("Playlist Number: " + tempvalue +". ");
                    playlists.get(currentPlaylist).details();
                    System.out.println();
                } 
            } else
            if (create.equals(command))
            {
                System.out.print("Playlist's name: ");
                String s = input.nextLine();
                Playlist tempPlaylist = new Playlist(s);
                playlists.add(tempPlaylist);
                System.out.println();
                System.out.println("New playlist created.");
                System.out.println();
                currentPlaylist++;
                int tempvalue = (currentPlaylist+1);
                System.out.println("Playlist Number: " + tempvalue +". "); 
                tempPlaylist.details();
            } else {
                withinPlaylist = true;
            }   
        }
    }
}