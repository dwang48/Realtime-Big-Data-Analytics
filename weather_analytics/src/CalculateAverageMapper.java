import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CalculateAverageMapper
    extends Mapper<LongWritable, Text, Text, Text> {
  
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    if (key.get() == 0)
        return;
    String fileName = ((FileSplit) context.getInputSplit()).getPath().getName();
    String[] gisjoinsplit = fileName.split("\\_");
    String gisjoin = gisjoinsplit[0];
    String line = value.toString();
    String[] parts = line.split(",");
    String date_time = parts[0];
    String[] day_and_time = date_time.split("\\s+");
    String day = day_and_time[0];
    String new_key = gisjoin + "," + day;
    StringBuilder sb = new StringBuilder();
    for( int i = 1; i < parts.length; i++) {
    	String token = parts[i];
    	sb.append(token);
    	if (i < parts.length)
    		sb.append(",");
    }

    context.write(new Text(gisjoin), new Text(sb.toString()));
  }
}