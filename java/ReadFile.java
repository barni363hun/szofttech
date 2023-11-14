import java.util.*;
import java.io.*;
class ReadFile{
static final String token="[,;]";
LinkedList<String>lineList=new LinkedList<String>();

public ReadFile(String filename){
File data=new File(filename);
if(data.exists()){
System.out.println("Opening File: "+data.getName());
System.out.println("Path: "+data.getAbsolutePath());
}else{
System.out.println("File does not exist.");}
try{
BufferedReader inFile=new BufferedReader(new FileReader(data));
String input=null;
while((input=inFile.readLine())!=null){
lineList.add(input);}
System.out.println(data.getName()+" loaded");}
catch(IOException e){e.printStackTrace();}
finally{}}

public int getListSize(){
return lineList.size();}

public LinkedList<String> getList(){
return lineList;}

public String getLine(int number){
return lineList.get(number);}

public String[] splitLine(int number, String token){
String[] splittedLine=lineList.get(number).split(token);
return splittedLine;}

public int splittedLineSize(String[] splittedLine){
return splittedLine.length;}

public int getMaxElements(String token){
int max_elements=0;
for(int i=0;i<this.getListSize();i++){
if(max_elements<this.splitLine(i,token).length){
max_elements=this.splitLine(i,token).length;}}
return max_elements;}

public String[][] getTable(String token){
String[][] table=new String[this.getListSize()][this.getMaxElements(token)];
String[] current_line;
int elements_count;
for(int i=0;i<this.getListSize();i++){
current_line=this.splitLine(i,token);
elements_count=current_line.length;
for(int j=0;j<current_line.length;j++){
table[i][j]=current_line[j];}}
return table;}

public String[] getRow(String token,int r){
String[] row=new String[this.getListSize()];
for(int i=0;i<this.getListSize();i++){
row[i]=this.splitLine(i,token)[r];}
return row;}

}
