/**
 * 
 */
package day0;

import java.io.File;

/**
 * @author Administrator
 */
public class ScanIBatisXML {

	/**
	 * 
	 */
	public ScanIBatisXML() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		String path = System.getProperty("user.dir") + "/src/main/resources/config/ibatis";

		File folder = new File(path);

		File[] fs = folder.listFiles();

		for (File f : fs) {
			String fname = f.getName(); // .replace("shdb_", "");
			// f.renameTo(new File(f.getParent(), fname));
			System.out.format("	<sqlMap resource=\"config/ibatis/%s\" />\r\n", fname);
		}


	}

}
