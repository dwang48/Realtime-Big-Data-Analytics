//import java.io.IOException;
//
//import mr.EnergyKeyWritable;
//import mr.EnergyValueWritable;
//import mr.Mapper;
//import org.apache.hadoop.io.LongWritable;
//import org.apache.hadoop.io.Text;
//import org.apache.hadoop.mrunit.mapreduce.MapDriver;
//import org.junit.Test;
//
//public class MapperTest {
//    @Test
//    public void testMapper() throws IOException, InterruptedException {
//        String inputStr = "G36000100,Multi-Family with 2 - 4 Units,2018-01-01 00:15:00,24,5811.144,0.000312535050513,0.0008359587191149,0.0,0.0,0.0,0.0,0.0,0.0,0.0027107557487304,0.0016921562437042,0.0034808438401425,0.0351757038711351,0.0006104064930529,0.0,0.3981651273812539,0.0,0.0,0.0,0.0,0.0051298387303694,0.0475914540288698,0.0,0.0,0.0,0.0013938941375219,-0.0,0.000312535050513,0.0,0.0103204262585322,0.5093574161823395,0.0,9.772924484999584e-05,0.0015280513840352,0.2685896166805523,0.2685896166805523,0.0,0.0,0.0,0.0015851941444583,0.0002462837940057,1.813454796358948,0.0,0.0,0.0,1.8301123993063213,0.0148261250089095,0.0,0.0,0.0986596231652348,0.0986596231652348,0.0,2.7067201666493865,0.0,0.0\n";
//
//        Text value = new Text(inputStr);
//        EnergyKeyWritable expectedKey = new EnergyKeyWritable();
//        EnergyValueWritable expectedValue = new EnergyValueWritable();
//
//        expectedKey.setBuildingType(new Text("Multi-Family with 2 - 4 Units"));
//        expectedKey.setHour(new Text("2018-01-01"));
//
//        expectedValue.setOut_electricity_total_energy_consumption(Double.parseDouble("0.5093574161823395"));
//        expectedValue.setOut_fuel_oil_total_energy_consumption(Double.parseDouble("0.2685896166805523"));
//        expectedValue.setOut_natural_gas_total_energy_consumption(Double.parseDouble("1.8301123993063213"));
//        expectedValue.setOut_propane_total_energy_consumption(Double.parseDouble("0.0986596231652348"));
//        expectedValue.setOut_site_energy_total_energy_consumption(Double.parseDouble("2.7067201666493865"));
//        expectedValue.setOut_wood_total_energy_consumption(Double.parseDouble("0"));
//
//
//        new MapDriver<LongWritable, Text, EnergyKeyWritable, EnergyValueWritable>()
//                .withMapper(new Mapper())
//                .withInput(new LongWritable(0), value)
//                .withOutput(expectedKey, expectedValue)
//                .runTest();
//    }
//}
