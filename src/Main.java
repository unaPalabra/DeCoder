public class Main {
    public static void main(String[] args) {
        DeCoder encryption = new DeCoder();
        StringBuilder message1 = encryption.encoder("Разве укусит змея, не прошипев?");
        StringBuilder message2 = encryption.encoder("Hello, world!");

        System.out.println(encryption.decoder(message1));
        System.out.println(encryption.decoder(message2));
    }
}
