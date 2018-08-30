package com.emi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class BasicController {
	@RequestMapping(method = RequestMethod.GET)
	public String printHello(ModelMap model) {
		model.addAttribute("message", "CALCULATE EMI & INTEREST RATES");
		return "main";
	}

	@RequestMapping(value = "/CalculateEMI", method = RequestMethod.POST)
	public String CalculateEMI(HttpServletRequest request, HttpServletResponse response, Model model) {

		String amount = request.getParameter("amount");
		Double inter = Double.parseDouble(request.getParameter("rate"));
		String month = request.getParameter("month");

		double loanAmount = Double.parseDouble(amount);
		double rateOfInterest = inter;
		int numberOfMonths = Integer.parseInt(month);

		double temp = 1200; // 100*numberofmonths(12))
		double interestPerMonth = rateOfInterest / temp;

		double onePlusInterestPerMonth = 1 + interestPerMonth;

		double powerOfOnePlusInterestPerMonth = Math.pow(onePlusInterestPerMonth, numberOfMonths);

		double powerofOnePlusInterestPerMonthMinusOne = powerOfOnePlusInterestPerMonth - 1;

		double divides = powerOfOnePlusInterestPerMonth / powerofOnePlusInterestPerMonthMinusOne;

		double principleMultiplyInterestPerMonth = loanAmount * interestPerMonth;

		double totalEmi = principleMultiplyInterestPerMonth * divides;

		double finalValue = Math.round(totalEmi * 100.0) / 100.0;

		model.addAttribute("emi_payable", finalValue);
		
		return "emi";
	}

}
