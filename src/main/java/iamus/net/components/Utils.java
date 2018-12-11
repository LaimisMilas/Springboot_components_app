package iamus.net.components;

public class Utils {

	
	public static String nameToUpperCase(String name) {
		name = name.substring(0,1).toUpperCase()+name.substring(1);
		return name;
	}
}
