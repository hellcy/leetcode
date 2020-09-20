public class Codec {
    
    Map<String, String> map = new HashMap<>();
    String base64 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortURL = generate();
        while (map.containsKey(shortURL)) {
            shortURL = generate();
        }
        for (int i = 0; i < 10; ++i) {
        System.out.println(generate());     
        }
       
        map.put(shortURL, longUrl);
        return shortURL;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
    
    private String generate() {
        String ans = "";
        Random rn = new Random();
        for (int i = 0; i < 6; ++i) 
        {
            int number = rn.nextInt(62);
            ans += String.valueOf(base64.charAt(number));
        }
        
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));