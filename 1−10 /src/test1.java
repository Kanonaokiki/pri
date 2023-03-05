import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test1 {
        public static void main(String[] args) {
                //改行
        	System.out.println("問1");
                //問題1:配列"numa"の要素を全要素を出力しなさい。※i++など利用しないfor文で記述すること
                int[] numa = {1, 2, 3, 4, 5};
                	for (int numa1: numa){
                    System.out.println(numa1);
                	}
                //改行
                System.out.println("問2");
                //問題2:配列"numb"の要素を逆順に出力してください。
                int[] numb = {1, 2, 3, 4, 5};
                	for (int i = numb.length - 1; i >= 0 ; i--) {
                    System.out.println(numb[i]);
                }

                //改行
                System.out.println("問３");
                //問題3:配列"numc"の中で偶数の要素だけを合計した値を出力してください。
                int[] numc = {1, 2, 3, 4, 5};

                int evenSum = 0;

                for (int numc1: numc){
                	if (numc1 % 2 == 0) {
                		evenSum += numc1;
                	}
                }
                System.out.println(evenSum);

                //改行
                System.out.println("問４");

                //問題4:この配列"numd"をコピーした配列名"new_numd"を作り"new_numd"の中身を出力してください。
                int[] numd = {1, 3, 5, 7, 9};

                int[] new_numd= numd;
                for(int new_numd1: new_numd){
                    System.out.println(new_numd1);
                	}
                //改行
                System.out.println("問５");

                //問題5:この配列"nume"を昇順に並び替えて出力しなさい。
                int[] nume = {6, 2, 8, 1, 9};
                Arrays.sort(nume);
                System.out.println(Arrays.toString(nume));
                //改行
                System.out.println("問６");

                //問題6:配列"numf"に要素を1つ(10)追加した配列"new_numf"を作成し出力しなさい。
                int[] numf = {1, 3, 5, 7, 9};

                int[] new_numf = new int[numf.length + 1];
                for (int i = 0; i < numf.length; i++) {
                    new_numf[i] = numf[i];
                }
                new_numf[numf.length] = 10;
                System.out.println(Arrays.toString(new_numf));
                //改行
                System.out.println("問７");

                //問題7:Map"car"に「キー："honda" バリュー"ホンダ",キー："toyota" バリュー："トヨタ",キー："subaru" バリュー："スバル"」の要素を追加してください
                Map<String, String> car = new HashMap<>();
                car.put("honda", "ホンダ");
                car.put("toyota", "トヨタ");
                car.put("subaru", "スバル");

                //改行
                System.out.println("問８");

                //問題8:Map"car"の「キー："toyota"」のバリューを出力してください。
                System.out.println(car.get("toyota"));
                //改行
                System.out.println("問９");

                //問題9:Map"car"のキーとバリューを全て出力してください。※for文で行うこと
                for (Map.Entry<String, String> car1 : car.entrySet()) {
                    String key = car1.getKey();
                    String value = car1.getValue();
                    System.out.println(key + " " + value);
                }
                //改行
                System.out.println("問１０");

                //問題10:Map"car"のキーとバリューを全て出力してください。※forEach文で行うこと
                for (Map.Entry<String, String> car1 : car.entrySet()) {
                    System.out.println(car1.getKey() +" "+ car1.getValue());
                }
        }
}

