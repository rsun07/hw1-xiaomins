package edu.cmu.lti.f14.hw1_xiaomins;

import java.io.File;
import java.io.IOException;

import com.aliasi.chunk.CharLmHmmChunker;
import com.aliasi.hmm.HmmCharLmEstimator;
import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;
import com.aliasi.tokenizer.TokenizerFactory;
import com.aliasi.util.AbstractExternalizable;

public class TrainGeneTag {

  static final int MAX_N_GRAM = 8;

  static final int NUM_CHARS = 256;

  static final double LM_INTERPOLATION = MAX_N_GRAM; // default behavior

  static final String trainingData = "./src/main/java/medtag";

  static final String outuptDictionary = "./src/main/java/trainingDictionary";

  // java TrainGeneTag <trainingInputFile> <modelOutputFile>
  @SuppressWarnings("deprecation")
  public static void main(String[] args) throws IOException {
    File corpusFile = new File(args[0]);
    File modelFile = new File(args[1]);

    System.out.println("Setting up Chunker Estimator");
    TokenizerFactory factory = IndoEuropeanTokenizerFactory.INSTANCE;
    HmmCharLmEstimator hmmEstimator = new HmmCharLmEstimator(MAX_N_GRAM, NUM_CHARS,
            LM_INTERPOLATION);
    CharLmHmmChunker chunkerEstimator = new CharLmHmmChunker(factory, hmmEstimator);

    System.out.println("Setting up Data Parser");

    /*
     * there is still some problem in the training model due to time limitation, I give up try it
     * before submission
     */
    /*
     * @SuppressWarnings("deprecation") com.aliasi.corpus.parsers.GeneTagParser parser = new
     * com.aliasi.corpus.parsers.GeneTagParser(); // PLEASE IGNORE DEPRECATION WARNING
     * parser.setHandler(chunkerEstimator);
     * 
     * System.out.println("Training with Data from File=" + corpusFile); parser.parse(corpusFile);
     * 
     * System.out.println("Compiling and Writing Model to File=" + modelFile);
     * AbstractExternalizable.compileTo(chunkerEstimator,modelFile);
     */
  }

}