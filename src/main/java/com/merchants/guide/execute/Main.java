package com.merchants.guide.execute;

import com.merchants.guide.process.InputProcess;
import com.merchants.guide.process.OutputProcess;
import com.merchants.guide.utils.StringUtility;
import com.merchants.guide.dao.CurrencyValueDAO;
import com.merchants.guide.dao.QuestionDAO;

public class Main {
	public static void main(String[] args) {
		StringUtility stringUtility = new StringUtility();
		InputProcess inputProcess = new InputProcess();
		OutputProcess outputProcess = new OutputProcess();
		inputProcess.loadFileData("input_data.txt");
		inputProcess.processCurrencyValues();
		System.out.println("================================================");
		System.out.println("VALORES");
		System.out.println("================================================");
		stringUtility.printList(CurrencyValueDAO.getCurrencyValues());
		System.out.println("================================================");
		
		System.out.println("================================================");
		System.out.println("PERGUNTAS");
		System.out.println("================================================");
		stringUtility.printList(QuestionDAO.getQuestions());
		System.out.println("================================================");
		
		System.out.println("================================================");
		System.out.println("PROCESSANDO RESULTADO");
		System.out.println("================================================");
		outputProcess.processResult();
		System.out.println("================================================");

	}
}
