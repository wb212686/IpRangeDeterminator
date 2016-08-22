import com.google.common.net.InetAddresses;
import org.junit.Assert;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Dima on 22.08.16.
 */
public class IpRangeDeterminatorTest {
    @Test
    public void getIpTest() throws UnknownHostException {
        InetAddress ip1 = InetAddresses.forString("192.168.1.1");
        InetAddress ip2 = InetAddresses.forString("192.168.1.8");
        ArrayList<String> ipRangeList = new ArrayList<String>(Arrays.asList("192.168.1.2",
                "192.168.1.3", "192.168.1.4" ,"192.168.1.5", "192.168.1.6", "192.168.1.7"));

        Assert.assertArrayEquals(ipRangeList.toArray(), IpRangeDeterminator.getIpRange(ip1, ip2).toArray());
    }
}
