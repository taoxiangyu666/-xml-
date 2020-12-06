package com.test.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

public class Dom4jDemo {
    public static void main(String[] args) {
        //1.创建Reader对象
        SAXReader reader = new SAXReader();
        try {
            //2.加载xml
            Document document = reader.read(new File("src/main/resources/demo.xml"));
            //获取根节点
            Element rootElement = document.getRootElement();
//            System.out.println(rootElement);
            //获取一个迭代器
            Iterator iterator = rootElement.elementIterator();
            while (iterator.hasNext()){
               Element element = (Element) iterator.next();
//                System.out.println(element);
                List<Attribute> attributes = element.attributes();
//                System.out.println(attributes);
                for (Attribute attribute : attributes) {
                    //获取属性值
                    System.out.println("属性值： "+attribute.getValue());
                }

                Iterator iterator1 = element.elementIterator();
                while (iterator1.hasNext()){
                    Element next = (Element) iterator1.next();
                    System.out.println("节点名："+next.getName() +"   节点值： "+next.getStringValue());
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }


}
