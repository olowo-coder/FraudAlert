import java.util.Arrays;

public class FraudAlertCheck {
    public static void main(String[] args) {
        String days = "9 5";
        String trans = "2 3 4 2 3 6 8 4 5";
        int numberOfAlert = 0;

        String[] dayArr = days.split(" ");
        int period = Integer.parseInt(dayArr[0]);
        int check = Integer.parseInt(dayArr[1]);
        String[] transArr = trans.split(" ");

        for (int i = 0; i < transArr.length; i++) {
            if(check+i == transArr.length) break;
            String[] slicedArray = Arrays.copyOfRange(transArr, i, check + i);
            float val = findMedian(slicedArray);
            if(Float.parseFloat(transArr[check+i]) >= (2*val)){
                numberOfAlert++;
            }
        }
        System.out.println(numberOfAlert);
    }
    static float findMedian(String[] strArr){
        Arrays.sort(strArr);
        int len = strArr.length;
        if( len % 2 != 0){
            return Float.parseFloat(strArr[len/2]);
        }
        int first = len/2 - 1;
        int second = (len/2);
        float firstVal = Float.parseFloat(strArr[first]);
        float secVal = Float.parseFloat(strArr[second]);
        return (firstVal + secVal) / 2;
    }
}
