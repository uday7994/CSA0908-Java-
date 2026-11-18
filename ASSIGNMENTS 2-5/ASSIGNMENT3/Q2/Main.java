import java.io.*;
class ExamException extends Exception { ExamException(String m){super(m);} ExamException(String m,Throwable c){super(m,c);} }
class SubmissionStorageException extends ExamException { SubmissionStorageException(String m,Throwable c){super(m,c);} }
class Storage {
 void save(String file,long size) throws SubmissionStorageException {
  try { if(size>500) throw new IOException("Disk quota exceeded"); System.out.println("Saved "+file); }
  catch(IOException e){ throw new SubmissionStorageException("Could not store "+file,e); }
 }
}
public class Main {
 public static void main(String[] args) {
  Storage s=new Storage();
  try { s.save("answer01.pdf",120); s.save("answer02.pdf",800); }
  catch(ExamException e){System.out.println("Error: "+e.getMessage());System.out.println("Cause: "+e.getCause().getMessage());}
 }
}
