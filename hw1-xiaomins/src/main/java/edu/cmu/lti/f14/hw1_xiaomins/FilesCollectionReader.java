package edu.cmu.lti.f14.hw1_xiaomins;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;

/**
 * 
 * @author  Ryan Sun
 *A Collection Reader is responsible for obtaining documents from the collection and returning each document as a CAS.
 */

public class FilesCollectionReader extends CollectionReader_ImplBase {
  
  /**
   * Name of configuration parameter that must be set to the path of a directory containing input
   * files.
   */
  public static final String PARAM_INPUTDIR = "InputDirectory";
  
  /**
   * Name of configuration parameter that contains the character encoding used by the input files.
   * If not specified, the default system encoding will be used.
   */
  public static final String PARAM_ENCODING = "Encoding";
    /**
   * Name of optional configuration parameter that contains the language of the documents in the
   * input directory. If specified this information will be added to the CAS.
   */
  public static final String PARAM_LANGUAGE = "Language";
  
//instance variables
  private ArrayList<File> mFiles;
  private int mCurrentIndex;
  private ArrayList<String> lines;
  private BufferedReader br;
  private int curLine;
  
  /**
   * The initialize() method is called by the framework when the Collection Reader is first created.
   * In this method, the Collection Reader class can access the values of its configuration parameters 
   * and perform other initialization logic.
   * @see org.apache.uima.collection.CollectionReader#getNext(org.apache.uima.cas.CAS)
   */
  
  public void initialize() throws ResourceInitializationException {
    File directory = new File(((String) getConfigParameterValue(PARAM_INPUTDIR)));
    mCurrentIndex = 0;
    //get list of files (not subdirectories) in the specified directory
    // the reason I add these lines below is for future modification
    mFiles = new ArrayList<File>();
    mFiles.add(directory);
    
    
    /* in this assignment, there is only one file 
     * so I only use bufferdReader to read the first file
     * store it in br, then I can read this file line by line.
     * 
     * If I need to read many files line by line
     * I will use a arrayList<ArrayList<String>> to store them by iteration.
    */
    //System.out.println(mFiles.get(0));
    initalDocumentForHW1();
   }    
      /**
       * this private function will initialize the buffered reader 
       *  for homework1
       */
      private void initalDocumentForHW1(){    
        try{
          FileReader fr = new FileReader(mFiles.get(0));
          br = new BufferedReader(fr);
        }catch (FileNotFoundException ex) {
          ex.printStackTrace();
        }
        // read the file line by line
        lines = new ArrayList<String>();
        
         try {
           while(true){
            String temp = br.readLine();
            if(temp == null)
              break;
            lines.add(temp);
           }
          }catch (IOException ex) {
          ex.printStackTrace();
          } 
        
        curLine = 0;
      }
      
  /**
   * The getNext() method reads the next document from the collection and populates a CAS.
   */
  @Override
  public void getNext(CAS aCAS) throws IOException, CollectionException {
    // TODO Auto-generated method stub
    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException ex) {
      throw new CollectionException(ex);
    }
    //read the id and sentence, and store them in different strings
    String temp = lines.get(curLine++);  
    //System.out.println(temp);
    jcas.setDocumentText(temp);

    
    // set language if it was explicitly specified as a configuration parameter
    
    /*
     * the codes below is copy from the UIMA example
     * I leave it here for future modification
     * 
    * Also store location of source document in CAS. This information is critical
    * if CAS Consumers will need to know where the original document contents are located.
    * For example, the Semantic Search CAS Indexer writes this information into the
    * search index that it creates, which allows applications that use the search index to
    * locate the documents that satisfy their semantic queries.
    SourceDocumentInformation srcDocInfo = new SourceDocumentInformation(jcas);
    srcDocInfo.setUri(mFiles.get(0).getAbsoluteFile().toURL().toString());
    srcDocInfo.setOffsetInSource(0);
    srcDocInfo.setDocumentSize((int) mFiles.get(0).length());
    srcDocInfo.setLastSegment(mCurrentIndex == mFiles.size());
    srcDocInfo.addToIndexes();
    */
  }
  
  /**
   * The close method is called when the Collection Reader is no longer needed.
   */
  @Override
  public void close() throws IOException {
    // TODO Auto-generated method stub
  }
  /**
   * return how much of the collection has been read thus far and 
   * how much remains to be read.
   */
  @Override
  public Progress[] getProgress() {
    // TODO Auto-generated method stub
    return new Progress[]{new ProgressImpl(mCurrentIndex,mFiles.size(),Progress.ENTITIES)};
  }
  /**
  The hasNext() method returns whether or not there are any documents remaining to be read from
  the collection
  */
  @Override
  public boolean hasNext() throws IOException, CollectionException {
    // TODO Auto-generated method stub
    return curLine < lines.size();
  }

}
