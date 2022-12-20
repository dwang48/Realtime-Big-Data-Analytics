package mr;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class EnergyValueWritable implements Writable {

    private double out_electricity_total_energy_consumption;

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeDouble(out_electricity_total_energy_consumption);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.out_electricity_total_energy_consumption = dataInput.readDouble();
    }

    public double getOut_electricity_total_energy_consumption() {
        return out_electricity_total_energy_consumption;
    }

    public void setOut_electricity_total_energy_consumption(double out_electricity_total_energy_consumption) {
        this.out_electricity_total_energy_consumption = out_electricity_total_energy_consumption;
    }


    public String toString(){
        return
                this.out_electricity_total_energy_consumption + ",";
    }
}
