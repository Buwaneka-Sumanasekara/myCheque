package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author BUWANEKA
 */
public class Cheque {

    public String generateFormat(String txt) {
        int length = txt.length();
        int sepCount = length / 3;

//         String txtRev = new StringBuffer(txt).reverse().toString();
        String Format = "";
        if (sepCount > 1) {
            for (int i = 0; i < sepCount; i++) {
                if (i == sepCount - 1) {
                    Format += "###";
                } else {
                    Format += "###,";
                }

            }
        } else {
            Format = "###,###";
        }
        return Format;
    }

    public String getWords(String text) {
        String Word = "";
        if (text.length() <= 3) {
            if (text.length() < 3) {
                if(text.equals("0")){
                   Word="Zero"; 
                }else{
                Word = getNumberName_thrSep(-1, text);
                }
            } else {
                Word = getNumberName_thrSep(0, text);
            }

        } else {
            String[] split = text.split(",");

            int j = split.length - 1;
            for (int i = 0; i < split.length; i++) {
                //System.out.println(split[i]);
                if(Integer.parseInt(split[i])>0){
                Word += getNumberName_thrSep(j, split[i]) + " ";
                }
                j--;
            }
        }
        return Word;
    }

    private String getNumberName_thrSep(int decimalPoint, String Num) {
        String Name = "";

        if (Num.length() == 3) {
            //3 digts
            String lasttwo = Num.substring(1, Num.length());
            if (Integer.parseInt(lasttwo) <= 19) {
                String words_less19 = getWords_less19("" + Integer.parseInt(lasttwo));

                if (decimalPoint == 0) {
                    if (words_less19.equals("")) {
                        String F=getWords_less19("" + Num.toCharArray()[0]);
                        if (F.equals("")) {
                            Name =   " " ;
                        }else{
                              Name =  F+ " " + decimalPlaceName(decimalPoint) + words_less19;
                        }
                    } else {
                        Name = getWords_less19("" + Num.toCharArray()[0]) + " " + decimalPlaceName(decimalPoint) + "  and " + words_less19;
                    }
                } else {
                    if (words_less19.equals("")) {
                        Name = getWords_less19("" + Num.toCharArray()[0]) + " " + decimalPlaceName(0) + " " + decimalPlaceName(decimalPoint) + words_less19;
                    } else {
                        Name = getWords_less19("" + Num.toCharArray()[0]) + " " + decimalPlaceName(0) + " and " + words_less19 + " " + decimalPlaceName(decimalPoint);
                    }
                }
            } else {
                String First_place = getWords_less19("" + Num.toCharArray()[0]);
                String Second_place = getWords_less19("" + Num.toCharArray()[1]);
                String Third_place = getWords_less19("" + Num.toCharArray()[2]);
                if (decimalPoint > 0) {
                    Name = First_place + " " + decimalPlaceName(0) + " and " + getTenthPlace("" + Num.toCharArray()[1]) + " " + Third_place + " " + decimalPlaceName(decimalPoint);
                } else {
                    Name = First_place + " " + decimalPlaceName(0) + " and " + getTenthPlace("" + Num.toCharArray()[1]) + " " + Third_place;
                }
            }
        } else {
            if (Integer.parseInt(Num) > 19) {
                String First_place = getWords_less19("" + Num.toCharArray()[0]);
                String Second_place = getWords_less19("" + Num.toCharArray()[1]);

                Name += getTenthPlace("" + Num.toCharArray()[0]) + " " + Second_place + " " + decimalPlaceName(decimalPoint);

            } else {

                Name += getWords_less19(Num) + " " + decimalPlaceName(decimalPoint);
            }

        }
        return Name;
    }

    private String decimalPlaceName(int decimalPlace) {
        String N = "";

        switch (decimalPlace) {
            case 0:
                N = "Hundered";
                break;
            case 1:
                N = "Thousand";
                break;
            case 2:
                N = "Milion";
                break;
            case 3:
                N = "Bilion";
                break;
            case 4:
                N = "Thirilion";
                break;
            default:
                N = "";
                break;

        }
        return N;
    }

    private String getWords_less19(String txt) {
        String W = "";

        switch (txt) {
              
            case "1":
                W = "one";
                break;
            case "2":
                W = "two";
                break;
            case "3":
                W = "three";
                break;
            case "4":
                W = "four";
                break;
            case "5":
                W = "five";
                break;
            case "6":
                W = "six";
                break;
            case "7":
                W = "seven";
                break;
            case "8":
                W = "eight";
                break;
            case "9":
                W = "nine";
                break;
            case "10":
                W = "ten";
                break;
            case "11":
                W = "eleven";
                break;
            case "12":
                W = "twelve";
                break;
            case "13":
                W = "thirteen";
                break;
            case "14":
                W = "fourteen";
                break;
            case "15":
                W = "fifteen";
                break;
            case "16":
                W = "sixteen";
                break;
            case "17":
                W = "seventeen";
                break;
            case "18":
                W = "eighteen";
                break;
            case "19":
                W = "nineteen";
                break;
            default:
                W = "";

        }
        return W;
    }

    private String getTenthPlace(String First_place) {
        String M = "";
        switch (First_place) {
            case "2":
                M = "twenty";
                break;
            case "3":
                M = "Thirty";
                break;
            case "4":
                M = "Fourty";
                break;
            case "5":
                M = "Fifty";
                break;
            case "6":
                M = "Sixty";
                break;
            case "7":
                M = "Seventy";
                break;
            case "8":
                M = "Eigthy";
                break;
            case "9":
                M = "Ninety";
                break;
            default:
                M = "";
                break;
        }
        return M;
    }

//    public static void main(String[] args) {
//        System.out.println(new Cheque().getWords("10,100,000"));
//    }

}
