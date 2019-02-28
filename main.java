public class Main {

    public static void main(String[] args) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String formula = "=TRIM(";
        int currChar = 18;
        int loopTimes = -1;

        char endCell1 = 'B';
        char endCell2 = 'K';

        for(int i=0; i < 45; i++) {
            String toAdd = "";

            if (loopTimes == -1) {
                toAdd += ("IF(" + alphabet.charAt(currChar)
                        + Integer.toString(2)
                        + "=\"Y\", CONCATENATE($"
                        + alphabet.charAt(currChar)
                        + "$"
                        + Integer.toString(1)
                        + ",\",\"),\"\")&\" \"&");
            } else if (alphabet.charAt(currChar)==endCell2 && alphabet.charAt(loopTimes)==endCell1) {
                toAdd += ("IF("
                        + alphabet.charAt(loopTimes)
                        + alphabet.charAt(currChar)
                        + Integer.toString(2)
                        + "=\"Y\", CONCATENATE($"
                        + alphabet.charAt(loopTimes)
                        + "$"
                        + alphabet.charAt(currChar)
                        + Integer.toString(1)
                        + ",\",\"),\"\")");
            } else {
                toAdd += ("IF("
                        + alphabet.charAt(loopTimes)
                        + alphabet.charAt(currChar)
                        + Integer.toString(2)
                        + "=\"Y\", CONCATENATE($"
                        + alphabet.charAt(loopTimes)
                        + "$"
                        + alphabet.charAt(currChar)
                        + Integer.toString(1)
                        + ",\",\"),\"\")&\" \"&");
            }

            formula = formula.concat(toAdd);

            currChar++;

            if (currChar == 26) {
                currChar = 0;
                loopTimes++;
            }
        }

        formula += ")";

        System.out.println(formula);
//        =TRIM(IF(S2="Y", CONCATENATE($S$1,","),"")&" "&IF(T2="Y", CONCATENATE($T$1,","),"")&" "&IF(U2="Y", CONCATENATE($U$1,","),"")&" "&IF(V2="Y", CONCATENATE($V$1,","),"")&" "&IF(W2="Y", CONCATENATE($W$1,","),"")&" "&IF(X2="Y", CONCATENATE($X$1,","),"")&" "&IF(Y2="Y", CONCATENATE($Y$1,","),"")&" "&IF(Z2="Y", CONCATENATE($Z$1,","),"")&" "&IF(AA2="Y", CONCATENATE($A$A1,","),"")&" "&IF(AB2="Y", CONCATENATE($A$B1,","),"")&" "&IF(AC2="Y", CONCATENATE($A$C1,","),"")&" "&IF(AD2="Y", CONCATENATE($A$D1,","),"")&" "&IF(AE2="Y", CONCATENATE($A$E1,","),"")&" "&IF(AF2="Y", CONCATENATE($A$F1,","),"")&" "&IF(AG2="Y", CONCATENATE($A$G1,","),"")&" "&IF(AH2="Y", CONCATENATE($A$H1,","),"")&" "&IF(AI2="Y", CONCATENATE($A$I1,","),"")&" "&IF(AJ2="Y", CONCATENATE($A$J1,","),"")&" "&IF(AK2="Y", CONCATENATE($A$K1,","),"")&" "&IF(AL2="Y", CONCATENATE($A$L1,","),"")&" "&IF(AM2="Y", CONCATENATE($A$M1,","),"")&" "&IF(AN2="Y", CONCATENATE($A$N1,","),"")&" "&IF(AO2="Y", CONCATENATE($A$O1,","),"")&" "&IF(AP2="Y", CONCATENATE($A$P1,","),"")&" "&IF(AQ2="Y", CONCATENATE($A$Q1,","),"")&" "&IF(AR2="Y", CONCATENATE($A$R1,","),"")&" "&IF(AS2="Y", CONCATENATE($A$S1,","),"")&" "&IF(AT2="Y", CONCATENATE($A$T1,","),"")&" "&IF(AU2="Y", CONCATENATE($A$U1,","),"")&" "&IF(AV2="Y", CONCATENATE($A$V1,","),"")&" "&IF(AW2="Y", CONCATENATE($A$W1,","),"")&" "&IF(AX2="Y", CONCATENATE($A$X1,","),"")&" "&IF(AY2="Y", CONCATENATE($A$Y1,","),"")&" "&IF(AZ2="Y", CONCATENATE($A$Z1,","),"")&" "&IF(BA2="Y", CONCATENATE($B$A1,","),"")&" "&IF(BB2="Y", CONCATENATE($B$B1,","),"")&" "&IF(BC2="Y", CONCATENATE($B$C1,","),"")&" "&IF(BD2="Y", CONCATENATE($B$D1,","),"")&" "&IF(BE2="Y", CONCATENATE($B$E1,","),"")&" "&IF(BF2="Y", CONCATENATE($B$F1,","),"")&" "&IF(BG2="Y", CONCATENATE($B$G1,","),"")&" "&IF(BH2="Y", CONCATENATE($B$H1,","),"")&" "&IF(BI2="Y", CONCATENATE($B$I1,","),"")&" "&IF(BJ2="Y", CONCATENATE($B$J1,","),"")&" "&IF(BK2="Y", CONCATENATE($B$K1,","),""))

    }
}
