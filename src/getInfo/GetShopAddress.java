package getInfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetShopAddress {
	/**
	 *店舗の情報を一店舗ごと、取り出し、ShopInfoListに格納
	 * @return ArrayList<String> ShopInfoList
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		List<String> shopInfoList =  makeShopInfoList();

	}
    public static List<String> makeShopInfoList() throws IOException {
    	//店舗情報をString型で格納するため、ShopInfoListを宣言
    	ArrayList<String>ShopInfoList = new ArrayList<String>();
    	ArrayList<String> shopList = GetShopsURL.makeShopInfoList();



    	for(String url : shopList) {
//    		try {
//   			 Thread.sleep(10000); // 10秒(1万ミリ秒)間だけ処理を止める
//   			} catch (InterruptedException e) {
//   				e.printStackTrace();
//   			}
    		//カテゴリに属するショップの一覧を取得
    		String chrome = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36";
    		Document document = Jsoup.connect(url).userAgent(chrome).timeout(0).get();

    		//ショップ一覧のdiv を指定
    		String elements3 = document.outerHtml();
            Elements elements = document.getElementsByClass("c5 ct b6 b7 dp");// e9 ea eb
            Elements elements2 = document.getElementsByClass("dh di dj b7");// e9 ea eb
            //ショップの情報を１店舗ごと取り出す

            for (Element element : elements) {
            	int i = 0;
//            	Element element2 = elements2.get(i++);
            	//店舗情報をコンソールに表示(デバック用)
            	System.out.println(element.text() );//+ "@"+ element2.text()
            	//リストにショップ情報をString型で格納
                ShopInfoList.add(element.text()); //+ "@"+ element2.text()

            }

    	}
    	List<String> hashShopInfoLIst = new ArrayList<String>(new HashSet<>(ShopInfoList));
    	return hashShopInfoLIst;
    }

    public static ArrayList<String> makeShopList() {
		ArrayList<String>uverShop = new ArrayList<String>();
		try{
			  //"/Users/goodlove0125/Documents/uverShopList.txt"
			  File file = new File("/Users/goodlove0125/Documents/UverShopUrl.txt");
			  BufferedReader br = new BufferedReader(new FileReader(file));

			  String str = br.readLine();
			  while(str != null){
			    System.out.println(str);
			    uverShop.add(str);

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