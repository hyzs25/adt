package com.example.android_ch15_xml;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		InputStream in = getResources().openRawResource(R.raw.data);
		
		try{
			byte[] by = new byte[in.available()];
			in.read();
			String XMLstr = new String(by,"utf-8");
			in.reset();
			System.out.println(XMLstr);
			//开始解析
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(in);
			//定义一个节点
			Node node = doc.getFirstChild();
			//输出第一个子节点
			System.out.println("第一个子节点: " + node.getNodeName());
			NodeList list = doc.getElementsByTagName("c");
			NamedNodeMap map;
			for(int i = 0; i < list.getLength(); i++){
				node = list.item(i);
				map = node.getAttributes();
				System.out.println(node.getTextContent() + " " + map.getNamedItem("title").getNodeValue());
			}			
		}catch(IOException e){
				e.printStackTrace();
		} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
}