import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FindMinReducer
    extends Reducer<Text, Text, Text, Text> {
  
  @Override
  public void reduce(Text key, Iterable<Text> values, Context context)
      throws IOException, InterruptedException {
    Double temperature_min = Double.valueOf(10000);
    Double relative_humidity_min = Double.valueOf(10000);
    Double wind_speed_min = Double.valueOf(10000);
    Double wind_direction_min = Double.valueOf(10000);
    Double global_horizontal_radiation_min = Double.valueOf(10000);
    Double direct_normal_radiation_min = Double.valueOf(10000);
    Double diffuse_horizontal_radiation_min = Double.valueOf(10000);
    String resultStr = "";

    for (Text perValue : values){
      String[] parts = perValue.toString().split(",");
      temperature_min = Math.min(temperature_min, Double.parseDouble(parts[0]));
      relative_humidity_min = Math.min(relative_humidity_min, Double.parseDouble(parts[1]));
      wind_speed_min = Math.min(wind_speed_min, Double.parseDouble(parts[2]));
      wind_direction_min = Math.min(wind_direction_min, Double.parseDouble(parts[3]));
      global_horizontal_radiation_min = Math.min(global_horizontal_radiation_min, Double.parseDouble(parts[4]));
      direct_normal_radiation_min = Math.min(direct_normal_radiation_min,Double.parseDouble(parts[5]));
      diffuse_horizontal_radiation_min = Math.min(diffuse_horizontal_radiation_min, Double.parseDouble(parts[6]));
    }

    resultStr += temperature_min + " " + relative_humidity_min + " " + wind_speed_min + " " + wind_direction_min + " " + global_horizontal_radiation_min + " " + direct_normal_radiation_min + " " + diffuse_horizontal_radiation_min;
    // Double PageRank = Double.valueOf(0);
    // String resultStr = "";
    // for (Text perValue : values){
    //   if (perValue.toString().contains(",")){
    //     String[] parts = perValue.toString().split(",");
    //     PageRank += Double.parseDouble(parts[1]);
    //   }
    //   else {
    //      resultStr += perValue.toString();
    //   }
    // }
    // resultStr += " " + PageRank.toString();
    context.write(key, new Text(resultStr));
  }
}