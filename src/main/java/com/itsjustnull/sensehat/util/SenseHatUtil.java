package com.itsjustnull.sensehat.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;

public final class SenseHatUtil {

	public String printStackTrace(Exception ex) {

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		String sStackTrace = sw.toString();
		return sStackTrace;
	}

	public Timestamp currentTimeStamp() {

		return new Timestamp(System.currentTimeMillis());
	}

}
