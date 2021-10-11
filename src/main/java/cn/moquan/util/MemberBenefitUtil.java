package cn.moquan.util;

public class MemberBenefitUtil {

    public static double getBenefit(int vip){

        if(vip < 50){
            return 1;
        }else if(vip < 100){
            return 0.95;
        }else if(vip < 150){
            return 0.9;
        }else if(vip < 200){
            return 0.85;
        }else if(vip < 250){
            return 0.8;
        }else if(vip < 300){
            return 0.75;
        }else{
            return 0.7;
        }

    }

}
