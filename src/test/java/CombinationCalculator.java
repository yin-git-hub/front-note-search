import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CombinationCalculator {
    static int i = 0;

    public CombinationCalculator() throws IOException {
    }

    public static List<List<Double>> generateCombinations(Double[] nums) throws IOException {
        List<List<Double>> result = new ArrayList<>();
        List<Double> currentCombination = new ArrayList<>();
        generate(nums, 0, currentCombination);
        return result;
    }
    static String filename = "output.txt"; // 指定要写入的文件名
    static BufferedWriter writer;

    static {
        try {
            writer = new BufferedWriter(new FileWriter(filename, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generate(Double[] nums, int start, List<Double> currentCombination) throws IOException {


        ArrayList<Double> combination = new ArrayList<>(currentCombination);
        i++;
//        System.out.println("这是第"+i+"个组合");
        double sum = 0.0;
        for (Double num : combination) {
            sum += num;
        }

        if(-1440D<sum&&sum<-1438D){

            writer.write("这是第"+(i+1)+"个结果：：："+ sum + ":::" +combination+"\n\r");

            System.out.println("这是第"+(i+1)+"个结果：：："+ sum + ":::" +combination);
        }
        // 将数据写入文件

        for (int i = start; i < nums.length; i++) {
            currentCombination.add(nums[i]);
            generate(nums, i + 1, currentCombination);
            currentCombination.remove(currentCombination.size() - 1);

        }
    }


//    public static void main(String[] args) {
//        Double[] nums = {1D, 2D, 3D, 4D};
//        List<List<Double>> combinations = generateCombinations(nums);
//
//        System.out.println("All combinations:"+combinations.size());
//        for (List<Double> combination : combinations) {
//            System.out.println(combination);
//        }
//    }
}
