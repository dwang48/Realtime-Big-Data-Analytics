package mr;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class EnergyKeyWritable implements WritableComparable<EnergyKeyWritable> {

    private Text buildingType;

    private Text hour;

    // For Mapping the data on GISJOIN
    private Text Gnum;

    private Text time;

    @Override
    public int compareTo(EnergyKeyWritable o) {
        int compareResult1 = this.buildingType.compareTo(o.buildingType);
        int compareResult2 = this.hour.compareTo(o.hour);
        int compareResult3 = this.Gnum.compareTo(o.Gnum);
        int compareResult4 = this.time.compareTo(o.time);

        if(this.buildingType.compareTo(o.buildingType) != 0) return compareResult1;
        if(this.hour.compareTo(o.hour) != 0) return compareResult2;
        if(this.Gnum.compareTo(o.Gnum) != 0) return compareResult3;
        if(this.time.compareTo(o.time) != 0) return compareResult4;
        return 0;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        buildingType.write(dataOutput);
        hour.write(dataOutput);
        Gnum.write(dataOutput);
        time.write(dataOutput);

    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        buildingType.readFields(dataInput);
        hour.readFields(dataInput);
        Gnum.readFields(dataInput);
        time.readFields(dataInput);
    }

    public EnergyKeyWritable(){
        buildingType = new Text("");
        hour = new Text("");
        Gnum = new Text("");
        time = new Text("");
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

    public Text getGnum(){
        return Gnum;
    }
    public void setGnum(Text Gnum){
        this.Gnum = Gnum;
    }
    public Text getTime(){
        return time;
    }
    public void setTime(Text time){
        this.time = time;
    }


    public String toString(){
//        for calculating hourly electricity usage by different types of building all across the U.S>
//        return this.buildingType + ","
//                + this.hour;
//        for calculating daily electricity usage by different types of building at different locations
//        return this.Gnum+","+this.buildingType + ","
//                + this.time;
//        for calculating annual electricity usage by county
            return this.Gnum+","+this.buildingType + ","
            + this.time;

    }



}
