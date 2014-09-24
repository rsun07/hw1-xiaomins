package edu.cmu.lti.f14.hw1_xiaomins;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * I write this test class under the help of my classmate Yifu Wang
 */
public class test {
  private int correct_num = 0;

  private int answer_num = 0;

  private int supposed_num = 0;

  private String AnswerText = "";

  public void setAnswerText(String pathname) throws IOException {
    File filename = new File(pathname);
    InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
    BufferedReader br = new BufferedReader(reader);
    StringBuffer sb = new StringBuffer();
    String line = "";
    line = br.readLine();
    while (line != null) {
      line = br.readLine(); 
      sb.append(line);
      supposed_num++;
    }
    br.close();
    reader.close();
    AnswerText = sb.toString();
  }

  public double getPrecision() {
    return (double) correct_num / answer_num;
  }

  public double getRecall() {
    return (double) correct_num / supposed_num;
  }

  public void judgeAnswer(String ans) {
    if (AnswerText == "")
      return;
    if (AnswerText.contains(ans)) {
      correct_num++;
    }
  }

  public void setAnswernum(int num) {
    answer_num = num;
  }

  public double getfScore() {
    double precision = getPrecision();
    double recall = getRecall();
    return 2.0 * precision * recall / (precision + recall);
  }

  public void printReport() {
    System.out.println();
    System.out.println("Correct Num:" + correct_num);
    System.out.println("Total Returned Answer:" + answer_num);
    System.out.println("Supposed Answer Num:" + supposed_num);
    System.out.println("Precision:" + getPrecision());
    System.out.println("Recall:" + getRecall());
    System.out.println("F-socre:" + getfScore());
  }
}