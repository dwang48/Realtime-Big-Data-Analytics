package mr;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.List;

public class Mapper
        extends org.apache.hadoop.mapreduce.Mapper<LongWritable, Text, EnergyKeyWritable, EnergyValueWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        Logger log = Logger.getLogger(Mapper.class.getName());
        String line = value.toString();
        List<String> tokenList = Utils.tokenize(line, ",");
        if(tokenList.get(0).equals("county")) return;
        List<String> hourList = Utils.tokenize(tokenList.get(2), " ");

        EnergyKeyWritable key1 = new EnergyKeyWritable();
        key1.setBuildingType(new Text(tokenList.get(1)));
        String hh = Utils.tokenize(hourList.get(1), ":").get(0);
        //setting GISJOIN number
        key1.setGnum(new Text(tokenList.get(0)));
        String t = Utils.tokenize(tokenList.get(2)," ").get(0);
        key1.setTime(new Text(t));
        key1.setHour(new Text(hh));
        EnergyValueWritable val1 = new EnergyValueWritable();

        try{
            val1.setOut_electricity_total_energy_consumption(Double.parseDouble(tokenList.get(24)));
        }catch (Exception e){
            log.info("Token List: " + tokenList.toString());
        }

        context.write(key1, val1);
    }
}
