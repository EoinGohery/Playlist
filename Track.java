//Eoin Gohery 17206413
public class Track 
{
    private String title;
    public String artist;
    public int year;
    private int duration;
    
    public Track(String title, String artist, int year, int duration)
    {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.duration = duration;
    }
    
    public String getTitle()
    {
        return  title;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }   
    public String getArtist()
    {
        return  artist;
    }
    public void setArtist(String artist) 
    {
        this.artist = artist;
    }   
    public int getYear()
    {
        return  year;
    }
    public void setYear(int year) 
    {
        this.year = year;
    }   
    public int getDuration()
    {
        return  duration;
    }
    public void setDuration(int duration) 
    {
        this.duration = duration;
    } 
    public void info()
    {
        System.out.println("Title: " + getTitle());
        System.out.println("Artist: " + getArtist());
        System.out.println("Year: " + getYear());
        System.out.println("Duration: " + getDuration() + " seconds");
        System.out.println();
    }
}