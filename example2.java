/*
reading / retrieving JSON response value via HttpRequest
note: details of where this code is in use is not shared due to me and my partners privacy and copyright reasons. 
Currently, we will not share the complete code as we don't want it to be open-source yet.
note 2: code has been altered to not be the exact copy of the version I made professionally, and can not be recognized.
note 3: code is missing essential parts that makes it function correctly (for me and my partners privacy reasons as well).
note 4: All the rights of this particular code belong to me, this spesific code can be used freely, with credits pointing to this page.
*/  


private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        final String SOME_URL = jTextField1.getText();
        final String SOME_VALUE_IDENTIFIER = jTextField3.getText();
        final String SOME_URL_TWO = SOME_URL+"find?identifiers="+SOME_VALUE_IDENTIFIER;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
        .GET()
        .header("accept", "application/json")
        .uri(URI.create(SOME_URL_TWO))
        .build();
        HttpResponse <String> response;

        try{
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body().toString();

            var cleanedJson = json.substring(json.indexOf("\"importantNumber\":"));
            var finalResult = cleanedJson.split(",")[0];

            jTextField5.setText(finalResult);
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }catch (InterruptedException ex){
            throw new RuntimeException(ex);
        }

    }  
