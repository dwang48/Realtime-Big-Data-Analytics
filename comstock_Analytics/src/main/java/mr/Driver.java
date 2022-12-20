package mr;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.net.URI;

public class Driver extends Configured implements Tool {
    @Override
    public int run(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.printf("Usage: %s [generic options] <input> <output>\n",
                    getClass().getSimpleName());
            ToolRunner.printGenericCommandUsage(System.err);
            return -1;
        }

        Job job = Job.getInstance();
        job.setJarByClass(getClass());

        FileInputFormat.setInputDirRecursive(job, true);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setMapperClass(Mapper.class);
        job.setReducerClass(Reducer.class);
        job.setCombinerClass(Reducer.class);
        job.setNumReduceTasks(1);

        job.setOutputKeyClass(EnergyKeyWritable.class);
        job.setOutputValueClass(EnergyValueWritable.class);
        job.setMapOutputKeyClass(EnergyKeyWritable.class);
        job.setMapOutputValueClass(EnergyValueWritable.class);

        job.setNumReduceTasks(1);
        return job.waitForCompletion(true) ? 0 : 1;
    }

    public static void main(String[] args) throws Exception {
        int exitCode = 0;

        exitCode = ToolRunner.run(new Driver(), args);

        System.exit(exitCode);
    }
}
