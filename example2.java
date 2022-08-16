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
