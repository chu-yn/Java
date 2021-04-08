public class MP3 extends Item {
    /**
     * Initialise the fields of the item.
     *
     * @param theTitle The title of this item.
     * @param time     The running time of this item.
     */
    private String artist;
    private int numberOfTracks;

    public MP3(String theTitle, String theArtist, int tracks, int time) {
        super(theTitle, time);
        artist = theArtist;
        numberOfTracks = tracks;
    }

    /**
     * @return The artist for this CD.
     */
    public String getArtist() {
        return artist;
    }

    /**
     * @return The number of tracks on this CD.
     */
    public int getNumberOfTracks() {
        return numberOfTracks;
    }

    /**
     * print tile and number of tracks in lines
     */
    public void printShortDetails() {
        System.out.println("Title: " + getTitle());
        System.out.println("Track: " + getNumberOfTracks());
    }

}
