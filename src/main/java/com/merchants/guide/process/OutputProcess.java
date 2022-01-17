package com.merchants.guide.process;

import java.util.Iterator;
import java.util.StringTokenizer;

import com.merchants.guide.dao.QuestionDAO;
import com.merchants.guide.decorator.IntergalaticAmount;
import com.merchants.guide.decorator.IntergalaticBaseAmount;
import com.merchants.guide.factory.CurrencyTypeFactory;
import com.merchants.guide.types.SpecialCurrencyTypes;
import com.merchants.guide.types.WordSplitType;
import com.merchants.guide.utils.RomanToDecimal;

public class OutputProcess {
	
	RomanToDecimal romanToDecimal = new RomanToDecimal();
	CurrencyTypeFactory currencyTypeFactory = new CurrencyTypeFactory();

	StringBuilder simpleValue = new StringBuilder();

	public void processResult() {
		Iterator<String> it = QuestionDAO.getQuestions().iterator();
		while(it.hasNext()) {
			String question = it.next();
			String answer = this.answersQuestion(question);
			this.printAnswer(answer);
		}
	}

	private void printAnswer(String answer) {
		System.out.println(answer);
	}

	private String answersQuestion(String string) {
		String answer = "";
		string = removeQuestionSymbol(string);
		if (string.contains(WordSplitType.TYPE_SPLIT.getDescription().trim())) {
			String valuesQuestion = getValuesQuestion(string);
			StringTokenizer tokenizer = new StringTokenizer(valuesQuestion);
			answer = processQuestionValues(tokenizer,valuesQuestion);
		} else {
			answer = "I have no idea what you are talking about";
		}
		return answer;
	}
	
	private String removeQuestionSymbol(String string) {
		if (string.contains("?")) {
			string = string.replace("?", "");
		}
		return string;
	}

	private String processQuestionValues(StringTokenizer tokenizer, String valuesQuestion){
		IntergalaticAmount amount = new IntergalaticBaseAmount();
		String answer = "";
		while (tokenizer.hasMoreTokens()) {
			String currentValue = tokenizer.nextToken();
			amount = decoreAmount(amount, currentValue);
			if(amount == null) {
				return "I have no idea what you are talking about";
			}
			String result = amount.result();
			answer = valuesQuestion + WordSplitType.TYPE_SPLIT.getDescription() + result;
		}
		return answer;
	}
	
	private IntergalaticAmount decoreAmount(IntergalaticAmount amount,String currentValue) {
		if (isSpecialCurrencyTypes(currentValue)) {
			amount = createSpecialCurrencyIntance(amount, currentValue);
		} else {
			simpleValue = new StringBuilder();
			amount = currencyTypeFactory.createInstace(amount,currentValue, 0d);
			if(amount == null) return null;
			simpleValue.append(amount.value());
		}
		return amount;
	}

	private IntergalaticAmount createSpecialCurrencyIntance(IntergalaticAmount amount, String currentValue) {
		amount = new IntergalaticBaseAmount();
		double factor = romanToDecimal.romanToDecimal(simpleValue.toString());
		return currencyTypeFactory.createInstace(amount, currentValue, factor);
	}

	private String getValuesQuestion(String string) {
		String values[] = string.split(WordSplitType.TYPE_SPLIT.getDescription());
		return values[1];
	}

    public boolean isSpecialCurrencyTypes(String string) {
        for (SpecialCurrencyTypes c : SpecialCurrencyTypes.values()) {
            if (string.contains(c.getDescription())) {
                return true;
            }
        }
        return false;
    }

}
