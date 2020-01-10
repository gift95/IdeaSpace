package cn.yunhe.listener;

import cn.yunhe.beans.HostInfo;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.List;

public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        List<HostInfo> infoList = (List<HostInfo>) se.getSession().getAttribute("infoList");
        for (HostInfo hostinfo : infoList
        ) {


        }
    }

}
