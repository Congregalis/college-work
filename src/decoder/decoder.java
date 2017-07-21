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
	//�������//++
	public void getplaintext(String filePath){
		String cfname = "";//�����ļ�crpherfilename//
		String pfname = "";//�����ļ�plainfilename//
		
		filename = filePath.replace("","");//����ո�
		cfname = filename.substring(filename.lastIndexOf("/")+1, filename.lastIndexOf("."));// /��.����ļ���
		pfname = "D:/java�γ�/plain Of " + cfname + " .txt";
		separate();
		String plaintext=decode();
		try{
			FileWriter file = new FileWriter(pfname);
            BufferedWriter filein = new BufferedWriter(file);
            filein.write("�������£�");
            filein.newLine();
            filein.write(plaintext);
            filein.newLine();
            filein.flush();//�������
        	filein.close();
            file.close();
		}
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
	}
	

	
	private void separate(){
		//���ļ�������
		try(BufferedReader fileout = new BufferedReader(new FileReader(filename))){
			head = fileout.readLine();
			if(head==null){
				System.out.println("���ļ���ʽ����ȷ��");
				}
			else{
				ciphertext = fileout.readLine();
				if(ciphertext==null){
					System.out.println("���ļ�����Ϊ�ա�");
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
			return("��������޷�����");
		while((lenthOfKey=reader(beginning,cipherBody))>0){
			while((idex=reader(lenthOfKey,cipherBody))<((int)Math.pow(2, lenthOfKey)-1))//math.pow�ݺ������
			{	index = (int)Math.pow(2, lenthOfKey)-1-lenthOfKey+idex;//�������Ϊ10����
				plainBody += head.charAt(index);//д��
			}
		}
		return(plainBody);
	}
	
	private int reader(int n,String body){
		String str="";
		int result=0;//��ʼ��
		
		for(int i=0;i<n;i++){
			if(bodyIdex>=body.length())
				break;
			str += body.charAt(bodyIdex);
			bodyIdex++;
		}
			Integer Result = Integer.valueOf(str, 2);//������ת��Ϊʮ��������
			result = Result.intValue();
		
		return(result);//--
	}
}
