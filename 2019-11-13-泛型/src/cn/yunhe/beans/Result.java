package cn.yunhe.beans;

import java.util.Map;

/**
 * ���ؽ���ķ�װ��
 */
public class Result {

    private int code;

    private String msg;

    private int count;

    private Map<String, Object> map;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Result [code=" + code + ", msg=" + msg + ", count=" + count
                + ", map=" + map + "]";
    }

    public void success() {
        this.code = 200;
        this.msg = "success";
    }
}
