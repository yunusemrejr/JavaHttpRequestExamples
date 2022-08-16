/*

sending / writing new value via HttpRequest

note: details of where this code is in use is not shared due to me and my partners privacy and copyright reasons. 
Currently, we will not share the complete code as we don't want it to be open-source yet.
note 2: code has been altered to not be the exact copy of the version I made professionally, and can not be recognized.
note 3: code is missing essential parts that makes it function correctly (for me and my partners privacy reasons as well).
note 4: All the rights of this particular code belong to me, this spesific code can be used freely, with credits pointing to this page.


*/

public void myFunctionX() throws IOException {
        
        
       //ReadAndWrite readwrite = new ReadAndWrite();
        //var placeIDtoWriteTo = readwrite.placeIDtoWriteTo;
        //String newAssignedValue = readwrite.newAssignedValue;
       // String IP_URL_XXX = readwrite.IP_URL_XXX; 
        
  try{
      
      WritingStatusString="writing your values!...";
jTextField9.setText(WritingStatusString);


      URL url = new URL(IP_URL_XXX+"writeMachines");
HttpURLConnection http = (HttpURLConnection)url.openConnection();

http.setRequestMethod("POST");
http.setDoOutput(true);

http.setRequestProperty("Accept", "application/json");
http.setRequestProperty("Content-Type", "application/json");

String data = "[{\"identifierX\": " + "\"" + placeIDtoWriteTo + "\"" + "," + "\"qualityValue\": \"" + newAssignedValue +  "\"}]";

byte[] output = data.getBytes(StandardCharsets.UTF_8);

OutputStream stream = http.getOutputStream();
stream.write(output);

System.out.println(http.getResponseCode() + " ------ " + http.getResponseMessage());


  if(http.getResponseMessage().isEmpty()){
      
        WritingStatusString="Failed";
        jTextField9.setText(WritingStatusString);
        
        }
  
  else{
         WritingStatusString=http.getResponseMessage();
         jTextField9.setText(WritingStatusString);
         
        }
 

http.disconnect();

  }
  
  catch(IOException e){
      
      throw new IOException(e);
      
  }
       


    
         
         
        
    }
