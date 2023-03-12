public class Main {
    public static void main(String[] args) {
        DeCoder encryption = new DeCoder("Разве укусит змея, не прошипев?");

        encryption.encoder();                            // encoder massage with date
        System.out.println(encryption.decoder());       // decoding massage with date
    }
}
