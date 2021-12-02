package com.participants.Pooja.Assignment;

import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;  


public class ReadXMLFileExample1  
{  
public static void main(String argv[])   
{  
try   
{  
//creating a constructor of file class and parsing an XML file  
File file = new File("D:\\XMLFile.xml");  
//an instance of factory that gives a document builder  
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
//an instance of builder to parse the specified xml file  
DocumentBuilder db = dbf.newDocumentBuilder();  
Document doc = db.parse(file);  
doc.getDocumentElement().normalize();  
System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
NodeList nodeList = doc.getElementsByTagName("student");  
// nodeList is not iterable, so we are using for loop  
for (int itr = 0; itr < nodeList.getLength(); itr++)   
{  
Node node = nodeList.item(itr);  
System.out.println("\nNode Name :" + node.getNodeName());  
if (node.getNodeType() == Node.ELEMENT_NODE)   
{  
Element eElement = (Element) node;  
System.out.println("Student id: "+ eElement.getElementsByTagName("id").item(0).getTextContent());  
System.out.println("First Name: "+ eElement.getElementsByTagName("firstname").item(0).getTextContent());  
System.out.println("Last Name: "+ eElement.getElementsByTagName("lastname").item(0).getTextContent());  
System.out.println("Subject: "+ eElement.getElementsByTagName("subject").item(0).getTextContent());  
System.out.println("Marks: "+ eElement.getElementsByTagName("marks").item(0).getTextContent());  
}  
}  
}   
catch (Exception e)   
{  
e.printStackTrace();  
}  
}  
}  