package cn.yunhe.listener;

import cn.yunhe.beans.HostInfo;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class RequsetListener implements ServletRequestListener {
    List<HostInfo> infoList = null;

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        //先从全局域中获取数据集合
        ServletContext context = sre.getServletContext();
        Object obj = context.getAttribute("infoList");
        if (obj == null) {
            infoList = new ArrayList<>();
        } else {
            infoList = (List<HostInfo>) obj;
        }
        //创建HostInfo对象将信息封装进对象中存入集合，放入全局域中
        HostInfo hostInfo = new HostInfo();
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        hostInfo.setAddr(request.getRemoteAddr());
        hostInfo.setHost(request.getRemoteHost());
        hostInfo.setPort(request.getRemotePort());
        infoList.add(hostInfo);
        context.setAttribute("infoList", infoList);

    }
}
