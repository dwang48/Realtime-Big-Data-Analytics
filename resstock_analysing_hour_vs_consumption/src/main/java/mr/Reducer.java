package mr;
import java.io.IOException;

public class Reducer
    extends org.apache.hadoop.mapreduce.Reducer<EnergyKeyWritable, EnergyValueWritable, EnergyKeyWritable, EnergyValueWritable>{
    @Override
    protected void reduce(EnergyKeyWritable key, Iterable<EnergyValueWritable> values, Context context)
            throws IOException, InterruptedException {
        EnergyValueWritable newValue = new EnergyValueWritable();
        double out_electricity_total_energy_consumption_new = 0;
        double out_fuel_oil_total_energy_consumption_new  = 0;
        double out_natural_gas_total_energy_consumption_new  = 0;
        double out_propane_total_energy_consumption_new  = 0;
        double out_site_energy_total_energy_consumption_new  = 0;
        double out_wood_total_energy_consumption_new  = 0;

        for(EnergyValueWritable oldValue : values){
            out_electricity_total_energy_consumption_new  += oldValue.getOut_electricity_total_energy_consumption();
            out_fuel_oil_total_energy_consumption_new  += oldValue.getOut_fuel_oil_total_energy_consumption();
            out_natural_gas_total_energy_consumption_new  += oldValue.getOut_natural_gas_total_energy_consumption();
            out_propane_total_energy_consumption_new  += oldValue.getOut_propane_total_energy_consumption();
            out_site_energy_total_energy_consumption_new  += oldValue.getOut_site_energy_total_energy_consumption();
            out_wood_total_energy_consumption_new  += oldValue.getOut_wood_total_energy_consumption();
        }

        newValue.setOut_electricity_total_energy_consumption(out_electricity_total_energy_consumption_new);
        newValue.setOut_fuel_oil_total_energy_consumption(out_fuel_oil_total_energy_consumption_new);
        newValue.setOut_natural_gas_total_energy_consumption(out_natural_gas_total_energy_consumption_new);
        newValue.setOut_propane_total_energy_consumption(out_propane_total_energy_consumption_new);
        newValue.setOut_site_energy_total_energy_consumption(out_site_energy_total_energy_consumption_new);
        newValue.setOut_wood_total_energy_consumption(out_wood_total_energy_consumption_new);
        context.write(key, newValue);
    }
}
