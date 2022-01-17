package com.merchants.guide.process;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.merchants.guide.dao.CurrencyValueDAO;
import com.merchants.guide.dao.PropertiesDAO;
import com.merchants.guide.dao.QuestionDAO;
import com.merchants.guide.types.SpecialCurrencyTypes;
import com.merchants.guide.types.WordQuestionType;
import com.merchants.guide.utils.FileHelper;
import com.merchants.guide.utils.RomanToDecimal;

public class InputProcess {
	
	private FileHelper fileHelper = new FileHelper();
	private RomanToDecimal romanToDecimal = new RomanToDecimal();

	public StringTokenizer getTokens(String string){
		return new StringTokenizer(string," ");
	}
	
	public void proccessLine(String string) {
		if(isQuestion(string)) {
			QuestionDAO.add(string);
		} else {
			CurrencyValueDAO.add(string);
		}
	}
	
	public boolean isQuestion(String string){
		Predicate<WordQuestionType> isQuestion = (WordQuestionType c) -> string.contains(c.getDescription());
		return Arrays.stream(WordQuestionType.values()).anyMatch(isQuestion);
	}
	
	public void loadFileData(String fileName) {
		File file = fileHelper.getFile(fileName);
		try (Scanner scanner = new Scanner(file)) {
			proccessFile(scanner);
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void proccessFile(Scanner scanner) {
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			this.proccessLine(line.toLowerCase());
		}
	}

	public void processCurrencyValues() {
		Iterator<String> it = CurrencyValueDAO.getCurrencyValues().iterator();
		while(it.hasNext()) {
			defineProccessType(it);		
		}
	}

	private void defineProccessType(Iterator<String> it) {
		String actual = it.next();
		StringTokenizer tokenizer = this.getTokens(actual);
		if(tokenizer.countTokens() == 3) {
			processSimpleCurrencyValue(tokenizer);
		} else {
			processSpecialCurrencyValue(tokenizer, actual);
		}
	}

	private void processSimpleCurrencyValue(StringTokenizer tokenizer) {
		while(tokenizer.hasMoreTokens()) {
			saveToken(tokenizer);
		}	
	}
	
	private void saveToken(StringTokenizer tokenizer){
		String key = tokenizer.nextToken();
		tokenizer.nextToken();
		String value = tokenizer.nextToken();
		PropertiesDAO.addProperties(key, value);
	}

	private void processSpecialCurrencyValue(StringTokenizer tokenizer, String string) {
		double decimal = 0;
	    StringBuilder roman = getCompleteRomamNumber(tokenizer);
	    decimal = getNumberOnString(string);
	    double result = calcSpecialCurrencyValue(decimal, roman.toString().trim());
	    this.addValueOnTheProperties(result, string);
	}

	private StringBuilder getCompleteRomamNumber(StringTokenizer tokenizer) {
		StringBuilder roman = new StringBuilder();
	    while(tokenizer.hasMoreTokens()) {
	        String romanValue = PropertiesDAO.getProperty(tokenizer.nextToken().trim());
	        if(romanValue != null){
	        	roman.append(romanValue);
	        }
	    }
		return roman;
	}

	private void addValueOnTheProperties(double result, String string) {
	    if(string.contains(SpecialCurrencyTypes.SILVER.getDescription())) {
	    	PropertiesDAO.addProperties(SpecialCurrencyTypes.SILVER.getDescription(), String.valueOf(result));
	    } else if(string.contains(SpecialCurrencyTypes.GOLD.getDescription())) {
	    	PropertiesDAO.addProperties(SpecialCurrencyTypes.GOLD.getDescription(), String.valueOf(result));
	    } else if(string.contains(SpecialCurrencyTypes.IRON.getDescription())) {
	    	PropertiesDAO.addProperties(SpecialCurrencyTypes.IRON.getDescription(), String.valueOf(result));
	    }
	}

	private double calcSpecialCurrencyValue(double decimal, String roman) {
	    double dividend = romanToDecimal.romanToDecimal(roman.toString().trim());
	    double result = decimal / dividend;
		return result;
	}

	private double getNumberOnString(String string) {
		double decimal = 0;
	    Matcher matcher = Pattern.compile("\\d+").matcher(string);  
	    if (matcher.find()) {
	    	decimal = Double.parseDouble(matcher.group());
	    }  
	    return decimal;
	}
	

}