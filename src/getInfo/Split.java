package getInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
public class Split {

	public static void main(String[] args) {
		ArrayList<String> shopInfoList;
		try {
			shopInfoList = jsoup2.makeShopInfoList();
			//重複しているデータをHashSetで取り除く
			 List<String> hashShopInfoLIst = new ArrayList<String>(new HashSet<>(shopInfoList));

		for(String info : hashShopInfoLIst) {

			//split()を配列で使うため、Array.asListを使用
			List<String> infoSplit = new ArrayList<>();
			//指定された配列に連動する固定サイズのリストをすため、listの操作が不可。そのため、LinkedListを使用
			infoSplit = new LinkedList( Arrays.asList(info.split(" ")));
			int rw1 = infoSplit.indexOf("を節約");
			int rw2 = infoSplit.indexOf("配達を選択できません");
			int rw3 = infoSplit.indexOf("ただいまご利用いただけません");
			int rw4 = infoSplit.indexOf("です");
			int removePoint = -1;

			removePoint = (rw1 != -1) ? rw1
					  :	(rw2 != -1) ? rw2
					  :	(rw3 != -1) ? rw3
					  :	(rw4 != -1) ? rw4 : -1;

			if(removePoint != -1) {
				infoSplit.subList(0,removePoint + 1).clear();
			}



			//「•」から「件の評価に基づいています。までの文字列を削除」
			int size =  infoSplit.size();
			int start = infoSplit.indexOf("•");
			int end = -1;
			int nolmalReviewIndex  =  infoSplit.indexOf("件の評価に基づいています。") ;
			int manyReviewsIndex =  infoSplit.indexOf("件以上の評価に基づいています。") ;

			int reviewIndex = (nolmalReviewIndex != -1) ? nolmalReviewIndex
						: (manyReviewsIndex != -1) ? manyReviewsIndex : -1;

			//切り出す位置の最終をレビュー出現箇所に設定するためのポイントを作成
			//レビューが含まれる場合,その位置を取得
			if(reviewIndex != -1) {
				end = reviewIndex + 1;
			}

			//レビューが含まれていない場合start以降のものをすべて削除。
			if(reviewIndex == -1) {
				infoSplit.subList(start,size).clear();
			}

			//レビューが存在し、レビューの後ろに配送料など不要な情報があった際に削除
			if(reviewIndex!= -1 && reviewIndex != size-2 ) {
				infoSplit.subList(end+1,size).clear();
			}

			if(end != -1) {
				infoSplit.subList(start, end).clear();
			}





			//文字を連結
			StringBuilder sb = new StringBuilder();
			for(String str : infoSplit) {
				sb.append(str);
			}

			String shopInfo = sb.toString();

			// ¥, ¥¥ を 「 [ 」で置き換え
			shopInfo = shopInfo.replaceAll("¥", " ");
//			System.out.println(info);
//			System.out.println(shopInfo);

			//営業中の店舗のみ表示
			int confirmation = (rw2 != -1) ? rw2
					  :	(rw3 != -1) ? rw3
					  :	(rw4 != -1) ? rw4 : -1;

			if(confirmation == -1) {

//				System.out.println(info);
				System.out.println(shopInfo);
			}





		}
		//Exceptionを先に記述すると、到達不能なコードがあるとのコンパイルエラーが発生
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

}
