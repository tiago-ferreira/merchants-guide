package com.merchants.guide.process;

import com.merchants.guide.dao.CurrencyValueDAO;
import com.merchants.guide.dao.QuestionDAO;
import com.merchants.guide.utils.StringUtility;
import org.junit.Test;

public class OutputProcessTest {

	@Test
	public void testProcessResult() {
		StringUtility stringUtility = new StringUtility();
		InputProcess input = new InputProcess();
		OutputProcess output = new OutputProcess();
		input.loadFileData("input_test_data.txt");
		input.processCurrencyValues();
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
		System.out.println("PROCESSANDO RESULTADO TESTE");
		System.out.println("================================================");
		output.processResult();
		System.out.println("================================================");
	}

}
