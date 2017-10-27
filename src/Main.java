import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("F:\\tTanchiBeginnerDataSet\\ccf_offline_stage1_train.csv"));//换成你的文件名
            reader.readLine();//第一行信息，为标题信息，不用，如果需要，注释掉
            String line = null;
            List<List<String>> all = new ArrayList<>();
            int maxlength = 0;
            int positive = 0;
            Map<String, List<Integer>> map = new HashMap<>();
            while((line=reader.readLine())!=null&&maxlength<1000000){
                String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
                if(item[item.length-1].equals("null")||item[2].equals("null")) continue;

                if(!map.containsKey(item[0])){
                    map.put(item[0], new ArrayList<Integer>());
                    map.get(item[0]).add(Util.countdays(item[item.length-2],item[item.length-1]));
                }
                else{
                    map.get(item[0]).add(Util.countdays(item[item.length-2],item[item.length-1]));
                }
                maxlength++;
            }
            System.out.print(map);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}
