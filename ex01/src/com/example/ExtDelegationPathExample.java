package com.example;

import java.net.URL;
import java.net.URLClassLoader;

public class ExtDelegationPathExample {

	public static void main(String[] args) {
		// ClassLoaders up to BootStrap;
		//		AppClassLoader
		//		ExtClassLoader
		
		String targetClassLoaderName = "ExtClassLoader";
		
		printClassLoaderPath(targetClassLoaderName);
	}
	
	private static void printClassLoaderPath(String targetClassLoaderName) {
		URLClassLoader classLoader = (URLClassLoader) URLClassLoader.getSystemClassLoader();
		
		do {
			String classLoaderName = classLoader.getClass().getSimpleName();
			
			if( classLoaderName.equals(targetClassLoaderName)) {
				System.out.println(classLoaderName);
				for(int i = 0; i < classLoaderName.length(); i++)
					System.out.print('*');
				
				System.out.println();
				
				for(URL url : classLoader.getURLs())
					System.out.printf("\t %s\n", url);
			}
		} while( (classLoader = (URLClassLoader) classLoader.getParent()) != null);
	}

}