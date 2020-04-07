package getInfo;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetInfo {
	/**
	 * "https://www.ubereats.com/jp/category/fukuoka" に表示されているカテゴリーへのリンクを取得
	 * "/Users/goodlove0125/Documents/uverShopList.txt"に保存
	 * @param args
	 * @throws IOException
	 */

	 public static void main(String[] args) throws IOException {
	        Document document = Jsoup.connect("https://www.ubereats.com/jp/category/fukuoka").get();
	        Elements elements = document.getElementsByClass("aw").select("[href]");



	        for (Element element : elements) {
	            System.out.println(element.attr("href"));
	        }
	    }
}