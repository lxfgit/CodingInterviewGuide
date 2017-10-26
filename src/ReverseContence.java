/**
 * Created by LXF on 2017/8/15.
 */
public class ReverseContence {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
        String s = "";
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (!Character.isLetter(temp)) {
                s = s.replace(temp, ' ');
            }
        }
        String[] str = s.split(" ");
        for (int i = str.length-1; i >=0 ; i--) {
            if (!str[i].trim().equals("")) {
            System.out.print(str[i].trim()+((i==0)?"":" "));
            }
        }
    }
}
