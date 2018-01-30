package com.wisely.batch;

import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;
import com.wisely.domain.BatchPerson;

public class CsvItemProcessor  extends ValidatingItemProcessor<BatchPerson>{

	@Override
	public BatchPerson process(BatchPerson item) throws ValidationException {
		super.process(item); //1
		
		if(item.getNation().equals("汉族")){ //2
			item.setNation("01");
		}else{
			item.setNation("02");
		}
		return item;
	}


}
