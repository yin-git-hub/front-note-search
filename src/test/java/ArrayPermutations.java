import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CombinationGenerator {

    public static List<Double> sumOfCombinations(List<List<Double>> combinations) {
        List<Double> sums = new ArrayList<>();
        for (int i = 0; i < combinations.size(); i++) {
            List<Double> combination = combinations.get(i);
            double sum = 0.0;
            for (Double num : combination) {
                sum += num;
            }
            sums.add(sum);
            String filename = "output.txt"; // 指定要写入的文件名

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {


                // 将数据写入文件
                writer.write("这是第"+(i+1)+"个结果：：："+ sum + ":::" +combination+"\n\r");

                System.out.println("Data has been written to " + filename);
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
            System.out.println("这是第"+(i+1)+"个结果：：："+ sum + ":::" +combination);
        }

        return sums;
    }


    public static void main(String[] args) throws IOException {
        Double[] nums = {
                -89759.47D,
                        -45918.7D,
                        -45185.96D,
                        -43076.93D,
                        -15647.73D,
                        -9992.03D,
                        -3017.46D,
                        -2683.75D,
                        -715.67D,
                        -490.46D,
                        -397.39D,
                        -293.16D,
                        -243.04D,
                        -176.06D,
                        -160.74D,
                        -44.4D,
                        -26.91D,
                        -22.84D,
                        -16.98D,
                        -11.78D,
                        -6.4D,
                        -5.52D,
                        -3.88D,
                        -3.49D,
                        -2.73D,
                        -0.56D,
                        -0.35D,
                        -0.31D,
                0.31D,
                0.56D,
                3.49D,
                5.52D,
                5.99D,
                17.33D,
                22.84D,
                31.16D,
                40.37D,
                64.82D,
                135.74D,
                175.25D,
                186.57D,
                293.16D,
                541.61D,
                715.67D,
                1000.35D,
                1986.98D,
                5738.02D,
                15681.04D,
                60903.22D,
                215698.33D
        };
        List<List<Double>> lists = CombinationCalculator.generateCombinations(nums);
        System.out.println("共有"+lists.size()+"种组合方式");


//        sumOfCombinations(lists);
    }
}
