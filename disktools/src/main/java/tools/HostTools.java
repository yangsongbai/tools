package tools;

import com.disk.host.HostInfo;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * HostTools 的主要职责:
 *
 * @ClassName HostTools
 * @Description: TODO
 * @Author songbai yang
 * @Date 2019/9/8 19:44
 * @Version V1.0
 **/
public class HostTools {

    public static HostInfo getHostInfo() {
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String ip=addr.getHostAddress().toString(); //获取本机ip
        String hostName=addr.getHostName().toString(); //获取本机计算机名称
        return new HostInfo(ip,hostName,addr.getCanonicalHostName());
    }
}
