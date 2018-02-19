package hu.bme.mit.train.tachograph;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TrainTachograph {

	Table<String,Integer,Integer> myTable = HashBasedTable.create();

	public void addToTable(String time, Integer cursorpos, Integer speed){

		myTable.put(time, cursorpos, speed);
	}

	public Integer getTable(String time, Integer cursorpos){
		return myTable.get(time, cursorpos);
	}

}
