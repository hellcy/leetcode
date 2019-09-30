class Solution {
    public int numUniqueEmails(String[] emails) {
        /*
            Set
        */
        Set<String> set = new HashSet<>();
        for (String s : emails) {
            String local = s.split("@")[0].split("\\+")[0].replace(".", "");
            String domain = s.split("@")[1];
            //System.out.println(local);
            set.add(local + "@" + domain);
        }
        return set.size();
    }
}