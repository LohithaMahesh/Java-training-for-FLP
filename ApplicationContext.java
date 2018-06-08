package com;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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

public class ApplicationContext {
	
	   Map<String,String> input = new HashMap<>();
	   Map<String,String> output = new HashMap<>();
	   List<String> listinput=new ArrayList<>();
	   List<String> listinputtime=new ArrayList<>();
	   List<String> listoutput=new ArrayList<>();
	   File f = new File("D:/AllFiles");
	   
	   final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH.mm.ss");
       Date date = new Date();
       //System.out.println(sdf.format(date));
       String str = sdf.format(date);
       String dt = str.split("\\s")[0];
       String time2 = str.split("\\s")[1];
//       System.out.println("date on split: "+dt);
//       System.out.println("time on split: "+time2);
	   
	public void load(){
		try{
			
		
        System.out.println(sdf.format(date));
        
        System.out.println("date on split: "+dt);
        System.out.println("time on split: "+time2);
		
		
		
		         
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
	            
	           String name = eElement.getAttribute("name");
	           System.out.println("Name : "+name);
	           String time = eElement.getAttribute("time");
	            System.out.println("Time : "+ time);
	            
	          
	            input.put(name, time);
	            for(Entry<String, String> m: input.entrySet()){
	            	String nm=m.getKey();
	            	String tm=m.getValue();
	            	System.out.println(tm+"--"+nm);
	            	listinput.add(nm);
	            	listinputtime.add(tm);
	            	
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
    }
	
//	public List<String> allFiles(){
//		File f = new File("D:/AllFiles");
//		String [] list = f.list();
//		List<String> allf = Arrays. asList(list);
//		return allf;
//	}
	
	public boolean isValid(File f){
		
		String [] list = f.list();
		
		List<String> allf = Arrays.asList(list);
		
		for(String st2:listinput){
			System.out.println("--st2---"+st2);	
			   for(String st: allf){
				  if(st.equals(st2)){
					  System.out.println(st);
					  return true;
					 
				  }
			  }
		}
		 
		return false;
	}
	// for duplicacy checking
	public boolean isDuplicate(File f){
		
		for(Entry<String, String> m: output.entrySet()){
        	String processedFileName = m.getKey();
        	String processedCurrentDate = m.getValue();
        	System.out.println( processedFileName +"--"+ processedCurrentDate);
        	listoutput.add(processedFileName);
        }
//		if(inputfileList.equals(listoutput)){
//			return true;
//		}
		return false;
	}
	//
	public boolean isOnTime(File f){
		
		return true;
		
	}

}
