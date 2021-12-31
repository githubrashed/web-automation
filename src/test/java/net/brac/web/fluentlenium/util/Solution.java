package net.brac.web.fluentlenium.util;

import net.brac.web.fluentlenium.page.microfinance.member.MemberSetupPage;
import sun.rmi.runtime.NewThreadAction;

public class Solution extends MemberSetupPage {

    public static void main(String[] args)
    {
//        MemberSetupPage memberSetupPage = new MemberSetupPage();
//        memberSetupPage=""
//       String id= memberSetupPage.getId().replaceAll("[^0-9]+", "");
        String s="  Hi How Are You 11  ";
        String s1=s.replaceAll("[^0-9]+", "");
        //*replacing all the value of string except digit by using "[^0-9]+" regex.*
        System.out.println(s1);
//        return s1;
    }

//   public static void main(String[] args) {
//        getNationalId();
//    }
//
//    public static String getNationalId() {
//        return "197" + (long) Math.floor(Math.random() * 9_000_000_000_000_0L) + 1_000_000_000_000_0L;
//    }

    }


//    public static int findIndex(int[] my_array, int t){
////        if (my_array==null)
////            return -1;
////        int len=my_array.length;
////        int i=0;
////        while (i<len){
////            if (my_array[i]==t)
////                return i;
////            else
////                i=i+1;
////        }
////        return -1;
////
////    }
////
////    public static void main(String[] args) {
////        int[] my_array = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
////        System.out.println("Index position of 25 is: " + findIndex(my_array, 14));

//        public static boolean contains(int[] arr, int item) {
//            for (int n : arr) {
//                if (item == n) {
//                    return true;
//                }
//            }
//            return false;
//
//        }
//
//        public static void main(String[] args) {
//            // Write your code here
//
//            int[] my_array1 = {1789, 2035, 1899, 1456, 2013,
//                    1458, 2458, 1254, 1472, 2365,
//                    1456, 2265, 1457, 2456};
//            contains(my_array1, 2013);
//
//        }


//Scanner in = new Scanner(System.in);
//Map<String, Integer> m=new HashMap<String, Integer>();
//int n =in.nextInt();
//in.nextLine();
//for (i=0;i<n;i++){
//    String name=in.nextLine();
//  int  phone=  in.nextInt();
//  m.put(name, phone);
//    while (in.hasNext()){
//        String s=in.nextLine();
//        if (m.containsKey(s)){
//            System.out.println(m.get(s));
//        }
//        else {
//            System.out.println("Not found");
//        }
//    }
//}

//        Scanner scan = new Scanner(System.in);
//        int N=scan.nextInt();
//        List<Integer> list = new ArrayList<>();
//        for (int i=0; i<N; i++){
//            int value=scan.nextInt();
//            list.add(value);
//            System.out.println(value);
//        }
//
//        int Q = scan.nextInt();
//        for (int i=0; i<Q; i++){
//            String action= scan.next();
//            if (action.equals("Insert")){
//                int index=scan.nextInt();
//               int value= scan.nextInt();
//               list.add(index, value);
//            }
//            else {
//                int index=scan.nextInt();
//                list.remove(index);
//            }
//        }
//        for (Integer num: list){
//            System.out.println(num + " ");
//        }
//
//        scan.close();
//    }


//        Scanner sc = new Scanner(System.in);
//        int n =sc.nextInt();
//        String s=String.valueOf(n);
//        if (n==Integer.parseInt(s)){
//            System.out.println("Good job");
//        }
//        else {
//            System.out.println("Wrong answer");
//        }

//        int [] numbers = new int[] {20, 30, 25, 35, -16, 60, -100};
//        int sum=0;
//        for (int i=0; i<numbers.length;i++){
//            sum=sum + numbers[i];
//            double average=sum/numbers.length;
//            System.out.println("Average value of the array elements is : " + average);
//        }

//        Scanner sc = new Scanner(System.in);
////
//        // Use of the next() method
//        String Inpt = sc.next();
//        System.out.println(Inpt);

        // Scanner class
//        Scanner sc = new Scanner(System.in);
////
////        // Use of nextLine() method
////        String Inpt = sc.nextLine();
////        System.out.println(Inpt);




  /*--- solution 2-----


    Scanner sc = new Scanner(System.in);
    String A = sc.next();
    String B = sc.next();
        System.out.println(A.length() + B.length());
    ;

    int i = A.compareTo(B);
        if (i > 0) {
        System.out.println("Yes");
    } else {
        System.out.println("No");
    }
    String atemp1 = A.substring(0, 1).toUpperCase() + A.substring(1);
    String atemp2 = B.substring(0, 1).toUpperCase() + B.substring(1);
        System.out.println(atemp1 + " " + atemp2);


  /*--- solution 2-----
//        int my_array[] = {1, 2;
//        int sum=0;
//        for(int i=1; i<=2;i++ ){
//            sum=sum + i;
//            System.out.println(sum);
//        }

//        for(int i=1; i<=2;i++ ){
//            sum +=i;
//            System.out.println(sum);
//        }

//        for(int i: my_array){
//            sum=sum + i;
//            System.out.println(sum);
//        }



       /*--- solution 1-----
        int [] my_array1 = {1789, 2035, 1899, 1456, 2013};
        String [] my_array2 ={"java", "Python",   "PHP",  "C Programming"};
        System.out.println("Original numeric array :" + Arrays.toString(my_array1) );
        System.out.println("Original String array : "+ Arrays.toString(my_array2));*/


