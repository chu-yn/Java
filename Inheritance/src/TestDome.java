public class TestDome {
    public static void main(String[] args) {
        // create object database from Database
        Database database = new Database();
        // create object cd1 from CD
        CD cd1 = new CD("CD", "ABC", 0, 3);
        // print short details using printShortDetails() from CD
        cd1.printShortDetails();
        // add cd1 into database
        database.addItem(cd1);
        // create object dvd1 from DVD
        DVD dvd1 = new DVD("DVD", "DEF", 120);
        // add dvd1 into database
        database.addItem(dvd1);
        // create object mp3 from MP3
        MP3 mp3 = new MP3("MP3", "GHI", 1, 2);
        // print short details using printShortDetails() form MP3
        mp3.printShortDetails();
        // add mp3 into database
        database.addItem(mp3);
        // list item from database
        database.list();
        // add comment using addComment from Item
        cd1.setComment("cd1 comment");
        // set own using setOwn from Item
        cd1.setOwn(true);
        // add comment using addComment from Item
        dvd1.setComment("dvd1 comment");
        // set own using setOwn from Item
        dvd1.setOwn(true);
        // add comment using addComment from Item
        mp3.setComment("mp3 comment");
        // set own using setOwn from Item
        mp3.setOwn(true);
        // list item from database
        database.list();
    }
}
