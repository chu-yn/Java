public class TestDome {
    public static void main(String[] args) {
        Database database = new Database();
        CD cd1 = new CD("First try", "ABC", 1, 3);
        database.addItem(cd1);
        cd1.setComment("Very good");
        cd1.printShortDetails();
        MP3 mp3 = new MP3("Second try", "DEF", 2, 2);
        database.addItem(mp3);
        mp3.setComment("good content");
        mp3.printShortDetails();
        database.list();
    }
}
