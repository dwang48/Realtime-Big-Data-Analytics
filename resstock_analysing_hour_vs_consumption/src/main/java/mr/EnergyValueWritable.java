package mr;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class EnergyValueWritable implements Writable {

    private double out_electricity_total_energy_consumption;
    private double out_fuel_oil_total_energy_consumption;
    private double out_natural_gas_total_energy_consumption;
    private double out_propane_total_energy_consumption;
    private double out_site_energy_total_energy_consumption;
    private double out_wood_total_energy_consumption;

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeDouble(out_electricity_total_energy_consumption);
        dataOutput.writeDouble(out_fuel_oil_total_energy_consumption);
        dataOutput.writeDouble(out_natural_gas_total_energy_consumption);
        dataOutput.writeDouble(out_propane_total_energy_consumption);
        dataOutput.writeDouble(out_site_energy_total_energy_consumption);
        dataOutput.writeDouble(out_wood_total_energy_consumption);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.out_electricity_total_energy_consumption = dataInput.readDouble();
        this.out_fuel_oil_total_energy_consumption = dataInput.readDouble();
        this.out_natural_gas_total_energy_consumption = dataInput.readDouble();
        this.out_propane_total_energy_consumption = dataInput.readDouble();
        this.out_site_energy_total_energy_consumption = dataInput.readDouble();
        this.out_wood_total_energy_consumption = dataInput.readDouble();

    }

    public double getOut_electricity_total_energy_consumption() {
        return out_electricity_total_energy_consumption;
    }

    public void setOut_electricity_total_energy_consumption(double out_electricity_total_energy_consumption) {
        this.out_electricity_total_energy_consumption = out_electricity_total_energy_consumption;
    }

    public double getOut_fuel_oil_total_energy_consumption() {
        return out_fuel_oil_total_energy_consumption;
    }

    public void setOut_fuel_oil_total_energy_consumption(double out_fuel_oil_total_energy_consumption) {
        this.out_fuel_oil_total_energy_consumption = out_fuel_oil_total_energy_consumption;
    }

    public double getOut_natural_gas_total_energy_consumption() {
        return out_natural_gas_total_energy_consumption;
    }

    public void setOut_natural_gas_total_energy_consumption(double out_natural_gas_total_energy_consumption) {
        this.out_natural_gas_total_energy_consumption = out_natural_gas_total_energy_consumption;
    }

    public double getOut_propane_total_energy_consumption() {
        return out_propane_total_energy_consumption;
    }

    public void setOut_propane_total_energy_consumption(double out_propane_total_energy_consumption) {
        this.out_propane_total_energy_consumption = out_propane_total_energy_consumption;
    }

    public double getOut_site_energy_total_energy_consumption() {
        return out_site_energy_total_energy_consumption;
    }

    public void setOut_site_energy_total_energy_consumption(double out_site_energy_total_energy_consumption) {
        this.out_site_energy_total_energy_consumption = out_site_energy_total_energy_consumption;
    }

    public double getOut_wood_total_energy_consumption() {
        return out_wood_total_energy_consumption;
    }

    public void setOut_wood_total_energy_consumption(double out_wood_total_energy_consumption) {
        this.out_wood_total_energy_consumption = out_wood_total_energy_consumption;
    }

    public String toString(){
        return
                this.out_electricity_total_energy_consumption + "," +
        this.out_fuel_oil_total_energy_consumption + "," +
        this.out_natural_gas_total_energy_consumption + "," +
        this.out_propane_total_energy_consumption + "," +
        this.out_site_energy_total_energy_consumption + "," +
        this.out_wood_total_energy_consumption;
    }
}
