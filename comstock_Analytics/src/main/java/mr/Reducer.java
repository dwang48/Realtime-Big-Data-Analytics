package mr;
import java.io.IOException;

public class Reducer
    extends org.apache.hadoop.mapreduce.Reducer<EnergyKeyWritable, EnergyValueWritable, EnergyKeyWritable, EnergyValueWritable>{
    @Override
    protected void reduce(EnergyKeyWritable key, Iterable<EnergyValueWritable> values, Context context)
            throws IOException, InterruptedException {
        EnergyValueWritable newValue = new EnergyValueWritable();
        double out_electricity_total_energy_consumption_new = 0;

        for(EnergyValueWritable oldValue : values){
            out_electricity_total_energy_consumption_new  += oldValue.getOut_electricity_total_energy_consumption();
        }

        newValue.setOut_electricity_total_energy_consumption(out_electricity_total_energy_consumption_new);
        context.write(key, newValue);
    }
}
