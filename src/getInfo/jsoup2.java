package getInfo;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import selenium.ReadLine;

public class jsoup2 {
	/**
	 *店舗の情報を一店舗ごと、取り出し、ShopInfoListに格納
	 * @return ArrayList<String> ShopInfoList
	 * @throws IOException
	 */

    public static ArrayList<String> makeShopInfoList() throws IOException {
    	//店舗情報をString型で格納するため、ShopInfoListを宣言
    	ArrayList<String>ShopInfoList = new ArrayList<>();
    	//ショップのカテゴリーURLをshopListに格納
    	ArrayList<String> shopList = ReadLine.makeShopList();

    	for(String url : shopList) {
    		//カテゴリに属するショップの一覧を取得
    		Document document = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100").timeout(0).get();
    		//ショップ一覧のdiv を指定
            Elements elements = document.getElementsByClass("e9 ea eb");
            //ショップの情報を１店舗ごと取り出す
            for (Element element : elements) {
            	//店舗情報をコンソールに表示(デバック用)
            	System.out.println(element.text());
            	//リストにショップ情報をString型で格納
                ShopInfoList.add(element.text());

            }
    	}
    	return ShopInfoList;
    }
}