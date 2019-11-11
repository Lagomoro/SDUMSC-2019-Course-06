/**
 * @class: CalculateController.java 
 * @extends: java.lang.Object
 * @author: Lagomoro <Yongrui Wang>
 * @submit: 2019/11/11
 * @description: Calculate expression.
 **/
package org.sdumsc.course201907.controller;

import java.util.Stack;

import org.sdumsc.course201907.ui.components.EditText;
import org.sdumsc.course201907.ui.components.Label;

public class CalculateController {
	
	private static EditText editText;
	private static Label label;
	
    public static void setEditText(EditText text) {
    	editText = text;
	}
    
    public static void setLabel(Label l) {
    	label= l;
	}
    
    public static void pushText(String text) {
    	editText.setText(editText.getText() + text);
    	editText.refresh();
	}
    
	public static void push(String text) {
		switch(text) {
		case "C":
			String temp = editText.getText();
			if(temp.length() > 0) {
				editText.setText(temp.substring(0, temp.length() - 1));
			}
			break;
		case "CE":
			editText.setText("");
			break;
		case "=":
			editText.setText(calculate(editText.getText()));
			break;
		default:
			pushText(text);
		}
	}
	
	public static String calculate(String text) {
		try {
			return Integer.toString(calculateSuffix(toSuffix(text)));
		} catch (Exception e) {
			return "Error!!!";
		}
	}
	
	public static boolean isNumber(String input) {
		return input.charAt(0) >= '0' && input.charAt(0) <= '9';
	}

	public static int compareSymbol(String symbol){
		return symbol.equals("+") || symbol.equals("-") ? 0 : (symbol.equals("¡Á") || symbol.equals("¡Â") || symbol.equals("*") || symbol.equals("/") ? 1 : -1);
	}
	
	public static Stack<String> toSuffix(String expression) throws Exception{
		Stack<String> result = new Stack<String>();
		Stack<String> temp = new Stack<String>();
		int length = expression.length(); 
		String current;
		for (int i = 0; i < length; i++) {
			current = expression.charAt(i) + "";
			if (isNumber(current)) {
				String value = current;
				for (int j = i + 1; j < length; j++) {
					if(isNumber(expression.charAt(j) + "")) {
						i++;
						value +=expression.charAt(j);
					}else {
						break;
					}
				}
				temp.push(value);
			} else if (current.equals("+") || current.equals("-") || current.equals("¡Á") || current.equals("¡Â") || current.equals("*") || current.equals("/")) {
				while (true) {
					if (result.isEmpty() || result.get(result.size()-1).equals("(")) {
						result.push(current);
						break;
					} else if (compareSymbol(current) > compareSymbol(result.get(result.size()-1))) {
						result.push(current);
						break;
					} else {
						temp.push(result.pop());
					}
				}
			} else {
				if (current.equals("(")) {
					result.push(current);
				} else {
					while (!result.isEmpty() && !result.get(result.size()-1).equals("("))
						temp.push(result.pop());
					if (!result.isEmpty())
						result.pop();
				}
			}
		}
		while (!result.isEmpty())
			temp.push(result.pop());
		while (!temp.isEmpty())
			result.push(temp.pop());
		return result;
	}

	public static int calculateSuffix(Stack<String> suffixExpression) throws Exception{
		int temp;
		String current;
		Stack<Integer> result = new Stack<Integer>();
		while (!suffixExpression.isEmpty()) {
			current = suffixExpression.pop();
			switch (current) {
			case "+":
				temp = result.pop();
				temp = result.pop() + temp;
				break;
			case "-":
				temp = result.pop();
				temp = result.pop() - temp;
				break;
			case "¡Á":case "*":
				temp = result.pop();
				temp = result.pop() * temp;
				break;
			case "¡Â":case "/":
				temp = result.pop();
				temp = result.pop() / temp;
				break;
			default:
				temp = Integer.parseInt(current);
			}
			result.push(temp);
		}
		return result.get(result.size()-1);
	}
	
}
