import java.util.Arrays;

public class BOJ_4673 {
    public static void main(String[] args) {
        boolean[] check = new boolean[10001];
        //셀프넘버 : 생성자가 없는 숫자
        Arrays.fill(check, true);       //true : 생성자 없음     //false : 생성자 있음

        for(int i=1; i< check.length; i++){
            int x = self_num(i);
            if(x <= 10000){
                check[x] = false;
            }
        }

        //출력
        for(int i=1; i<check.length; i++){
            if(check[i]){
                System.out.println(i);
            }
        }
    }

    public static int self_num(int x){
        int self = x;
        while(x != 0){
            self += (x%10);
            x /= 10;
        }
        return self;
    }
}
