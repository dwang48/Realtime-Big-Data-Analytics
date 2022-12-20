import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FindMinMapper
    extends Mapper<LongWritable, Text, Text, Text> {
  
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    if (key.get() == 0)
        return;
    String line = value.toString();
    String[] parts = line.split(",");
    String date_time = parts[0];
    // String[] day_and_time = date_time.split("\\s+");
    // String day = day_and_time[0];
    StringBuilder sb = new StringBuilder();
    for( int i = 1; i < parts.length; i++) {
    	String token = parts[i];
    	sb.append(token);
    	if (i < parts.length)
    		sb.append(",");
    }

    // double PR = Double.parseDouble(parts[parts.length-1]);
    // String originalOutlinks = "";
    // for( int i = 1; i < parts.length - 1; i++) {
    //   double newPR = PR / (parts.length - 2);
    //   String newValue = parts[0] + "," + newPR;
    //   originalOutlinks = originalOutlinks + parts[i].toString() + " ";
    //   context.write(new Text(parts[i]), new Text(newValue));
    // }
    context.write(new Text(date_time), new Text(sb.toString()));
  }
}