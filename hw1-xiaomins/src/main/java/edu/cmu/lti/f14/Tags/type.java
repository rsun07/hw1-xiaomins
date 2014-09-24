

/* First created by JCasGen Tue Sep 23 19:46:03 EDT 2014 */
package edu.cmu.lti.f14.Tags;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Tue Sep 23 20:05:08 EDT 2014
 * XML source: /Users/mac/git/hw1-xiaomins/hw1-xiaomins/src/main/resources/typeSystemDescriptor.xml
 * @generated */
public class type extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(type.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected type() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public type(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public type(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public type(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: id

  /** getter for id - gets 
   * @generated
   * @return value of the feature 
   */
  public String getId() {
    if (type_Type.featOkTst && ((type_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.cmu.lti.f14.Tags.type");
    return jcasType.ll_cas.ll_getStringValue(addr, ((type_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setId(String v) {
    if (type_Type.featOkTst && ((type_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.cmu.lti.f14.Tags.type");
    jcasType.ll_cas.ll_setStringValue(addr, ((type_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: GeneName

  /** getter for GeneName - gets 
   * @generated
   * @return value of the feature 
   */
  public String getGeneName() {
    if (type_Type.featOkTst && ((type_Type)jcasType).casFeat_GeneName == null)
      jcasType.jcas.throwFeatMissing("GeneName", "edu.cmu.lti.f14.Tags.type");
    return jcasType.ll_cas.ll_getStringValue(addr, ((type_Type)jcasType).casFeatCode_GeneName);}
    
  /** setter for GeneName - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setGeneName(String v) {
    if (type_Type.featOkTst && ((type_Type)jcasType).casFeat_GeneName == null)
      jcasType.jcas.throwFeatMissing("GeneName", "edu.cmu.lti.f14.Tags.type");
    jcasType.ll_cas.ll_setStringValue(addr, ((type_Type)jcasType).casFeatCode_GeneName, v);}    
   
    
  //*--------------*
  //* Feature: Sentence

  /** getter for Sentence - gets 
   * @generated
   * @return value of the feature 
   */
  public String getSentence() {
    if (type_Type.featOkTst && ((type_Type)jcasType).casFeat_Sentence == null)
      jcasType.jcas.throwFeatMissing("Sentence", "edu.cmu.lti.f14.Tags.type");
    return jcasType.ll_cas.ll_getStringValue(addr, ((type_Type)jcasType).casFeatCode_Sentence);}
    
  /** setter for Sentence - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setSentence(String v) {
    if (type_Type.featOkTst && ((type_Type)jcasType).casFeat_Sentence == null)
      jcasType.jcas.throwFeatMissing("Sentence", "edu.cmu.lti.f14.Tags.type");
    jcasType.ll_cas.ll_setStringValue(addr, ((type_Type)jcasType).casFeatCode_Sentence, v);}    
   
    
  //*--------------*
  //* Feature: start

  /** getter for start - gets 
   * @generated
   * @return value of the feature 
   */
  public int getStart() {
    if (type_Type.featOkTst && ((type_Type)jcasType).casFeat_start == null)
      jcasType.jcas.throwFeatMissing("start", "edu.cmu.lti.f14.Tags.type");
    return jcasType.ll_cas.ll_getIntValue(addr, ((type_Type)jcasType).casFeatCode_start);}
    
  /** setter for start - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setStart(int v) {
    if (type_Type.featOkTst && ((type_Type)jcasType).casFeat_start == null)
      jcasType.jcas.throwFeatMissing("start", "edu.cmu.lti.f14.Tags.type");
    jcasType.ll_cas.ll_setIntValue(addr, ((type_Type)jcasType).casFeatCode_start, v);}    
   
    
  //*--------------*
  //* Feature: end

  /** getter for end - gets 
   * @generated
   * @return value of the feature 
   */
  public int getEnd() {
    if (type_Type.featOkTst && ((type_Type)jcasType).casFeat_end == null)
      jcasType.jcas.throwFeatMissing("end", "edu.cmu.lti.f14.Tags.type");
    return jcasType.ll_cas.ll_getIntValue(addr, ((type_Type)jcasType).casFeatCode_end);}
    
  /** setter for end - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setEnd(int v) {
    if (type_Type.featOkTst && ((type_Type)jcasType).casFeat_end == null)
      jcasType.jcas.throwFeatMissing("end", "edu.cmu.lti.f14.Tags.type");
    jcasType.ll_cas.ll_setIntValue(addr, ((type_Type)jcasType).casFeatCode_end, v);}    
  }

    