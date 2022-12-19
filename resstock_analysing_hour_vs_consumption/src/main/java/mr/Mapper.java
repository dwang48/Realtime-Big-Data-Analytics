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
        if(tokenList.get(0).equals("in.county")) return;
        List<String> hourList = Utils.tokenize(tokenList.get(2), " ");

        EnergyKeyWritable key1 = new EnergyKeyWritable();
        key1.setBuildingType(new Text(tokenList.get(1)));
        String hh = Utils.tokenize(hourList.get(1), ":").get(0);

        key1.setHour(new Text(hh));
        EnergyValueWritable val1 = new EnergyValueWritable();

        try{
            val1.setOut_electricity_total_energy_consumption(Double.parseDouble(tokenList.get(34)));
            val1.setOut_fuel_oil_total_energy_consumption(Double.parseDouble(tokenList.get(39)));
            val1.setOut_natural_gas_total_energy_consumption(Double.parseDouble(tokenList.get(49)));
            val1.setOut_propane_total_energy_consumption(Double.parseDouble(tokenList.get(54)));
            val1.setOut_site_energy_total_energy_consumption(Double.parseDouble(tokenList.get(56)));
            val1.setOut_wood_total_energy_consumption(Double.parseDouble(tokenList.get(58)));
        }catch (Exception e){
            log.info("Here is the token List: " + tokenList.toString());
        }

        context.write(key1, val1);
    }
}
