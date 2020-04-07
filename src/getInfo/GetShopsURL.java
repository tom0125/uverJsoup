package getInfo;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import selenium.ReadLine;

public class GetShopsURL {
	/**
	 *jsouo2と機能は同じ
	 * @return ArrayList<String> ShopInfoList
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		makeShopInfoList() ;
	}
    public static ArrayList<String> makeShopInfoList() throws IOException {
    	//店舗情報をString型で格納するため、ShopInfoListを宣言
    	ArrayList<String>ShopInfoList = new ArrayList<>();
    	//ショップのカテゴリーURLをshopListに格納
    	ArrayList<String> shopList = ReadLine.makeShopList();

    	for(String url : shopList) {
    		//カテゴリに属するショップの一覧を取得
    		String chrome = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36";
    		Document document = Jsoup.connect(url).userAgent(chrome).timeout(0).get();
    		//ショップ一覧から、各店舗のURLを取得
    		Elements elements = document.getElementsByClass("b1 ec b6").select("[href]");
            //ショップのURLを１店舗ごと取り出す
    		for (Element element : elements) {
	            System.out.println("https://www.ubereats.com" + element.attr("href"));
	          //リストにショップURLを格納
                ShopInfoList.add("https://www.ubereats.com" + element.attr("href"));
	        }
    	}
    	return ShopInfoList;
    }
}