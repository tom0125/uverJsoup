package selenium;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadLine {
	/**
	 * /Users/goodlove0125/Documents/uverShopList.txt" から一行づつ読み込み、ドメインを付与
	 * 完成したURLはArrayList<String>型のuverShopに格納
	 *
	 * @return 　ArrayList<String>型のuverShop
	 */

	public static ArrayList<String> makeShopList() {
		ArrayList<String>uverShop = new ArrayList<String>();
		try{

			  File file = new File("/Users/goodlove0125/Documents/uverShopList.txt");
			  BufferedReader br = new BufferedReader(new FileReader(file));

			  String str = br.readLine();
			  while(str != null){
			    System.out.println(str);
			    uverShop.add("https://www.ubereats.com" + str);

			    str = br.readLine();
			  }

			  br.close();

			}catch(FileNotFoundException e){
			  System.out.println(e);
			}catch(IOException e){
			  System.out.println(e);
			}
		return uverShop;
	}

}
