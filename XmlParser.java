package com;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XmlParser {
	
	Map<String,String> sourceMap = new HashMap<>();
	   Map<String,String> destinationMap = new HashMap<>();
	   List<String> sourcelistinput = new ArrayList<>();
	   List<String> listinputtime = new ArrayList<>();
	   List<String> listoutput = new ArrayList<>();
	   File f = new File("D:/AllFiles");
	   
	public Map<String,String> load(){
		
		 
		   
		try{
		   
	    File fXmlFile = new File("C:/Users/sudevi/workspace/JavaTraining/src/com/FileDetails.xml");
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    Document doc = dBuilder.parse(fXmlFile);
	    doc.getDocumentElement().normalize();

	    System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	    NodeList nList = doc.getElementsByTagName("input-file");
	    System.out.println("----------------------------");

	    for (int temp = 0; temp < nList.getLength(); temp++) {
	        Node nNode = nList.item(temp);
	        System.out.println("\nCurrent Element :" + nNode.getNodeName());
	        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            Element eElement = (Element) nNode;
	            
	           String xmlNameAttribute = eElement.getAttribute("name");
	           System.out.println("Name : "+xmlNameAttribute);
	           String xmlTimeAttribute = eElement.getAttribute("time");
	            System.out.println("Time : "+ xmlTimeAttribute);
	            
	          
	            sourceMap.put(xmlNameAttribute, xmlTimeAttribute);
	            for(Entry<String, String> m: sourceMap.entrySet()){
	            	String nm=m.getKey();
	            	System.out.println(nm);
	            	String tm=m.getValue();
	            	System.out.println(tm+"--"+nm);
	            	sourcelistinput.add(nm); //filename
	            	listinputtime.add(tm);  //time
	            	
	            }
	            
//	            System.out.println("First Name : "+ eElement.getElementsByTagName("firstname").item(0).getTextContent());
//	            System.out.println("Last Name : "+ eElement.getElementsByTagName("lastname").item(0).getTextContent());
//	            System.out.println("Dob : "+ eElement.getElementsByTagName("dob").item(0).getTextContent());
//	            System.out.println("Dod : " + eElement.getElementsByTagName("dod").item(0).getTextContent());
//	            System.out.println("LoanAmt : "+ eElement.getElementsByTagName("loanAmount").item(0).getTextContent());
	        }
	    }
	    } catch (Exception e) {
	    e.printStackTrace();
	    }
		return sourceMap;
    }
	
	public List<String> getListFromSourceMap(){
		List<String> mapToList = new ArrayList<String>();
		Map<String, String> maplist = load();
		for(Entry<String, String> map : maplist.entrySet()){
			mapToList.add(map.getKey());
		}
		
		return mapToList;
	}
	
	public  List<String> getAllFileList(File f){
		String[] fileList = f.list();
		List<String> allFileList = Arrays.asList(fileList);
		 
		return allFileList; 
	}
	
public boolean isValid(File f){
	List<String> allFileList = getAllFileList(f);
	List<String> mapToList= getListFromSourceMap();
	for(String li:mapToList){
		for(String fi:allFileList){
			if(li.equals(fi)){
				System.out.println(fi);
				return true;
			}
		}
	}
		return false;
	}
	
}
