package com.disk.host;

/**
 * HostInfo 的主要职责:
 *
 * @ClassName HostInfo
 * @Description: TODO
 * @Author songbai yang
 * @Date 2019/9/8 19:44
 * @Version V1.0
 **/
public class HostInfo {
    private String ip;
    private String hostName;
    private String canonicalHostName;

    public String getCanonicalHostName() {
        return canonicalHostName;
    }

    public HostInfo(String ip, String hostName, String canonicalHostName) {
        this.ip = ip;
        this.hostName = hostName;
        this.canonicalHostName = canonicalHostName;
    }

    public void setCanonicalHostName(String canonicalHostName) {
        this.canonicalHostName = canonicalHostName;
    }

    public HostInfo(String ip, String hostName) {
        this.ip = ip;
        this.hostName = hostName;
    }

    public HostInfo() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    @Override
    public String toString() {
        return "HostInfo{" +
                "ip='" + ip + '\'' +
                ", hostName='" + hostName + '\'' +
                ", canonicalHostName='" + canonicalHostName + '\'' +
                '}';
    }
}
