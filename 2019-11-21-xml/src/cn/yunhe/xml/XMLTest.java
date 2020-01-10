package cn.yunhe.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Attribute;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 为什么要学习xml解析？---工作中的使用场景
 * 	JSON格式		轻量级	推荐
 * 	XML					不常用
 * 此处讲xml解析的目的
 * 	1  融合之前学习的OOP知识
 * 	2 xml解析是框架的底层原理之一
 * 
 * 什么是xml文件？
 * 	以xml结尾的，内容是标签语言实现的一种数据存储方式
 * 原生的xml解析方式是什么？
 * 	Document对象-->DocumentBuilder-->DocumentBuilderFactory
 * 常见的xml解析方式有哪些？
 * 	DOM	SAX DOM4J JDOM
 * 各自之间的优缺点对比 -- 几种xml解析方式的区别
 * 常用的dom4j的使用
 */
public class XMLTest {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, DocumentException {
//		parseXML01();
		parseXMLBy4j();
	}
	
	/**
	 * 原生的xml解析方式
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws FileNotFoundException 
	 */
	public static void parseXML01() throws ParserConfigurationException, FileNotFoundException, SAXException, IOException{
		//先创建DocumentBuilder的工厂对象
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//通过工厂对象创建DocumentBuilder
		DocumentBuilder builder = factory.newDocumentBuilder();
		//获取Document对象
		Document document = builder.parse(new FileInputStream("src/Order.xml"));
		//获取xml文件中的所有bean标签
		NodeList nodeList = document.getElementsByTagName("bean");
		//遍历集合，根据下标查找想要的bean所对应的实例
		if(null != nodeList){
			for(int i=0;i<nodeList.getLength();i++){
				//获取node对象
				Node node = nodeList.item(i);
				//获取该节点对应的所有属性值
				NamedNodeMap nodeMap = node.getAttributes();
				Node nameNode = nodeMap.getNamedItem("class");
				System.out.println("节点名称："+nameNode.getNodeName()+"-节点值："+nameNode.getNodeValue());
			}
		}
	}
	
	/**
	 * DOM4j是第三方提供的方式，因此需要使用jar包
	 * @throws DocumentException 
	 * @throws FileNotFoundException 
	 */
	public static void parseXMLBy4j() throws FileNotFoundException, DocumentException{
		//创建SAXReader用于读取对应的xml文件
		SAXReader reader = new SAXReader();
		//获取Document对象
		org.dom4j.Document document = reader.read(new File("src/Order.xml"));
		//获取文档的跟节点
		Element element = document.getRootElement();
		//获取该跟节点所包含的所有子节点
		List<Element> elList = element.elements();
		//遍历集合
		if(null != elList){
			for(Element el : elList){
				//获取对应节点的属性集合
				List<Attribute> attrList = el.attributes();
				for(Attribute attr : attrList){
					//获取key
					String key = attr.getName();
					//获取val
					String val = attr.getValue();
					System.out.println("key="+key+"--val:"+val);
				}
			}
		}
	}
}
