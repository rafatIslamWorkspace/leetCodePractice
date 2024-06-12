//package random;
//
//import java.io.*;
//import java.math.*;
//import java.security.*;
//import java.text.*;
//import java.util.*;
//import java.util.concurrent.*;
//import java.util.regex.*;
//
//
//
//class mostBalanced {
//
//    /*
//     * Complete the 'mostBalancedPartition' function below.
//     *
//     * The function is expected to return an INTEGER.
//     * The function accepts following parameters:
//     *  1. INTEGER_ARRAY parent
//     *  2. INTEGER_ARRAY files_size
//     */
//
//    public static int mostBalancedPartition(List<Integer> parent, List<Integer> files_size) {
//    // Write your code here
//    	return 0;
//    }
//    
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int parentCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> parent = new ArrayList<>();
//
//        for (int i = 0; i < parentCount; i++) {
//            int parentItem = Integer.parseInt(bufferedReader.readLine().trim());
//            parent.add(parentItem);
//        }
//
//        int files_sizeCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> files_size = new ArrayList<>();
//
//        for (int i = 0; i < files_sizeCount; i++) {
//            int files_sizeItem = Integer.parseInt(bufferedReader.readLine().trim());
//            files_size.add(files_sizeItem);
//        }
//
//        int result = Result.mostBalancedPartition(parent, files_size);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//
//}
//
//
//
