package TEST_Databases;

public class Start {
    public static void main(String[] args) {
        DBWorker worker = new DBWorker();
        for (int i = 0; i < worker.maker.size(); i++){
            System.out.printf("|%8d %4s |\n", 100,"");
        }
    }
}
