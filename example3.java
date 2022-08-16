    


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
