    /*
reading / retrieving and applying logical sorting to JSON response value via HttpRequest

note: details of where this code is in use is not shared due to me and my partners privacy and copyright reasons. 
Currently, we will not share the complete code as we don't want it to be open-source yet.
note 2: code has been altered to not be the exact copy of the version I made professionally, and can not be recognized.
note 3: code is missing essential parts that makes it function correctly (for me and my partners privacy reasons as well).
note 4: All the rights of this particular code belong to me, this spesific code can be used freely, with credits pointing to this page.
*/  


private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try{
            final String SomeURL = jTextField1.getText()+"doMyTask";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
            .GET()
            .header("accept", "application/json")
            .uri(URI.create(SomeURL))
            .build();
            HttpResponse <String> response;

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json2 = response.body().toString();
            var cleanedJson2 = json2.substring(json2.indexOf("\"NamesOfPeople\":"));
            var finalResult2 = cleanedJson2.split("}],")[0];

           
            
            
            
             int x = StringUtils.countMatches(finalResult2, "&/");
                 for(int i=0;i<x;i++){
                     String[] xc = finalResult2.split("&/");
                         splittedX.add(xc[i]);
                         
                         
                 }
                 
                for (int i = 0;i<splittedXyz.size();i++) {
                    boolean xxccz = splittedXyz.get(i).contains("}/&");
                    if(xxccz==true){
                        splittedSmarts.add(splittedXyz.get(i));
                    }  
                    
                    
                }
                
                
                
                String eachOfTheStrings="";
                int endOfTheElementsImportantLength;
                int indexOfMostCommonDotsThere;
                String substringsForTagNamesIhave="";
                
                
                
                
                
                  for(int i = 0; i<splittedSmarts.size();i++){
               
                      eachOfTheStrings= splittedSmarts.get(i);
                      
                      
                           indexOfMostCommonDotsThere = eachOfTheStrings.indexOf(",");
                          endOfTheElementsImportantLength=  eachOfTheStrings.length();
                          substringsForTagNamesIhave = eachOfTheStrings.substring(indexOfMostCommonDotsThere+43,  endOfTheElementsImportantLength);
                        
                          
                  System.out.println(substringsForTagNamesIhave);
                }
                 
               
            
            var finalResultXXXX="";
            jTextField6.setText(finalResultXXXX);

        }catch(RuntimeException ex){
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

    }
