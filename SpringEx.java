package com;

import java.io.File;
import java.util.List;

public class SpringEx {

	public static void main(String argv[]) {
		File f = new File("D:/AllFiles");
		ApplicationContext ac = new ApplicationContext();
		//ac.load();
		//System.out.println(ac.isValid(f));
		XmlParser xp=new XmlParser();
		List<String> limap = xp.getListFromSourceMap();
		System.out.println("size: --"+limap.size());
//		xp.load();
//		
//		List<String> li = xp.getAllFileList(f);
//		for(String lit:li){
//			System.out.println("lit---"+lit);
//		}
//		
		boolean b=xp.isValid(f);
		System.out.println(b);
		
		
	  }

}
