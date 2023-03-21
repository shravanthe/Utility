# Utility
Different repository for efficient work.

**JSONUtils.java** =This util code is used to extract any specific attribute from any JsonObject. Feel free to modify it for better output.

                    **One can use this file as below.**
                     JSONObject jsonObj = new JSONObject(jsonString);
                    // Get the value of the "genre_handle" attribute
                     String name = (String) JSONUtils.jsonToMap(jsonObj, "genre_handle");
                    System.out.println(name); // Output: John
