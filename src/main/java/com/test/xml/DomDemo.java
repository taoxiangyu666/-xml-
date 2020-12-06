package com.test.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomDemo {
    public static void main(String[] args) {
        //1.创建DocurmentBuilderFactory对象
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //2.使用DocurmentBuilderFactory对象 生成DocurmentBuilder对象
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            //3.读取xml配置文件
            Document document = documentBuilder.parse(new File("src/main/resources/demo.xml"));
            //4.解析xml，封装成xml对象
            //NodeList 对象代表一个有顺序的节点列表
            NodeList nodeList = document.getElementsByTagName("student");
            //遍历节点集合
            element(nodeList);
            // node(nodeList);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void element(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            NodeList childNodes = element.getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                if (childNodes.item(j).getNodeType()== Node.ELEMENT_NODE){
                    System.out.print(childNodes.item(j).getNodeName() + ":");
                    //firstChild 属性返回被选节点的第一个子节点。
                    System.out.println(childNodes.item(j).getFirstChild().getNodeValue());
                }
            }
        }
    }

    private static void node(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            //item	可返回节点列表中处于指定的索引号的节点。
            Node item = nodeList.item(i);
            NodeList childNodes = item.getChildNodes();
            for (int j = 0; j <childNodes.getLength() ; j++) {
                if (childNodes.item(j).getNodeType()==Node.ELEMENT_NODE){
                    //获取节点
                    System.out.print(childNodes.item(j).getNodeName() +":");
                    //获取节点值
                    System.out.println(childNodes.item(j).getFirstChild().getNodeValue());
                }

            }
        }
    }

}
