package com.lt.tanxin;

public class Dota2Senate649 {
    public String predictPartyVictory(String senate) {
        boolean isRExisting = true;
        boolean isDExisting = true;
        int validR = 0;
        int validD = 0;
        byte[] sen = senate.getBytes();
        while (isRExisting&&isDExisting) {
            isRExisting = false;
            isDExisting = false;
            for (int i = 0; i < sen.length; i++) {
                if (sen[i] == 'R') {
                    if (validD > 0) {
                        sen[i] = 0;
                        validD--;
                    } else {
                        validR++;
                        isRExisting = true;
                    }
                }
                if (sen[i] == 'D') {
                    if (validR > 0) {
                        sen[i] = 0;
                        validR--;
                    } else {
                        validD++;
                        isDExisting = true;
                    }
                }
            }
        }
        return isRExisting ? "Radiant" : "Dire";
    }

//    public String predictPartyVictory(String senate) {
//        boolean isRExisting = true;
//        boolean isDExisting = true;
//        int valid = 0;
//        byte[] sen = senate.getBytes();
//        while (isRExisting && isDExisting) {
//            isRExisting = false;
//            isDExisting = false;
//            for (int i = 0; i < sen.length; i++) {
//                if (sen[i] == 'R') {
//                    if (valid < 0) {
//                        sen[i] = 0;
//                        valid++;
//                    } else {
//                        isRExisting = true;
//                        valid++;
//                    }
//                }
//                if (sen[i] == 'D') {
//                    if (valid > 0) {
//                        sen[i] = 0;
//                        valid--;
//                    } else {
//                        isDExisting = true;
//                        valid--;
//                    }
//                }
//            }
//        }
//        return isRExisting ? "Radiant" : "Dire";
//    }



}
