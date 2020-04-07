package getInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
public class Test{

	/**
	 * split.javaのテスト
	 * @param args
	 */

	public static void main(String[] args) {
//		ArrayList<String> shopInfoList;
//		try {
//			shopInfoList = jsoup2.makeShopInfoList();
//
//
//		for(String info : shopInfoList) {
		String info = "配達を選択できません ￥1,000 以上のご注文で ￥100 を節約 おかゆや Okayuya ¥ • お粥 • 中華料理 • コーヒーとお茶 • ヘルシー • 朝食とブランチ • 日本料理 • グルテンフリー • グルテンフリー フレンドリー 5 つ星のうち 4.6 の評価を獲得した上位のレストラン 200 件以上の評価に基づいています。 4.6(500+)";
			//split()を配列で使うため、Array.asListを使用
			List<String> infoSplit = new ArrayList<>();
			//指定された配列に連動する固定サイズのリストをすため、listの操作が不可。そのため、LinkedListを使用
			infoSplit = new LinkedList( Arrays.asList(info.split(" ")));
			System.out.println("「です」の出現位置は:" + infoSplit.indexOf("です"));
			System.out.println("「ただいまご利用いただけません」の出現位置は:" + infoSplit.indexOf("ただいまご利用いただけません"));
			System.out.println("「を節約」の出現位置は:" + infoSplit.indexOf("を節約"));
			System.out.println("「配達を選択できません」の出現位置は:" + infoSplit.indexOf("配達を選択できません"));
			System.out.println("「¥」の出現位置は:" + infoSplit.indexOf("¥"));
			System.out.println("「件の評価に基づいています。」の出現位置は:" + infoSplit.indexOf("件の評価に基づいています。"));

			int rw3 = infoSplit.indexOf("です");
			int rw2 = infoSplit.indexOf("ただいまご利用いただけません");
			int rw1 = infoSplit.indexOf("を節約");
			int rw4 = infoSplit.indexOf("配達を選択できません");
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

//			//レビューが含まれている場合true
//			boolean includeReview  = nolmalReviewIndex == -1 | manyReviewsIndex == -1;

			//切り出す位置の最終をレビュー出現箇所に設定するためのポイントを作成
			//レビューが含まれる場合,その位置を取得
			if(reviewIndex != -1) {
				end = reviewIndex + 1;
			}

//			//評価が多い場合、件以上の〜と表示されるので、以下のワードでも切り出し位置を指定
//			if(manyReviewsIndex != -1) {
//				end = manyReviewsIndex + 1;
//			}


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

			System.out.println(shopInfo);

		}
}
		//Exceptionを先に記述すると、到達不能なコードがあるとのコンパイルエラーが発生
//		} catch (IOException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}catch (Exception e) {
//			// TODO: handle exception
//		}







//		//デバック用
//		for(String x : infoSplit) {
//			System.out.println(x);
//		}

//		List<String> infoSplit¥ = Arrays.asList(info.split("¥"));
//
//
//		String name = infoSplit¥.get(0).replace("配達を選択できません ", "");
//		String score =infoSplit.get(infoSplit.size()-1);
//		System.out.println(name);
//		System.out.println(score);

