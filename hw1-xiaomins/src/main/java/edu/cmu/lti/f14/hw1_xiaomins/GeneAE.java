package edu.cmu.lti.f14.hw1_xiaomins;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunker;
import com.aliasi.chunk.Chunking;
import com.aliasi.util.AbstractExternalizable;

import edu.cmu.lti.f14.Tags.type;

/**
 * Build an Annotator that splits input document into sentences and related id
 * 
 * @author Xiaoming (Ryan) Sun
 */

public class GeneAE extends JCasAnnotator_ImplBase {
  /**
   * @see JCasAnnotator_ImplBase#process(JCas) the process function is used to process JCas read
   *      from collection reader by using linpipe's chunking function, it can extract the useful
   *      information such as, gene name, the start and end position of genename, the whole sentence
   *      and the id from the sentence then it pass the JCas into the CAS of consumer
   */
  public void process(JCas aJCas) throws AnalysisEngineProcessException {

    // get the sentence from collection reader
    String temp = aJCas.getDocumentText();

    // initialize the bio dictionary and construct the chunker
    File modelFile = new File("./src/main/java/ne-en-bio-genetag.HmmChunker");
    Chunker chunker = null;
    try {
      chunker = (Chunker) AbstractExternalizable.readObject(modelFile);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    // get the sentence(information) from collection reader
    // store the id and sentence for later write
    String id = temp.substring(0, 13).trim();
    String sentence = temp.substring(14).trim();
    // find the bio-token by chunk function
    Chunking chunking = chunker.chunk(sentence);
    // read and write the start and end (both including white space) of bio-token
    Set<Chunk> chunkSet = chunking.chunkSet();
    Iterator<Chunk> it = chunkSet.iterator();
    while (it.hasNext()) {
      type tag = new type(aJCas);
      Chunk tempChunk = it.next();
      int start = tempChunk.start();
      int end = tempChunk.end();
      // write/input the information into JCas
      tag.setStart(start);
      tag.setEnd(end);
      tag.setGeneName(sentence.substring(start, end));
      // write id and related sentence into CAS for consumer
      tag.setId(id);
      tag.setSentence(sentence);
      // System.out.println(tag.getGeneName());
      tag.addToIndexes();
    }
  }
}
