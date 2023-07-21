package java_exercise;

import org.junit.Test;

/**
 * @author kraken
 * @date 2022.9.18
 * @docs https://www.liaoxuefeng.com/wiki/1252599548343744/1255888634635520
 */
public class Java03 {
    /**
     * 按位与运算实际上可以看作两个整数表示的IP地址10.0.17.77和10.0.17.0，通过与运算，可以快速判断一个IP是否在给定的网段内
     *  @docs https://www.huaweicloud.com/zhishi/edits-15756157.html
     * @param ip 原始 ip
     * @param cidr 网络段
     * @return 是否属于某一个网络段
     */
    public boolean isInRange(String ip, String cidr) {
        String[] ips = ip.split("\\.");
        int ipInt = Integer.parseInt(ips[0]) << 24 | Integer.parseInt(ips[1]) << 16 | Integer.parseInt(ips[2]) << 8
                | Integer.parseInt(ips[3]);
        String[] cidrArr = cidr.split("/");
        String[] cidrIps = cidrArr[0].split("\\.");
        int cidrIp =
                Integer.parseInt(cidrIps[0]) << 24 | Integer.parseInt(cidrIps[1]) << 16 | Integer.parseInt(cidrIps[2]) << 8
                        | Integer.parseInt(cidrIps[3]);
        int cidrMarkOffset = 32 - Integer.parseInt(cidrArr[1]);
        int cidrMark = 0xFFFFFFFF << cidrMarkOffset;
        return (ipInt & cidrMark) == (cidrIp & cidrMark);
    }

    @Test
    public void ipTest() {
        System.out.println(isInRange("192.168.1.127", "192.168.1.64/28"));
        System.out.println(isInRange("192.168.1.2", "192.168.0.0/23"));
        System.out.println(isInRange("192.168.0.1", "192.168.0.0/24"));
        System.out.println(isInRange("192.168.0.101", "192.168.0.0/32"));
    }

    @Test
    public void sum100() {
        int n = 100;
        int sum = (1 + n) * n / 2;
        System.out.println(sum);
    }
}
