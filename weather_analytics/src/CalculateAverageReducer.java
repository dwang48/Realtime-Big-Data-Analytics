import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CalculateAverageReducer
    extends Reducer<Text, Text, Text, Text> {
  
  @Override
  public void reduce(Text key, Iterable<Text> values, Context context)
      throws IOException, InterruptedException {
    Double count = Double.valueOf(0);
    Double temperature_total = Double.valueOf(0);
    Double relative_humidity = Double.valueOf(0);
    Double wind_speed = Double.valueOf(0);
    Double wind_direction = Double.valueOf(0);
    Double global_horizontal_radiation = Double.valueOf(0);
    Double direct_normal_radiation = Double.valueOf(0);
    Double diffuse_horizontal_radiation = Double.valueOf(0);
    String resultStr = "";

    for (Text perValue : values){
      String[] parts = perValue.toString().split(",");
      count += 1;
      temperature_total += Double.parseDouble(parts[0]);
      relative_humidity += Double.parseDouble(parts[1]);
      wind_speed += Double.parseDouble(parts[2]);
      wind_direction += Double.parseDouble(parts[3]);
      global_horizontal_radiation += Double.parseDouble(parts[4]);
      direct_normal_radiation += Double.parseDouble(parts[5]);
      diffuse_horizontal_radiation += Double.parseDouble(parts[6]);
    }
    temperature_total /= count;
    relative_humidity /= count;
    wind_speed /= count;
    wind_direction /= count;
    global_horizontal_radiation /= count;
    direct_normal_radiation /= count;
    diffuse_horizontal_radiation /= count;

    resultStr += temperature_total + " " + relative_humidity + " " + wind_speed + " " + wind_direction + " " + global_horizontal_radiation + " " + direct_normal_radiation + " " + diffuse_horizontal_radiation;
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