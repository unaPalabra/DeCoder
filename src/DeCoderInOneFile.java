import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DeCoderInOneFile {
    public static void main(String[] args) {

        String massege = "Разве укусит змея, не прошипев?";

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        String date = dateFormat.format(calendar.getTime());
        StringBuilder codMassage = new StringBuilder();

        char[] arrMass = massege.toCharArray();
        int[] nums = new int[arrMass.length];
        int[] arrRand = new int[arrMass.length];

        for (int i = 0; i < arrMass.length; i++) {
            SecureRandom random = new SecureRandom();
            int rand = random.nextInt(10, 88);
            nums[i] = arrMass[i] * rand;
            arrRand[i] = rand;
            codMassage.append(arrRand[i]).append(nums[i] + " ").trimToSize();
        }
        codMassage.append(date);   // return string encoded message with date


        StringBuilder dateStr = new StringBuilder(codMassage);
        dateStr.delete(0, codMassage.length() - 21);

        String[] arrCods = codMassage.delete(codMassage.length() - 21, codMassage.length()).toString().split(" ");
        String[] arrDec = new String[arrCods.length];
        String[] arrDecRand = new String[arrCods.length];
        StringBuilder decodMass = new StringBuilder();

        //we get a coded message and a string of random numbers
        for (int i = 0; i < arrCods.length; i++) {
            arrDec[i] = arrCods[i].substring(2);
            arrDecRand[i] = arrCods[i].substring(0, 2);
            decodMass.append((char) (Integer.parseInt(arrDec[i]) / Integer.parseInt(arrDecRand[i])));
        }

        System.out.println(decodMass.append("\n").append(dateStr));
    }
}



