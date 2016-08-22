import com.google.common.collect.Interner;
import com.google.common.net.InetAddresses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * Created by Dima on 22.08.16.
 */
public class IpRangeDeterminator {
     public static ArrayList<String> getIpRange(InetAddress ip1, InetAddress ip2) throws UnknownHostException {
        int address1 = InetAddresses.coerceToInteger(ip1);
        int address2 = InetAddresses.coerceToInteger(ip2);
         ArrayList<String> ipAdressesList = new ArrayList<String>();
        for (int i = 1; i < address2 - address1; i++) {
            byte[] bytes = BigInteger.valueOf(address1 + i).toByteArray();
            InetAddress address = InetAddress.getByAddress(bytes);
            ipAdressesList.add(address.toString().substring(1));
        }
        return ipAdressesList;
     }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InetAddress ip1 = null;
        InetAddress ip2 = null;
        try {
            ip1 = InetAddresses.forString(reader.readLine());
            ip2 = InetAddresses.forString(reader.readLine());
        }
        catch (IllegalArgumentException e) {
            throw new RuntimeException("Введен некорректный IP адрес", e);
        }

        for (String s : getIpRange(ip1, ip2)) {
            System.out.println(s);
        }
    }
}
