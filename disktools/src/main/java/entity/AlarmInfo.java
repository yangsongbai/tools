package entity;

import com.disk.host.HostInfo;

import java.util.HashMap;
import java.util.HashSet;

/**
 * AlarmInfo 的主要职责:
 *
 * @ClassName AlarmInfo
 * @Description: TODO
 * @Author songbai yang
 * @Date 2019/9/8 19:51
 * @Version V1.0
 **/
public class AlarmInfo {
    private HostInfo hostInfo;
    private HashMap<String,String> disk;

    public AlarmInfo(HostInfo hostInfo, HashMap<String, String> disk) {
        this.hostInfo = hostInfo;
        this.disk = disk;
    }

    public AlarmInfo() {
    }

    public HostInfo getHostInfo() {
        return hostInfo;
    }

    public void setHostInfo(HostInfo hostInfo) {
        this.hostInfo = hostInfo;
    }

    public HashMap<String, String> getDisk() {
        return disk;
    }

    public void setDisk(HashMap<String, String> disk) {
        this.disk = disk;
    }

    @Override
    public String toString() {
        return "AlarmInfo{" +
                "hostInfo=" + hostInfo +
                ", disk=" + disk +
                '}';
    }
}
