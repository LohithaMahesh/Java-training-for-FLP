package com;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PolarThread {
	
	public void run(){
		ApplicationContext ac=new ApplicationContext();
		
		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH.mm.ss");
        Date date = new Date();
        System.out.println(sdf.format(date));
        String str = sdf.format(date);
        String dt = str.split("\\s")[0];
        String time2 = str.split("\\s")[1];
        System.out.println("date on split: "+dt);
        System.out.println("time on split: "+time2);
        Map<String,String>  finalMap = new HashMap<>();
        
		while(true){
			File f = new File("D:/AllFiles");
			String [] list = f.list();
			List<String> allf = Arrays.asList(list);
			for(String fl: allf){
				if(!ac.isValid(f)&&ac.isDuplicate(f)&&!ac.isOnTime(f)){
					//fl.remove();
					
				}else{
					// make entry in the map(filename and date).
					//move file to processed folder;
					
					finalMap.put(fl, str);
					for(Entry<String, String> fn: finalMap.entrySet()){
						System.out.println(fn.getKey()+"--"+fn.getValue());
					}
				}
			}
		}
		
		
	}

}
