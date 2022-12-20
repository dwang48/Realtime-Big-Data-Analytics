import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class CalculateAverage {

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      System.err.println("Usage: CalculateAverage <input path> <output path>");
      System.exit(-1);
    }
      Job job = Job.getInstance();
      job.setNumReduceTasks(1);
      job.setJarByClass(CalculateAverage.class);
      job.setJobName("Calculate Average");

      FileInputFormat.setInputPaths(job, new Path(args[0]));
      FileOutputFormat.setOutputPath(job, new Path(args[1]));

      job.setMapperClass(CalculateAverageMapper.class);
      job.setReducerClass(CalculateAverageReducer.class);

      job.setOutputKeyClass(Text.class);
      job.setOutputValueClass(Text.class);

      System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}