package mr;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class EnergyKeyWritable implements WritableComparable<EnergyKeyWritable> {

    private Text buildingType;

    private Text hour;

    @Override
    public int compareTo(EnergyKeyWritable o) {
        int compareResult1 = this.buildingType.compareTo(o.buildingType);
        int compareResult2 = this.hour.compareTo(o.hour);

        if(this.buildingType.compareTo(o.buildingType) != 0) return compareResult1;
        if(this.hour.compareTo(o.hour) != 0) return compareResult2;

        return 0;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        buildingType.write(dataOutput);
        hour.write(dataOutput);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        buildingType.readFields(dataInput);
        hour.readFields(dataInput);
    }

    public EnergyKeyWritable(){
        buildingType = new Text("");
        hour = new Text("");
    }

    public Text getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(Text buildingType) {
        this.buildingType = buildingType;
    }

    public Text getHour() {
        return hour;
    }

    public void setHour(Text hour) {
        this.hour = hour;
    }

    public String toString(){
        return this.buildingType + ","
                + this.hour;
    }

}
