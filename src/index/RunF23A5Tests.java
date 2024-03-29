package index;

import grader.basics.execution.BasicProjectExecution;
import gradingTools.comp524f23.assignment6.F23Assignment6Suite;
import trace.grader.basics.GraderBasicsTraceUtility;

public class RunF23A5Tests {
	public static void main(final String[] args) {
		
		final int maxPrintedTraces = 600;
		final int maxTraces = 2000;
		final int processTimeOut = 5;
		
		// if you set this to false, grader steps will not be traced
		GraderBasicsTraceUtility.setTracerShowInfo(true);	
		// if you set this to false, all grader steps will be traced,
		// not just the ones that failed		
		GraderBasicsTraceUtility.setBufferTracedMessages(true);
		// Change this number if a test trace gets longer than 600 and is clipped
		GraderBasicsTraceUtility.setMaxPrintedTraces(maxPrintedTraces);
		// Change this number if all traces together are longer than 2000
		GraderBasicsTraceUtility.setMaxTraces(maxTraces);
		// Change this number if your process times out prematurely
		BasicProjectExecution.setProcessTimeOut(processTimeOut);
		// You need to always call such a method
		F23Assignment6Suite.main(args);
	}
}
