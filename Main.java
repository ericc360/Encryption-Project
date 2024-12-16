class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }
  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init(){
	  
	

 
    char[] sub = new char[26];
	sub[0] = 'a';
	sub[1] = 'b';
	sub[2] = 'c';
	sub[3] = 'd';
	sub[4] = 'e';
	sub[5] = 'f';
	sub[6] = 'g';
	sub[7] = 'h';
	sub[8] = 'i';
	sub[9] = 'j';
	sub[10] = 'k';
	sub[11] = 'l';
	sub[12] = 'm';
	sub[13] = 'n';
	sub[14] = 'o';
	sub[15] = 'p';
	sub[16] = 'q';
	sub[17] = 'r';
	sub[18] = 's';
	sub[19] = 't';
	sub[20] = 'u';
	sub[21] = 'v';
	sub[22] = 'w';
	sub[23] = 'x';
	sub[24] = 'y';
	sub[25] = 'z';



	char[] sub2 = new char[26];
	sub2[0] = 'ā'; 
	sub2[1] = 'ē';  
	sub2[2] = 'ī';  
	sub2[3] = 'ō';  
	sub2[4] = 'ū'; 
	sub2[5] = 'Ā';  
	sub2[6] = 'Ē';  
	sub2[7] = 'Ī'; 
	sub2[8] = 'Ō';  
	sub2[9] = 'Ū';  
	sub2[10] = 'á'; 
	sub2[11] = 'é'; 
	sub2[12] = 'í'; 
	sub2[13] = 'ó';  
	sub2[14] = 'ú';  
	sub2[15] = 'Á';  
	sub2[16] = 'É'; 
	sub2[17] = 'Í';  
	sub2[18] = 'Ó';  
	sub2[19] = 'Ú'; 
	sub2[20] = 'à';  
	sub2[21] = 'è';  
	sub2[22] = 'ì';  
	sub2[23] = 'ò';  
	sub2[24] = 'ù'; 
	sub2[25] = 'ü';  
    
   
    String file = Input.readFile("Original.txt");

    
    String encodedMsg1 = subEncryption(file,sub,sub2);
    Input.writeFile("Encode1.txt",encodedMsg1);

     
    String encodedMsg2 = encode(file);
    Input.writeFile("Encode2.txt",encodedMsg2);

    
    String encodedMsg3 = reverse(file);
    Input.writeFile("Encode3.txt",encodedMsg3);

    
     //decoding message
    String file2 = Input.readFile("Encode3.txt");
    
    String decodedMsg1 = reverse(file2);
    Input.writeFile("Decode1.txt", decodedMsg1);
    
    String decodedMsg2 = decode(decodedMsg1);
    Input.writeFile("Decode2.txt", decodedMsg2);
    
    String decodedMsg3 = subEncryption(file,sub2,sub);
    Input.writeFile("Decode3.txt", decodedMsg3);
    
    
  }
  
  String reverse(String txt){
    String bld ="";
    for(int x=0; x<= txt.length()-1; x++){
      bld = txt.charAt(x) + bld;
    }
    return bld;
  }
  
  
  
  String encode(String txt){
    String bld="";
    int ascii;
    char ch='\0';
    for(int x=0; x<=txt.length()-1;x++){
      ch=txt.charAt(x);
      ascii=(int)ch;
      ascii+=5;
      bld+= (char)ascii;
    }
     
    return bld;
  }

  
  String decode(String txt){
    String bld="";
    int ascii;
    char ch='\0';
    for(int x=0; x<=txt.length()-1;x++){
      ch=txt.charAt(x);
      ascii=(int)ch;
      ascii-=5;
      bld+= (char)ascii;
    }
    return bld;
  }

  
  String subEncryption(String s, char[] sub, char[] sub2){
    String bld="";
    char ch ='\0';
    int index=0;
    for(int x=0; x<=s.length()-1; x++){
      ch=s.charAt(x);
      index=indexOf(ch,sub);
      if(index!=-1){
        bld+=sub2[index];
      }
      else{
        bld+=ch;
      }
    }
    return bld;
  }
  
  int indexOf(char ch, char[] arry){
    for(int x=0; x<=arry.length-1; x++){
      if(arry[x]==ch){
        return x;
      }
    }
    return -1;
  }
  int randInt(int lower, int upper){
    int range = upper - lower;
    return (int)(Math.random()*range+lower);
  }

}