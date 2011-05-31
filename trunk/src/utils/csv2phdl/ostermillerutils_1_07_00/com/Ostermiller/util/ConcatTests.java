/*
 * Contact Streams Regression test.
 * Copyright (C) 2004 Stephen Ostermiller
 * http://ostermiller.org/contact.pl?regarding=Java+Utilities
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * See COPYING.TXT for details.
 */
package com.Ostermiller.util;

import java.io.*;

/**
 * Regression test for Concatenation Streams.
 * More information about this class is available from <a target="_top" href=
 * "http://ostermiller.org/utils/Conact.html">ostermiller.org</a>.
 *
 * @author Stephen Ostermiller http://ostermiller.org/contact.pl?regarding=Java+Utilities
 * @since ostermillerutils 1.04.00
 */
class ConcatTests {

	/**
	 * Main method for tests
	 * @param args command line arguments (ignored)
	 */
	public static void main(String[] args){
		try {
			ConcatReader cr = new ConcatReader(
				new Reader[]{
					new StringReader("1"),
					new StringReader("two"),
					new StringReader(""),
					new StringReader("4"),
					new StringReader("five"),
					new StringReader("six"),
					new StringReader("seven"),
				}
			);
			if (!cr.ready()) throw new Exception ("Not Ready");
			read(cr, '1');
			read(cr, 't');
			read(cr, 'w');
			read(cr, 'o');
			if (!cr.ready()) throw new Exception ("Not Ready");
			read(cr, '4');
			read(cr, "fiv");
			skip(cr, 2);
			read(cr, "i");
			read(cr, "xseven");
			if (cr.read() != -1) throw new Exception ("Read did not terminate");
			if (cr.read() != -1) throw new Exception ("Didn't stay closed");
			cr.close();

			final ConcatReader cr1 = new ConcatReader();
			if (cr1.ready()) throw new Exception ("Ready");
			cr1.addReader(new StringReader("one"));
			read(cr1, 'o');
			cr1.addReader(new StringReader("two"));
			read(cr1, "netwo");
			new Thread(){
				@Override public void run(){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ix){
						throw new RuntimeException(ix);
					}
					cr1.addReader(new StringReader("three"));
				}
			}.start();
			read(cr1, "three");
			cr1.lastReaderAdded();
			if (cr1.read() != -1) throw new Exception ("Read did not terminate");

			ConcatInputStream cis = new ConcatInputStream(
				new InputStream[]{
					new ByteArrayInputStream(new byte[]{'1'}),
					new ByteArrayInputStream(new byte[]{'t','w','o'}),
					new ByteArrayInputStream(new byte[]{}),
					new ByteArrayInputStream(new byte[]{'4'}),
					new ByteArrayInputStream(new byte[]{'f','i','v','e'}),
					new ByteArrayInputStream(new byte[]{'s','i','x'}),
					new ByteArrayInputStream(new byte[]{'s','e','v','e','n'}),
				}
			);
			if (cis.available() <= 0) throw new Exception ("Not Ready");
			read(cis, '1');
			read(cis, 't');
			read(cis, 'w');
			read(cis, 'o');
			read(cis, '4');
			read(cis, "fivesi");
			if (cis.available() <= 0) throw new Exception ("Not Ready");
			read(cis, "xseven");
			if (cis.read() != -1) throw new Exception ("Read did not terminate");
			if (cis.read() != -1) throw new Exception ("Didn't stay closed");

			final ConcatInputStream cis1 = new ConcatInputStream();
			if (cis.available() != 0) throw new Exception ("Ready");
			cis1.addInputStream(new ByteArrayInputStream("one".getBytes("ASCII")));
			read(cis1, 'o');
			cis1.addInputStream(new ByteArrayInputStream("two".getBytes("ASCII")));
			read(cis1, "netwo");
			new Thread(){
				@Override public void run(){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ix){
						throw new RuntimeException(ix);
					}
					try {
						cis1.addInputStream(new ByteArrayInputStream("three".getBytes("ASCII")));
					} catch (Exception x){
						System.err.println(x.getMessage());
						x.printStackTrace();
						System.exit(1);
					}
				}
			}.start();
			read(cis1, "three");
			cis1.lastInputStreamAdded();
			if (cis1.read() != -1) throw new Exception ("Read did not terminate");

		} catch (Exception x){
			System.err.println(x.getMessage());
			x.printStackTrace();
			System.exit(1);
		}
		System.exit(0);
	}

	private static void skip(Reader in, int n) throws Exception {
		int s = 0;
		while (s<n){
			s+=in.skip(n-s);
		}
	}


	private static void read(Reader in, char expected) throws Exception {
		int c = in.read();
		if (c != expected) throw new Exception ("Expected to read " + expected + " but read " + (char)c);
	}

	private static void read(InputStream in, char expected) throws Exception {
		int c = in.read();
		if (c != expected) throw new Exception ("Expected to read " + expected + " but read " + (char)c);
	}

	private static void read(Reader in, String expected) throws Exception {
		int totalRead = 0;
		while (totalRead < expected.length()){
			char[] buffer = new char[expected.length()-totalRead];
			int read = in.read(buffer);
			if (read == -1) throw new Exception("Read terminated early");
			if (!expected.substring(totalRead, totalRead+read).equals(new String(buffer,0,read))){
				throw new Exception ("Expected to read " + expected.substring(totalRead, totalRead+read) + " but read " + new String(buffer,0,read));
			}
			totalRead+=read;
		}
	}

	 private static void read(InputStream in, String expected) throws Exception {
		int totalRead = 0;
		while (totalRead < expected.length()){
			byte[] buffer = new byte[expected.length()-totalRead];
			int read = in.read(buffer);
			if (read == -1) throw new Exception("Read terminated early");
			if (!expected.substring(totalRead, totalRead+read).equals(new String(buffer,0,read,"ASCII"))){
				throw new Exception ("Expected to read " + expected.substring(totalRead, totalRead+read) + " but read " + new String(buffer,0,read,"ASCII"));
			}
			totalRead+=read;
		}
	}

}