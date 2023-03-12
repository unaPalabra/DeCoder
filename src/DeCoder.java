import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DeCoder {
    private String getDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        return dateFormat.format(calendar.getTime());
    }

    public StringBuilder encoder(String massege) {
        char[] arrMass = massege.toCharArray();
        int[] nums = new int[arrMass.length];
        int[] arrRand = new int[arrMass.length];

        SecureRandom random = new SecureRandom();
        int rand = random.nextInt(10, 88);
        StringBuilder codMassage = new StringBuilder();

        for (int i = 0; i < arrMass.length; i++) {
            nums[i] = arrMass[i] * rand;
            arrRand[i] = rand;
            codMassage.append(arrRand[i]).append(nums[i] + " ").trimToSize();
        }
        return codMassage.append(getDate());   // return string encoded message with date
    }

    public StringBuilder decoder(StringBuilder message) {
        StringBuilder dateStr = new StringBuilder(message);
        dateStr.delete(0, message.length() - 21);
        String[] arrCods = message.delete(message.length() - 21, message.length()).toString().split(" ");

        String[] arrDec = new String[arrCods.length];
        String[] arrDecRand = new String[arrCods.length];
        StringBuilder decodMass = new StringBuilder();

        for (int i = 0; i < arrCods.length; i++) {
            arrDec[i] = arrCods[i].substring(2);
            arrDecRand[i] = arrCods[i].substring(0, 2);
            decodMass.append((char) (Integer.parseInt(arrDec[i]) / Integer.parseInt(arrDecRand[i])));
        }
        return decodMass.append("\n").append(dateStr);
    }
}
