package cn.yunhe.xmldemo;

import cn.yunhe.beans.User;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class XmlFz {
    public static void main(String[] args) throws FileNotFoundException, DocumentException, ClassNotFoundException, InstantiationException, IllegalAccessException {
String path = "D:/IdeaSpace/2019-11-22-xmlmode/src/Order.xml";
        Map<String, Object> map=  new XmlFz().getMap(path);
        //System.out.println(map);
        Object object =  new XmlFz().getById("cn.yunhe.beans.User",path);
        User user = (User) object;
        user.setUserId(15);

    }

    /**
     * 1 创建SAXReader对象
     * 2 创建 document 对象 读取xml 格式为 Document document = xml.reader（new File（xmlPath））
     * 3 获取根节点
     * 4 遍历根节点 获取子节点将其放入list集合中
     * @param path
     * @return List<Element>
     * @throws FileNotFoundException
     * @throws DocumentException
     */
    public List<Element> getElement(String path) throws FileNotFoundException, DocumentException {
        SAXReader saxReader = new SAXReader();
        Document doc = saxReader.read(new File(path));
        Element element = doc.getRootElement();
        List<Element> elementList = element.elements();
        return elementList;
    }

    /**
     * 1 遍历子节点
     *2 获取每个节点内的属性 获取某个属性的值 的格式为 Attribute attribute = element.attribute(String s)
     *3 将值放入map集合中
     *      可以利用反射将class对象放入集合中 格式为 Class.forName（String）
     * @param path
     * @return
     * @throws FileNotFoundException
     * @throws DocumentException
     * @throws ClassNotFoundException
     */
    private Map<String, Object> getMap(String path) throws FileNotFoundException, DocumentException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Map<String, Object> map = new HashMap<>();
        List<Element> elementList = getElement(path);
        //遍历子节点获取每个节点的属性
        for (Element el : elementList) {
            //获取子节点中属性为id 的值 和属性为 class 的值 并将其放入map集合中
            Attribute attKey = el.attribute("id");
            Attribute attVal = el.attribute("class");
            String key = attKey.getValue();
            String val = attVal.getValue();
            // 利用反射将class对象存放到map集合中
            Class cla = Class.forName(val);
            Object obj = cla.newInstance();
            map.put(key, obj);

        }
        return map;
    }

    /**
     * 通过clss路径获取class对象
     * @param clsPath
     * @param path
     * @throws FileNotFoundException
     * @throws DocumentException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public Object getById(String clsPath,String path) throws FileNotFoundException, DocumentException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Map<String, Object> map = getMap(path);
        Object object = null;
        Collection<Object> coll = map.values();
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
            object = iterator.next();
            if (null !=object) {
                boolean flag = object.getClass().getName().equals(clsPath);
                if (flag) {
                    return object;

                }
            }
        }

        return object;
    }
}
