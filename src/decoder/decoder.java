package decoder;
import java.io.*;

public class decoder {
	
	private String head="";
	private String plainBody="";
	private String cipherBody="";
	private String ciphertext;
	private String filename="";
	private int bodyIdex=0;
	
	
	public decoder(){}
	//获得明文//++
	public void getplaintext(String filePath){
		String cfname = "";//密文文件crpherfilename//
		String pfname = "";//明文文件plainfilename//
		
		filename = filePath.replace("","");//清楚空格
		cfname = filename.substring(filename.lastIndexOf("/")+1, filename.lastIndexOf("."));// /与.获得文件名
		pfname = "D:/java课程/plain Of " + cfname + " .txt";
		separate();
		String plaintext=decode();
		try{
			FileWriter file = new FileWriter(pfname);
            BufferedWriter filein = new BufferedWriter(file);
            filein.write("译文如下：");
            filein.newLine();
            filein.write(plaintext);
            filein.newLine();
            filein.flush();//清除数据
        	filein.close();
            file.close();
		}
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
	}
	

	
	private void separate(){
		//打开文件并读入
		try(BufferedReader fileout = new BufferedReader(new FileReader(filename))){
			head = fileout.readLine();
			if(head==null){
				System.out.println("该文件格式不正确。");
				}
			else{
				ciphertext = fileout.readLine();
				if(ciphertext==null){
					System.out.println("该文件内容为空。");
				}
				else {
					do{
						cipherBody += ciphertext;
						ciphertext = fileout.readLine();
					}while(ciphertext!=null);
				}
			}
		}
		catch(IOException ioe) {
	        ioe.printStackTrace();
	    }
	}
private String decode(){
		int index;
		int lenthOfKey=0;
		int beginning=3;
		int idex=0;
		if(cipherBody==null||cipherBody.length()<9)
			return("输入错误无法解析");
		while((lenthOfKey=reader(beginning,cipherBody))>0){
			while((idex=reader(lenthOfKey,cipherBody))<((int)Math.pow(2, lenthOfKey)-1))//math.pow幂函数输出
			{	index = (int)Math.pow(2, lenthOfKey)-1-lenthOfKey+idex;//变二进制为10进制
				plainBody += head.charAt(index);//写入
			}
		}
		return(plainBody);
	}
	
	private int reader(int n,String body){
		String str="";
		int result=0;//初始化
		
		for(int i=0;i<n;i++){
			if(bodyIdex>=body.length())
				break;
			str += body.charAt(bodyIdex);
			bodyIdex++;
		}
			Integer Result = Integer.valueOf(str, 2);//二进制转化为十进制整数
			result = Result.intValue();
		
		return(result);//--
	}
}
