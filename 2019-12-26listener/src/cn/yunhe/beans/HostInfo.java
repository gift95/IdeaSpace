package cn.yunhe.beans;

public class HostInfo {
    private int port;
    private String host;
    private String addr;

    public HostInfo() {
    }

    public HostInfo(int port, String host, String addr) {
        this.port = port;
        this.host = host;
        this.addr = addr;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "HostInfo{" +
                "port=" + port +
                ", host='" + host + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
